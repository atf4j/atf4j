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

import static org.junit.Assert.assertNotNull;

import lombok.extern.slf4j.Slf4j;
import net.atf4j.core.TestReport;
import net.atf4j.core.TestResult;
import net.atf4j.core.VerificationError;
import net.atf4j.fdd.model.Condition;
import net.atf4j.fdd.model.TestCase;
import net.atf4j.fdd.model.TestStep;

/**
 * A UnitTest for TestStep objects.
 */
@Slf4j
public class TestStepTest {

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
     * Unit Test for test default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        verifyNotNull(new TestStep());
    }

    /**
     * Unit Test typical usage.
     */
    @Test
    public void testTypical() {
        final TestStep testStep = new TestStep();
        log.debug(testStep.toString());
        verifyNotNull(testStep);
        testStep.execute();
        log.info(testStep.toString());
    }

    /**
     * Unit Test for test test case string.
     */
    @Test
    public void testTestCaseString() {
        final TestStep testStep = new TestStep();
        verifyNotNull(testStep);
        final String string = testStep.toString();
        verifyNotNull(string);
        log.info(string);
    }

    /**
     * Unit Test for test test step.
     */
    @Test
    public void testTestStep() {
        final TestStep testStep = new TestStep();
        log.debug(testStep.toString());
        verifyNotNull(testStep);

        final TestResult result = testStep.result();
        log.info(result.toString());
        verifyNotNull(result);
    }

    /**
     * Test method for TestCase.
     *
     * @throws VerificationError the Atf4jException
     */
    @Test
    public void testRegisterLogging() throws VerificationError {
        final TestCase testCase = new TestCase();
        log.debug(testCase.toString());

        final MockTestReport report = new MockTestReport();
        log.info(report.toString());
        verifyNotNull(testCase.registerLogging(report));
    }

    /**
     * Unit Test for test pre condition.
     */
    @Test
    public void testPreCondition() {
        final TestStep testStep = new TestStep();
        log.debug(testStep.toString());
        verifyNotNull(testStep);

        final PassingCondition preCondition = new PassingCondition();
        log.debug(preCondition.toString());
        verifyNotNull(preCondition);

        assertNotNull(testStep.addPreCondition(preCondition));
        log.debug(testStep.toString());

        testStep.execute();
        log.debug(testStep.toString());
    }

    /**
     * Unit Test for test post condition.
     */
    @Test
    public void testPostCondition() {
        final TestStep testStep = new TestStep();
        log.debug(testStep.toString());
        verifyNotNull(testStep);

        final PassingCondition postCondition = new PassingCondition();
        log.debug(postCondition.toString());
        verifyNotNull(postCondition);

        assertNotNull(testStep.addPostCondition(postCondition));
        log.debug(testStep.toString());

        testStep.execute();
        log.info(testStep.toString());
    }

}
