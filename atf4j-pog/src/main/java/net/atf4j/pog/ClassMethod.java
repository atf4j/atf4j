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

import java.util.ArrayList;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Class to represent a method of the class to be Generated.
 */
public class ClassMethod {
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private static final String METHOD_CODE = "public %s %s() { return new %s(); }";
    private String access;
    private String returnType;
    private String methodName;
    private final ArrayList<ClassField> parameters = new ArrayList<ClassField>();

    public ClassMethod() {
        super();
        setType("void");
        final String uniqueness = UUID.randomUUID().toString().substring(0, 8);
        setName(String.format("method%s", uniqueness));
    }

    public ClassMethod(final String type, final String methodName) {
        super();
        setType(type);
        setName(methodName);
    }

    public ClassMethod setAccess(final String access) {
        this.access = access;
        return this;
    }

    public ClassMethod setName(final String name) {
        this.methodName = methodCase(name);
        return this;
    }

    public ClassMethod setType(final String type) {
        this.returnType = type;
        return this;
    }

    public boolean add(final ClassField e) {
        return this.parameters.add(e);
    }

    public String getAccess() {
        return this.access;
    }

    public String getType() {
        return this.returnType;
    }

    public String getName() {
        return this.methodName;
    }

    public String methodCase(final String string) {
        final char[] charArray = string.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public String toCode() {
        if (this.parameters.size() > 0) {
            final String string = this.parameters.toString();
            this.log.info(string);
            return String.format(METHOD_CODE, this.returnType, this.methodName, this.returnType);
        } else {
            return String.format(METHOD_CODE, this.returnType, this.methodName, this.returnType);
        }
    }

    @Override
    public String toString() {
        return String.format("ClassMethod [access=%s, returnType=%s, methodName=%s]",
                this.access,
                this.returnType,
                this.methodName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.methodName == null) ? 0 : this.methodName.hashCode());
        result = prime * result + ((this.returnType == null) ? 0 : this.returnType.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClassMethod other = (ClassMethod) obj;
        if (this.methodName == null) {
            if (other.methodName != null) {
                return false;
            }
        } else if (!this.methodName.equals(other.methodName)) {
            return false;
        }
        if (this.returnType == null) {
            if (other.returnType != null) {
                return false;
            }
        } else if (!this.returnType.equals(other.returnType)) {
            return false;
        }
        return true;
    }

}
