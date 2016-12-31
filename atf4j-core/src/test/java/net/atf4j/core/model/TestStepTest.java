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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.Atf4jException;

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

    @Test
    public void testDefaultConstructor() {
        assertNotNull(new TestStep());
    }

    @Test
    public void testTestStep() {
        final TestStep testStep = new TestStep();
        assertNotNull(testStep);
    }

    /**
     * Test method for {@link TestCase}.
     *
     * @throws Atf4jException
     *             the atf 4 j exception
     */
    @Test
    public void testRegisterLogging() throws Atf4jException {
        final TestCase testCase = new TestCase();
        final MockTestReport logging = new MockTestReport();
        assertNotNull(testCase.registerLogging(logging));
    }

    /**
     * Test method for {@link TestCase}.
     *
     * @throws Atf4jException
     *             the atf 4 j exception
     */
    @Test
    public void testExecuteTestContext() throws Atf4jException {
        final TestContext context = new TestContext();
        assertNotNull(context);
        final TestStep testStep = new TestStep();
        assertNotNull(testStep);
        assertNotNull(testStep.execute(context));
    }

    @Test
    public void testPreCondition() {
        final TestStep testStep = new TestStep();
        assertNotNull(testStep);
        testStep.addPreCondition(new PassingCondition());
    }

    @Test
    public void testPostCondition() {
        final TestStep testStep = new TestStep();
        assertNotNull(testStep);
        testStep.addPostCondition(new PassingCondition());
    }

}
