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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.timers.NestedTimers;
import net.atf4j.core.timers.TimerInterface;

/**
 * Atf4j class.
 */
public final class Atf4j {

    /** provides logging. */
    private static final Logger log = LoggerFactory.getLogger(Atf4j.class);

    /** Nested Timers. */
    private static final NestedTimers nestedTimers = NestedTimers.getInstance();

    /**
     * Instantiates a new atf4j.
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
        log.debug("start {}", string);
        nestedTimers.startTimer(string);
    }

    /**
     * End.
     */
    public static void end() {
        final TimerInterface stopTimer = nestedTimers.stopTimer();
        final String string = stopTimer.toString();
        log.debug("end {}", string);
    }

    /**
     * Document the current call stack from the test method. The test method
     * must be marked with @Test annotation.
     */
    public static void document() {
        document(Thread.currentThread().getStackTrace());
    }

    /**
     * Document.
     *
     * @param stackTrace the stack trace
     * @return the string
     */
    public static String document(final StackTraceElement[] stackTrace) {
        final StringBuffer scenario = new StringBuffer();
        for (final StackTraceElement stackTraceElement : stackTrace) {
            if (isTest(stackTraceElement)) {
                final String methodName = stackTraceElement.getMethodName();
                final String phrase = unroll(methodName);
                scenario.append(phrase);
                log.info(phrase);
            }
        }
        return scenario.toString();
    }

    private static boolean isTest(final StackTraceElement stackTraceElement) {
        try {
            final Class<?> aClass = Class.forName(stackTraceElement.getClassName());
            log.info(aClass.toString());
            logAnnotation("\t{}\n", aClass.getAnnotations());
            final String methodName = stackTraceElement.getMethodName();
            final Method[] methods = aClass.getMethods();
            for (final Method method : methods) {
                if (method.getName().equals(methodName)) {
                    log.info("\t{}\n", method);
                    logAnnotation("\t\t{}\n", method.getDeclaredAnnotations());
                }
            }
        } catch (final ClassNotFoundException e) {
            log.error("{}", e);
        } catch (final SecurityException e) {
            log.error("{}", e);
        }
        return false;
    }

    private static void logAnnotation(final String pattern, final Annotation[] annotations) {
        for (final Annotation annotation : annotations) {
            log.info(pattern, annotation);
        }
    }

    /**
     * Unroll a string.
     *
     * @param input the input
     * @return the string
     */
    public static String unroll(final String input) {
        if (input != null) {
            if (input.length() > 0) {
                final StringBuffer phrase = new StringBuffer(input.length() * 2);
                for (int i = 0; i < input.length(); i++) {
                    if (i == 0) {
                        // capitalise the first character for sentence case.
                        phrase.append(Character.toUpperCase(input.charAt(0)));
                    } else {
                        final char chr = input.charAt(i);
                        if (chr == '_') {
                            phrase.append(' ');
                        } else if (Character.isUpperCase(chr)) {
                            phrase.append(' ');
                            phrase.append(Character.toLowerCase(chr));
                        } else {
                            phrase.append(chr);
                        }
                    }
                }
                phrase.append('.');
                return phrase.toString();
            }
            return "";
        }
        return null;
    }
}
