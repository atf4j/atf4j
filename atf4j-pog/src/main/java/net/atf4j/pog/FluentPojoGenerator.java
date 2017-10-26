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

import net.atf4j.pog.ClassField.FieldType;

/**
 * Fluent Pojo Generator class.
 */
public class FluentPojoGenerator extends AbstractCodeGenerator {

    /** POJO_TEMPLATE. */
    private static final String FLUENT_POJO_TEMPLATE = "templates/FluentPojoClass.vm";

    /**
     * Instantiates a new pojo generator.
     *
     * @throws TemplateNotLoadedException the template not loaded
     */
    public FluentPojoGenerator() throws TemplateNotLoadedException {
        super(FLUENT_POJO_TEMPLATE);
    }

    /**
     * Adds the date field.
     *
     * @param fieldName the field name
     * @return the code generator
     */
    public AbstractCodeGenerator addDateField(final String fieldName) {
        // final ClassField classField = new ClassField(FieldType.DATE,
        // fieldName);
        // fields.add(classField);
        return this;
    }

    /**
     * Adds the boolean field.
     *
     * @param fieldName the field name
     * @return the code generator
     */
    public AbstractCodeGenerator addBooleanField(final String fieldName) {
        // final ClassField classField = new ClassField(FieldType.BOOLEAN,
        // fieldName);
        // fields.add(classField);
        return this;
    }

    /**
     * Adds the string field.
     *
     * @param fieldName the field name
     * @return the code generator
     */
    public AbstractCodeGenerator addStringField(final String fieldName) {
        // final ClassField classField = new ClassField(FieldType.STRING,
        // fieldName);
        // fields.add(classField);
        return this;
    }

    /**
     * Adds the field.
     *
     * @param fieldType the field type
     * @param fieldName the field name
     * @return the code generator
     */
    public AbstractCodeGenerator addField(final FieldType fieldType, final String fieldName) {
        // final ClassField classField = new ClassField(fieldType, fieldName);
        // fields.add(classField);
        return this;
    }

    /**
     * Adds the field.
     *
     * @param fieldType the field type
     * @param fieldName the field name
     * @return the code generator
     */
    public AbstractCodeGenerator addField(final String fieldType, final String fieldName) {
        // final ClassField classField = new ClassField(fieldType, fieldName);
        // fields.add(classField);
        return this;
    }

}