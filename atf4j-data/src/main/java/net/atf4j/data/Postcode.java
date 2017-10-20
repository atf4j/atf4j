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

import net.atf4j.core.Atf4jException;

/**
 * Provides UK Postcode. <code>
 *  POSTCODE     ::= Outward_Code Inward_Code
 *  Outward_Code ::= Postcode_Area Postcode_District
 *  Inward_Code  ::= Postcode_Sector Postcode_Unit
 * </code>
 */
public final class Postcode {

    private static final String POSTCODE = "XX99 9XX";

    /** format verification pattern. */
    private static final Pattern pattern = Pattern.compile("^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$");

    /** The post code. */
    private String postCode = "";
    private String outwardCode = "";
    private String inwardCode = "";

    /**
     * Create new INSTANCE of create.
     *
     * @return the Postcode object.
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
     * @throws InvalidPostcodeException
     */
    public Postcode(final String postCode) throws InvalidPostcodeException {
        super();
        setPostCode(postCode);
    }

    /**
     * Sets the post code.
     *
     * @param postCode the post code as a String.
     * @return this for fluent interface.
     * @throws InvalidPostcodeException
     */
    public Postcode setPostCode(final String postCode) throws InvalidPostcodeException {
        this.postCode = postCode;
        if (Postcode.verify(this.postCode)) {
            final String[] parts = this.postCode.split("\\W");
            setOutwardCode(parts[0]);
            setInwardCode(parts[1]);
            return this;
        } else {
            throw new InvalidPostcodeException(postCode);
        }
    }

    /**
     * Sets the outward code.
     *
     * @param outwardCode the out code
     * @return this for fluent interface.
     */
    public Postcode setOutwardCode(final String outwardCode) {
        this.outwardCode = outwardCode;
        return this;
    }

    /**
     * Sets the inward code.
     *
     * @param inwardCode the in code
     * @return this for fluent interface.
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s %s", outwardCode, inwardCode);
    }

    /**
     * The property file was not found.
     */
    public class InvalidPostcodeException extends Atf4jException {
        private static final long serialVersionUID = 1L;

        /**
         * Instantiates a new property not found.
         *
         * @param invalidPostcode the property key
         */
        public InvalidPostcodeException(final String invalidPostcode) {
            super(String.format("Postcode %s is valid format", invalidPostcode));
        }
    }
}
