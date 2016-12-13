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
package net.atf4j.core;

/**
 * TestStatus. IGNORED SKIPPED
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public enum TestStatus {
    /**
     * The test has not yet been run.
     */
    PENDING("Unrun"),

    /** False premise - Failed Assumption. */
    FALSE("False"),
    /**
     * The test has been run and passed.
     */
    PASSED("Passed"),
    /**
     * The test has been run and failed.
     */
    FAILED("Failed"),
    /**
     * The Test failed to complete. Note : Distinction
     */
    EXCEPTION("Exception");

    /** The value. */
    private final String value;

    /**
     * Constructor for Status.
     *
     * @param asText
     *            the as text
     */
    TestStatus(final String asText) {
        this.value = asText;
    }

    /**
     * Status forString.
     *
     * @param asText
     *            the as text
     * @return Status value
     */
    public static TestStatus forString(final String asText) {
        for (final TestStatus value : values()) {
            if (value.value.equals(asText)) {
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
        return this.value;
    }

}
