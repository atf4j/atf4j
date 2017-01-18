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

import java.util.Calendar;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for Person objects.
 */
public class PersonTest extends ResultsReporting {

    /**
     * Test method for void.
     */
    @Test
    public void testPerson() {
        final Person person = new Person()
                                          .forename("Forname")
                                          .middlename("MiddleName")
                                          .surname("Surname");
        assertNotNull(person);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testPersonFornameMiddleSurname() {
        final Person person = new Person("Forname", "MiddleName", "Surname");
        assertNotNull(person);
    }

    /**
     * Test method for Person}.
     */
    @Test
    public void testSetGetTitle() {
        final String actual = "";
        assertEquals(actual, new Person().title(actual).title());
    }

    /**
     * Test method for Person}.
     */
    @Test
    public void testSetGetForenameString() {
        final String actual = "Forename";
        assertEquals(actual, new Person().forename(actual).forename());
    }

    /**
     * Test method for Person}.
     */
    @Test
    public void testSetGetMiddlenameString() {
        final String actual = "Middlename";
        assertEquals(actual, new Person().middlename(actual).middlename());
    }

    /**
     * Test method for Person}.
     */
    @Test
    public void testSetGetSurnameString() {
        final String actual = "Surname";
        assertEquals(actual, new Person().surname(actual).surname());
    }

    /**
     * Test method for Person}.
     */
    @Test
    public void testSetGetDob() {
        final Calendar actual = Calendar.getInstance();
        assertEquals(actual, new Person().dateOfBirth(actual).dateOfBirth());
    }

    /**
     * Test method for Person}.
     */
    @Test
    public void testSetGetPostalAddress() {
        final PostalAddress actual = null;
        assertEquals(actual, new Person().postalAddress(actual).postalAddress());
    }

    /**
     * Test method for Person}.
     */
    @Test
    public void testSetGetEmailAddress() {
        final String actual = "";
        assertEquals(actual, new Person().emailAddress(actual).emailAddress());
    }

    /**
     * Test method for Person}.
     */
    @Test
    public void testToString() {
        new Person().toString();
    }

}
