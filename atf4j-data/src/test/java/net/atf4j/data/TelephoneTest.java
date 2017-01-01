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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * A UnitTest for Telephone objects.
 */
public class TelephoneTest {

    private static final String _0123456789 = "0123456789";

    /**
     * Test method for {@link Telephone}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new Telephone());
    }

    /**
     * Test method for {@link Telephone}.
     */
    @Test
    public void testTelephone() {
        final Telephone telephone = new Telephone();
        assertNotNull(telephone);
    }

    /**
     * Test method for {@link Telephone}.
     */
    @Test
    public void testTelephoneString() {
        final Telephone telephone = new Telephone(_0123456789);
        assertNotNull(telephone);
        assertEquals("Telephone [number=0123456789]", telephone.toString());
    }

    /**
     * Test method for {@link Telephone}.
     */
    @Test
    public void testSetGetNumber() {
        final Telephone telephone = new Telephone();
        assertNotNull(telephone);
        assertEquals(_0123456789, telephone.setNumber(_0123456789).getNumber());
    }

    /**
     * Test method for {@link Telephone}.
     */
    @Test
    public void testDebugString() {
        final String string = new Telephone().debugString();
        assertNotNull(string);
    }

    /**
     * Test method for {@link Telephone}.
     */
    @Test
    public void testToString() {
        final String string = new Telephone().toString();
        assertNotNull(string);
    }

}
