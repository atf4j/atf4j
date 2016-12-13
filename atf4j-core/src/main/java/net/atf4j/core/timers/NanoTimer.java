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
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.core.timers;

import java.util.UUID;

import net.atf4j.core.ToStringBuilder;

/**
 * A named nano second Timer. (In most cases this offers no advantage over the
 * millisecond timer).
 */
public class NanoTimer implements ITimer {

    /** The start time. */
    private long startTime = -1L;

    /** The stop time. */
    private long stopTime = -1L;

    /** The elapsed time. */
    private long elapsedTime = -1L;

    /** The timer name. */
    private final String timerName;

    /**
     * Instantiates a new timer.
     */
    public NanoTimer() {
        this.timerName = UUID.randomUUID().toString();
    }

    /**
     * Instantiates a new named timer.
     *
     * @param useName
     *            is a name for this Timer
     */
    public NanoTimer(final String useName) {
        this.timerName = useName;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.timers.ITimer#start()
     */
    @Override
    public final NanoTimer start() {
        this.startTime = System.nanoTime();
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.timers.ITimer#stop()
     */
    @Override
    public final NanoTimer stop() {
        this.stopTime = System.nanoTime();
        this.elapsedTime = this.stopTime - this.startTime;
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.timers.ITimer#getStartTime()
     */
    @Override
    public final long getStartTime() {
        return this.startTime;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.timers.ITimer#getElapsedTime()
     */
    @Override
    public long getElapsedTime() {
        return this.elapsedTime;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectObjectToString(this);
    }

    public String getTimerName() {
        return this.timerName;
    }

}
