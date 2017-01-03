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
 * A UnitTest for Name objects.
 */
public class NameTest {

    /**
     * Test method for {@link Name}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new Name());
    }

    public void testName() {
        assertNotNull(new Name());
    }

    @Test
    public void testNameString() {
        final String expected = "Name";
        final Name nameObject = new Name(expected);
        assertNotNull(nameObject);
        assertEquals(expected, nameObject.getName());
    }

    @Test
    public void testCreate() {
        Name name = Name.create();
        assertNotNull(name);
    }

    /**
     * Test method for {@link Name}.
     */
    @Test
    public void testSetGetName() {
        final String value = "Name";
        final Name name = new Name();
        assertEquals(value, name.setName(value).getName());
    }

    /**
     * Test method for {@link Name}.
     */
    @Test
    public void testCapitalise() {
        new Name();
        assertEquals("Name", Name.capitalise("nAME"));
    }

    /**
     * Test method for {@link Name}.
     */
    @Test
    public void testDebugString() {
        final String string = new Name().debugString();
        assertNotNull(string);

    }

    /**
     * Test method for {@link Name}.
     */
    @Test
    public void testToString() {
        final String string = new Name().toString();
        assertNotNull(string);

    }

}
