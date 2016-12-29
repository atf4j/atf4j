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
 * Consumer Data.
 */
public class Customer {

    protected Forename forename;
    protected Surname surname;

    /**
     * Instantiates a new consumer.
     */
    public Customer() {
        super();
        this.forename = new Forename(null);
        this.surname = new Surname(null);
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
     * Sets the forename.
     *
     * @param forename the forename
     * @return the customer
     */
    public Customer setForename(final Forename forename) {
        this.forename = forename;
        return this;
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
     * Sets the surname.
     *
     * @param surname the surname
     * @return the customer
     */
    public Customer setSurname(final Surname surname) {
        this.surname = surname;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Customer [forename=%s, surname=%s]", this.forename, this.surname);
    }

}
