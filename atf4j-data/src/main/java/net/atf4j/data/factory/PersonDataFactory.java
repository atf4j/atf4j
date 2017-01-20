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

import net.atf4j.data.EmailAddress;
import net.atf4j.data.Person;

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
     * Creates the.
     *
     * @return the postal address
     */
    public static Person create() {
        final Person person = new Person();
        person.forename(randomForename());
        person.surname(randomSurname());
        person.dateOfBirth(DataFactory.dateOfBirth());
        person.emailAddress(EmailAddress.create().toString());
        person.title();
        return person;
    }

    /**
     * Random forename.
     *
     * @return the string
     */
    public static String randomForename() {
        if (random.nextBoolean()) {
            return randomMaleForename();
        } else {
            return randomFemaleForename();
        }
    }

    /**
     * Random male forename.
     *
     * @return the string
     */
    public static String randomMaleForename() {
        return randomEntry(getInstance().maleForenames);
    }

    /**
     * Random female forename.
     *
     * @return the string
     */
    public static String randomFemaleForename() {
        return randomEntry(getInstance().femaleForenames);
    }

    /**
     * Random surname.
     *
     * @return the string
     */
    public static String randomSurname() {
        return randomEntry(getInstance().surnames);
    }

    /**
     * Random fullname.
     *
     * @return the string
     */
    public static String randomFullname() {
        return String.format("%s %s", randomForename(), randomSurname());
    }

    /**
     * Random email.
     *
     * @return the string
     */
    public static String randomEmail() {
        return EmailAddress.create().toString();
    }

}
