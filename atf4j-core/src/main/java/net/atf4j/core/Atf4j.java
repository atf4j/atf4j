/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with atf4j. If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.timers.NestedTimers;

/**
 * The Atf4j class.
 */
public class Atf4j {

    /** logging. */
    protected static final Logger log = LoggerFactory.getLogger(Atf4j.class);

    /** The Constant multiTimers. */
    protected static final NestedTimers multiTimers = NestedTimers.getInstance();

    /**
     * Start test.
     */
    public static void startTest() {
        log.info("startTest");
        log.info(multiTimers.startTimer("startTest").toString());
    }

    /**
     * Start test.
     *
     * @param description
     *            the description
     */
    public static void startTest(final String description) {
        log.info(description);
        log.info(multiTimers.startTimer(description).toString());
    }

    /**
     * End test.
     */
    public static void endTest() {
        log.info(multiTimers.stopTimer().toString());
        log.info("endTest");
    }

    /**
     * Start step.
     */
    public static void startStep() {
        log.info("startStep");
        log.info(multiTimers.startTimer("startStep").toString());
    }

    /**
     * Start step.
     *
     * @param description
     *            the description
     */
    public static void startStep(final String description) {
        log.info(description);
        log.info(multiTimers.startTimer(description).toString());
    }

    /**
     * End step.
     */
    public static void endStep() {
        log.info(multiTimers.stopTimer().toString());
        log.info("endStep");
    }

    /**
     * Document.
     *
     * @param stackTrace
     *            the stack trace
     * @return the string
     */
    private static String document(final StackTraceElement[] stackTrace) {
        for (final StackTraceElement stackTraceElement : stackTrace) {
            log.info(stackTraceElement.toString());
            final String methodName = stackTraceElement.getMethodName();
            log.info(methodName);
            return methodName;
        }
        return null;
    }
}
