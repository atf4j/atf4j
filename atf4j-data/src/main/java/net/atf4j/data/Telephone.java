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
    private Type type;
    // Country Code
    // Area Code
    // Number

    public enum Type {
        Phone("Phone"),
        Landline("Landline"),
        Mobile("Mobile"),
        Fax("Fax"),
        Telex("Telex"),
        Unknown("Unknown");

        private final String typeName;

        Type(final String name) {
            this.typeName = name;
        }

        public static Type initialise() {
            return Type.Phone;
        }

        public static Type forString(final String asText) {
            for (final Type value : values()) {
                if (value.typeName.equals(asText)) {
                    return value;
                }
            }
            return null;
        }
    }

    public static Telephone create() {
        return new Telephone();
    }

    public static Telephone create(final Type type) {
        return new Telephone().setType(type);
    }

    public static boolean verify() {
        return false;
    }

    /**
     * Instantiates a new telephone number.
     */
    public Telephone() {
        super();
        setNumber("");
        setType(Type.Unknown);
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
        setType(Type.Phone);
    }

    /**
     * Instantiates a new telephone.
     *
     * @param number
     *            the number
     * @param type
     *            the type
     */
    public Telephone(final String type, final String number) {
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
        this.type = Type.forString(type);
        return this;
    }

    public Telephone setType(final Telephone.Type type) {
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
        if (this.type != null) {
            return this.type.toString();
        } else {
            return "Telephone";
        }
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("%s [number=%s, type=%s]",
                this.getClass().getSimpleName(),
                this.getNumber(),
                this.getType());
    }

    @Override
    public String toString() {
        return String.format("%s : %s",
                this.getType(),
                this.getNumber());
    }

}
