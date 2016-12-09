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
package net.aft4j.annotations;

import java.lang.reflect.Method;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.LoggedTest;;

/**
 * Abstract Annotated Test class.
 */
@Atf4j.TestScript
public abstract class AbstractAtf4jAnnotatedTest extends LoggedTest {

	/** The Constant log. */
	public static final Logger log = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

	/** The Constant EXPECTED_TEST_ID. */
	private static final String EXPECTED_TEST_ID = "Expected @Atf4j.TestId annotation, but not found.";

	/** The Constant EXPECTED_TEST_NAME. */
	private static final String EXPECTED_TEST_NAME = "Expected @Atf4j.TestName annotation, but not found.";

	/** The Constant EXPECTED_TEST_DESCRIPTION. */
	private static final String EXPECTED_TEST_DESCRIPTION = "Expected @Atf4j.TestDescription, but annotation not found.";

	/**
	 * Test id.
	 *
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public String testId() throws Exception {
		log.trace("AbstractAtf4jAnnotatedTest.testId");

		final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		for (final StackTraceElement element : stackTrace) {
			final String methodName = element.getMethodName();
			log.trace("methodName" + methodName);
		}

		final Method testMethod = findTestMethod(stackTrace);
		final Atf4j.TestId atf4jTestId = testMethod.getAnnotation(Atf4j.TestId.class);
		return atf4jTestId.value() == null ? EXPECTED_TEST_ID : atf4jTestId.value();
	}

	/**
	 * Send the Atf4j.TestId annotation of the Test Method to the log.
	 *
	 * @return the Atf4j.TestId as a String object.
	 */
	public String logTestId() {
		log.trace("AbstractAtf4jAnnotatedTest.logTestId");

		String testId = null;
		try {
			testId = getTestId();
			log.info(testId);
		} catch (final Exception exception) {
			log.error(exception.getLocalizedMessage());
		}
		return testId;
	}

	/**
	 * Gets the the Atf4j.TestId annotation of the Test Method.
	 *
	 * @return the Atf4j.TestId as a String object.
	 * @throws Exception the exception
	 */
	protected String getTestId() throws Exception {
		log.trace("AbstractAtf4jAnnotatedTest.getTestId");
		final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		final Method testMethod = findTestMethod(stackTrace);
		if (testMethod == null) {
			return EXPECTED_TEST_ID;
		} else {
			final Atf4j.TestId atf4jTestId = testMethod.getAnnotation(Atf4j.TestId.class);
			return atf4jTestId.value() == null ? EXPECTED_TEST_ID : atf4jTestId.value();
		}
	}

	/**
	 * Send the Atf4j.TestName annotation of the Test Method to the log.
	 *
	 * @return the Atf4j.TestName as a String object.
	 */
	public String logTestName() {
		log.trace("AbstractAtf4jAnnotatedTest.logTestName");
		String testName = null;
		try {
			testName = getTestName();
			log.info(testName);
		} catch (final Exception exception) {
			log.error(exception.getLocalizedMessage());
		}
		return testName;
	}

	/**
	 * Gets the Atf4j.TestName annotation as a String object.
	 *
	 * @return the Atf4j.TestName as a String object.
	 * @throws Exception the exception
	 */
	protected String getTestName() throws Exception {
		log.trace("AbstractAtf4jAnnotatedTest.getTestName");
		final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		final Method testMethod = findTestMethod(stackTrace);
		if (testMethod == null) {
			return EXPECTED_TEST_NAME;
		} else {
			final Atf4j.TestName atf4jTestName = testMethod.getAnnotation(Atf4j.TestName.class);
			return atf4jTestName.value() == null ? EXPECTED_TEST_NAME : atf4jTestName.value();
		}
	}

	/**
	 * Send the Atf4j.TestDescription annotation of the Test Method to the log.
	 *
	 * @return the Atf4j.TestName as a String object.
	 */
	public String logTestDescriptions() {
		log.trace("AbstractAtf4jAnnotatedTest.getTestName");
		String testDescriptions = null;
		try {
			testDescriptions = getTestDescription();
			log.info(testDescriptions);
		} catch (final Exception exception) {
			log.error(exception.getLocalizedMessage());
		}
		return testDescriptions;
	}

	/**
	 * Gets the Atf4j.TestDescription annotation of the Test Method as a String
	 * object.
	 *
	 * @return the Atf4j.TestDescription as a String object.
	 * @throws Exception the exception
	 */
	protected String getTestDescription() throws Exception {
		log.trace("AbstractAtf4jAnnotatedTest.getTestName");
		final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		final Method testMethod = findTestMethod(stackTrace);
		if (testMethod == null) {
			return EXPECTED_TEST_DESCRIPTION;
		} else {
			final Atf4j.TestDescription atf4jTestDescription = testMethod.getAnnotation(Atf4j.TestDescription.class);
			return atf4jTestDescription.value() == null ? EXPECTED_TEST_DESCRIPTION : atf4jTestDescription.value();
		}
	}

	/**
	 * Find test method.
	 *
	 * @param stackTrace            the stack trace
	 * @return the method
	 * @throws Exception the exception
	 */
	private Method findTestMethod(final StackTraceElement[] stackTrace) throws Exception {
		log.trace("AbstractAtf4jAnnotatedTest.findTestMethod");
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
