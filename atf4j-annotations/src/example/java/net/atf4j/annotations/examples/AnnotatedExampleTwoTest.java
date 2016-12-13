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
package net.atf4j.annotations.examples;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.atf4j.annotations.AnnotatedTest;
import net.atf4j.annotations.Atf4j;

/**
 * Annotated Test Example Two, using static imports. Allows annotations to be
 * accessed directly with the functions getTestId(); getTestName();
 * getTestDescription();
 */
public class AnnotatedExampleTwoTest extends AnnotatedTest {

    /**
     * Annotated Test example two.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    @Atf4j.TestId("EXAMPLE-0002")
    @Atf4j.TestName("testExampleTwo")
    @Atf4j.TestDescription("Example showing annotations with inherited context")
    public final void testExample() throws Exception {
        log.trace(this.getClass().getSimpleName() + ".testAnnotationsWithPass");
        log.info("Test ID : = {} ", testId());
        log.info("Test Name : = {} ", testName());
        log.info("Test Description : = {} ", testDescription());
        assertTrue(true);
    }

}
