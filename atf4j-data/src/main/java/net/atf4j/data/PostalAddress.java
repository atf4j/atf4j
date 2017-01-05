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

import java.util.Arrays;

/**
 * Address data class.
 */
public class PostalAddress {

    private String[] addressLines = new String[0];
    private Postcode postcode;

    public static PostalAddress create() {
        return new PostalAddress();
    }

    /**
     * Instantiates a new address.
     */
    public PostalAddress() {
        super();
    }

    /**
     * Instantiates a new address.
     *
     * @param address
     *            the address
     * @param postcode
     *            the postcode
     */
    public PostalAddress(final String[] address, final Postcode postcode) {
        super();
        setAddress(address);
        setPostcode(postcode);
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String[] getAddress() {
        return this.addressLines;
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the new address
     * @return the postal address
     */
    public PostalAddress setAddress(final String[] address) {
        this.addressLines = address;
        return this;
    }

    /**
     * Gets the postcode.
     *
     * @return the postcode
     */
    public Postcode getPostcode() {
        return this.postcode;
    }

    /**
     * Sets the postcode.
     *
     * @param postcode
     *            the new postcode
     * @return the postal address
     */
    public PostalAddress setPostcode(final Postcode postcode) {
        this.postcode = postcode;
        return this;
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("%s [address=%s, postcode=%s]", this.getClass().getSimpleName(),Arrays.toString(this.addressLines), this.postcode);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

}
