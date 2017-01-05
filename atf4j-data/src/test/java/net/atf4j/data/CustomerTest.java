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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * A UnitTest for Customer objects.
 */
public class CustomerTest {

    /**
     * Test method for Customer}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new Customer());
    }

    @Test
    public void testCreate() {
        assertNotNull(Customer.create());
    }

    /**
     * Test method for Customer}.
     */
    @Test
    public void testSetGetTitle() {
        final String title = "Title";
        assertEquals(title, new Customer().setTitle(title).getTitle());
    }

    /**
     * Test method for Customer}.
     */
    @Test
    public void testSetGetForename() {
        final String forename = "Forename";
        assertEquals(forename, new Customer().setForename(forename).getForename());
    }

    /**
     * Test method for Customer}.
     */
    @Test
    public void testSetGetSurname() {
        final String surname = "Surname";
        assertEquals(surname, new Customer().setSurname(surname).getSurname());
    }

    /**
     * Test method for Customer}.
     */
    @Test
    public void testDebugString() {
        final String string = new Customer().debugString();
        assertNotNull(string);
    }

    /**
     * Test method for Customer}.
     */
    @Test
    public void testToString() {
        final String string = new Customer().toString();
        assertNotNull(string);
    }

}
