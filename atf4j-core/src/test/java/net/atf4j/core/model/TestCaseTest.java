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

package net.atf4j.core.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.Atf4jException;
import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for TestCase objects.
 */
public class TestCaseTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

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
     * Test method for TestCase.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(UNEXPECTED_NULL, new TestCase());
    }

    /**
     * Unit Test for test test case string.
     */
    @Test
    public void testTestCaseString() {
        assertNotNull(UNEXPECTED_NULL, new TestCase("TestCase"));
    }

    /**
     * Test method for TestCase.
     *
     * @throws Atf4jException the atf 4 j exception
     */
    @Test
    public void testRegisterLogging() throws Atf4jException {
        assertNotNull(UNEXPECTED_NULL, new TestCase().registerLogging(new MockTestReport()));
    }

    /**
     * Test method for TestCase.
     *
     * @throws Atf4jException the atf 4 j exception
     */
    @Test
    public void testExecuteTestContext() throws Atf4jException {
        final TestContext context = new TestContext();
        assertNotNull(UNEXPECTED_NULL, context);
        final TestCase testCase = new TestCase();
        assertNotNull(UNEXPECTED_NULL, testCase.execute(context));
    }

    /**
     * Test method for TestCase.
     */
    @Test
    public void testNumberOfTestSteps() {
        final TestCase testCase = new TestCase();
        assertEquals(0, testCase.numberOfTestSteps());
    }

    /**
     * Test method for TestCase.
     */
    @Test
    public void testAddTestStep() {
        final TestStep testStep = new TestStep();
        assertNotNull(UNEXPECTED_NULL, testStep);

        final TestCase testCase = new TestCase();
        assertNotNull(UNEXPECTED_NULL, testCase);

        final TestCase addTestStep = testCase.addTestStep(testStep);
        assertNotNull(UNEXPECTED_NULL, testStep);

        assertEquals(1, addTestStep.numberOfTestSteps());
    }

    /**
     * Unit Test for test pre condition.
     */
    @Test
    public void testPreCondition() {
        final TestCase testCase = new TestCase();
        assertNotNull(UNEXPECTED_NULL, testCase.addPreCondition(new PassingCondition()));
    }

    /**
     * Unit Test for test post condition.
     */
    @Test
    public void testPostCondition() {
        final TestCase testCase = new TestCase();
        assertNotNull(UNEXPECTED_NULL, testCase.addPostCondition(new PassingCondition()));
    }

}
