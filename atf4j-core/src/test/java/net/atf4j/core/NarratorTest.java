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

import org.junit.Test;

/**
 * A UnitTest for Narrator objects.
 */
public final class NarratorTest extends TestResultsReporting {

    public final class ClassUnderTest {
        private final Object object = new Object();
        private final String className = this.getClass().getSimpleName();
        private final Boolean aBoolean = true;
        private final long number = Long.MAX_VALUE;

        @Override
        public String toString() {
            return String.format("NarratorTest [object=%s, className=%s, aBoolean=%s, number=%s]",
                    object,
                    className,
                    aBoolean,
                    number);
        }
    }

    /**
     * Unit Test for test reflect object to string.
     */
    @Test
    public void testReflectObjectToString() {
        log.info(Narrator.reflectObjectToString(new ClassUnderTest()));
    }

}
