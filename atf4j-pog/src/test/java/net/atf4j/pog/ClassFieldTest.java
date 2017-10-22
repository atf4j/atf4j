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

import net.atf4j.core.TestResultsReporting;
import net.atf4j.pog.ClassField.FieldType;

/**
 * A UnitTest for ClassField objects.
 */
public final class ClassFieldTest extends TestResultsReporting {

    /**
     * Test method for void.
     */
    @Test
    public void testExpected() {
        log.info(new ClassField(FieldType.BOOLEAN, "bool").toCode());
        log.info(new ClassField(FieldType.DATE, "date").toCode());
        log.info(new ClassField(FieldType.NUMBER, "number").toCode());
        log.info(new ClassField(FieldType.STRING, "string").toCode());
        log.info(new ClassField(FieldType.VALUE, "value").toCode());
        log.info(new ClassField(FieldType.OBJECT, "object").toCode());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testDefaultConstructor() {
        final ClassField classField = new ClassField();
        assertNotNull(UNEXPECTED_NULL, classField);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testClassField() {
        final ClassField classField = new ClassField();
        assertNotNull(UNEXPECTED_NULL, classField);
        log.info(classField.toString());
        log.info(classField.toCode());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testBooleanField() {
        final ClassField classField = new ClassField(FieldType.BOOLEAN, "bool");
        assertNotNull(UNEXPECTED_NULL, classField);
        log.info(classField.toCode());

        final ClassField booleanField = new ClassField("Boolean", "bool");
        assertNotNull(UNEXPECTED_NULL, booleanField);
        log.info(booleanField.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testDateField() {
        final ClassField classField = new ClassField(FieldType.DATE, "date");
        assertNotNull(UNEXPECTED_NULL, classField);
        log.info(classField.toCode());

        final ClassField dateField = new ClassField("Date", "date");
        assertNotNull(UNEXPECTED_NULL, dateField);
        log.info(dateField.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testNumberField() {
        final ClassField classField = new ClassField(FieldType.NUMBER, "number");
        assertNotNull(UNEXPECTED_NULL, classField);
        log.info(classField.toCode());

        final ClassField numberField = new ClassField("Number", "number");
        assertNotNull(UNEXPECTED_NULL, numberField);
        log.info(classField.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testStringField() {
        final ClassField classField = new ClassField(FieldType.STRING, "string");
        assertNotNull(UNEXPECTED_NULL, classField);
        log.info(classField.toCode());

        final ClassField stringField = new ClassField("String", "string");
        assertNotNull(UNEXPECTED_NULL, stringField);
        log.info(stringField.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testValueField() {
        final ClassField classField = new ClassField(FieldType.VALUE, "value");
        assertNotNull(UNEXPECTED_NULL, classField);
        log.info(classField.toCode());

        final ClassField stringField = new ClassField("Object", "value");
        assertNotNull(UNEXPECTED_NULL, stringField);
        log.info(stringField.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testObject() {
        final ClassField classField = new ClassField(FieldType.OBJECT, "object");
        assertNotNull(UNEXPECTED_NULL, classField);
        log.info(classField.toCode());

        final ClassField stringField = new ClassField("Object", "object");
        assertNotNull(UNEXPECTED_NULL, stringField);
        log.info(stringField.toString());
    }

}
