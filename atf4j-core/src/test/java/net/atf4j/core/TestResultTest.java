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
package net.atf4j.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * A UnitTest for TestStatus objects.
 * forString
 */
public class TestResultTest extends ResultsReporting {

    /**
     * Test method for TestResult}.
     */
    @Test
    public void testInitialise() {
        final TestResult testStatus = TestResult.initialise();
        assertNotNull(testStatus);
        assertEquals(TestResult.PENDING, testStatus);
    }

    /**
     * test TestStatus object.
     */
    @Test
    public void testTestStatus() {
        assertEquals("Pending", TestResult.PENDING.toString());
        assertEquals("Skipped", TestResult.SKIPPED.toString());
        assertEquals("Passed", TestResult.PASSED.toString());
        assertEquals("Failed", TestResult.FAILED.toString());
        assertEquals("Exception", TestResult.EXCEPTION.toString());
    }

    /**
     * test TestStatus object.
     */
    @Test
    public void testTestStatusFromString() {
        assertEquals(TestResult.PENDING, TestResult.forString("Pending"));
        assertEquals(TestResult.SKIPPED, TestResult.forString("Skipped"));
        assertEquals(TestResult.PASSED, TestResult.forString("Passed"));
        assertEquals(TestResult.FAILED, TestResult.forString("Failed"));
        assertEquals(TestResult.EXCEPTION, TestResult.forString("Exception"));
    }

}
