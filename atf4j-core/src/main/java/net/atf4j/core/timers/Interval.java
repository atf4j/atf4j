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

/**
 * Encapsulate an Interval of Time in a [GOF] Memento.
 */
public class Interval {

    /** SECOND as 1000 Milliseconds. */
    public static final int SECOND = 1000;

    /** MINUTE as 60 Seconds. */
    public static final int MINUTE = 60 * SECOND;

    /** HOUR as 60 Minutes. */
    public static final int HOUR = 60 * MINUTE;

    /** DAY as 24 Hours. */
    public static final int DAY = 24 * HOUR;

    /** The time period. */
    private final long timePeriod;

    /**
     * Instantiates a new interval.
     */
    public Interval() {
        this.timePeriod = 0L;
    }

    /**
     * Interval.
     *
     * @param useTimePeriod
     *            the use time period
     */
    public Interval(final long useTimePeriod) {
        this.timePeriod = useTimePeriod;
    }

    /**
     * factory method helper inMilliSeconds.
     *
     * @param timePeriod
     *            the use time period
     * @return new Interval object.
     */
    public static Interval inMilliSeconds(final long timePeriod) {
        return new Interval(timePeriod);
    }

    /**
     * inSeconds.
     *
     * @param timePeriod
     *            in Seconds.
     * @return new Interval object.
     */
    public static Interval inSeconds(final long timePeriod) {
        return new Interval(timePeriod * Interval.SECOND);
    }

    /**
     * inMinutes.
     *
     * @param timePeriod
     *            in Minutes.
     * @return new Interval object.
     */
    public static Interval inMinutes(final long timePeriod) {
        return new Interval(timePeriod * Interval.MINUTE);
    }

    /**
     * inHours.
     *
     * @param timePeriod
     *            in Hours.
     * @return new Interval object.
     */
    public static Interval inHours(final long timePeriod) {
        return new Interval(timePeriod * Interval.HOUR);
    }

    /**
     * inDays.
     *
     * @param timePeriod
     *            in Days.
     * @return new Interval object.
     */
    public static Interval inDays(final long timePeriod) {
        return new Interval(timePeriod * Interval.DAY);
    }

    /**
     * asMilliSeconds.
     *
     * @return timePeriod of Interval in Milliseconds as long.
     */
    public final long asMilliSeconds() {
        return this.timePeriod;
    }

    /**
     * asSeconds.
     *
     * @return timePeriod of Interval in seconds as long.
     */
    public final long asSeconds() {
        return this.timePeriod / SECOND;
    }

    /**
     * asMinutes.
     *
     * @return timePeriod of Interval in seconds as long.
     */
    public final long asMinutes() {
        return this.timePeriod / MINUTE;
    }

    /**
     * asHours.
     *
     * @return timePeriod of Interval in seconds as long.
     */
    public final long asHours() {
        return this.timePeriod / HOUR;
    }

    /**
     * asDays.
     *
     * @return timePeriod of Interval in seconds as long.
     */
    public final long asDays() {
        return this.timePeriod / DAY;
    }

    /**
     * asLong.
     *
     * @return timePeriod of Interval in Milliseconds as long.
     */
    public final long asLong() {
        return this.timePeriod;
    }

    @Override
    public String toString() {
        return String.format("Interval [timePeriod=%s]", this.timePeriod);
    }
}
