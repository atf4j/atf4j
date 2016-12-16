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
package net.atf4j.annotations;

import static org.junit.Assert.fail;

import org.junit.Test;

import net.atf4j.core.LoggedTest;

/**
 * An AnnotatedTest Class.
 */
@Atf4j.TestScript
public class AnnotationHelperTest extends LoggedTest {

    private static final String TEST_FAIL_ID = "FAIL-0001";
    private static final String TEST_PASS_ID = "PASS-0001";
    private static final String TEST_FAIL_NAME = "testAnnotationsWithFail";
    private static final String TEST_PASS_NAME = "testAnnotationsWithPass";
    private static final String GIVEN_WHEN_THEN = "\n\tGiven...\n\tWhen...\n\tThen...\n";

    /**
     * Test method atf4j Test Annotations with pass. Given a test is annotated
     * When the test passes Then log includes the test metadata
     */
    @Test
    @Atf4j.TestId(TEST_PASS_ID)
    @Atf4j.TestName(TEST_PASS_NAME)
    @Atf4j.TestDescription(GIVEN_WHEN_THEN)
    public final void testAnnotationsWithPass() {
        this.log.trace("{}.testAnnotationsWithPass", this.getClass().getSimpleName());
        verify(TEST_PASS_ID, AnnotationHelper.getTestId());
        verify(TEST_PASS_NAME, AnnotationHelper.getTestName());
        verify(GIVEN_WHEN_THEN, AnnotationHelper.getTestDescription());
    }

    /**
     * Test method atf4j Test Annotations with failure. Given a test is
     * annotated\n When the test fails\n Then log includes the test metadata.\n
     */
    @Test(expected = AssertionError.class)
    @Atf4j.TestId(TEST_FAIL_ID)
    @Atf4j.TestName(TEST_FAIL_NAME)
    @Atf4j.TestDescription(GIVEN_WHEN_THEN)
    public final void testAnnotationsWithFail() {
        this.log.trace("{}.testAnnotationsWithFail", this.getClass().getSimpleName());
        try {
            fail("Force a failure.");
        } finally {
            verify(TEST_FAIL_ID, AnnotationHelper.getTestId());
            verify(TEST_FAIL_NAME, AnnotationHelper.getTestName());
            verify(GIVEN_WHEN_THEN, AnnotationHelper.getTestDescription());
        }
    }

    /**
     * Test missing test id annotation.
     */
    @Test
    public final void testMissingTestIdAnnotation() {
        verify("Expected @Atf4j.TestId annotation not found.", AnnotationHelper.getTestId());
    }

    /**
     * Test missing test name annotation.
     */
    @Test
    public final void testMissingTestNameAnnotation() {
        verify("Expected @Atf4j.TestName annotation not found.", AnnotationHelper.getTestName());
    }

    /**
     * Test missing test description annotation.
     */
    @Test
    public final void testMissingTestDescriptionAnnotation() {
        verify("Expected @Atf4j.TestDescription annotation not found.", AnnotationHelper.getTestDescription());
    }

}
