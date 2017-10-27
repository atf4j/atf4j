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

/**
 * A UnitTest for ClassField objects.
 */
public final class ClassFieldTest extends TestResultsReporting {

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testExpected() {
        verifyNotNull(ClassField.makeString("aString"));
        verifyNotNull(ClassField.makeDate("aDate"));
        verifyNotNull(ClassField.makeBoolean("aBoolean"));
        verifyNotNull(ClassField.makeNumber("aNumber"));
        verifyNotNull(ClassField.makeNumber("aObject"));
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testClassField() {
        final ClassField classField = new ClassField();
        verifyNotNull(classField);
        log.debug("classField = {}", classField);
        log.debug("classField.toCode() = {}", classField.toCode());
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testBooleanField() {
        final ClassField classField = new ClassField(FieldType.BOOLEAN, "aBoolean");
        verifyNotNull(classField);
        log.debug("classField = {}", classField);
        log.debug("classField.toCode() = {}", classField.toCode());

        final ClassField booleanField = new ClassField("boolean", "aBoolean");
        verifyNotNull(booleanField);
        log.debug("booleanField = {}", booleanField);
        log.debug("booleanField.toCode() = {}", booleanField.toCode());
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testDateField() {
        final ClassField classField = new ClassField(FieldType.DATE, "date");
        verifyNotNull(classField);
        log.debug("classField = {}", classField);
        log.debug("classField.toCode() = {}", classField.toCode());

        final ClassField dateField = new ClassField("Date", "date");
        verifyNotNull(dateField);
        log.debug("dateField = {}", dateField);
        log.debug("dateField.toCode() = {}", dateField.toCode());
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testNumberField() {
        final ClassField classField = new ClassField(FieldType.NUMBER, "number");
        verifyNotNull(classField);
        log.debug("classField = {}", classField);
        log.debug("classField.toCode() = {}", classField.toCode());

        final ClassField numberField = new ClassField("Number", "number");
        verifyNotNull(numberField);
        log.debug("numberField = {}", numberField);
        log.debug("numberField.toCode() = {}", numberField.toCode());
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testObjectField() {
        final ClassField classField = new ClassField(FieldType.OBJECT, "object");
        verifyNotNull(classField);
        log.debug("classField = {}", classField);
        log.debug("classField.toCode() = {}", classField.toCode());

        final ClassField objectField = new ClassField("Object", "object");
        verifyNotNull(objectField);
        log.debug("objectField = {}", objectField);
        log.debug("objectField.toCode() = {}", objectField.toCode());
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testStringField() {
        final ClassField classField = new ClassField(FieldType.STRING, "string");
        verifyNotNull(classField);
        log.debug("classField = {}", classField);
        log.debug("classField.toCode() = {}", classField.toCode());

        final ClassField stringField = new ClassField("String", "string");
        verifyNotNull(stringField);
        log.debug("stringField = {}", stringField);
        log.debug("stringField.toCode() =\n{}", stringField.toCode());
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testWebElement() {
        final ClassField webElement = new ClassField("WebElement", "webElement");
        verifyNotNull(webElement);
        log.debug("webElement.debugString() = {}", webElement.debugString());
        log.debug("webElement.toCode() =\n{}", webElement.toCode());
    }

    /**
     * Unit tests for the ClassField object.
     */
    @Test
    public void testCustomClass() {
        final ClassField customClass = new ClassField("CustomClass", "customClass");
        verifyNotNull(customClass);
        log.debug("customClass.debugString() = {}", customClass.debugString());
        log.debug("customClass.toCode() =\n{}", customClass.toCode());
    }

}
