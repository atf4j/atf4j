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
 * A Class to represent a method of a Generated Class.
 */
public class ClassMethod {
    private static final String METHOD_CODE = "public %s %s() { return new %s() }";
    private String returnType;
    private String methodName;

    public ClassMethod() {
        super();
        setType("void");
        final String uniqueness = UUID.randomUUID().toString();
        setName(String.format("method%s", uniqueness));
    }

    public ClassMethod(final String type, final String name) {
        super();
        this.returnType = type;
        this.methodName = methodCase(name);
    }

    public ClassMethod setName(final String name) {
        this.methodName = methodCase(name);
        return this;
    }

    public ClassMethod setType(final String type) {
        this.returnType = type;
        return this;
    }

    public String getType() {
        return this.returnType;
    }

    public String getName() {
        return this.methodName;
    }

    private String methodCase(final String string) {
        final String stem = ("" + string.charAt(0)).toLowerCase();
        final String suffix = string.substring(1, string.length());
        return String.format("%s%s", stem, suffix);
    }

    @Override
    public String toString() {
        return String.format(METHOD_CODE, this.returnType, this.methodName, this.returnType);
    }

}
