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

/**
 * Consumer Data.
 */
public class Customer {

    protected String title;
    protected Forename forename;
    protected Surname surname;

    public static Customer create() {
        return new Customer();
    }

    /**
     * Instantiates a new Customer.
     */
    public Customer() {
        super();
        this.title = "";
        this.forename = new Forename("");
        this.surname = new Surname("");
    }

    /**
     * Instantiates a new customer.
     *
     * @param title
     *            the title
     * @param forename
     *            the forename
     * @param surname
     *            the surname
     */
    public Customer(final String title, final Forename forename, final Surname surname) {
        super();
        this.title = title;
        this.forename = forename;
        this.surname = surname;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the title
     * @return the customer
     */
    public Customer setTitle(final String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the forename.
     *
     * @param forename
     *            the forename
     * @return the customer
     */
    public Customer setForename(final String forename) {
        return setForename(new Forename(forename));
    }

    /**
     * Sets the forename of the Customer.
     *
     * @param forename
     *            the forename
     * @return the customer
     */
    public Customer setForename(final Forename forename) {
        this.forename = forename;
        return this;
    }

    /**
     * Sets the surname.
     *
     * @param surname
     *            the surname
     * @return the customer
     */
    public Customer setSurname(final String surname) {
        return setSurname(new Surname(surname));
    }

    /**
     * Sets the surname of the Customer.
     *
     * @param surname
     *            the surname
     * @return the customer
     */
    public Customer setSurname(final Surname surname) {
        this.surname = surname;
        return this;
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
     * Gets the forename.
     *
     * @return the forename
     */
    public String getForename() {
        return this.forename.toString();
    }

    /**
     * Gets the surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return this.surname.toString();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("%s [title=%s, forename=%s, surname=%s]", this.getClass().getSimpleName(),this.title, this.forename, this.surname);
    }

}
