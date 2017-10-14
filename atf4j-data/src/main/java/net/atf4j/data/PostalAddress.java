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

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

/**
 * Address data class.
 */
public class PostalAddress {

    private String[] addressLines = new String[8];
    private Postcode postcode;

    /**
     * Instantiates a new address.
     */
    public PostalAddress() {
        super();
    }

    /**
     * Instantiates a new postal address.
     * 
     * @param address
     *            the address
     */
    public PostalAddress(final String address) {
        super();
        this.addressLines = address.split(",");
    }

    /**
     * Instantiates a new address.
     *
     * @param address
     *            the address
     */
    public PostalAddress(final String[] address) {
        super();
        setAddress(address);
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
     * Sets the address row.
     *
     * @param row
     *            the row
     * @param line
     *            the line
     */
    public void setAddressRow(final int row, final String line) {
        assertTrue(row > 0);
        assertTrue(row < this.addressLines.length);
        this.addressLines[row] = line;
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
     * Gets the address.
     *
     * @return the address
     */
    public String[] getAddress() {
        return this.addressLines;
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
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("%s [address=%s, postcode=%s]", this.getClass().getSimpleName(),
                Arrays.toString(this.addressLines), this.postcode);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

}
