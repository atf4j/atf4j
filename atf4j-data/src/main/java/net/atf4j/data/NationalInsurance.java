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
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * NationalInsurance.
 *
 *
 */
public class NationalInsurance {

    /** REGULAR EXPRESSION. */
    private static final Pattern pattern = Pattern
            .compile("^[A-CEGHJ-PR-TW-Z]{1}[A-CEGHJ-NPR-TW-Z]{1}[0-9]{6}[A-D]{1}$");

    /** The code. */
    private String code;

    /**
     * Instantiates a new national insurance number.
     */
    public NationalInsurance() {
        super();
    }

    /**
     * Instantiates a new national insurance number.
     *
     * @param code
     *            the code
     */
    public NationalInsurance(final String code) {
        super();
        this.code = code;
    }

    /**
     * Verify.
     *
     * @param code
     *            the code
     * @return true, if successful
     */
    public static boolean verify(final String code) {
        final Matcher matcher = pattern.matcher(code);
        return matcher.find();
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Sets the code.
     *
     * @param code
     *            the code to set
     * @return the national insurance
     */
    public NationalInsurance setCode(final String code) {
        this.code = code;
        return this;
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("NationalInsurance [code=%s]", this.code);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

}
