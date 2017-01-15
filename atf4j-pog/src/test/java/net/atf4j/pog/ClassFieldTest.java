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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;
import net.atf4j.pog.ClassField.FieldType;

public class ClassFieldTest extends ResultsReporting {

    @Test
    public void testExpected() {
        this.log.info(new ClassField(FieldType.BOOLEAN, "bool").toCode());
        this.log.info(new ClassField(FieldType.DATE, "date").toCode());
        this.log.info(new ClassField(FieldType.NUMBER, "number").toCode());
        this.log.info(new ClassField(FieldType.STRING, "string").toCode());
        this.log.info(new ClassField(FieldType.VALUE, "value").toCode());
        this.log.info(new ClassField(FieldType.OBJECT, "object").toCode());
    }

    @Test
    public void testDefaultConstructor() {
        final ClassField classField = new ClassField();
        assertNotNull(classField);
    }

    @Test
    public void testClassField() {
        final ClassField classField = new ClassField();
        assertNotNull(classField);
        this.log.info(classField.toString());
        this.log.info(classField.toCode());
    }

    @Test
    public void testBooleanField() {
        final ClassField classField = new ClassField(FieldType.BOOLEAN, "bool");
        assertNotNull(classField);
        this.log.info(classField.toCode());

        final ClassField booleanField = new ClassField("Boolean", "bool");
        assertNotNull(booleanField);
        this.log.info(booleanField.toString());
    }

    @Test
    public void testDateField() {
        final ClassField classField = new ClassField(FieldType.DATE, "date");
        assertNotNull(classField);
        this.log.info(classField.toCode());

        final ClassField dateField = new ClassField("Date", "date");
        assertNotNull(dateField);
        this.log.info(dateField.toString());
    }

    @Test
    public void testNumberField() {
        final ClassField classField = new ClassField(FieldType.NUMBER, "number");
        assertNotNull(classField);
        this.log.info(classField.toCode());

        final ClassField numberField = new ClassField("Number", "number");
        assertNotNull(numberField);
        this.log.info(classField.toString());
    }

    @Test
    public void testStringField() {
        final ClassField classField = new ClassField(FieldType.STRING, "string");
        assertNotNull(classField);
        this.log.info(classField.toCode());

        final ClassField stringField = new ClassField("String", "string");
        assertNotNull(stringField);
        this.log.info(stringField.toString());
    }

    @Test
    public void testValueField() {
        final ClassField classField = new ClassField(FieldType.VALUE, "value");
        assertNotNull(classField);
        this.log.info(classField.toCode());

        final ClassField stringField = new ClassField("Object", "value");
        assertNotNull(stringField);
        this.log.info(stringField.toString());
    }

    @Test
    public void testObject() {
        final ClassField classField = new ClassField(FieldType.OBJECT, "object");
        assertNotNull(classField);
        this.log.info(classField.toCode());

        final ClassField stringField = new ClassField("Object", "object");
        assertNotNull(stringField);
        this.log.info(stringField.toString());
    }

}
