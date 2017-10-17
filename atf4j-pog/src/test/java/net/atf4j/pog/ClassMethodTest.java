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
public class ClassMethodTest extends TestResultsReporting {

    /**
     * Test method for void.
     */
    @Test
    public void testDefaultConstructor() {
        final ClassMethod classMethod = new ClassMethod();
        assertNotNull("unexpected null", classMethod);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testClassMethod() {
        final ClassMethod classMethod = new ClassMethod();
        assertNotNull("unexpected null", classMethod);
        final String string = classMethod.toString();
        this.log.info(string);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testClassMethodString() {
        final ClassMethod classMethod = new ClassMethod("String", "method");
        assertNotNull("unexpected null", classMethod);
        final String string = classMethod.toString();
        this.log.info(string);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testClassMethodDate() {
        final ClassMethod classMethod = new ClassMethod("Date", "date");
        assertNotNull("unexpected null", classMethod);
        final String string = classMethod.toString();
        this.log.info(string);
    }

}
