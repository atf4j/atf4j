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

import net.atf4j.core.TestResult;

/**
 * TestResults.
 */
public class TestResults {

    /** The test results. */
    Collection<TestResult> testResults;

    /**
     * Instantiates a new test results.
     */
    public TestResults() {
        super();
    }

    /**
     * Gets the test results.
     *
     * @return the test results
     */
    public Collection<TestResult> getTestResults() {
        return this.testResults;
    }

    /**
     * Sets the test results.
     *
     * @param testResults
     *            the test results
     * @return the test results
     */
    public TestResults setTestResults(final Collection<TestResult> testResults) {
        this.testResults = testResults;
        return this;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("TestResults [testResults=%s]", this.testResults);
    }

}
