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
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A UnitTest for TestStatus objects.
 * forString
 */
public class TestStatusTest extends Reporting {

    /**
     * test TestStatus object.
     */
    @Test
    public void testTestStatus() {
        assertEquals("Pending", TestStatus.PENDING.toString());
        assertEquals("Skipped", TestStatus.SKIPPED.toString());
        assertEquals("Passed", TestStatus.PASSED.toString());
        assertEquals("Failed", TestStatus.FAILED.toString());
        assertEquals("Exception", TestStatus.EXCEPTION.toString());
    }

    /**
     * test TestStatus object.
     */
    @Test
    public void testTestStatusFromString() {
        assertEquals(TestStatus.PENDING, TestStatus.forString("Pending"));
        assertEquals(TestStatus.SKIPPED, TestStatus.forString("Skipped"));
        assertEquals(TestStatus.PASSED, TestStatus.forString("Passed"));
        assertEquals(TestStatus.FAILED, TestStatus.forString("Failed"));
        assertEquals(TestStatus.EXCEPTION, TestStatus.forString("Exception"));
    }
}
