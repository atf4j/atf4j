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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * A UnitTest for AnnotatedTest objects.
 */
public class AnnotatedTestTest extends AbstractAnnotatedTest {

    /**
     * Test method for AnnotatedTest.
     */
    @Test
    public void testTestId() throws Exception {
        log.info("{}.testTestId", this.getClass().getSimpleName());
        final String testId = super.testId();
        assertNotNull(testId);
        log.info("testId = {}", testId);
    }

    /**
     * Test method for AnnotatedTest.
     */
    @Test
    public void testTestName() {
        log.info("{}.testTestName", this.getClass().getSimpleName());
        final String testName = super.testName();
        assertNotNull(testName);
        log.info("testName = {}", testName);
    }

    /**
     * Test method for AnnotatedTest.
     */
    @Test
    public void testTestDescription() {
        log.info("{}.testTestDescription", this.getClass().getSimpleName());
        final String testDescription = super.testDescription();
        assertNotNull(testDescription);
        log.info("testDescription = {}", testDescription);
    }

}
