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

import static org.junit.Assert.fail;

import org.junit.Test;

import net.atf4j.core.LoggedTest;


/**
 * An AnnotatedTest Class.
 */
@Atf4j.TestScript
public class Atf4jAnnotationTest extends LoggedTest {

	/**
	 * The Class TestReport.
	 */
	public static class TestReport extends AbstractAtf4jAnnotatedTest {
	}

	/** The Constant TEST_FAIL_ID. */
	private static final String TEST_FAIL_ID = "FAIL-0001";
	
	/** The Constant TEST_PASS_ID. */
	private static final String TEST_PASS_ID = "PASS-0001";
	
	/** The Constant TEST_ANNOTATIONS_WITH_FAIL. */
	private static final String TEST_ANNOTATIONS_WITH_FAIL = "testAnnotationsWithFail";
	
	/** The Constant ANNOTATIONS_TEST_PASSED_NAME. */
	private static final String ANNOTATIONS_TEST_PASSED_NAME = "testAnnotationsWithPass";
	
	/** The Constant GIVEN_WHEN_THEN. */
	private static final String GIVEN_WHEN_THEN = "Given...\nWhen...\nThen...\n";

	/**
	 * Test method atf4j Test Annotations with pass.
	 * Given a test is annotated
	 * When the test passes
	 * Then log includes the test metadata
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Atf4j.TestId(TEST_PASS_ID)
	@Atf4j.TestName(ANNOTATIONS_TEST_PASSED_NAME)
	@Atf4j.TestDescription(GIVEN_WHEN_THEN)
	public final void testAnnotationsWithPass() throws Exception {
		log.trace("testAnnotationsWithPass");
		verify(TEST_PASS_ID, AnnotationHelper.getTestId());
		verify(ANNOTATIONS_TEST_PASSED_NAME, AnnotationHelper.getTestName());
		verify(GIVEN_WHEN_THEN, AnnotationHelper.getTestDescription());
	}

	/**
	 * Test method atf4j Test Annotations with failure.
	 * Given a test is annotated\n
	 * When the test fails\n
	 * Then log includes the test metadata.\n
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Atf4j.TestId(TEST_FAIL_ID)
	@Atf4j.TestName(TEST_ANNOTATIONS_WITH_FAIL)
	@Atf4j.TestDescription(GIVEN_WHEN_THEN)
	public final void testAnnotationsWithFail() throws Exception {
		log.trace("testAnnotationsWithPass");
		try {
			fail("Force a failure.");
		} catch (final AssertionError assertion) {
			log.error(assertion.getLocalizedMessage());
		} finally {
			verify(TEST_FAIL_ID, AnnotationHelper.getTestId());
			verify(TEST_ANNOTATIONS_WITH_FAIL, AnnotationHelper.getTestName());
			verify(GIVEN_WHEN_THEN, AnnotationHelper.getTestDescription());
		}
	}
}
