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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import net.atf4j.core.TestResult;
import net.atf4j.core.TestResultsReporting;
import net.atf4j.fdd.model.Condition;
import net.atf4j.fdd.model.TestCase;
import net.atf4j.fdd.model.TestReport;
import net.atf4j.fdd.model.TestSuite;

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
        verifyNotNull(new TestSuite());
    }

    /**
     * Unit Test typical usage.
     */
    @Test
    public void testTypical() {
        final TestSuite testSuite = new TestSuite();
        this.log.info(testSuite.toString());
        verifyNotNull(testSuite);
        assertEquals(testSuite, testSuite.execute());
        this.log.info(testSuite.toString());
    }

    @Test
    public void testMockTestReport() {
        final TestSuite testSuite = new TestSuite(new MockTestReport());
        this.log.info(testSuite.toString());
        verifyNotNull(testSuite);
        assertEquals(testSuite, testSuite.execute());
        this.log.info(testSuite.toString());
    }

    /**
     * Unit Test for test test case string.
     */
    @Test
    public void testTestCaseString() {
        final TestSuite testSuite = new TestSuite();
        verifyNotNull(testSuite);
        final String string = testSuite.toString();
        verifyNotNull(string);
        this.log.info(string);
    }

    /**
     * Test method for TestSuite.
     */
    @Test
    public void testTestSuite() {
        final TestSuite testSuite = new TestSuite();
        verifyNotNull(testSuite);
        final String string = testSuite.toString();
        this.log.debug(string);
        assertEquals(testSuite, testSuite.execute());
        final TestResult result = testSuite.result();
        this.log.info(result.toString());
        verifyNotNull(result);
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
    @Test(expected = AssertionError.class)
    public void testAddNullTestCase() {
        final TestSuite testSuite = new TestSuite();
        testSuite.addTestCase(null);
    }

    /**
     * Unit Test for test pre condition.
     */
    @Test
    public void testPreCondition() {
        final TestSuite testSuite = new TestSuite();
        final PassingCondition newPreCondition = new PassingCondition();
        testSuite.addPreCondition(newPreCondition);
        assertEquals(testSuite, testSuite.execute());
    }

    /**
     * Unit Test for test post condition.
     */
    @Test
    public void testPostCondition() {
        final TestSuite testSuite = new TestSuite();
        final PassingCondition newPostCondition = new PassingCondition();
        testSuite.addPostCondition(newPostCondition);
        assertEquals(testSuite, testSuite.execute());
    }

}
