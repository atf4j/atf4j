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
 * A UnitTest for ClassMethod objects.
 */
public final class ClassMethodTest extends TestResultsReporting {

    /**
     * Test expected.
     */
    @Test
    public void testExpected() {
        log.debug(new ClassField("Boolean", "getBoolean").toCode());
        log.debug(new ClassField("Date", "getDate").toCode());
        log.debug(new ClassField("Number", "getNumber").toCode());
        log.debug(new ClassField("String", "getString()").toCode());
        log.debug(new ClassField("Value", "getValue").toCode());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testClassMethod() {
        final ClassMethod classMethod = new ClassMethod();
        log.debug("new ClassMethod() = {}", classMethod.toString());
        assertNotNull(UNEXPECTED_NULL, classMethod);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testClassMethodString() {
        final ClassMethod classMethod = new ClassMethod("String", "method");
        log.debug("new ClassMethod('String', 'method') = {}", classMethod.toString());
        assertNotNull(UNEXPECTED_NULL, classMethod);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testClassMethodDate() {
        final ClassMethod classMethod = new ClassMethod("Date", "date");
        log.debug("new ClassMethod('Date', 'date') = {}", classMethod.toString());
        assertNotNull(UNEXPECTED_NULL, classMethod);
    }

}
