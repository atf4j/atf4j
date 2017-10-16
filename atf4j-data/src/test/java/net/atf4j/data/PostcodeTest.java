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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A Unit test class for Postcode objects.
 */
public final class PostcodeTest extends TestResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test method for Postcode.
     */
    @Test
    public void testDefaultConstructor() {
        final Postcode postcode = new Postcode();
        assertNotNull(UNEXPECTED_NULL, postcode);
    }

    /**
     * Test method for Postcode.
     */
    @Test
    public void testPostcode() {
        final Postcode postcode = new Postcode();
        assertNotNull(UNEXPECTED_NULL, postcode);
    }

    /**
     * Test method for void.
     */
    public void testPostcodeCreate() {
        final Postcode postcode = Postcode.create();
        assertNotNull(UNEXPECTED_NULL, postcode);
    }

    /**
     * Test method for Postcode.
     */
    @Test
    public void testPostcodeString() {
        final Postcode postcode = new Postcode("AA00 9XX");
        assertNotNull(UNEXPECTED_NULL, postcode);
    }

    /**
     * Test method for Postcode.
     */
    @Test
    public void testVerify() {
        assertTrue(Postcode.verify("AA00 9XX"));
    }

    /**
     * Test method for Postcode.
     */
    @Test
    public void testToString() {
        final Postcode postcode = new Postcode();
        final String string = postcode.toString();
        assertNotNull(UNEXPECTED_NULL, string);
    }

}
