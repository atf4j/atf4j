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
import static org.junit.Assume.assumeTrue;

import org.junit.Test;

/**
 * A UnitTest for Atf4jSteps objects.
 */
public class Atf4jStepsTest {

    /**
     * test Atf4jSteps object.
     */
    @Test
    public void testSimpleStep() {
        start("start test");
        {
            start("step One");
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
    public void testSteps() {
        start("start test");
        {
            start("step One");
            {
                assumeTrue(true);
            }
            end();

            start("step Two");
            {
                assumeTrue(true);
            }
            end();
        }
        end();
    }
}
