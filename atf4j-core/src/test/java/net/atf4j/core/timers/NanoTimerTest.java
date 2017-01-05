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
 * A UnitTest for NanoTimer objects.
 */
public class NanoTimerTest extends ResultsReporting {

    /**
     * Test method for NanoTimer}.
     */
    @Test
    public void testDefaultConstructor() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer);
    }

    /**
     * Test method for NanoTimer}.
     */
    @Test
    public void testNanoTimerString() {
        final String actual = "Named NanoTimer";
        final NanoTimer nanoTimer = new NanoTimer(actual);
        assertNotNull(nanoTimer);
        assertNotNull(actual, nanoTimer.getTimerName());
    }

    /**
     * Test method for NanoTimer}.
     */
    @Test
    public void testStart() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer.start());
    }

    /**
     * Test method for NanoTimer}.
     */
    @Test
    public void testStop() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer.stop());
    }

    /**
     * Test method for NanoTimer}.
     */
    @Test
    public void testGetStartTime() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer.getStartTime());
    }

    /**
     * Test method for NanoTimer}.
     */
    @Test
    public void testGetElapsedTime() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer.getElapsedTime());
    }

    /**
     * Test method for NanoTimer}.
     */
    @Test
    public void testToString() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer.toString());
    }

}
