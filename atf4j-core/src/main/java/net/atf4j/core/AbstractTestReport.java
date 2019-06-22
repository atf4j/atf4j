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

import lombok.extern.slf4j.Slf4j;

/**
 * Results Reporting class.
 */
@Slf4j
public abstract class AbstractTestReport implements TestReport {

    /** Unexpected null message. */
    protected static final String UNEXPECTED_NULL = "Unexpected null.";

    /** Expected exception message. */
    protected static final String EXPECTED_EXCEPTION = "Expected exception but did not occur.";

    /**
     * Instantiates a new test results reporting.
     */
    protected AbstractTestReport() {
        super();
    }

    /**
     * To description from current context.
     *
     * @return the string
     */
    protected static String toDescription() {
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