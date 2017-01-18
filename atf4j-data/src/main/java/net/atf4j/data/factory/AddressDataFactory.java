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

import net.atf4j.csv.CsvFile;
import net.atf4j.data.PostalAddress;

/**
 * AddressFactory.
 */
public class AddressDataFactory extends AbstractDataFactory {

    public static final String RANDOM = null;
    private static AddressDataFactory instance = null;

    private CsvFile postCodeData = null;
    private CsvFile postalTownsUK = null;

    /**
     * Instantiates a new address data factory.
     */
    protected AddressDataFactory() {
        initialise();
    }

    /**
     * Initialise.
     */
    protected void initialise() {
        try {
            this.postalTownsUK = new CsvFile("postalTownsUK.csv");
        } catch (final Exception e) {
            e.printStackTrace();
        }
        try {
            this.postCodeData = new CsvFile("postCodeData.csv");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the single instance of AddressDataFactory.
     *
     * @return single instance of AddressDataFactory
     */
    public static AddressDataFactory getInstance() {
        if (AddressDataFactory.instance == null) {
            AddressDataFactory.instance = new AddressDataFactory();
        }
        return AddressDataFactory.instance;
    }

    /**
     * Create new instance of create.
     *
     * @return the postal address
     */
    public static PostalAddress create() {
        final PostalAddress postalAddress = new PostalAddress();
        return postalAddress;
    }

    /**
     * Random.
     *
     * @return the postal address
     */
    public static PostalAddress random() {
        return null;
    }

    public static PostalAddress random(final Object characteristic) {
        return null;
    }

    /**
     * For tag.
     *
     * @param string
     *            the string
     * @return the postal address
     */
    public static PostalAddress forTag(final String string) {
        return null;
    }

}
