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

/**
 * Person.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class Person {

    /** The forename. */
    private Forename forename;

    /** The middlename. */
    private Forename middlename;

    /** The surname. */
    private Surname surname;
    // private String title;
    // private String forename;
    // private String surname;
    // private Date dob;
    // private Address postalAddress;
    // private String emailAddress;
    // private Collection<Contact> contacts;

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
     */
    public void setForename(final String forename) {
        setForename(new Forename(forename));
    }

    /**
     * Sets the forename.
     *
     * @param forename
     *            the new forename
     */
    public void setForename(final Forename forename) {
        this.forename = forename;
    }

    /**
     * Sets the middlename.
     *
     * @param middlename
     *            the new middlename
     */
    public void setMiddlename(final String middlename) {
        setMiddlename(new Forename(middlename));
    }

    /**
     * Sets the middlename.
     *
     * @param middlename
     *            the new middlename
     */
    public void setMiddlename(final Forename middlename) {
        this.middlename = middlename;
    }

    /**
     * Sets the surname.
     *
     * @param surname
     *            the new surname
     */
    public void setSurname(final String surname) {
        setSurname(surname);
    }

    /**
     * Sets the surname.
     *
     * @param surname
     *            the new surname
     */
    public void setSurname(final Surname surname) {
        this.surname = surname;
    }

    /**
     * Gets the forename.
     *
     * @return the forename
     */
    public Forename getForename() {
        return this.forename;
    }

    /**
     * Gets the middlename.
     *
     * @return the middlename
     */
    public Forename getMiddlename() {
        return this.middlename;
    }

    /**
     * Gets the surname.
     *
     * @return the surname
     */
    public Surname getSurname() {
        return this.surname;
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
     * To string.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Person [");
        if (this.forename != null) {
            builder.append("forename=").append(this.forename).append(", ");
        }
        if (this.middlename != null) {
            builder.append("middlename=").append(this.middlename).append(", ");
        }
        if (this.surname != null) {
            builder.append("surname=").append(this.surname);
        }
        builder.append("]");
        return builder.toString();
    }

}
