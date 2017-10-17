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

package net.atf4j.data.factory;

import java.util.Arrays;

import net.atf4j.data.EmailAddress;
import net.atf4j.data.Person;
import net.atf4j.data.Person.Title;

/**
 * PersonFactory, a data factory to create data.
 */
public class PersonDataFactory extends AbstractDataFactory {

    private static PersonDataFactory instance = null;
    private String[] maleForenames;
    private String[] femaleForenames;
    private String[] surnames;

    /**
     * Instantiates a new person data factory.
     */
    protected PersonDataFactory() {
        super();
        initialise();
    }

    /**
     * Initialise.
     */
    protected void initialise() {
        try {
            this.maleForenames = load("person-male-forenames.txt");
        } catch (final Exception e) {
            this.log.error(e.getMessage());
        }

        try {
            this.femaleForenames = load("person-female-forenames.txt");
        } catch (final Exception e) {
            this.log.error(e.getMessage());
        }

        try {
            this.surnames = load("person-surnames.txt");
        } catch (final Exception e) {
            this.log.error(e.getMessage());
        }
    }

    /**
     * Gets the single instance of PersonDataFactory.
     *
     * @return single instance of PersonDataFactory
     */
    protected static PersonDataFactory getInstance() {
        if (PersonDataFactory.instance == null) {
            PersonDataFactory.instance = new PersonDataFactory();
        }
        return PersonDataFactory.instance;
    }

    /**
     * Creates the Person object.
     *
     * @return the postal address
     */
    public static Person create() {
        final Person person = new Person();
        person.forename(randomForename());
        person.surname(randomSurname());
        person.dateOfBirth(DataFactory.dateOfBirth());
        person.emailAddress(EmailAddress.create().toString());
        person.title(Title.DR);
        return person;
    }

    /**
     * Create a Random forename.
     *
     * @return the string
     */
    public static String randomForename() {
        if (rnd.nextBoolean()) {
            return randomMaleForename();
        } else {
            return randomFemaleForename();
        }
    }

    /**
     * Create Random male forename.
     *
     * @return the string
     */
    public static String randomMaleForename() {
        return randomEntry(getInstance().maleForenames);
    }

    /**
     * Create Random female forename.
     *
     * @return the string
     */
    public static String randomFemaleForename() {
        return randomEntry(getInstance().femaleForenames);
    }

    /**
     * Create Random surname.
     *
     * @return the string
     */
    public static String randomSurname() {
        return randomEntry(getInstance().surnames);
    }

    /**
     * Create Random fullname.
     *
     * @return the string
     */
    public static String randomFullname() {
        return String.format("%s %s", randomForename(), randomSurname());
    }

    /**
     * Create Random email.
     *
     * @return the string
     */
    public static String randomEmail() {
        return EmailAddress.create().toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PersonDataFactory [maleForenames=" + Arrays.toString(this.maleForenames) + ", femaleForenames="
                + Arrays.toString(this.femaleForenames) + ", surnames=" + Arrays.toString(this.surnames) + "]";
    }
}
