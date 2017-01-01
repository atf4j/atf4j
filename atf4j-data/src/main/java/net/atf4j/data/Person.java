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

import java.util.Date;

/**
 * Person.
 */
public class Person {

    private String title;
    private Forename forename;
    private Name middlename;
    private Surname surname;
    private Date dob;
    private PostalAddress postalAddress;
    private String emailAddress;

    public static Person create() {
        return new Person();
    }

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
        setForename(forename);
        setMiddlename(middlename);
        setSurname(surname);
    }

    /**
     * Sets the forename.
     *
     * @param forename
     *            the new forename
     * @return the person
     */
    public Person setForename(final String forename) {
        return setForename(new Forename(forename));
    }

    /**
     * Sets the forename.
     *
     * @param forename
     *            the new forename
     * @return the person
     */
    public Person setForename(final Forename forename) {
        this.forename = forename;
        return this;
    }

    /**
     * Sets the middlename.
     *
     * @param middlename
     *            the new middlename
     * @return the person
     */
    public Person setMiddlename(final String middlename) {
        return setMiddlename(new Forename(middlename));
    }

    /**
     * Sets the middlename.
     *
     * @param middlename
     *            the new middlename
     * @return the person
     */
    public Person setMiddlename(final Name middlename) {
        this.middlename = middlename;
        return this;
    }

    /**
     * Sets the surname.
     *
     * @param surname
     *            the new surname
     * @return the person
     */
    public Person setSurname(final String surname) {
        return setSurname(new Surname(surname));
    }

    /**
     * Sets the surname.
     *
     * @param surname
     *            the new surname
     * @return the person
     */
    public Person setSurname(final Surname surname) {
        this.surname = surname;
        return this;
    }

    /**
     * Gets the forename.
     *
     * @return the forename
     */
    public String getForename() {
        return this.forename.toString();
    }

    /**
     * Gets the middlename.
     *
     * @return the middlename
     */
    public String getMiddlename() {
        return this.middlename.toString();
    }

    /**
     * Gets the surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return this.surname.toString();
    }

    /**
     * nameAsString.
     *
     * @return fullname as String
     */
    public String nameAsString() {
        final StringBuilder fullname = new StringBuilder();
        if (this.forename != null) {
            fullname.append("forename=").append(this.forename).append(", ");
        }
        if (this.middlename != null) {
            fullname.append("middlename=").append(this.middlename).append(", ");
        }
        if (this.surname != null) {
            fullname.append("surname=").append(this.surname);
        }
        return fullname.toString();
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the title
     * @return the person
     */
    public Person setTitle(final String title) {
        this.title = title;
        return this;
    }

    /**
     * Gets the dob.
     *
     * @return the dob
     */
    public Date getDob() {
        return this.dob;
    }

    /**
     * Sets the dob.
     *
     * @param dob
     *            the dob
     * @return the person
     */
    public Person setDob(final Date dob) {
        this.dob = dob;
        return this;
    }

    /**
     * Gets the postal address.
     *
     * @return the postal address
     */
    public PostalAddress getPostalAddress() {
        return this.postalAddress;
    }

    /**
     * Sets the postal address.
     *
     * @param postalAddress
     *            the postal address
     * @return the person
     */
    public Person setPostalAddress(final PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
        return this;
    }

    /**
     * Gets the email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /**
     * Sets the email address.
     *
     * @param emailAddress
     *            the new email address
     * @return the person
     */
    public Person setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format(
                "Person [title=%s, forename=%s, middlename=%s, surname=%s, dob=%s, postalAddress=%s, emailAddress=%s]",
                this.title, this.forename, this.middlename, this.surname, this.dob, this.postalAddress,
                this.emailAddress);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

}
