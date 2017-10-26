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
     * Unit tests for the ClassField object.
     */
    @Test
    public void testClassField() {
        final ClassField classField = new ClassField();
        assertNotNull(UNEXPECTED_NULL, classField);
        log.debug("classField = {}", classField);
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testBooleanField() {
        final ClassField classField = new ClassField(FieldType.BOOLEAN, "aBoolean");
        assertNotNull(UNEXPECTED_NULL, classField);
        log.debug("classField = {}", classField);

        final ClassField booleanField = new ClassField("boolean", "aBoolean");
        assertNotNull(UNEXPECTED_NULL, booleanField);
        log.debug("booleanField = {}", booleanField);
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testDateField() {
        final ClassField classField = new ClassField(FieldType.DATE, "date");
        assertNotNull(UNEXPECTED_NULL, classField);
        log.debug("classField = {}", classField);

        final ClassField dateField = new ClassField("Date", "date");
        assertNotNull(UNEXPECTED_NULL, dateField);
        log.debug("dateField = {}", dateField);
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testNumberField() {
        final ClassField classField = new ClassField(FieldType.NUMBER, "number");
        assertNotNull(UNEXPECTED_NULL, classField);
        log.debug("classField = {}", classField);

        final ClassField numberField = new ClassField("Number", "number");
        assertNotNull(UNEXPECTED_NULL, numberField);
        log.debug("numberField = {}", numberField);
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testObjectField() {
        final ClassField classField = new ClassField(FieldType.OBJECT, "object");
        assertNotNull(UNEXPECTED_NULL, classField);
        log.debug("classField = {}", classField);

        final ClassField objectField = new ClassField("Object", "object");
        assertNotNull(UNEXPECTED_NULL, objectField);
        log.debug("objectField = {}", objectField);
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testStringField() {
        final ClassField classField = new ClassField(FieldType.STRING, "string");
        assertNotNull(UNEXPECTED_NULL, classField);
        log.debug("classField = {}", classField);

        final ClassField stringField = new ClassField("String", "string");
        assertNotNull(UNEXPECTED_NULL, stringField);
        log.debug("stringField = {}", stringField);
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testWebElementField() {
        final ClassField webElement = new ClassField("WebElement", "webElement");
        assertNotNull(UNEXPECTED_NULL, webElement);
        log.debug("webElement = {}", webElement);
    }

}
