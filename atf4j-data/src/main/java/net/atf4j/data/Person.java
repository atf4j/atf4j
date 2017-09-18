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

import java.util.Calendar;

/**
 * Person.
 */
public class Person {

    /**
     * The Gender Enum.
     */
    public static enum Gender {
        MALE("Male"), FEMALE("Male"), UNKNOWN("");

        private final String genderString;

        /**
         * Instantiates a new gender.
         *
         * @param asText
         *            the as text
         */
        private Gender(final String asText) {
            this.genderString = asText;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return this.genderString;
        }
    };

    /**
     * The Title Enum.
     */
    public static enum Title {
        MR("Mr"), MRS("Mrs"), MS("Ms"), MISS("Miss"), SIR("Sir"), LADY("Lady"), LORD("Lord"), DR("Dr");

        /** The value. */
        private final String titleString;

        /**
         * Instantiates a new title.
         *
         * @param asText
         *            the as text
         */
        private Title(final String asText) {
            this.titleString = asText;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return this.titleString;
        }
    }

    private String title;
    private String forename;
    private String middlename;
    private String surname;
    private Calendar dob;
    private PostalAddress postalAddress;
    private String emailAddress;
    private String Gender;

    /**
     * Instantiates a new person.
     */
    public Person() {
    }

    /**
     * Person.
     *
     * @param forename
     *            the forename
     * @param middlename
     *            the middlename
     * @param surname
     *            the surname
     */
    public Person(final String forename, final String middlename, final String surname) {
        super();
        forename(forename);
        middlename(middlename);
        surname(surname);
    }

    /**
     * Title.
     *
     * @param title
     *            the title
     * @return the person
     */
    public Person title(final String title) {
        this.title = title;
        return this;
    }

    /**
     * Forename.
     *
     * @param forename
     *            the forename
     * @return the person
     */
    public Person forename(final String forename) {
        this.forename = forename;
        return this;
    }

    /**
     * Middlename.
     *
     * @param middlename
     *            the middlename
     * @return the person
     */
    public Person middlename(final String middlename) {
        this.middlename = middlename;
        return this;
    }

    /**
     * Surname.
     *
     * @param surname
     *            the surname
     * @return the person
     */
    public Person surname(final String surname) {
        this.surname = surname;
        return this;
    }

    /**
     * Date of birth.
     *
     * @param dob
     *            the dob
     * @return the person
     */
    public Person dateOfBirth(final Calendar dob) {
        this.dob = dob;
        return this;
    }

    /**
     * Sets the postal address.
     *
     * @param postalAddress
     *            the postal address
     * @return the person
     */
    public Person postalAddress(final PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
        return this;
    }

    /**
     * Sets the email address.
     *
     * @param emailAddress
     *            the new email address
     * @return the person
     */
    public Person emailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Gender.
     *
     * @param gender
     *            the gender
     * @return the person
     */
    public Person gender(final String gender) {
        this.Gender = gender;
        return this;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String title() {
        return this.title;
    }

    /**
     * Forename.
     *
     * @return the string
     */
    public String forename() {
        return this.forename;
    }

    /**
     * Middlename.
     *
     * @return the string
     */
    public String middlename() {
        return this.middlename;
    }

    /**
     * Surname.
     *
     * @return the string
     */
    public String surname() {
        return this.surname;
    }

    /**
     * Date of birth.
     *
     * @return the calendar
     */
    public Calendar dateOfBirth() {
        return this.dob;
    }

    /**
     * Age.
     *
     * @return the int
     */
    public int age() {
        final Calendar now = Calendar.getInstance();
        final int currentmonth = now.get(Calendar.MONTH);
        final int currentyear = now.get(Calendar.YEAR);

        final int month = this.dob.get(Calendar.MONTH);
        final int year = this.dob.get(Calendar.YEAR);

        final int age = (currentyear * 12 + currentmonth - (year * 12 + month)) / 12;

        return age;
    }

    /**
     * Gets the postal address.
     *
     * @return the postal address
     */
    public PostalAddress postalAddress() {
        return this.postalAddress;
    }

    /**
     * Gets the email address.
     *
     * @return the email address
     */
    public String emailAddress() {
        return this.emailAddress;
    }

    /**
     * Gender.
     *
     * @return the string
     */
    public String gender() {
        return this.Gender;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format(
                "Person [title=%s, forename=%s, middlename=%s, surname=%s, dob=%s, postalAddress=%s, emailAddress=%s]",
                this.title, this.forename, this.middlename, this.surname, this.dob, this.postalAddress,
                this.emailAddress);
    }

}
