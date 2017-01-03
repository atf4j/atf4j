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

    private String number;
    private String type;
    // Country Code
    // Area Code
    // Number

    public enum Type {
        Mobile,
        Landline,
        Fax;
    }

    public static Telephone create() {
        return new Telephone();
    }

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
        setNumber(number);
    }

    public Telephone(final String number, final String type) {
        super();
        setNumber(number);
        setType(type);
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
     * Sets the type.
     *
     * @param type
     *            the type
     * @return the telephone
     */
    public Telephone setType(final String type) {
        this.type = type;
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
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("%s [number=%s,type=%s]",
                this.getClass().getSimpleName(),
                this.getNumber(),
                this.getType());
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

}
