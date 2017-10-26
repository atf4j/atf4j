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

import net.atf4j.core.TestResultsReporting;

/**
 * A Class to represent a field of the class to be Generated.
 */
public class ClassField extends TestResultsReporting {

    /** Code Template for a field. */
    private static final String FIELD_CODE = "%s %s %s = %s;";

    /** access modifier for field. */
    private AccessModifier accessModifier = AccessModifier.DEFAULT;

    /** access modifier as String. */
    private String accessModifierString = accessModifier.value;

    /** type of field . */
    private FieldType fieldType = FieldType.OBJECT;

    /** type of field as String. */
    private String fieldTypeString = fieldType.value;

    /** name of field. */
    private String fieldName;

    /** The initial value. */
    private String initialValue = "null";

    /**
     * AccessModifiers Enum.
     * <p>
     * Default, public, protected, and private
     */
    public enum AccessModifier {

        /** Default. */
        DEFAULT(""),

        /** Date. */
        PUBLIC("public"),

        /** Number. */
        PROTECTED("protected"),

        /** String. */
        PRIVATE("private");

        /** the value of the access modifier. */
        private final String value;

        /**
         * Instantiates a new field type.
         *
         * @param asText the as text
         */
        AccessModifier(final String asText) {
            value = asText;
        }

        /**
         * Initialise.
         *
         * @return the field type
         */
        public static AccessModifier initialise() {
            return AccessModifier.DEFAULT;
        }

        /**
         * FieldType From string value.
         *
         * @param asText the as text
         * @return the field type
         */
        public static AccessModifier fromString(final String asText) {
            for (final AccessModifier candidate : values()) {
                if (candidate.value.equals(asText)) {
                    return candidate;
                }
            }
            return AccessModifier.DEFAULT;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * The FieldType Enum.
     */
    public enum FieldType {

        /** Boolean. */
        BOOLEAN("Boolean"),

        /** Date. */
        DATE("Date"),

        /** Number. */
        NUMBER("BigDecimal"),

        /** Object. */
        OBJECT("Object"),

        /** String. */
        STRING("String"),

        /** The Other. */
        Other("Other");

        /** The value. */
        private final String value;

        /**
         * Instantiates a new field type.
         *
         * @param asText the as text
         */
        FieldType(final String asText) {
            value = asText;
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
         * FieldType From string value.
         *
         * @param asText the as text
         * @return the field type
         */
        public static FieldType fromString(final String asText) {
            for (final FieldType candidate : values()) {
                if (candidate.value.equals(asText)) {
                    return candidate;
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
            return value;
        }
    }

    /**
     * Instantiates a new class field.
     */
    public ClassField() {
        setAccessModifier(AccessModifier.DEFAULT);
        final String uniqueness = UUID.randomUUID().toString().substring(0, 8);
        setFieldName(String.format("object%s", uniqueness));
    }

    /**
     * Instantiates a new class field.
     *
     * @param fieldType the type
     * @param fieldName the name
     */
    public ClassField(final FieldType fieldType, final String fieldName) {
        setAccessModifier(AccessModifier.DEFAULT);
        setFieldType(fieldType);
        setFieldName(fieldName);
    }

    /**
     * Instantiates a new class field.
     *
     * @param fieldType the field type
     * @param fieldName the field name
     */
    public ClassField(final String fieldType, final String fieldName) {
        setAccessModifier(AccessModifier.DEFAULT);
        setFieldType(fieldType);
        setFieldName(fieldName);
    }

    /**
     * Sets the access modifier.
     *
     * @param accessModifier the access modifier
     * @return the class field
     */
    public ClassField setAccessModifier(final AccessModifier accessModifier) {
        this.accessModifier = accessModifier;
        accessModifierString = accessModifier.value;
        return this;
    }

    /**
     * Sets the access modifier.
     *
     * @param accessModifier the access modifier
     * @return the class field
     */
    protected ClassField setAccessModifier(final String accessModifier) {
        accessModifierString = accessModifier;
        this.accessModifier = AccessModifier.fromString(accessModifier);
        return this;
    }

    /**
     * Sets the field type.
     *
     * @param fieldType the field type
     * @return the class field
     */
    public ClassField setFieldType(final FieldType fieldType) {
        this.fieldType = fieldType;
        fieldTypeString = fieldType.value;
        return this;
    }

    /**
     * Sets the field type.
     *
     * @param fieldTypeString the field type string
     * @return the class field
     */
    public ClassField setFieldType(final String fieldTypeString) {
        this.fieldTypeString = fieldTypeString;
        fieldType = FieldType.fromString(fieldTypeString);
        return this;
    }

    /**
     * Sets the field name.
     *
     * @param fieldName the field name
     * @return the class field
     */
    public ClassField setFieldName(final String fieldName) {
        this.fieldName = fieldCase(fieldName);
        return this;
    }

    /**
     * Sets the initial value.
     *
     * @param initialValue the initial value
     * @return the class field
     */
    public ClassField setInitialValue(final String initialValue) {
        this.initialValue = initialValue;
        return this;
    }

    /**
     * Gets the access modifier.
     *
     * @return the access modifier
     */
    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    /**
     * Gets the access modifier value.
     *
     * @return the access modifier value
     */
    public String getAccessModifierValue() {
        return accessModifierString;
    }

    /**
     * Gets the field type string.
     *
     * @return the field type string
     */
    public String getFieldTypeString() {
        return fieldTypeString;
    }

    /**
     * Gets the field name.
     *
     * @return the field name
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Gets the initial value.
     *
     * @return the initial value
     */
    public String getInitialValue() {
        return initialValue;
    }

    /**
     * Field case.
     *
     * @param string the string
     * @return the string
     */
    private String fieldCase(final String string) {
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
        return String.format(FIELD_CODE,
                accessModifier,
                fieldType,
                fieldName,
                initialValue);
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format(
                "%s [accessModifier=%s, accessModifierValue=%s, fieldType=%s, fieldTypeString=%s, fieldName=%s, initialValue=%s]",
                this.getClass().getSimpleName(),
                accessModifier,
                accessModifierString,
                fieldType,
                fieldTypeString,
                fieldName,
                initialValue);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return toCode();
    }

}
