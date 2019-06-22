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

import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import lombok.extern.slf4j.Slf4j;
import net.atf4j.core.TestReport;
import net.atf4j.core.VerificationError;
import net.atf4j.fdd.model.Condition;
import net.atf4j.fdd.model.TestCase;
import net.atf4j.fdd.model.TestStep;

/**
 * A UnitTest for TestCase objects.
 */
@Slf4j
public class TestCaseTest {

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
        verifyNotNull(new TestCase());
    }

    /**
     * Unit Test typical usage.
     */
    @Test
    public void testTypical() {
        final TestCase testBase = new TestCase();
        log.info("testCase = {}", testBase);
        verifyNotNull(testBase);
        testBase.execute();
    }

    /**
     * Unit Test for test test case string.
     */
    @Test
    public void testTestCaseString() {
        final TestCase testCase = new TestCase("TestCase");
        verifyNotNull(testCase);
        verifyNotNull(testCase.toString());
    }

    /**
     * Test method for TestCase.
     *
     * @throws VerificationError the Atf4jException
     */
    @Test
    public void testRegisterLogging() throws VerificationError {
        verifyNotNull(new TestCase().registerLogging(new MockTestReport()));
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
        verifyNotNull(testStep);

        final TestCase testCase = new TestCase();
        verifyNotNull(testCase);

        final TestCase addTestStep = testCase.addTestStep(testStep);
        verifyNotNull(testStep);

        assertEquals(1, addTestStep.numberOfTestSteps());
    }

    /**
     * Unit Test for test pre condition.
     */
    @Test
    public void testPreCondition() {
        final TestCase testCase = new TestCase();
        final PassingCondition newPreCondition = new PassingCondition();
        verifyNotNull(testCase.addPreCondition(newPreCondition));
        testCase.execute();
    }

    /**
     * Unit Test for test post condition.
     */
    @Test
    public void testPostCondition() {
        final TestCase testCase = new TestCase();
        final PassingCondition newPostCondition = new PassingCondition();
        verifyNotNull(testCase.addPostCondition(newPostCondition));
        testCase.execute();
    }

}
