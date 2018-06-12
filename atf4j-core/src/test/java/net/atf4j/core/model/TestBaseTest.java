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

import net.atf4j.core.TestResultsReporting;
import net.atf4j.core.VerificationError;

/**
 * A UnitTest for TestBase objects.
 */
public class TestBaseTest extends TestResultsReporting {

    /**
     * The MockTestBase Class.
     */
    public class MockTestBase extends AbstractTestBase {

        @Override
        public AbstractTestBase execute() throws VerificationError {
            return this;
        }
    }

    /**
     * The MockTestReport Class.
     */
    public class MockTestReport implements TestReport {

    }

    /**
     * The IncompleteTestBase Class.
     */
    public class IncompleteTestBase extends AbstractTestBase {
    }

    /**
     * The PassingCondition Class.
     */
    public class PassingCondition extends Condition {
    }

    /**
     * The FailingCondition Class .
     */
    public class FailingCondition extends Condition {
    }

    public class FailPostCondition extends Condition {

    }

    public class PassPostCondition extends Condition {

    }

    public class PassPreCondition extends Condition {

    }

    public class FailPreCondition extends Condition {

    }

    /**
     * Test method for TestCase.
     */
    @Test
    public void testDefaultConstructor() {
        verifyNotNull(new MockTestBase());
    }

    /**
     * Test incomplete.
     */
    @Test(expected = VerificationError.class)
    public void testIncomplete() {
        new IncompleteTestBase().execute();
    }

    /**
     * Test typical.
     */
    @Test
    public void testTypical() {
        final MockTestBase testBase = new MockTestBase();
        this.log.info("testCase={}", testBase);
        verifyNotNull(testBase);
        testBase.execute();
    }

    @Test
    public void testTypicalFail() {
        final MockTestBase testBase = new MockTestBase();
        this.log.info("testCase={}", testBase);
        verifyNotNull(testBase);
        testBase.addPreCondition(new FailPreCondition());
        testBase.execute();
    }

    @Test
    public void testTypicalPassFail() {
        final MockTestBase testBase = new MockTestBase();
        this.log.info("testCase={}", testBase);
        verifyNotNull(testBase);
        testBase.addPreCondition(new PassPreCondition());
        testBase.addPreCondition(new FailPreCondition());
        testBase.execute();
    }

    @Test
    public void testTypicalPassPassFail() {
        final MockTestBase testBase = new MockTestBase();
        this.log.info("testCase={}", testBase);
        verifyNotNull(testBase);
        testBase.addPreCondition(new PassPreCondition());
        testBase.addPreCondition(new FailPostCondition());
        testBase.execute();
    }

    @Test
    public void testTypicalPassPassPass() {
        final MockTestBase testBase = new MockTestBase();
        this.log.info("testCase={}", testBase);
        verifyNotNull(testBase);
        testBase.addPreCondition(new PassPreCondition());
        testBase.addPreCondition(new PassPostCondition());
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
     * Test method for TestBase.
     *
     * @throws VerificationError the Atf4jException
     */
    @Test
    public void testRegisterLogging() throws VerificationError {
        verifyNotNull(new MockTestBase().registerLogging(new MockTestReport()));
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testUniqueIdentifier() {
        final MockTestBase mockTestBase = new MockTestBase();
        verifyNotNull(mockTestBase.getUniqueIdentifier());
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testTestStatus() {
        verifyNotNull(new MockTestBase().getTestStatus());
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testAddPreCondition() {
        final Condition newPreCondition = new PassingCondition();
        verifyNotNull(newPreCondition);
        final MockTestBase mockTestBase = new MockTestBase();
        verifyNotNull(mockTestBase);
        verifyNotNull(mockTestBase.addPreCondition(newPreCondition));
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testAddPostCondition() {
        final Condition newPostCondition = new PassingCondition();
        verifyNotNull(newPostCondition);
        final MockTestBase mockTestBase = new MockTestBase();
        verifyNotNull(mockTestBase);
        verifyNotNull(mockTestBase.addPostCondition(newPostCondition));
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testToString() {
        verifyNotNull(new MockTestBase().toString());
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testDebugString() {
        verifyNotNull(new MockTestBase().debugString());
    }

}
