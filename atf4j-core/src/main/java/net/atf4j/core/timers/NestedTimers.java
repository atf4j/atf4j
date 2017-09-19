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

/**
 * NestedTimers. [GOF] Singleton.
 */
public final class NestedTimers {

    /** Singleton INSTANCE of this Class. */
    private static final NestedTimers INSTANCE = new NestedTimers();

    /** A FIFO stack of running timers. */
    private final Stack<MilliTimer> runningTimers = new Stack<MilliTimer>();

    /** A FIFO stack of stopped timers. */
    private final Stack<MilliTimer> stoppedTimers = new Stack<MilliTimer>();

    /**
     * Instantiates a new nested timers collection.
     */
    private NestedTimers() {
    }

    /**
     * getInstance.
     *
     * @return NestedTimers
     */
    public static NestedTimers getInstance() {
        return NestedTimers.INSTANCE;
    }

    public static TimerInterface start() {
        final String timerName = UUID.randomUUID().toString();
        return getInstance().startTimer(timerName);
    }

    /**
     * start a new Timer.
     *
     * @param timerName
     *            as String.
     * @return Timer.
     */
    public TimerInterface startTimer(final String timerName) {
        final MilliTimer timer = new MilliTimer(timerName);
        timer.start();
        this.runningTimers.push(timer);
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
        final MilliTimer timer = this.runningTimers.pop();
        timer.stop();
        this.stoppedTimers.push(timer);
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
        for (final MilliTimer timer : this.runningTimers) {
            this.stoppedTimers.push(timer.stop());
        }
        return this;
    }

    /**
     * Running timers.
     *
     * @return the enumeration
     * @see java.util.Vector#elements()
     */
    public Enumeration<MilliTimer> runningTimers() {
        return this.runningTimers.elements();
    }

    /**
     * Stopped timers.
     *
     * @return the enumeration
     * @see java.util.Vector#elements()
     */
    public Enumeration<MilliTimer> stoppedTimers() {
        return this.stoppedTimers.elements();
    }

    /**
     * runningTimersAsString.
     *
     * @return the string
     */
    public String runningTimersAsString() {
        final StringBuffer stringBuffer = new StringBuffer();
        final Enumeration<MilliTimer> running = this.runningTimers.elements();
        while (running.hasMoreElements()) {
            stringBuffer.append(running.nextElement().toString() + "\n");
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
        final Enumeration<MilliTimer> stopped = this.stoppedTimers.elements();
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
        return String.format("%s [runningTimers=%s,stoppedTimers=%s]", this.getClass().getSimpleName(),
                this.runningTimers, this.stoppedTimers);
    }

    public class TimersExhausted extends Atf4jException {
        private static final long serialVersionUID = 1L;
    }

}
