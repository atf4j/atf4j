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
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayDeque;
import java.util.Collection;

import net.atf4j.core.Atf4jException;

/**
 * TestCase.
 */
public class TestCase extends TestBase {

    private final Collection<TestStep> testSteps;

    public TestCase() {
        super();
        this.testSteps = new ArrayDeque<TestStep>();
    }

    /**
     * Execute.
     *
     * @param context
     *            the context
     * @return the abstract test result
     * @throws Atf4jException
     *             the atf4j exception
     * @see net.atf4j.core.model.TestBase#execute(net.atf4j.core.model.TestContext)
     */
    @Override
    public TestCase execute(final TestContext context) throws Atf4jException {
        assumeNotNull(context);
        assumeNotNull(this.testSteps);
        for (final TestStep testStep : this.testSteps) {
            final TestBase execute = testStep.execute(context);
            assumeNotNull(execute);
            assertEquals(testStep, execute);
        }
        return this;
    }

    /**
     * numberOfTestSteps.
     *
     * @return size of testStep collection as int.
     * @see java.util.Collection#size()
     */
    public int numberOfTestSteps() {
        return this.testSteps.size();
    }

    /**
     * Adds the test step.
     *
     * @param newTestStep
     *            as TestStep Object.
     * @return success as boolean.
     * @see java.util.Collection#add(java.lang.Object)
     */
    public TestCase addTestStep(final TestStep newTestStep) {
        final boolean result = this.testSteps.add(newTestStep);
        assumeTrue(result);
        return this;
    }

    /**
     * Start test suite.
     */
    public TestCase startTestSuite() {
        this.log.info("startTestSuite {}", this.getName());
        return this;
    }

    /**
     * End test suite.
     */
    public TestCase endTestSuite() {
        this.log.info("endTestSuite {}", this.getName());
        return this;
    }

}
