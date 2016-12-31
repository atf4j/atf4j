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
package net.atf4j.annotations;

import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An Annotation Helper class.
 */
public class AnnotationHelper {

    /** logging. */
    private static final Logger log = LoggerFactory.getLogger(AnnotationHelper.class);

    private static final String EXPECTED_TEST_ID = "Expected @Atf4j.TestId annotation not found.";
    private static final String EXPECTED_TEST_NAME = "Expected @Atf4j.TestName annotation not found.";
    private static final String EXPECTED_TEST_DESCRIPTION = "Expected @Atf4j.TestDescription annotation not found.";

    /**
     * Gets the test id from <code>@TestId</code>.
     *
     * @return the getTestId as String
     */
    static public String getTestId() {
        log.info("AnnotationHelper.getTestId");
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        final Method testMethod = findTestMethod(stackTrace);
        if (testMethod == null) {
            return EXPECTED_TEST_ID;
        } else {
            final Atf4j.TestId atf4jTestId = testMethod.getAnnotation(Atf4j.TestId.class);
            final String resultString = atf4jTestId.value() == null ? EXPECTED_TEST_ID : atf4jTestId.value();
            return resultString;
        }
    }

    /**
     * Gets the test name from <code>@TestName</code>.
     *
     * @return the getTestName as String
     */
    static public String getTestName() {
        log.info("AnnotationHelper.getTestName");
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        final Method testMethod = findTestMethod(stackTrace);
        if (testMethod == null) {
            return EXPECTED_TEST_NAME;
        } else {
            final Atf4j.TestName atf4jTestName = testMethod.getAnnotation(Atf4j.TestName.class);
            final String resultString = atf4jTestName.value() == null ? EXPECTED_TEST_NAME : atf4jTestName.value();
            return resultString;
        }
    }

    /**
     * Gets the test descriptions from <code>@TestDesciption</code>.
     *
     * @return the getTestDescriptions as String
     */
    static public String getTestDescription() {
        log.info("AnnotationHelper.getTestDescription");
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        final Method testMethod = findTestMethod(stackTrace);
        if (testMethod == null) {
            return EXPECTED_TEST_DESCRIPTION;
        } else {
            final Atf4j.TestDescription atf4jTestDescription = testMethod.getAnnotation(Atf4j.TestDescription.class);
            final String resultString = atf4jTestDescription.value() == null ? EXPECTED_TEST_DESCRIPTION
                    : atf4jTestDescription.value();
            return resultString;
        }
    }

    /**
     * Find test method.
     *
     * @param stackTrace
     *            the stack trace
     * @return the method
     * @throws Exception
     *             the exception
     */
    private static Method findTestMethod(final StackTraceElement[] stackTrace) {
        log.info("AbstractAtf4jAnnotatedTest.findTestMethod");
        for (final StackTraceElement stackTraceElement : stackTrace) {
            final String candidateClassName = stackTraceElement.getClassName();
            try {
                final Class<?> candidateClass = Class.forName(candidateClassName);
                final Class<?> anAnnotatedClass = candidateClass;
                final String candidateMethodName = stackTraceElement.getMethodName();
                final Method[] methods = anAnnotatedClass.getMethods();
                for (final Method method : methods) {
                    if (method.getName().equals(candidateMethodName)) {
                        if (method.isAnnotationPresent(Test.class)) {
                            if (method.isAnnotationPresent(Atf4j.TestName.class)) {
                                return method;
                            }
                        }
                    }
                }
            } catch (final ClassNotFoundException classNotFoundException) {
                log.error(classNotFoundException.toString());
            } catch (final SecurityException securityException) {
                log.error(securityException.toString());
            }
        }
        return null;
    }
}
