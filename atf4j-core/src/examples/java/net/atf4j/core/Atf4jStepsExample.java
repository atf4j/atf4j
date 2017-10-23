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

package net.atf4j.core;

import static net.atf4j.core.Atf4j.document;
import static net.atf4j.core.Atf4j.end;
import static net.atf4j.core.Atf4j.start;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import org.junit.Test;

/**
 * A UnitTest for Atf4jSteps objects.
 */
public final class Atf4jStepsExample {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * test Atf4jSteps object.
     */
    @Test
    public void testSimpleStep() {
        start("start simple test step");
        {
            start("step one");
            {
                document(Thread.currentThread().getStackTrace());
            }
            end();
        }
        end();
    }

    /**
     * test Atf4jSteps object.
     */
    @Test
    public void testStepPass() {
        start("start pass test step");
        {
            start("step one");
            {
                assumeTrue(true);
            }
            end();

            start("step two");
            {
                assertNotNull(UNEXPECTED_NULL, this);
            }
            end();
        }
        end();
    }

    /**
     * Test step fail.
     */
    @Test(expected = AssertionError.class)
    public void testStepFail() {
        start("start fail test step");
        {
            start("step one");
            {
                fail("fail step");
            }
            end();
        }
        end();
    }
}
