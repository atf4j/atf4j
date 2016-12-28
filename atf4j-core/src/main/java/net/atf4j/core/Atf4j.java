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
    protected static final NestedTimers nestedTimers = NestedTimers.getInstance();

    /**
     * Start.
     *
     * @param string
     *            the string
     */
    public static void start(final String string) {
        log.info(string);
        nestedTimers.startTimer("start");
    }

    /**
     * End.
     */
    public static void end() {
        log.info(nestedTimers.stopTimer().toString());
    }

    /**
     * Document.
     *
     * @param stackTrace
     *            the stack trace
     * @return the string
     */
    public static String document(final StackTraceElement[] stackTrace) {
        for (final StackTraceElement stackTraceElement : stackTrace) {
            log.info(stackTraceElement.toString());
            final String methodName = stackTraceElement.getMethodName();
            log.info(methodName);
            return methodName;
        }
        return null;
    }

}
