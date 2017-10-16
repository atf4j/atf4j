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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A Unit test class for PostalAddress.
 */
public final class PostalAddressTest extends TestResultsReporting {

    private static final String ADDRESS = "LineOne,LineTwo,LineThree,LineFour,LineFive,LineSix,LineSeven,LineEight";
    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        final PostalAddress address = new PostalAddress();
        assertNotNull(UNEXPECTED_NULL, address);
        this.log.info("{}", address);
    }

    /**
     * Test postal address string.
     */
    @Test
    public void testPostalAddressString() {
        final PostalAddress address = new PostalAddress(ADDRESS);
        assertNotNull(UNEXPECTED_NULL, address);
        this.log.info("{}", address);
    }

    /**
     * Test postal address string array.
     */
    @Test
    public void testPostalAddressStringArray() {
        final String[] addressLines = ADDRESS.split(",");
        final PostalAddress address = new PostalAddress(addressLines);
        assertNotNull(UNEXPECTED_NULL, address);
        this.log.info("{}", address);
    }

    /**
     * Test method for PostalAddress.
     */
    @Test
    public void testToString() {
        final String addressString = new PostalAddress().toString();
        assertNotNull(UNEXPECTED_NULL, addressString);
        this.log.info("{}", addressString);
    }

    /**
     * Test method for PostalAddress.
     */
    @Test
    public void testDebugString() {
        final String addressString = new PostalAddress().debugString();
        assertNotNull(UNEXPECTED_NULL, addressString);
        this.log.info("{}", addressString);
    }

}
