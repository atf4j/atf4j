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

import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import lombok.extern.slf4j.Slf4j;

/**
 * A UnitTest for MappedTimers objects.
 */
@Slf4j
public final class MappedTimersTest {

    /**
     * Test method for MappedTimers.
     */
    @Test
    public void testGetInstance() {
        final MappedTimers timer = MappedTimers.getInstance();
        verifyNotNull(timer);
        log.debug(timer.toString());
    }

    /**
     * Test method for MappedTimers.
     */
    @Test
    public void testExpectedUsage() {
        final TimerInterface timer = MappedTimers.start("testExpectedUsage");
        verifyNotNull(timer);
        assertEquals(timer, timer.stop());
        log.debug(timer.toString());
    }

    /**
     * Test method for MappedTimers.
     */
    @Test
    public void testStopAll() {
        MappedTimers timers = MappedTimers.stopAll();
        verifyNotNull(timers);
    }

    /**
     * Test method for MappedTimers.
     */
    @Test
    public void testToString() {
        String debugString = MappedTimers.debugString();
        verifyNotNull(debugString);
    }
}
