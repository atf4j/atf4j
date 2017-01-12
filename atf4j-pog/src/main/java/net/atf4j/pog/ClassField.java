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

/**
 * A Class to represent a field of Generated Class.
 */
public class ClassField {

    private static final String FIELD_CODE = "private %s %s;";
    private String type;
    private String name;

    public ClassField() {
        super();
        setType("Object");
        final String uniqueness = UUID.randomUUID().toString();
        setName(this.name = String.format("object%s", uniqueness));
    }

    public ClassField(final String type, final String name) {
        super();
        setType(type);
        setName(name);
    }

    public ClassField setType(final String type) {
        this.type = type;
        return this;
    }

    public ClassField setName(final String name) {
        this.name = fieldCase(name);
        return this;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    private String fieldCase(final String string) {
        final String stem = ("" + string.charAt(0)).toLowerCase();
        final String suffix = string.substring(1, string.length());
        return String.format("%s%s", stem, suffix);
    }

    @Override
    public String toString() {
        return String.format(FIELD_CODE, this.type, this.name);
    }

}
