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
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */

package net.atf4j.annotations;

import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * A UnitTest for AnnotatedTest objects.
 */
@Slf4j
public class AnnotatedAtf4jTest extends AbstractAtf4jAnnotation {

    /**
     * Test test tag.
     *
     * @throws Exception the exception
     */
    @Test
    public void testTestTag() throws Exception {
        log.debug("testTestTag", this.getClass().getSimpleName());
        final String testTag = super.getTestTag();
        verifyNotNull(testTag);
        log.info("testTag = {}", testTag);
    }

    /**
     * Test method for AnnotatedTest.
     *
     * @throws Exception the exception
     */
    @Test
    public void testTestId() throws Exception {
        log.debug("testTestId", this.getClass().getSimpleName());
        final String testId = super.getTestId();
        verifyNotNull(testId);
        log.info("testId = {}", testId);
    }

    /**
     * Test method for AnnotatedTest.
     */
    @Test
    public void testTestName() {
        log.debug("testTestName", this.getClass().getSimpleName());
        final String testName = super.getTestName();
        verifyNotNull(testName);
        log.info("testName = {}", testName);
    }

    /**
     * Test method for AnnotatedTest.
     */
    @Test
    public void testTestDescription() {
        log.debug("testTestDescription", this.getClass().getSimpleName());
        final String testDescription = super.getTestDescription();
        verifyNotNull(testDescription);
        log.info("testDescription = {}", testDescription);
    }

}
