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

import org.junit.Assert;
import org.junit.Test;

/**
 * A UnitTest for Surname objects.
 */
public class SurnameTest {

    private static final String SURNAME = "Surname";

    /**
     * Test method for {@link Surname}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new Surname());
    }

    /**
     * Test method for { net.atf4j.data.Surname()}.
     */
    @Test
    public final void testSurname() {
        Assert.assertEquals(SURNAME, new Surname(SURNAME).getName());
    }

    /**
     * Test method for {@link Surname}.
     */
    @Test
    public void testDebugString() {
        final String string = new Surname().debugString();
        assertNotNull(string);
    }

    /**
     * Test method for {@link Surname}.
     */
    @Test
    public void testToString() {
        final String string = new Surname().toString();
        assertNotNull(string);
    }

}
