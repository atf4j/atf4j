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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ResultsReporting {

    /** logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Verify two Strings are equal.
     *
     * @param expected
     *            the expected value.
     * @param actual
     *            the actual value.
     * @return the string
     */
    protected String verify(final Object expected, final Object actual) {
        assertNotNull("Expected Value cannot be null", expected);
        assertNotNull("Actual Value cannot be null", actual);
        final boolean result = actual.equals(actual);
        final String message = String.format("actual(%s) == expected(%s) - %s", expected, actual,
                result ? "PASSED" : "FAILED");
        this.log.info(message);
        assertEquals(expected, actual);
        return message;
    }

    /**
     * Verify equals.
     *
     * @param expected
     *            the expected
     * @param actual
     *            the actual
     * @return the string
     */
    protected String verifyEquals(final long expected, final long actual) {
        final boolean result = (actual == expected);
        final String message = String.format("actual(%s) == expected(%s) - %s", expected, actual,
                result ? "PASSED" : "FAILED");
        this.log.info(message);
        assertEquals(expected, actual);
        return message;
    }

    /**
     * To description.
     *
     * @return the string
     * @throws ClassNotFoundException
     *             the class not found exception
     */
    protected String toDescription() throws ClassNotFoundException {
        final StringBuffer message = new StringBuffer();
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (final StackTraceElement stackTraceElement : stackTrace) {
            final String candidateMethodName = stackTraceElement.getMethodName();
            message.append(candidateMethodName);
            message.append(' ');
        }
        return message.toString();
    }
}
