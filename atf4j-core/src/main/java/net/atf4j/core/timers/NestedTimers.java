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

import java.util.Enumeration;
import java.util.Stack;
import java.util.UUID;

import net.atf4j.core.Atf4jException;
import net.atf4j.core.TestResultsReporting;

/**
 * NestedTimers. [GOF] Singleton.
 */
public final class NestedTimers extends TestResultsReporting {

    /** Singleton INSTANCE of this Class. */
    private static final NestedTimers INSTANCE = new NestedTimers();

    /** A FIFO stack of running timers. */
    private final Stack<NamedMilliTimer> runningTimers = new Stack<NamedMilliTimer>();

    /** A FIFO stack of stopped timers. */
    private final Stack<NamedMilliTimer> stoppedTimers = new Stack<NamedMilliTimer>();

    /**
     * Instantiates a new nested timers collection.
     */
    private NestedTimers() {
        super();
    }

    /**
     * getInstance.
     *
     * @return NestedTimers
     */
    public static NestedTimers getInstance() {
        return NestedTimers.INSTANCE;
    }

    /**
     * Start.
     *
     * @return the timer interface
     */
    public static TimerInterface start() {
        final String timerName = UUID.randomUUID().toString();
        return getInstance().startTimer(timerName);
    }

    /**
     * start a new Timer.
     *
     * @param timerName as String.
     * @return Timer.
     */
    public TimerInterface startTimer(final String timerName) {
        final NamedMilliTimer timer = new NamedMilliTimer(timerName);
        log.info(timer.toString());
        runningTimers.push(timer.start());
        return timer;
    }

    /**
     * stop the top timer.
     *
     * @return NestedTimers
     */
    public static TimerInterface stop() {
        return getInstance().stopTimer();
    }

    /**
     * stop the top Timer.
     *
     * @return Timer.
     */
    public TimerInterface stopTimer() {
        final NamedMilliTimer timer = runningTimers.pop();
        stoppedTimers.push(timer.stop());
        return timer;
    }

    /**
     * stopAll.
     *
     * @return NestedTimers
     */
    public static NestedTimers stopAll() {
        return getInstance().stopAllTimers();
    }

    /**
     * stopAll timers.
     *
     * @return NestedTimers
     */
    public NestedTimers stopAllTimers() {
        for (final NamedMilliTimer timer : runningTimers) {
            stoppedTimers.push(timer.stop());
        }
        return this;
    }

    /**
     * Running timers.
     *
     * @return the enumeration
     * @see java.util.Vector#elements()
     */
    public Enumeration<NamedMilliTimer> runningTimers() {
        return runningTimers.elements();
    }

    /**
     * Stopped timers.
     *
     * @return the enumeration
     * @see java.util.Vector#elements()
     */
    public Enumeration<NamedMilliTimer> stoppedTimers() {
        return stoppedTimers.elements();
    }

    /**
     * runningTimersAsString.
     *
     * @return the string
     */
    public String runningTimersAsString() {
        final StringBuffer stringBuffer = new StringBuffer();
        final Enumeration<NamedMilliTimer> running = runningTimers.elements();
        while (running.hasMoreElements()) {
            final String string = String.format("\n", running.nextElement());
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }

    /**
     * stoppedTimersAsString.
     *
     * @return the string
     */
    public String stoppedTimersAsString() {
        final StringBuffer stringBuffer = new StringBuffer();
        final Enumeration<NamedMilliTimer> stopped = stoppedTimers.elements();
        while (stopped.hasMoreElements()) {
            stringBuffer.append(stopped.nextElement().toString() + "\n");
        }
        return stringBuffer.toString();
    }

    /**
     * To string.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [runningTimers = %s, stoppedTimers = %s]",
                this.getClass().getSimpleName(),
                runningTimers,
                stoppedTimers);
    }

    /**
     * The TimersExhausted Class.
     */
    public class TimersExhausted extends Atf4jException {

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = 1L;
    }

}
