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

import net.atf4j.core.TestResultsReporting;

/**
 * A Class to represent a method of the class to be Generated.
 */
public final class ClassMethod extends TestResultsReporting {

    /** Code Template for method. */
    private static final String METHOD_CODE = "public %s %s() { return new %s(); }";
    
    /** SET_CODE constant. */
    private static final String SET_CODE = "public %s set%s(%s %s) { this.%s = %s; return this.%s; }";
    
    /** GET_CODE constant. */
    private static final String GET_CODE = "public %s get%s() { return this.%s; }";
    
    /** CREATE_CODE constant. */
    private static final String CREATE_CODE = "public %s create() { return new %s(); }";

    /** access modifiers. */
    private String access;

    /** return type. */
    private String returnType;

    /** method name. */
    private String methodName;

    /** parameters. */
    private final List<ClassField> parameters = new ArrayList<ClassField>();

    /**
     * Instantiates a new class method.
     */
    protected ClassMethod() {
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
    protected ClassMethod(final String type, final String methodName) {
        super();
        setType(type);
        setName(methodName);
    }

    /**
     * Adds the method.
     *
     * @param returnType the return type
     * @param methodName the method name
     * @return the class method
     */
    public static ClassMethod addMethod(final String returnType, final String methodName) {
        return new ClassMethod(returnType, methodName);
    }

    /**
     * Adds the factory.
     *
     * @param fieldType the field type
     * @return the class method
     */
    public static ClassMethod addFactory(final String fieldType) {
        return new ClassMethod(fieldType, "create");
    }

    /**
     * Factory method, to create factory method.
     *
     * @param fieldType the field type
     * @return the class method
     */
    public static ClassMethod addFactory(final FieldType fieldType) {
        return new ClassMethod(fieldType.name(), "create");
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
     * Sets the type.
     *
     * @param type the type
     * @return the class method
     */
    public ClassMethod setType(final String type) {
        this.returnType = type;
        return this;
    }

    /**
     * Sets the name.
     *
     * @param name the name
     * @return the class method
     */
    public ClassMethod setName(final String name) {
        this.methodName = methodCase(name);
        return this;
    }

    /**
     * Adds the.
     *
     * @param classField the e \* @return true, if successful, otherwise false.
     * @return true, if successful, otherwise false.
     */
    public boolean add(final ClassField classField) {
        return this.parameters.add(classField);
    }

    /**
     * Gets the access.
     *
     * @return the access
     */
    public String getAccess() {
        return this.access;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return this.returnType;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.methodName;
    }

    /**
     * Method case.
     *
     * @param string the string
     * @return the string
     */
    protected String methodCase(final String string) {
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
        if (this.parameters.isEmpty()) {
            return String.format(CREATE_CODE, this.returnType, this.methodName, this.returnType);
        } else {
            return String.format(CREATE_CODE, this.returnType, this.methodName, this.returnType);
        }
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("ClassMethod [access=%s, returnType=%s, methodName=%s]",
                this.access,
                this.returnType,
                this.methodName);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        if (this.log.isDebugEnabled()) {
            return debugString();
        } else {
            return toCode();
        }
    }
}
