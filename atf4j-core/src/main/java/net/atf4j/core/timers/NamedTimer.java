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

import java.util.UUID;

/**
 * A simple named Timer.
 */
public class NamedTimer implements TimerInterface {

    /** The start time in milliseconds. */
    private long startTime = 0;

    /** The stop time in milliseconds. */
    private long stopTime = 0;

    /** The elapsed time in milliseconds. */
    private long elapsedTime = 0;

    /**  Name of the timer, if no name was provided, then its unique UUID. */
    private final String timerName;

    /**
     * Instantiates a new timer.
     */
    public NamedTimer() {
        super();
        this.timerName = UUID.randomUUID().toString();
    }

    /**
     * Instantiates a new named timer.
     *
     * @param useName is a name for this Timer
     */
    public NamedTimer(final String useName) {
        super();
        this.timerName = useName;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.examples.timers.ITimer#start()
     */
    @Override
    public final NamedTimer start() {
        this.startTime = System.currentTimeMillis();
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.examples.timers.ITimer#stop()
     */
    @Override
    public final NamedTimer stop() {
        this.stopTime = System.currentTimeMillis();
        this.elapsedTime = this.stopTime - this.startTime;
        return this;
    }

    /**
     * Gets the timer name.
     *
     * @return the timer name
     */
    public String getTimerName() {
        return this.timerName;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.examples.timers.ITimer#getStartTime()
     */
    @Override
    public final long getStartTime() {
        return this.startTime;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.examples.timers.TimerInterface#getStopTime()
     */
    @Override
    public final long getStopTime() {
        return this.stopTime;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.examples.timers.ITimer#getElapsedTime()
     */
    @Override
    public long getElapsedTime() {
        return this.elapsedTime;
    }

    /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
    @Override
    public String toString() {
        return String.format("%s [timerName=%s, startTime=%s, stopTime=%s, elapsedTime=%s]",
                this.getClass().getSimpleName(),
                this.timerName,
                this.startTime,
                this.stopTime,
                this.elapsedTime);
    }

}
