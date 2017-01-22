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

public class Verify {

    private static final String MESSAGE = "actual(%s) == expected(%s) - %s";

    private static String resultString(final boolean result) {
        final String resultString = result ? "PASSED" : "FAILED";
        return resultString;
    }

    protected static String verifyEquals(final byte expected, final byte actual) {
        final boolean result = actual == expected;

        final String resultString = resultString(result);
        final String message = String.format(MESSAGE, actual, expected, resultString);
        assertEquals(message, expected, actual);
        return message;
    }

    protected static String verifyEquals(final char expected, final char actual) {
        final boolean result = actual == expected;

        final String resultString = resultString(result);
        final String message = String.format(MESSAGE, actual, expected, resultString);
        assertEquals(message, expected, actual);
        return message;
    }

    protected static String verifyEquals(final int expected, final int actual) {
        final boolean result = actual == expected;

        final String resultString = resultString(result);
        final String message = String.format(MESSAGE, actual, expected, resultString);
        assertEquals(message, expected, actual);
        return message;
    }

    protected static String verifyEquals(final long expected, final long actual) {
        final boolean result = actual == expected;

        final String resultString = resultString(result);
        final String message = String.format(MESSAGE, actual, expected, resultString);
        assertEquals(message, expected, actual);
        return message;
    }

    protected static String verifyEquals(final Object expected, final Object actual) {
        assertNotNull("Expected Value cannot be null", expected);
        assertNotNull("Actual Value cannot be null", actual);
        final boolean result = actual.equals(expected);

        final String resultString = resultString(result);
        final String message = String.format(MESSAGE, actual, expected, resultString);
        assertEquals(message, expected, actual);
        return message;
    }
}
