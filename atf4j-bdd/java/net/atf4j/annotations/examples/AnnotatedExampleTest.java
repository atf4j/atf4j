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

import static net.atf4j.annotations.AnnotationHelper.getTestDescription;
import static net.atf4j.annotations.AnnotationHelper.getTestId;
import static net.atf4j.annotations.AnnotationHelper.getTestName;
import static net.atf4j.core.Atf4j.document;
import static net.atf4j.core.Atf4j.end;
import static net.atf4j.core.Atf4j.start;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.annotations.Atf4j.TestDescription;
import net.atf4j.annotations.Atf4j.TestId;
import net.atf4j.annotations.Atf4j.TestName;

/**
 * Annotated Test Example One. using static imports. Allows annotations to be
 * accessed directly with the functions getTestId(); getTestName();
 * getTestDescription();
 */
public class AnnotatedExampleTest {

    /** logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Annotated Test example.
     */
    @Test
    @TestId("EXAMPLE-0001")
    @TestName("testEample")
    @TestDescription("Example showing annotations with static context")
    public void testSteps() {
        start(getTestId());
        {
            start(getTestName());
            {
                this.log.info("Test Description : = {} ", getTestDescription());
                document(Thread.currentThread().getStackTrace());
            }
            end();
        }
        end();
    }
}
