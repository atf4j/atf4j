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

import net.atf4j.core.TestResultsReporting;
import net.atf4j.core.timers.Interval;
import net.atf4j.core.timers.IntervalInterface;

/**
 * A UnitTest for Interval objects.
 */
public class IntervalTest extends TestResultsReporting {

    /**
     * Test method for Interval.
     */
    @Test
    public void testInterval() {
        final IntervalInterface interval = new Interval();
        assertNotNull(interval);
        this.log.info("interval = {}", interval);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testIntervalLong() {
        final long useTimePeriod = 1000;
        final IntervalInterface interval = new Interval(useTimePeriod);
        assertNotNull(UNEXPECTED_NULL, interval);
        this.log.info("interval = {}", interval);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInMilliSeconds() {
        final long timePeriod = 1000;
        final IntervalInterface inMilliSeconds = Interval.inMilliSeconds(timePeriod);
        assertNotNull(UNEXPECTED_NULL, inMilliSeconds);
        this.log.info("inMilliSeconds = {}", inMilliSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInSeconds() {
        final long timePeriod = 1;
        final IntervalInterface inSeconds = Interval.inSeconds(timePeriod);
        assertNotNull(UNEXPECTED_NULL, inSeconds);
        this.log.info("inSeconds = {}", inSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInMinutes() {
        final long timePeriod = 1;
        final IntervalInterface inMinutes = Interval.inMinutes(timePeriod);
        assertNotNull(UNEXPECTED_NULL, inMinutes);
        this.log.info("inMinutes = {}", inMinutes);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInHours() {
        final long timePeriod = 1;
        final IntervalInterface inHours = Interval.inHours(timePeriod);
        assertNotNull(UNEXPECTED_NULL, inHours);
        this.log.info("inHours = {}", inHours);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInDays() {
        final long timePeriod = 1;
        final IntervalInterface inDays = Interval.inDays(timePeriod);
        assertNotNull(UNEXPECTED_NULL, inDays);
        this.log.info("inDays = {}", inDays);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsLong() {
        final IntervalInterface interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asLong = interval.asLong();
        assertEquals(0, asLong);
        this.log.info("asLong = {}", asLong);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsMilliSeconds() {
        final IntervalInterface interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asMilliSeconds = interval.asMilliSeconds();
        assertEquals(0, asMilliSeconds);
        this.log.info("asMilliSeconds = {}", asMilliSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsSeconds() {
        final IntervalInterface interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asSeconds = interval.asSeconds();
        assertEquals(0, asSeconds);
        this.log.info("asSeconds = {}", asSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsMinutes() {
        final IntervalInterface interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asMinutes = interval.asMinutes();
        assertEquals(0, asMinutes);
        this.log.info("asMinutes = {}", asMinutes);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsHours() {
        final IntervalInterface interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asHours = interval.asHours();
        assertEquals(0, asHours);
        this.log.info("asHours = {}", asHours);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsDays() {
        final IntervalInterface interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        final long asDays = interval.asDays();
        assertEquals(0, asDays);
        this.log.info("asDays = {}", asDays);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testIntervalToString() {
        final IntervalInterface interval = new Interval();
        assertNotNull(UNEXPECTED_NULL, interval);
        this.log.info("interval = {}", interval);
    }

}
