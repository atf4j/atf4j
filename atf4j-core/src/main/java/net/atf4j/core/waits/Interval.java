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
package net.atf4j.core.waits;

/**
 * Encapsulate an Interval of Time in a [GOF] Memento.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class Interval {

    /** The Constant SECOND. */
    public static final int SECOND = 1000;

    /** The Constant MINUTE. */
    public static final int MINUTE = 60 * SECOND;

    /** The Constant HOUR. */
    public static final int HOUR = 60 * MINUTE;

    /** The Constant DAY. */
    public static final int DAY = 24 * HOUR;

    /** The time period. */
    private final long timePeriod;

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
     * @param useTimePeriod
     *            the use time period
     * @return new Interval object.
     */
    public static Interval inMilliSeconds(final long useTimePeriod) {
        return new Interval(useTimePeriod);
    }

    /**
     * inSeconds.
     * 
     * @param useTimePeriod
     *            in Seconds.
     * @return new Interval object.
     */
    public static Interval inSeconds(final long useTimePeriod) {
        return new Interval(useTimePeriod * Interval.SECOND);
    }

    /**
     * inMinutes.
     * 
     * @param useTimePeriod
     *            in Minutes.
     * @return new Interval object.
     */
    public static Interval inMinutes(final long useTimePeriod) {
        return new Interval(useTimePeriod * Interval.MINUTE);
    }

    /**
     * inHours.
     * 
     * @param useTimePeriod
     *            in Hours.
     * @return new Interval object.
     */
    public static Interval inHours(final long useTimePeriod) {
        return new Interval(useTimePeriod * Interval.HOUR);
    }

    /**
     * inDays.
     * 
     * @param useTimePeriod
     *            in Days.
     * @return new Interval object.
     */
    public static Interval inDays(final long useTimePeriod) {
        return new Interval(useTimePeriod * Interval.DAY);
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
     * asLong.
     * 
     * @return timePeriod of Interval in Milliseconds as long.
     */
    public final long asLong() {
        return this.timePeriod;
    }
}
