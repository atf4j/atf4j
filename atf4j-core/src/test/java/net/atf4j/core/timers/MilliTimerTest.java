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

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for MilliTimer objects.
 */
public class MilliTimerTest extends ResultsReporting {

    /**
     * Test method for MilliTimer}.
     */
    @Test
    public void testMilliTimer() {
        final MilliTimer milliTimer = new MilliTimer();
        assertNotNull("unexpected null", milliTimer);
    }

    /**
     * Test method for MilliTimer}.
     */
    @Test
    public void testMilliTimerString() {
        final MilliTimer milliTimer = new MilliTimer("");
        assertNotNull("unexpected null", milliTimer);
    }

    /**
     * Test method for MilliTimer}.
     */
    @Test
    public void testStart() {
        final MilliTimer milliTimer = new MilliTimer();
        assertNotNull("unexpected null", milliTimer.start());
    }

    /**
     * Test method for MilliTimer}.
     */
    @Test
    public void testStop() {
        final MilliTimer milliTimer = new MilliTimer();
        assertNotNull("unexpected null", milliTimer.stop());
    }

    /**
     * Test method for MilliTimer}.
     */
    @Test
    public void testGetStartTime() {
        final MilliTimer milliTimer = new MilliTimer();
        assertNotNull("unexpected null", milliTimer.getStartTime());
    }

    /**
     * Test method for MilliTimer}.
     */
    @Test
    public void testGetElapsedTime() {
        final MilliTimer milliTimer = new MilliTimer();
        assertNotNull("unexpected null", milliTimer.getElapsedTime());
    }

    /**
     * Test method for MilliTimer}.
     */
    @Test
    public void testToString() {
        final MilliTimer milliTimer = new MilliTimer();
        assertNotNull("unexpected null", milliTimer.toString());
    }

    /**
     * Test method for MilliTimer}.
     */
    @Test
    public void testGetTimerName() {
        final MilliTimer milliTimer = new MilliTimer();
        assertNotNull("unexpected null", milliTimer.getTimerName());
    }

}
