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

/**
 * TestResult.
 *
 * 
 * @version $Revision: 0.0.1 $
 */
public enum TestResult {

    /** The passed. */
    PASSED(true, "PASSED"),
    /** The failed. */
    FAILED(false, "FAILED");

    /** The status. */
    private boolean status;

    /** The value. */
    private String value;

    /**
     * Instantiates a new test result.
     *
     * @param booleanStatus
     *            the boolean status
     * @param stringValue
     *            the string value
     */
    TestResult(final Boolean booleanStatus, final String stringValue) {
        this.status = booleanStatus;
        this.value = stringValue;
    }

    /**
     * To boolean.
     *
     * @return the boolean
     */
    public Boolean toBoolean() {
        return this.status;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.value;
    }

    /**
     * From value.
     *
     * @param valueFor
     *            the value for
     * @return the test result
     */
    public static TestResult fromValue(final String valueFor) {
        for (final TestResult testResult : TestResult.values()) {
            if (testResult.value.equals(valueFor)) {
                return testResult;
            }
        }
        throw new IllegalArgumentException(valueFor);
    }

    /**
     * From.
     *
     * @param execute the execute
     */
    public void from(final AbstractTestResult execute) {
        // TODO Auto-generated method stub

    }
}
