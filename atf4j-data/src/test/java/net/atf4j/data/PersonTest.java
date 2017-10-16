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
import net.atf4j.data.Person.Gender;
import net.atf4j.data.Person.Title;

/**
 * A Unit test class for Person objects.
 */
public final class PersonTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test person.
     */
    @Test
    public void testPerson() {
        final Person person = new Person().forename("Forname").middlename("MiddleName").surname("Surname");
        assertNotNull(UNEXPECTED_NULL, person);
    }

    /**
     * Test person forname middle surname.
     */
    @Test
    public void testPersonFornameMiddleSurname() {
        final Person person = new Person("Forname", "MiddleName", "Surname");
        assertNotNull(UNEXPECTED_NULL, person);
    }

    /**
     * Test set get title.
     */
    @Test
    public void testSetGetTitle() {
        final Person person = new Person();
        assertNotNull(UNEXPECTED_NULL, person);
        assertEquals(Title.SIR, person.title(Title.SIR).title());
    }

    /**
     * Test set get forename string.
     */
    @Test
    public void testSetGetForenameString() {
        final String actual = "Forename";
        assertEquals(actual, new Person().forename(actual).forename());
    }

    /**
     * Test set get middlename string.
     */
    @Test
    public void testSetGetMiddlenameString() {
        final String actual = "Middlename";
        assertEquals(actual, new Person().middlename(actual).middlename());
    }

    /**
     * Test set get surname string.
     */
    @Test
    public void testSetGetSurnameString() {
        final String actual = "Surname";
        assertEquals(actual, new Person().surname(actual).surname());
    }

    /**
     * Test set get dob.
     */
    @Test
    public void testSetGetDob() {
        final Calendar actual = Calendar.getInstance();
        assertEquals(actual, new Person().dateOfBirth(actual).dateOfBirth());
    }

    /**
     * Test set get postal address.
     */
    @Test
    public void testSetGetPostalAddress() {
        final PostalAddress actual = null;
        assertEquals(actual, new Person().postalAddress(actual).postalAddress());
    }

    /**
     * Test set get email address.
     */
    @Test
    public void testSetGetEmailAddress() {
        final String actual = "";
        assertEquals(actual, new Person().emailAddress(actual).emailAddress());
    }

    /**
     * Test set get gender.
     */
    @Test
    public void testSetGetGender() {
        assertEquals(Gender.UNKNOWN, new Person().gender(Gender.UNKNOWN).gender());
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        new Person().toString();
    }

}
