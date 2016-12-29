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
 * UK Postcode.
 * <code>
 * POSTCODE     ::= Outward_Code Inward_Code
 * Outward_Code ::= Postcode_Area Postcode_District
 * Inward_Code  ::= Postcode_Sector Postcode_Unit
 * </code>
 */
public class Postcode {

    /** The Constant pattern. */
    private static final Pattern pattern = Pattern.compile("^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$");

    /** The post code. */
    private String postCode;

    /**
     * Instantiates a new postcode.
     */
    public Postcode() {
        super();
    }

    /**
     * Instantiates a new postcode.
     *
     * @param postCode
     *            the post code
     */
    public Postcode(final String postCode) {
        super();
        this.postCode = postCode;
    }

    /**
     * Verify.
     *
     * @param postcode
     *            the postcode
     * @return true, if successful
     */
    public boolean verify(final String postcode) {
        final Matcher matcher = pattern.matcher(postcode);
        return matcher.find();
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("Postcode [postCode=%s]", this.postCode);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

}
