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
 * A UnitTest for MilliTimer objects.
 */
public final class NamedTimerTest extends TestResultsReporting {

    @Test
    public void testMilliTimer() {
        final NamedTimer namedTimer = new NamedTimer();
        log.debug("new MilliTimer() = {}", namedTimer);
        assertNotNull(UNEXPECTED_NULL, namedTimer);
    }

    /**
     * Test method for MilliTimer.
     */
    @Test
    public void testMilliTimerString() {
        final NamedTimer namedTimer = new NamedTimer("MilliTimer");
        log.debug("new MilliTimer() = {}", namedTimer);
        assertNotNull(UNEXPECTED_NULL, namedTimer);
    }

    /**
     * Test method for MilliTimer.
     */
    @Test
    public void testStart() {
        final NamedTimer namedTimer = new NamedTimer();
        log.debug("new MilliTimer() = {}", namedTimer);
        assertNotNull(UNEXPECTED_NULL, namedTimer.start());
    }

    /**
     * Test method for MilliTimer.
     */
    @Test
    public void testStop() {
        final NamedTimer namedTimer = new NamedTimer();
        log.debug("new MilliTimer() = {}", namedTimer);
        assertNotNull(UNEXPECTED_NULL, namedTimer.stop());
    }

    /**
     * Test method for MilliTimer.
     */
    @Test
    public void testGetStartTime() {
        final NamedTimer milliTimer = new NamedTimer();
        log.debug("new MilliTimer() = {}", milliTimer);
        assertNotNull(UNEXPECTED_NULL, milliTimer.getStartTime());
    }

    /**
     * Test method for MilliTimer.
     */
    @Test
    public void testGetElapsedTime() {
        final NamedTimer namedTimer = new NamedTimer();
        log.debug("new MilliTimer() = {}", namedTimer);
        assertNotNull(UNEXPECTED_NULL, namedTimer.getElapsedTime());
    }

    /**
     * Test method for MilliTimer.
     */
    @Test
    public void testToString() {
        final NamedTimer namedTimer = new NamedTimer();
        log.debug("new MilliTimer() = {}", namedTimer);
        assertNotNull(UNEXPECTED_NULL, namedTimer.toString());
    }

    /**
     * Test method for MilliTimer.
     */
    @Test
    public void testGetTimerName() {
        final NamedTimer namedTimer = new NamedTimer();
        log.debug("new MilliTimer() = {}", namedTimer);
        assertNotNull(UNEXPECTED_NULL, namedTimer.getTimerName());
    }

}
