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

import net.atf4j.core.TestResult;

/**
 * The AbstractTestResult Class.
 */
public abstract class AbstractTestResult {

    /** The test status. */
    private TestResult testStatus;

    /**
     * Instantiates a new abstract test result.
     */
    public AbstractTestResult() {
        super();
    }

    /**
     * Instantiates a new abstract test result.
     *
     * @param testStatus
     *            the test status
     */
    public AbstractTestResult(final TestResult testStatus) {
        super();
        this.testStatus = testStatus;
    }

    /**
     * Gets the test status.
     *
     * @return the testStatus
     */
    public TestResult getTestStatus() {
        return this.testStatus;
    }

    /**
     * From.
     *
     * @param testResult
     *            the test result
     * @return the abstract test result
     */
    public AbstractTestResult from(final AbstractTestResult testResult) {
        this.testStatus = testResult.getTestStatus();
        return this;
    }

    /**
     * To string.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("AbstractTestResult [testStatus=%s]", this.testStatus);
    }

}
