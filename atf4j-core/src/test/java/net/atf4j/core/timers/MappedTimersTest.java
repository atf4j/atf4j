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

package net.atf4j.core.timers;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A UnitTest for MappedTimers objects.
 */
public class MappedTimersTest extends TestResultsReporting {

    /**
     * Test method for MappedTimers.
     */
    @Test
    public void testGetInstance() {
        final MappedTimers instance = MappedTimers.getInstance();
        assertNotNull(UNEXPECTED_NULL, instance);
    }

    /**
     * Test method for MappedTimers.
     */
    @Test
    public void testExpectedUsage() {
        final TimerInterface timer = MappedTimers.start("testExpectedUsage");
        assertNotNull(UNEXPECTED_NULL, timer);
        assertNotNull(UNEXPECTED_NULL, timer.stop());
        this.log.info(timer.toString());
    }

    /**
     * Test method for MappedTimers.
     */
    @Test
    public void testStopAll() {
        assertNotNull(UNEXPECTED_NULL, MappedTimers.stopAll());
    }

    /**
     * Test method for MappedTimers.
     */
    @Test
    public void testToString() {
        assertNotNull(UNEXPECTED_NULL, MappedTimers.debugString());
    }

}
