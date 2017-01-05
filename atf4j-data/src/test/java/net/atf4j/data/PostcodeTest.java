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

/**
 * A UnitTest for Postcode objects.
 */
public class PostcodeTest {

    /**
     * Test method for Postcode}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new Postcode());
    }

    /**
     * Test method for Postcode}.
     */
    @Test
    public void testPostcode() {
        assertNotNull(new Postcode());
    }

    public void testPostcodeCreate() {
        assertNotNull(Postcode.create());
    }

    /**
     * Test method for Postcode}.
     */
    @Test
    public void testPostcodeString() {
        assertNotNull(new Postcode("AA00 9XX"));
    }

    /**
     * Test method for Postcode}.
     */
    @Test
    public void testVerify() {
        assertTrue(Postcode.verify("AA00 9XX"));
    }

    /**
     * Test method for Postcode}.
     */
    @Test
    public void testDebugString() {
        final String postcode = new Postcode().debugString();
        assertNotNull(postcode);
    }

    /**
     * Test method for Postcode}.
     */
    @Test
    public void testToString() {
        final String postcode = new Postcode().toString();
        assertNotNull(postcode);
    }

}
