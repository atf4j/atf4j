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

    /**
     * Test method for Interval.
     */
    @Test
    public void testInterval() {
        this.log.info(new Interval().toString());
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testIntervalLong() {
        final long useTimePeriod = 1000;
        Interval interval = new Interval(useTimePeriod);
        assertNotNull("unexpected null",interval);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInMilliSeconds() {
        final long timePeriod = 1000;
        final Interval inMilliSeconds = Interval.inMilliSeconds(timePeriod);
        assertNotNull("unexpected null",inMilliSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInSeconds() {
        final long timePeriod = 1;
        final Interval inSeconds = Interval.inSeconds(timePeriod);
        assertNotNull("unexpected null",inSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInMinutes() {
        final long timePeriod = 1;
        final Interval inMinutes = Interval.inMinutes(timePeriod);
        assertNotNull("unexpected null",inMinutes);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInHours() {
        final long timePeriod = 1;
        final Interval inHours = Interval.inHours(timePeriod);
        assertNotNull("unexpected null",inHours);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testInDays() {
        final long timePeriod = 1;
        final Interval inDays = Interval.inDays(timePeriod);
        assertNotNull("unexpected null",inDays);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsLong() {
        Interval interval = new Interval();
        assertNotNull("unexpected null",interval);
        long asLong = interval.asLong();
        assertEquals(0, asLong);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsMilliSeconds() {
        Interval interval = new Interval();
        assertNotNull("unexpected null",interval);
        long asMilliSeconds = interval.asMilliSeconds();
        assertEquals(0, asMilliSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsSeconds() {
        Interval interval = new Interval();
        assertNotNull("unexpected null",interval);
        long asSeconds = interval.asSeconds();
        assertEquals(0, asSeconds);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsMinutes() {
        Interval interval = new Interval();
        assertNotNull("unexpected null",interval);
        long asMinutes = interval.asMinutes();
        assertEquals(0, asMinutes);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsHours() {
        Interval interval = new Interval();
        assertNotNull("unexpected null",interval);
        long asHours = interval.asHours();
        assertEquals(0, asHours);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testAsDays() {
        Interval interval = new Interval();
        assertNotNull("unexpected null",interval);
        long asDays = interval.asDays();
        assertEquals(0, asDays);
    }

    /**
     * Test method for Interval.
     */
    @Test
    public void testIntervalToString() {
        Interval interval = new Interval();
        assertNotNull("unexpected null",interval);
        String string = interval.toString();
        this.log.info(string);
    }

}
