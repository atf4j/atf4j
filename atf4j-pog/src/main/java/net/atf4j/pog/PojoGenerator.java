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

public class PojoGenerator extends CodeGenerator {

    public PojoGenerator() throws TemplateNotLoaded {
        super("/templates/PojoClass.vm");
    }

    public CodeGenerator addDateField(final String fieldName) {
        final ClassField classField = new ClassField(FieldType.DATE, fieldName);
        this.fields.add(classField);
        return this;
    }

    public CodeGenerator addBooleanField(final String fieldName) {
        final ClassField classField = new ClassField(FieldType.BOOLEAN, fieldName);
        this.fields.add(classField);
        return this;
    }

    public CodeGenerator addStringField(final String fieldName) {
        final ClassField classField = new ClassField(FieldType.STRING, fieldName);
        this.fields.add(classField);
        return this;
    }

    public CodeGenerator addField(final FieldType fieldType, final String fieldName) {
        final ClassField classField = new ClassField(fieldType, fieldName);
        this.fields.add(classField);
        return this;
    }

    public CodeGenerator addField(final String fieldType, final String fieldName) {
        final ClassField classField = new ClassField(fieldType, fieldName);
        this.fields.add(classField);
        return this;
    }

}
