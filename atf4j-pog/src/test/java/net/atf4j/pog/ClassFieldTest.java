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

public class ClassFieldTest extends ResultsReporting {

    @Test
    public void testExpected() {
        final ClassField stringField = new ClassField("String", "string");
        final ClassField dateField = new ClassField("Date", "date");
        final ClassField numberField = new ClassField("Number", "number");
        final ClassField booleanField = new ClassField("Boolean", "bool");
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
        final String string = classField.toString();
        this.log.info(string);
    }

    @Test
    public void testClassFieldString() {
        final ClassField classField = new ClassField("String", "string");
        assertNotNull(classField);
        final String string = classField.toString();
        this.log.info(string);
    }

    @Test
    public void testClassFieldDate() {
        final ClassField classField = new ClassField("Date", "date");
        assertNotNull(classField);
        final String string = classField.toString();
        this.log.info(string);
    }

    @Test
    public void testClassFieldNumber() {
        final ClassField numberField = new ClassField("Number", "number");
        assertNotNull(numberField);
        final String string = numberField.toString();
        this.log.info(string);
    }

    @Test
    public void testClassFieldBoolean() {
        final ClassField booleanField = new ClassField("Boolean", "bool");
        assertNotNull(booleanField);
        final String string = booleanField.toString();
        this.log.info(string);
    }
}
