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
 * along with atf4j. If not, see http://www.gnu.org/licenses/.
 */

package net.atf4j.core;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.timers.NestedTimers;

/**
 * Atf4j class.
 */
public final class Atf4j {

    private static final Logger LOG = LoggerFactory.getLogger(Atf4j.class);
    private static final NestedTimers nestedTimers = NestedTimers.getInstance();

    /**
     * Instantiates a new atf 4 j.
     */
    private Atf4j() {
        super();
    }

    /**
     * Start.
     */
    public static void start() {
        start(UUID.randomUUID().toString());
    }

    /**
     * Start.
     *
     * @param string the string
     */
    public static void start(final String string) {
        LOG.info("start {}", string);
        nestedTimers.startTimer(string);
    }

    /**
     * End.
     */
    public static void end() {
        LOG.info("end {}", nestedTimers.stopTimer().toString());
    }

    /**
     * Document.
     */
    public static void document() {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        document(stackTrace);
    }

    /**
     * Document.
     *
     * @param stackTrace the stack trace
     * @return the string
     */
    public static String document(final StackTraceElement[] stackTrace) {
        for (final StackTraceElement stackTraceElement : stackTrace) {
            LOG.trace(stackTraceElement.toString());
            final String methodName = stackTraceElement.getMethodName();
            LOG.debug(methodName);
            return methodName;
        }
        return null;
    }

}
