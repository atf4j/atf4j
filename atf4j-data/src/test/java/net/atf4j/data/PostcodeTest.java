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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for Postcode objects.
 */
public class PostcodeTest extends ResultsReporting {

    /**
     * Test method for {@link Postcode}.
     */
    @Test
    public void testDefaultConstructor() {
        new Postcode();
    }

    /**
     * Test method for {@link Postcode}.
     */
    @Test
    public void testPostcode() {
        new Postcode();
    }

    /**
     * Test method for {@link Postcode}.
     */
    @Test
    public void testPostcodeString() {
        new Postcode();
    }

    /**
     * Test method for {@link Postcode}.
     */
    @Test
    public void testVerify() {
        new Postcode();
    }

    /**
     * Test method for {@link Postcode}.
     */
    @Test
    public void testDebugString() {
        final String postcode = new Postcode().debugString();
        assertNotNull(postcode);
        this.log.info(postcode);
    }

    /**
     * Test method for {@link Postcode}.
     */
    @Test
    public void testToString() {
        final String postcode = new Postcode().toString();
        assertNotNull(postcode);
        this.log.info(postcode);
    }

}
