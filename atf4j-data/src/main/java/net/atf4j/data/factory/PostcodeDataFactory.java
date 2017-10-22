/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */

package net.atf4j.data.factory;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.csv.CsvRow;
import net.atf4j.data.Postcode;
import net.atf4j.data.PostcodeData;
import net.atf4j.data.Text;

/**
 * A factory for creating PostcodeData objects.
 */
public final class PostcodeDataFactory {

    private static final PostcodeDataFactory INSTANCE = new PostcodeDataFactory();
    private static final PostcodeData postCodeData = PostcodeData.getInstance();
    protected static Random rnd = new Random(System.currentTimeMillis());
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Instantiates a new postcode data factory.
     */
    private PostcodeDataFactory() {
        super();
    }

    /**
     * Gets the single instance of PostcodeDataFactory.
     *
     * @return single instance of PostcodeDataFactory
     */
    public static PostcodeDataFactory getInstance() {
        return PostcodeDataFactory.INSTANCE;
    }

    /**
     * Create new INSTANCE of Postcode.
     *
     * @return the postal address
     */
    public static Postcode create() {
        return new Postcode();
    }

    /**
     * Create a random postcode.
     *
     * @return the Postcode object.
     */
    public static Postcode random() {
        final Postcode postcode = new Postcode();
        final int rowCount = postCodeData.rowCount();
        final int randomRow = rnd.nextInt(rowCount);
        final CsvRow row = postCodeData.getRow(randomRow);
        final String[] fields = row.getFields();
        postcode.setOutwardCode(fields[0]);
        final String inward = String.format("%c%C%C", Text.randomDigit(), Text.randomChar(), Text.randomChar());
        postcode.setInwardCode(inward);
        return postcode;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("PostcodeDataFactory [postCodeData=%s]", postCodeData);
    }

}
