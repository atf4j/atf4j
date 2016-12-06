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
package net.aft4j.annotations;

import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class AnnotationHelper.
 */
class AnnotationHelper {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(AnnotationHelper.class);
	
	/** The Constant EXPECTED_TEST_SCRIPT. */
	private static final String EXPECTED_TEST_SCRIPT = "Expected @Atf4j.TestScript annotation not found.";
	
	/** The Constant EXPECTED_TEST_ID. */
	private static final String EXPECTED_TEST_ID = "Expected @Atf4j.TestId annotation not found.";
	
	/** The Constant EXPECTED_TEST_NAME. */
	private static final String EXPECTED_TEST_NAME = "Expected @Atf4j.TestName annotation not found.";
	
	/** The Constant EXPECTED_TEST_DESCRIPTION. */
	private static final String EXPECTED_TEST_DESCRIPTION = "Expected @Atf4j.TestDescription annotation not found.";

	/**
	 * Gets the test id from @TestId.
	 * {@link net.atf4j.automation.TestId()}
	 *
	 * @return the getTestId as String
	 */
	public static String getTestId() {
		log.info("AnnotationHelper.getTestId");
		final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		Method testMethod = null;
		try {
			testMethod = findTestMethod(stackTrace);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final Atf4j.TestId testId = testMethod.getAnnotation(Atf4j.TestId.class);

		return testId.value() == null ? EXPECTED_TEST_ID : testId.value();
	}

	/**
	 * Gets the test name from @TestName.
	 * {@link net.atf4j.automation.TestName()}
	 *
	 * @return the getTestName as String
	 */
	public static String getTestName() {
		log.info("AnnotationHelper.getTestName");

		final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		Method testMethod = null;
		try {
			testMethod = findTestMethod(stackTrace);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final Atf4j.TestName automatedTestName = testMethod.getAnnotation(Atf4j.TestName.class);

		return automatedTestName.value() == null ? EXPECTED_TEST_NAME : automatedTestName.value();
	}

	/**
	 * Gets the test descriptions from @TestDesciption.
	 * {@link net.atf4j.automation.TestDesciption()}
	 *
	 * @return the getTestDescriptions as String
	 */
	public static String getTestDescription() {
		log.info("AnnotationHelper.getTestDescription");

		final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		Method testMethod = null;
		try {
			testMethod = findTestMethod(stackTrace);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final Atf4j.TestDescription automatedTestDescription = testMethod.getAnnotation(Atf4j.TestDescription.class);

		return automatedTestDescription.value() == null ? EXPECTED_TEST_DESCRIPTION : automatedTestDescription.value();
	}

	// private static Method findTestMethod(final StackTraceElement[]
	// stackTrace) {
	// log.trace("AnnotationHelper.findTestMethod");
	//
	// try {
	// for (final StackTraceElement stackTraceElement : stackTrace) {
	// final String candidateClassName = stackTraceElement.getClassName();
	// log.info(candidateClassName);
	// final Class<?> candidateClass = Class.forName(candidateClassName);
	// if (candidateClass.isAnnotationPresent(Atf4j.TestScript.class)) {
	// final Class<?> anAnnotatedClass = candidateClass;
	// final String candidateMethodName = stackTraceElement.getMethodName();
	// log.trace(candidateMethodName);
	// final Method[] methods = anAnnotatedClass.getMethods();
	// log.info("methods.length=" + methods.length);
	// for (final Method method : methods) {
	// log.info(candidateMethodName);
	// if (method.getName().equals(candidateMethodName)) {
	// if (method.isAnnotationPresent(Test.class)) {
	// if (method.isAnnotationPresent(Atf4j.class)) {
	// return method;
	// }
	// }
	// }
	// }
	// }
	// }
	// } catch (final ClassNotFoundException classNotFoundException) {
	// classNotFoundException.printStackTrace();
	// throw new RuntimeException(classNotFoundException);
	// } catch (final SecurityException securityException) {
	// securityException.printStackTrace();
	// throw new RuntimeException(securityException);
	// }
	// return null;
	/**
	 * Find test method.
	 *
	 * @param stackTrace the stack trace
	 * @return the method
	 * @throws Exception the exception
	 */
	// }
	private static Method findTestMethod(final StackTraceElement[] stackTrace) throws Exception {
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
				classNotFoundException.printStackTrace();
				throw new RuntimeException(classNotFoundException);
			} catch (final SecurityException securityException) {
				securityException.printStackTrace();
				throw new RuntimeException(securityException);
			}
		}
		return null;
	}
}
