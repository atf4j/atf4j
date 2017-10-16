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

package net.atf4j.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UK Postcode. <code>
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
    private String outwardCode;
    private String inwardCode;

    /**
     * Create new instance of create.
     *
     * @return the postcode
     */
    public static Postcode create() {
        return new Postcode();
    }

    /**
     * Instantiates a new postcode.
     */
    public Postcode() {
        super();
    }

    /**
     * Instantiates a new postcode.
     *
     * @param postCode the post code
     */
    public Postcode(final String postCode) {
        super();
        setPostCode(postCode);
    }

    /**
     * Sets the post code.
     *
     * @param postCode the post code
     * @return the postcode
     */
    public Postcode setPostCode(final String postCode) {
        if (Postcode.verify(postCode)) {
            this.postCode = postCode;
            final String[] split = postCode.split("\\w");
            setOutwardCode(split[0]);
            setInwardCode(split[1]);
        }
        return this;
    }

    /**
     * Sets the out code.
     *
     * @param outwardCode the out code
     * @return the postcode
     */
    public Postcode setOutwardCode(final String outwardCode) {
        this.outwardCode = outwardCode;
        return this;
    }

    /**
     * Sets the in code.
     *
     * @param inwardCode the in code
     * @return the postcode
     */
    public Postcode setInwardCode(final String inwardCode) {
        this.inwardCode = inwardCode;
        return this;
    }

    /**
     * Gets the out code.
     *
     * @return the out code
     */
    public String getOutwardCode() {
        return this.outwardCode;
    }

    /**
     * Gets the in code.
     *
     * @return the in code
     */
    public String getInwardCode() {
        return this.inwardCode;
    }

    /**
     * Gets the post code.
     *
     * @return the post code
     */
    public String getPostCode() {
        return String.format("%s %s", getOutwardCode(), getInwardCode());
    }

    /**
     * Verify.
     *
     * @param postcode the postcode \* @return true, if successful, otherwise
     *            false.
     * @return true, if successful, otherwise false.
     */
    public static boolean verify(final String postcode) {
        final Matcher matcher = pattern.matcher(postcode);
        return matcher.find();
    }

}
