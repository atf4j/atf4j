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

package net.atf4j.pog;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Class to represent a field of the class to be Generated.
 */
public class ClassField {

    /**
     * The FieldType Enum.
     */
    public enum FieldType {

        /** The boolean. */
        BOOLEAN("boolean"),
        /** The date. */
        DATE("Date"),
        /** The number. */
        NUMBER("BigDecimal"),
        /** The string. */
        STRING("String"),
        /** The value. */
        VALUE("Object"),
        /** The object. */
        OBJECT("Object");

        /** The type. */
        private final String type;

        /**
         * Instantiates a new field type.
         *
         * @param asText the as text
         */
        FieldType(final String asText) {
            type = asText;
        }

        /**
         * Initialise.
         *
         * @return the field type
         */
        public static FieldType initialise() {
            return FieldType.OBJECT;
        }

        /**
         * From string.
         *
         * @param asText the as text
         * @return the field type
         */
        public static FieldType fromString(final String asText) {
            for (final FieldType value : values()) {
                if (value.type.equals(asText)) {
                    return value;
                }
            }
            return null;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return type;
        }
    }

    /** The log. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The Constant FIELD_CODE. */
    private static final String FIELD_CODE = "%s %s %s;";

    /** The access. */
    private String access;

    /** The type. */
    private String type;

    /** The name. */
    private String name;

    /**
     * Instantiates a new class field.
     */
    public ClassField() {
        setAccess("private");
        setType("Object");
        final String uniqueness = UUID.randomUUID().toString().substring(0, 8);
        setName(String.format("object%s", uniqueness));
    }

    /**
     * Instantiates a new class field.
     *
     * @param type the type
     * @param name the name
     */
    public ClassField(final String type, final String name) {
        setAccess("private");
        setType(type);
        setName(name);
    }

    /**
     * Instantiates a new class field.
     *
     * @param fieldType the field type
     * @param name the name
     */
    public ClassField(final FieldType fieldType, final String name) {
        setAccess("private");
        setType(fieldType);
        setName(name);
    }

    /**
     * Instantiates a new class field.
     *
     * @param access the access
     * @param type the type
     * @param name the name
     */
    public ClassField(final String access, final String type, final String name) {
        super();
        setAccess(access);
        setType(type);
        setName(name);
    }

    /**
     * Sets the access.
     *
     * @param access the access
     * @return the class field
     */
    public ClassField setAccess(final String access) {
        this.access = access;
        return this;
    }

    /**
     * Sets the type.
     *
     * @param type the type
     * @return the class field
     */
    public ClassField setType(final String type) {
        this.type = type;
        return this;
    }

    /**
     * Sets the type.
     *
     * @param fieldType the field type
     * @return the class field
     */
    public ClassField setType(final FieldType fieldType) {
        setType(fieldType.toString());
        return this;
    }

    /**
     * Sets the name.
     *
     * @param name the name
     * @return the class field
     */
    public ClassField setName(final String name) {
        this.name = fieldCase(name);
        return this;
    }

    /**
     * Gets the access.
     *
     * @return the access
     */
    public String getAccess() {
        return access;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Field case.
     *
     * @param string the string
     * @return the string
     */
    public String fieldCase(final String string) {
        final char[] charArray = string.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    /**
     * To code.
     *
     * @return the string
     */
    public String toCode() {
        final String string = String.format(FIELD_CODE, access, type, name);
        return string;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("ClassField [access=%s, type=%s, name=%s]", access, type, name);
    }

}
