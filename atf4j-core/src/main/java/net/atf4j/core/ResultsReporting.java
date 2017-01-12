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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ResultsReporting Class.
 */
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
    protected String verifyEquals(final Object expected, final Object actual) {
        assertNotNull("Expected Value cannot be null", expected);
        assertNotNull("Actual Value cannot be null", actual);
        final boolean result = actual.equals(expected);
        final String resultString = result ? "PASSED" : "FAILED";
        final String message = String.format("actual(%s) == expected(%s) - %s", actual, expected, resultString);
        assertEquals(message, expected, actual);
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
        final boolean result = actual == expected;
        final String resultString = result ? "PASSED" : "FAILED";
        final String message = String.format("actual(%s) == expected(%s) - %s", actual, expected, resultString);
        assertEquals(message, expected, actual);
        return message;
    }

    /**
     * To description.
     *
     * @return the string
     */
    protected String toDescription() {
        final StringBuffer message = new StringBuffer();
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (final StackTraceElement stackTraceElement : stackTrace) {
            final String candidateMethodName = stackTraceElement.getMethodName();
            message.append(candidateMethodName);
            message.append(' ');
        }
        return message.toString();
    }

    /**
     * Before.
     */
    @BeforeClass
    public static void before() {
        final String string = new String(new char[40]).replace("\0", "=");
        LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME).trace(string);
    }

    /**
     * After.
     */
    @After
    public void after() {
        final String string = new String(new char[40]).replace("\0", "-");
        this.log.trace(string);
    }

}
