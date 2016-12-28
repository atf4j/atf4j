/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with atf4j. If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.core;

import org.junit.Test;

import net.atf4j.core.timers.NestedTimers;

/**
 * NestedTimersTest Class.
 */
public class NestedTimersTest extends ResultsReporting {

    private static final int DEFAULT_INTERVAL = 100;

    /**
     * test NestedTimers object.
     */
    @Test
    public final void testNestedTimers() {
        final NestedTimers multiTimers = NestedTimers.getInstance();
        for (int i = 0; i < 10; i++) {
            this.log.info(multiTimers.startTimer(String.format("Test case Timer %s", i)).toString());
        }
        for (int i = 0; i < 10; i++) {
            this.log.info(multiTimers.stopTimer().toString());
        }
    }

    /**
     * Test method for
     * { net.atf4j.core.timers.MilliTimer#Timer(java.lang.String)}.
     */

    @Test
    public final void testTimerInstance() {
        final NestedTimers multiTimers = NestedTimers.getInstance();
        multiTimers.startTimer("Timer Instance : Test case 1");
        waitDefaultInterval();
        multiTimers.startTimer("Timer Instance : Test case 2");
        waitDefaultInterval();
        multiTimers.startTimer("Timer Instance : Test case 3");
        waitDefaultInterval();
        multiTimers.startTimer("Timer Instance : Test case 4");
        waitDefaultInterval();
        multiTimers.startTimer("Timer Instance : Test case 5");
        waitDefaultInterval();
        this.log.info("runningTimersAsString\n" + multiTimers.runningTimersAsString());
        this.log.info("stop : " + multiTimers.stopTimer().toString());
        this.log.info("stop : " + multiTimers.stopTimer().toString());
        this.log.info("stop : " + multiTimers.stopTimer().toString());
        this.log.info("stop : " + multiTimers.stopTimer().toString());
        this.log.info("stop : " + multiTimers.stopTimer().toString());
        NestedTimers.stopAll();
        this.log.info("stoppedTimersAsString()\n" + multiTimers.stoppedTimersAsString());
    }

    /**
     * Test method for
     * { net.atf4j.core.timers.MilliTimer#Timer(java.lang.String)}.
     */

    @Test
    public final void testStaticNamedTimers() {
        NestedTimers.start("Static Named Timers Test case 1");
        waitDefaultInterval();
        NestedTimers.start("Static Named Timers Test case 2");
        waitDefaultInterval();
        NestedTimers.start("Static Named Timers Test case 3");
        waitDefaultInterval();
        NestedTimers.start("Static Named Timers Test case 4");
        waitDefaultInterval();
        NestedTimers.start("Static Named Timers Test case 5");
        waitDefaultInterval();
        this.log.info(NestedTimers.stop().toString());
        this.log.info(NestedTimers.stop().toString());
        this.log.info(NestedTimers.stop().toString());
        this.log.info(NestedTimers.stop().toString());
        this.log.info(NestedTimers.stop().toString());
        NestedTimers.stopAll();
    }

    /**
     * Test method for
     * { net.atf4j.core.timers.MilliTimer#Timer(java.lang.String)}.
     */

    @Test
    public final void testTimerStarting() {
        NestedTimers.start("Timer Starting Test case 1");
        waitDefaultInterval();
        NestedTimers.start("Timer Starting Test case 2");
        waitDefaultInterval();
        NestedTimers.start("Timer Starting Test case 3");
        waitDefaultInterval();
        NestedTimers.start("Timer Starting Test case 4");
        waitDefaultInterval();
        NestedTimers.start("Timer Starting Test case 5");
        waitDefaultInterval();
        NestedTimers.stopAll();
    }

    /**
     * Wait default interval.
     */
    private void waitDefaultInterval() {
        try {
            Thread.sleep(DEFAULT_INTERVAL);
        } catch (final InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            this.log.error(interruptedException.toString());
        }
    }
}
