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
 * TelephoneNumber.
 */
public class Telephone {

    private String type;
    private String number;
    // Type Mobile|Landline|Fax|other
    // Country Code
    // Area Code
    // Number

    /**
     * Instantiates a new telephone number.
     */
    public Telephone() {
        super();
    }

    /**
     * Instantiates a new telephone number.
     *
     * @param number
     *            the number
     */
    public Telephone(final String number) {
        super();
        this.number = number;
    }

    /**
     * Sets the number.
     *
     * @param number
     *            the number to set
     * @return the telephone number
     */
    public Telephone setNumber(final String number) {
        this.number = number;
        return this;
    }

    /**
     * Gets the number.
     *
     * @return the number
     */
    public String getNumber() {
        return this.number;
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("%s [number=%s]", this.getClass().getSimpleName(), this.number);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

}
