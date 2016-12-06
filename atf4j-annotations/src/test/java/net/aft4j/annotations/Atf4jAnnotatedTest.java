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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;


/**
 * AnnotatedTest Class.
 */
@Atf4j.TestScript
public class Atf4jAnnotatedTest extends AbstractAtf4jAnnotatedTest {

	/** The Constant TEST_DESCRIPTION. */
	private static final String TEST_DESCRIPTION = "\n\tGiven predicates\n\tWhen command\n\tThen acceptance criteria\n";

	/**
	 * Test eample.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Atf4j.TestId("EXAMPLE-0000")
	@Atf4j.TestName("testEample")
	@Atf4j.TestDescription(TEST_DESCRIPTION)
	public final void testEample() throws Exception {
		log.trace(this.getClass().getSimpleName() + ".testAnnotationsWithPass");
		log.info("Test ID : = {} ", getTestId());
		log.info("Test Name : = {} ", getTestName());
		log.info("Test Description : = {} ", getTestDescription());
		assertTrue(true);
	}

	/**
	 * Test method atf4j Test Annotations with pass.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Atf4j.TestId("PASS-0001")
	@Atf4j.TestName("testMockPass")
	@Atf4j.TestDescription(TEST_DESCRIPTION)
	public final void testMockPass() throws Exception {
		log.trace(this.getClass().getSimpleName() + ".testAnnotationsWithPass");
		verify("PASS-0001", getTestId());
		verify("testMockPass", getTestName());
		verify(TEST_DESCRIPTION, getTestDescription());
		assertTrue(true);
	}

	/**
	 * Test method atf4j Test Annotations with failure.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Atf4j.TestId("FAIL-0001")
	@Atf4j.TestName("testMockFail")
	@Atf4j.TestDescription(TEST_DESCRIPTION)
	public final void testMockFail() throws Exception {
		log.trace(this.getClass().getSimpleName() + ".testMockFail");
		try {
			fail("Forced Failure");
		} catch (final AssertionError assertion) {
			verify("FAIL-0001", getTestId());
			verify("testMockFail", getTestName());
			verify(TEST_DESCRIPTION, getTestDescription());
			log.error(assertion.toString());
		} finally {
			verify("FAIL-0001", getTestId());
			verify("testMockFail", getTestName());
			verify(TEST_DESCRIPTION, getTestDescription());
		}
	}

	/**
	 * Test missing annotation.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public final void testMissingAnnotation() throws Exception {
		log.trace(this.getClass().getSimpleName() + ".testMissingAnnotation");
		log.info("Test ID : = {} ", getTestId());
		log.info("Test Name : = {} ", getTestName());
		log.info("Test Description : = {} ", getTestDescription());
		assertTrue(true);
	}

}
