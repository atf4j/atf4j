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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;
import net.atf4j.core.timers.Interval;

/**
 * A UnitTest for Interval objects.
 */
public class IntervalTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test method for Interval.
     */
    @Test
    public void testInterval() {
        final Interval interval = new Interval();
        assertNotNull(interval);
        this.log.info("{}", interval);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testIntervalLong() {
        final long useTimePeriod = 1000;
        final Interval interval = new Interval(useTimePeriod);
        assertNotNull(UNEXPECTED_NULL, interval);
        this.log.info("{}", interval);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInMilliSeconds() {
        final long timePeriod = 1000;
        final Interval inMilliSeconds = Interval.inMilliSeconds(timePeriod);
        assertNotNull(UNEXPECTED_NULL, inMilliSeconds);
        this.log.info("{}", inMilliSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInSeconds() {
        final long timePeriod = 1;
        final Interval inSeconds = Interval.inSeconds(timePeriod);
        assertNotNull(UNEXPECTED_NULL, inSeconds);
        this.log.info("{}", inSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInMinutes() {
        final long timePeriod = 1;
        final Interval inMinutes = Interval.inMinutes(timePeriod);
        assertNotNull(UNEXPECTED_NULL, inMinutes);
        this.log.info("{}", inMinutes);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInHours() {
        final long timePeriod = 1;
        final Interval inHours = Interval.inHours(timePeriod);
        assertNotNull(UNEXPECTED_NULL, inHours);
        this.log.info("{}", inHours);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInDays() {
        final long timePeriod = 1;
        final Interval inDays = Interval.inDays(timePeriod);
        assertNotNull(UNEXPECTED_NULL, inDays);
        this.log.info("{}", inDays);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsLong() {
        final Interval interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asLong = interval.asLong();
        assertEquals(0, asLong);
        this.log.info("{}", asLong);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsMilliSeconds() {
        final Interval interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asMilliSeconds = interval.asMilliSeconds();
        assertEquals(0, asMilliSeconds);
        this.log.info("{}", asMilliSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsSeconds() {
        final Interval interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asSeconds = interval.asSeconds();
        assertEquals(0, asSeconds);
        this.log.info("{}", asSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsMinutes() {
        final Interval interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asMinutes = interval.asMinutes();
        assertEquals(0, asMinutes);
        this.log.info("{}", asMinutes);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsHours() {
        final Interval interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asHours = interval.asHours();
        assertEquals(0, asHours);
        this.log.info("{}", asHours);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsDays() {
        final Interval interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asDays = interval.asDays();
        assertEquals(0, asDays);
        this.log.info("{}", asDays);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testIntervalToString() {
        final Interval interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        this.log.info("{}", interval);
    }

}
