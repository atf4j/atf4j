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

import java.util.Date;

import org.junit.Test;

/**
 * A UnitTest for Person objects.
 */
public class PersonTest {

    /**
     * Test method for {@link Person}.
     */
    @Test
    public void testPerson() {
        assertNotNull(new Person());
    }

    /**
     * Test method for {@link Person}.
     */
    @Test
    public void testPersonStringStringString() {
        final Person person = new Person("Forname", "MiddleName", "Surname");
        assertNotNull(person);
    }

    @Test
    public void testCreate() {
        assertNotNull(Person.create());
    }

    /**
     * Test method for {@link Person}.
     */
    @Test
    public void testSetGetTitle() {
        final String actual = "";
        assertEquals(actual, new Person().setTitle(actual).getTitle());
    }

    /**
     * Test method for {@link Person}.
     */
    @Test
    public void testSetGetForenameString() {
        final String actual = "Forename";
        assertEquals(actual, new Person().setForename(actual).getForename());
    }

    /**
     * Test method for {@link Person}.
     */
    @Test
    public void testSetGetMiddlenameString() {
        final String actual = "Middlename";
        assertEquals(actual, new Person().setMiddlename(actual).getMiddlename());
    }

    /**
     * Test method for {@link Person}.
     */
    @Test
    public void testSetGetSurnameString() {
        final String actual = "Surname";
        assertEquals(actual, new Person().setSurname(actual).getSurname());
    }

    /**
     * Test method for {@link Person}.
     */
    @Test
    public void testSetGetDob() {
        final Date actual = new Date();
        assertEquals(actual, new Person().setDob(actual).getDob());
    }

    /**
     * Test method for {@link Person}.
     */
    @Test
    public void testSetGetPostalAddress() {
        final PostalAddress actual = null;
        assertEquals(actual, new Person().setPostalAddress(actual).getPostalAddress());
    }

    /**
     * Test method for {@link Person}.
     */
    @Test
    public void testSetGetEmailAddress() {
        final String actual = "";
        assertEquals(actual, new Person().setEmailAddress(actual).getEmailAddress());
    }

    /**
     * Test method for {@link Person}.
     */
    @Test
    public void testToString() {
        new Person().toString();
    }

    /**
     * Test method for {@link Person}.
     */
    @Test
    public void testDebugString() {
        new Person().debugString();
    }

}
