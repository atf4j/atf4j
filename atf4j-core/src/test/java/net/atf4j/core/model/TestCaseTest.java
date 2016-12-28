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

import org.junit.Test;

import net.atf4j.core.Atf4jException;
import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for TestCase objects.
 */
public class TestCaseTest extends ResultsReporting {

    /**
     * The TestCaseReport Class.
     */
    public class TestCaseReport implements TestReport {
    }

    /**
     * Test method for {@link TestCase}.
     */
    @Test
    public void testDefaultConstructor() {
        new TestCase();
    }

    /**
     * Test method for {@link TestCase}.
     *
     * @throws Atf4jException
     *             the atf 4 j exception
     */
    @Test
    public void testRegisterLogging() throws Atf4jException {
        new TestCase().registerLogging(new TestCaseReport());
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
        new TestCase().execute(context);
    }

    /**
     * Test method for {@link TestCase}.
     */
    @Test
    public void testNumberOfTestSteps() {
        assertEquals(0, new TestCase().numberOfTestSteps());
    }

    /**
     * Test method for {@link TestCase}.
     */
    @Test
    public void testAddTestStep() {
        final TestStep newTestStep = new TestStep();
        final TestCase testCase = new TestCase();
        final TestCase addTestStep = testCase.addTestStep(newTestStep);
        final int numberOfTestSteps = addTestStep.numberOfTestSteps();
        assertEquals(1, numberOfTestSteps);
    }

}
