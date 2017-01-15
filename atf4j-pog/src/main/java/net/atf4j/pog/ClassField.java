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

    public enum FieldType {
        BOOLEAN("boolean"),
        DATE("Date"),
        NUMBER("BigDecimal"),
        STRING("String"),
        VALUE("Object"),
        OBJECT("Object");

        private final String type;

        FieldType(final String asText) {
            this.type = asText;
        }

        public static FieldType initialise() {
            return FieldType.OBJECT;
        }

        public static FieldType fromString(final String asText) {
            for (final FieldType value : values()) {
                if (value.type.equals(asText)) {
                    return value;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.type;
        }
    }

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private static final String FIELD_CODE = "%s %s %s;";
    private String access;
    private String type;
    private String name;

    public ClassField() {
        setAccess("private");
        setType("Object");
        final String uniqueness = UUID.randomUUID().toString().substring(0, 8);
        setName(String.format("object%s", uniqueness));
    }

    public ClassField(final String type, final String name) {
        setAccess("private");
        setType(type);
        setName(name);
    }

    public ClassField(final FieldType fieldType, final String name) {
        setAccess("private");
        setType(fieldType);
        setName(name);
    }

    public ClassField(final String access, final String type, final String name) {
        super();
        setAccess(access);
        setType(type);
        setName(name);
    }

    public ClassField setAccess(final String access) {
        this.access = access;
        return this;
    }

    public ClassField setType(final String type) {
        this.type = type;
        return this;
    }

    public ClassField setType(final FieldType fieldType) {
        setType(fieldType.toString());
        return this;
    }

    public ClassField setName(final String name) {
        this.name = fieldCase(name);
        return this;
    }

    public String getAccess() {
        return this.access;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String fieldCase(final String string) {
        final char[] charArray = string.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public String toCode() {
        final String string = String.format(FIELD_CODE, this.access, this.type, this.name);
        return string;
    }

    @Override
    public String toString() {
        return String.format("ClassField [access=%s, type=%s, name=%s]",
                this.access,
                this.type,
                this.name);
    }

}
