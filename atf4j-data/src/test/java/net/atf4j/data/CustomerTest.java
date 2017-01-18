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

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for Customer objects.
 */
public class CustomerTest extends ResultsReporting {

    /**
     * Test method for Customer}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new Customer());
    }

    /**
     * Test method for Customer}.
     */
    @Test
    public void testSetGetTitle() {
        final String title = "Title";
        assertEquals(title, new Customer().title(title).title());
    }

    /**
     * Test method for Customer}.
     */
    @Test
    public void testSetGetForename() {
        final String forename = "Forename";
        assertEquals(forename, new Customer().forename(forename).forename());
    }

    /**
     * Test method for Customer}.
     */
    @Test
    public void testSetGetSurname() {
        final String surname = "Surname";
        assertEquals(surname, new Customer().surname(surname).surname());
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
