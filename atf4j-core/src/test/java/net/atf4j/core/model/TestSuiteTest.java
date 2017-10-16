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
import net.atf4j.core.TestResultsReporting;
import net.atf4j.core.TestResult;

/**
 * A UnitTest for TestSuite objects.
 */
public class TestSuiteTest extends TestResultsReporting {

    /**
     * Test Case Report Class.
     */
    public class MockTestReport implements TestReport {
    }

    /**
     * Passing Test Condition Class.
     */
    public class PassingCondition extends Condition {
    }

    /**
     * Test method for TestSuite.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(UNEXPECTED_NULL, new TestSuite());
    }

    /**
     * Test method for TestSuite.
     */
    @Test
    public void testTestSuite() {
        final TestSuite testSuite = new TestSuite();
        assertNotNull(UNEXPECTED_NULL, testSuite);
        final TestResult result = testSuite.result();
        assertNotNull(UNEXPECTED_NULL, result);
        this.log.info("testResult={}", result);
    }

    /**
     * Unit Test for test test suite test context.
     */
    @Test
    public void testTestSuiteTestContext() {
        final TestSuite testSuite = new TestSuite(new TestContext());
        assertNotNull(UNEXPECTED_NULL, testSuite);
        this.log.info("testResult={}", testSuite.result());
    }

    /**
     * Unit Test for test test suite execute.
     *
     * @throws Atf4jException the atf 4 j exception
     */
    @Test
    public void testTestSuiteExecute() throws Atf4jException {
        final TestSuite testSuite = new TestSuite();
        assertNotNull(UNEXPECTED_NULL, testSuite.execute());
        this.log.info("testResult={}", testSuite.result());
    }

    /**
     * Unit Test for test test suite execute test context.
     *
     * @throws Atf4jException the atf 4 j exception
     */
    @Test
    public void testTestSuiteExecuteTestContext() throws Atf4jException {
        final TestSuite testSuite = new TestSuite();
        assertNotNull(UNEXPECTED_NULL, testSuite.execute(new TestContext()));
        this.log.info("testResult={}", testSuite.result());
    }

    /**
     * Test method for TestSuite.
     */
    @Test
    public void testNumberOfTestCases() {
        final TestSuite testSuite = new TestSuite();
        final int numberOfTestCases = testSuite.numberOfTestCases();
        assertEquals(0, numberOfTestCases);
    }

    /**
     * Test method for TestSuite.
     */
    @Test
    public void testAddTestCase() {
        final TestCase newTestCase = new TestCase();
        final TestSuite testSuite = new TestSuite();
        final TestSuite addTestCase = testSuite.addTestCase(newTestCase);
        final int numberOfTestSteps = addTestCase.numberOfTestCases();
        assertEquals(1, numberOfTestSteps);
    }

    /**
     * Test method for TestSuite.
     */
    @Test
    public void testAddNullTestCase() {
        final TestSuite testSuite = new TestSuite();
        final TestSuite addTestCase = testSuite.addTestCase(null);
        final int numberOfTestSteps = addTestCase.numberOfTestCases();
        assertEquals(0, numberOfTestSteps);
    }

    /**
     * Unit Test for test pre condition.
     */
    @Test
    public void testPreCondition() {
        final TestSuite testSuite = new TestSuite();
        testSuite.addPreCondition(new PassingCondition());
    }

    /**
     * Unit Test for test post condition.
     */
    @Test
    public void testPostCondition() {
        final TestSuite testSuite = new TestSuite();
        testSuite.addPostCondition(new PassingCondition());
    }

}
