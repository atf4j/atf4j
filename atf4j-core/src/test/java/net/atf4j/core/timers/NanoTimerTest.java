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
 * A UnitTest for NanoTimer objects.
 */
@Slf4j
public final class NanoTimerTest {

    /**
     * Test method for NanoTimer.
     */
    @Test
    public void testDefaultConstructor() {
        final NamedNanoTimer nanoTimer = new NamedNanoTimer();
        verifyNotNull(nanoTimer);
        log.debug(nanoTimer.toString());
    }

    /**
     * Test method for NanoTimer.
     */
    @Test
    public void testNanoTimerString() {
        final String actual = "Named NanoTimer";
        final NamedNanoTimer nanoTimer = new NamedNanoTimer(actual);
        verifyNotNull(nanoTimer);
        assertEquals(actual, nanoTimer.getTimerName());
        log.debug(nanoTimer.toString());
    }

    /**
     * Test method for NanoTimer.
     */
    @Test
    public void testStart() {
        final NamedNanoTimer nanoTimer = new NamedNanoTimer();
        verifyNotNull(nanoTimer.start());
        log.debug(nanoTimer.toString());
    }

    /**
     * Test method for NanoTimer.
     */
    @Test
    public void testStop() {
        final NamedNanoTimer nanoTimer = new NamedNanoTimer();
        verifyNotNull(nanoTimer.stop());
        log.debug(nanoTimer.toString());
    }

    /**
     * Test method for NanoTimer.
     */
    @Test
    public void testGetStartTime() {
        final NamedNanoTimer nanoTimer = new NamedNanoTimer();
        verifyNotNull(nanoTimer.getStartTime());
        log.debug(nanoTimer.toString());
    }

    /**
     * Test method for NanoTimer.
     */
    @Test
    public void testGetElapsedTime() {
        final NamedNanoTimer nanoTimer = new NamedNanoTimer();
        verifyNotNull(nanoTimer.getElapsedTime());
        log.debug(nanoTimer.toString());
    }

    /**
     * Test method for NanoTimer.
     */
    @Test
    public void testToString() {
        final NamedNanoTimer nanoTimer = new NamedNanoTimer();
        verifyNotNull(nanoTimer.toString());
        log.debug(nanoTimer.toString());
    }

}
