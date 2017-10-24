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
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Class to represent a method of the class to be Generated.
 */
public final class ClassMethod {

    /** Template for code for method. */
    private static final String METHOD_CODE = "public %s %s() { return new %s(); }";

    /** The access. */
    private String access;

    /** The return type. */
    private String returnType;

    /** The method name. */
    private String methodName;

    /** The parameters. */
    private final List<ClassField> parameters = new ArrayList<ClassField>();

    /** The log. */
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Instantiates a new class method.
     */
    public ClassMethod() {
        super();
        setType("void");
        final String uniqueness = UUID.randomUUID().toString().substring(0, 8);
        setName(String.format("method%s", uniqueness));
    }

    /**
     * Instantiates a new class method.
     *
     * @param type the type
     * @param methodName the method name
     */
    public ClassMethod(final String type, final String methodName) {
        super();
        setType(type);
        setName(methodName);
    }

    /**
     * Sets the access.
     *
     * @param access the access
     * @return the class method
     */
    public ClassMethod setAccess(final String access) {
        this.access = access;
        return this;
    }

    /**
     * Sets the name.
     *
     * @param name the name
     * @return the class method
     */
    public ClassMethod setName(final String name) {
        methodName = methodCase(name);
        return this;
    }

    /**
     * Sets the type.
     *
     * @param type the type
     * @return the class method
     */
    public ClassMethod setType(final String type) {
        returnType = type;
        return this;
    }

    /**
     * Adds the.
     *
     * @param classField the e \* @return true, if successful, otherwise false.
     * @return true, if successful, otherwise false.
     */
    public boolean add(final ClassField classField) {
        return parameters.add(classField);
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
        return returnType;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return methodName;
    }

    /**
     * Method case.
     *
     * @param string the string
     * @return the string
     */
    public String methodCase(final String string) {
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
        if (parameters.size() > 0) {
            final String string = parameters.toString();
            log.info(string);
            return String.format(METHOD_CODE, returnType, methodName, returnType);
        } else {
            return String.format(METHOD_CODE, returnType, methodName, returnType);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("ClassMethod [access=%s, returnType=%s, methodName=%s]",
                access,
                returnType,
                methodName);
    }
    //
    // /*
    // * (non-Javadoc)
    // *
    // * @see java.lang.Object#hashCode()
    // */
    // @Override
    // public int hashCode() {
    // final int prime = 31;
    // int result = 1;
    // result = prime * result + (methodName == null ? 0 :
    // methodName.hashCode());
    // result = prime * result + (returnType == null ? 0 :
    // returnType.hashCode());
    // return result;
    // }
    //
    // /*
    // * (non-Javadoc)
    // *
    // * @see java.lang.Object#equals(java.lang.Object)
    // */
    // @Override
    // public boolean equals(final Object obj) {
    // if (this == obj) {
    // return true;
    // }
    // if (obj == null) {
    // return false;
    // }
    // if (getClass() != obj.getClass()) {
    // return false;
    // }
    // final ClassMethod other = (ClassMethod) obj;
    // if (methodName == null) {
    // if (other.methodName != null) {
    // return false;
    // }
    // } else if (!methodName.equals(other.methodName)) {
    // return false;
    // }
    // if (returnType == null) {
    // if (other.returnType != null) {
    // return false;
    // }
    // } else if (!returnType.equals(other.returnType)) {
    // return false;
    // }
    // return true;
    // }
    //
}
