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

import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import net.atf4j.core.Atf4jException;

/**
 * TestCase.
 */
public class TestCase extends TestBase {

    private String name;
    private Collection<TestStep> testSteps;

    /**
     * Execute.
     *
     * @param context
     *            the context
     * @return the abstract test result
     * @throws Atf4jException
     *             the atf 4 j exception
     */
    @Override
    public AbstractTestResult execute(final TestContext context) throws Atf4jException {
        AbstractTestResult result = null;
        for (final TestStep testStep : this.testSteps) {
            result = testStep.execute(context);
        }
        return result;
    }

    /**
     * Register logging.
     *
     * @param logging
     *            the logging
     * @throws Atf4jException
     *             the atf4j exception
     * @see net.atf4j.core.model.TestBase#registerLogging(TestResultLoggingInterface)
     */
    @Override
    public void registerLogging(final TestResultLoggingInterface logging) throws Atf4jException {
        super.registerLogging(logging);
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
     * Iterator.
     *
     * @return the iterator
     */
    public Iterator<TestStep> iterator() {
        return this.testSteps.iterator();
    }

    /**
     * Adds the test step.
     *
     * @param newTestStep
     *            as TestStep Object.
     * @return success as boolean.
     * @see java.util.Collection#add(java.lang.Object)
     */
    public boolean addTestStep(final TestStep newTestStep) {
        return this.testSteps.add(newTestStep);
    }

    /**
     * Adds the test steps.
     *
     * @param newTestSteps
     *            the new test steps
     * @return true, if successful
     */
    public boolean addTestSteps(final Collection<? extends TestStep> newTestSteps) {
        return this.testSteps.addAll(newTestSteps);
    }

    /* (non-Javadoc)
     * @see net.atf4j.core.model.TestCommand#execute(java.util.Properties)
     */
    @Override
    public Properties execute(final Properties properties) {
        return null;
    }

    // Register Logging.
    // Add Test Case
    // Run all
}
