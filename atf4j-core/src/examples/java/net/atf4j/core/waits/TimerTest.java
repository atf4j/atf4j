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
package net.atf4j.core.waits;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeTrue;

import org.junit.Assert;
import org.junit.Test;

import net.atf4j.core.ResultsReporting;
import net.atf4j.core.timers.MilliTimer;
import net.atf4j.core.timers.TimerInterface;

/**
 * Timer Test.
 */
public class TimerTest extends ResultsReporting {

    private static final int DEFAULT_INTERVAL = 100;
    private long delta = 1000;

    /**
     * Test method for DefaultConstructor.
     */
    @Test
    public void testDefaultConstructor() {
        MilliTimer timer = new MilliTimer();
        assertNotNull("unexpected null",timer);
    }

    /**
     * Instrument the actual timer its self. Calculates the delta for tests.
     */
    @Test
    public final void testTimer0() {
        final TimerInterface timer = new MilliTimer(this.getClass().getSimpleName());
        timer.start();
        // NOP elapsed time should be close to zero
        timer.stop();
        this.log.info("testTimer0.Start Time=" + timer.getStartTime());
        this.log.info("testTimer0.Elapsed Time=" + timer.getElapsedTime());
        this.log.info("testTimer0." + timer.toString() + " Elapsed time not within delta (" + this.delta + ")");
        assumeTrue(timer.getElapsedTime() <= this.delta);
        this.delta = timer.getElapsedTime();
    }

    /**
     * Unit Test method for One Second Timer.
     */
    @Test
    public final void testTimerOneSec() {
        final TimerInterface timer = new MilliTimer(this.getClass().getSimpleName());
        timer.start();
        waitDefaultInterval();
        timer.stop();
        this.log.info("testTimerOneSec.Start Time=" + timer.getStartTime());
        this.log.info("testTimerOneSec.Elapsed Time=" + timer.getElapsedTime());
        final String message = timer.toString() + " Elapsed time not within delta (" + this.delta + ")";
        Assert.assertTrue(message, timer.getElapsedTime() <= DEFAULT_INTERVAL + this.delta);
    }

    /**
     * Wait default interval.
     */
    private void waitDefaultInterval() {
        try {
            Thread.sleep(TimerTest.DEFAULT_INTERVAL);
        } catch (final InterruptedException interruptedException) {
            // restore interrupt status.
            Thread currentThread = Thread.currentThread();
            currentThread.interrupt();
            this.log.error(interruptedException.toString());
        }
    }
}
