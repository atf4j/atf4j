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

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import net.atf4j.core.TestResultsReporting;

/**
 * Timer Test.
 */
public final class TimerTest extends TestResultsReporting {

    private static final int DEFAULT_INTERVAL = 100;
    private final long delta = 1000;

    /**
     * Test method for DefaultConstructor.
     */
    @Test
    public void testDefaultConstructor() {
        final NamedTimer timer = new NamedTimer();
        verifyNotNull(timer);
    }

    /**
     * Instrument the actual timer its self. Calculates the delta for tests.
     */
    @Test
    public void testTimer() {
        final TimerInterface timer = new NamedTimer(this.getClass().getSimpleName());
        assertNotNull(timer);
        assertNotNull(timer.start());
        assertNotNull(timer.stop());
        this.log.debug("Start Time = {}", timer.getStartTime());
        final long elapsedTime = timer.getElapsedTime();
        this.log.debug("Elapsed Time = {} ", elapsedTime);
        this.log.debug("Elapsed time within delta ({}) for {}", this.delta, timer.toString());
        final String message = String.format(" Elapsed time not within delta (%s) for ", this.delta, timer.toString());
        assertTrue(message, timer.getElapsedTime() <= DEFAULT_INTERVAL + this.delta);
    }

    /**
     * Unit Test method for One Second Timer.
     */
    @Test
    public void testTimerOneSec() {
        final TimerInterface timer = new NamedTimer(this.getClass().getSimpleName());
        assertNotNull(timer);
        assertNotNull(timer.start());
        waitDefaultInterval();
        assertNotNull(timer.stop());
        this.log.debug("Start Time = {}", timer.getStartTime());
        this.log.debug("Elapsed Time = {}", timer.getElapsedTime());
        final String message = String.format(" Elapsed time not within delta (%s)", timer, this.delta);
        assertTrue(message, timer.getElapsedTime() <= DEFAULT_INTERVAL + this.delta);
    }

    /**
     * Wait default interval.
     */
    private void waitDefaultInterval() {
        try {
            Thread.sleep(TimerTest.DEFAULT_INTERVAL);
        } catch (final InterruptedException interruptedException) {
            // restore interrupt status.
            final Thread currentThread = Thread.currentThread();
            currentThread.interrupt();
            this.log.error(interruptedException.toString());
        }
    }
}
