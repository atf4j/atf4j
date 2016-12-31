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
package net.atf4j.core.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for TestSuite objects.
 */
public class TestSuiteTest extends ResultsReporting {

    /**
     * The TestCaseReport Class.
     */
    public class MockTestReport implements TestReport {
    }

    /**
     * The PassingCondition Class.
     */
    public class PassingCondition extends Condition {
    }

    /**
     * Test method for {@link TestSuite}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new TestSuite());
    }

    /**
     * Test method for {@link TestSuite}.
     */
    @Test
    public void testTestSuite() {
        final TestSuite testSuite = new TestSuite();
        assertNotNull(testSuite);
    }

    /**
     * Test method for {@link TestSuite}.
     */
    @Test
    public void testNumberOfTestCases() {
        final TestSuite testSuite = new TestSuite();
        final int numberOfTestCases = testSuite.numberOfTestCases();
        assertEquals(0, numberOfTestCases);
    }

    /**
     * Test method for {@link TestSuite}.
     */
    @Test
    public void testAddTestCase() {
        final TestCase newTestCase = new TestCase();
        final TestSuite testSuite = new TestSuite();
        final TestSuite addTestCase = testSuite.addTestCase(newTestCase);
        final int numberOfTestSteps = addTestCase.numberOfTestCases();
        assertEquals(1, numberOfTestSteps);
    }

    @Test
    public void testPreCondition() {
        final TestSuite testSuite = new TestSuite();
        testSuite.addPreCondition(new PassingCondition());
    }

    @Test
    public void testPostCondition() {
        final TestSuite testSuite = new TestSuite();
        testSuite.addPostCondition(new PassingCondition());
    }

}
