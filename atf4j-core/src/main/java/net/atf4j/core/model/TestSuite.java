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
 * TestSuite.
 */
public class TestSuite extends TestBase {
	protected String id;
	protected String name;
	protected String description;
	protected Collection<TestCase> testCases;

	public TestSuite(final String id, final String name, final String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	/**
	 * Execute.
	 *
	 * @param context
	 *            the context
	 * @return the test result
	 * @throws Atf4jException
	 *             the atf4j exception
	 * @see net.atf4j.core.model.TestBase#execute(net.atf4j.core.model.TestContext)
	 */
	@Override
	public AbstractTestResult execute(final TestContext context) throws Atf4jException {
		final AbstractTestResult restResult = new TestResult();
		for (final TestCase testCase : this.testCases) {
			restResult.from(testCase.execute(context));
		}
		return restResult;
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

		for (final TestCase testCase : this.testCases) {
			testCase.registerLogging(logging);
		}
	}

	/**
	 * numberOfTestCases.
	 *
	 * @return size of testStep collection as int.
	 * @see java.util.Collection#size()
	 */
	public int numberOfTestCases() {
		return this.testCases.size();
	}

	/**
	 * Iterator.
	 *
	 * @return Iterator<TestCase>
	 * @see java.util.Collection#iterator()
	 */
	public Iterator<TestCase> iterator() {
		return this.testCases.iterator();
	}

	/**
	 * Adds the test case.
	 *
	 * @param newTestCase
	 *            as TestCase
	 * @return success as boolean.
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public boolean addTestCase(final TestCase newTestCase) {
		return this.testCases.add(newTestCase);
	}

	/**
	 * Adds the all.
	 *
	 * @param newTestCases
	 *            as Collection<TestCase>
	 * @return success as boolean.
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	public boolean addAll(final Collection<? extends TestCase> newTestCases) {
		return this.testCases.addAll(newTestCases);
	}

	public void startTestSuite() {
	}

	public void endTestSuite() {
	}

	public Properties execute(final Properties properties) {
		return null;
	}

	// Register Logging.
	// Add Test Case
	// Run all

}
