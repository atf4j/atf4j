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

package net.atf4j.core;

/**
 * Result of a Test.
 */
public enum TestResult {
    /**
     * The test has not yet been run.
     */
    PENDING("Pending"),
    /**
     * The test was skipped because of an assumption was false, a pre-condition
     * was false.
     **/
    SKIPPED("Skipped"),
    /**
     * The test has been run and passed.
     */
    PASSED("Passed"),
    /**
     * The test has been run and the SUT failed.
     */
    FAILED("Failed"),
    /**
     * The test failed with an exception.
     */
    EXCEPTION("Exception");

    /** The value. */
    private final String statusDescription;

    /**
     * Constructor for Test Status from string.
     *
     * @param asText the as text
     */
    private TestResult(final String asText) {
        statusDescription = asText;
    }

    /**
     * Initialise.
     *
     * @return the test result
     */
    public static TestResult initialise() {
        return TestResult.PENDING;
    }

    /**
     * Status forString.
     *
     * @param asText the as text
     * @return Status value
     */
    public static TestResult forString(final String asText) {
        for (final TestResult value : values()) {
            if (value.statusDescription.equals(asText)) {
                return value;
            }
        }
        return null;
    }

    /**
     * toString.
     *
     * @return Status value
     */
    @Override
    public String toString() {
        return statusDescription;
    }

    /**
     * Checks if is.
     *
     * @param result the result \* @return true, if successful, otherwise false.
     * @return true, if successful, otherwise false.
     */
    public boolean is(final TestResult result) {
        return this.equals(result);
    }

}
