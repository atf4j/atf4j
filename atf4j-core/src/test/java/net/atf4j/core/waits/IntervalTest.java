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
     * Test method for {@link Interval}.
     */
    @Test
    public void testInterval() {
        this.log.info(new Interval().toString());
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testIntervalLong() {
        final long useTimePeriod = 1000;
        new Interval(useTimePeriod);
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testInMilliSeconds() {
        final long timePeriod = 1000;
        final Interval inMilliSeconds = Interval.inMilliSeconds(timePeriod);
        assertNotNull(inMilliSeconds);
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testInSeconds() {
        final long timePeriod = 1;
        final Interval inSeconds = Interval.inSeconds(timePeriod);
        assertNotNull(inSeconds);
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testInMinutes() {
        final long timePeriod = 1;
        final Interval inMinutes = Interval.inMinutes(timePeriod);
        assertNotNull(inMinutes);
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testInHours() {
        final long timePeriod = 1;
        final Interval inHours = Interval.inHours(timePeriod);
        assertNotNull(inHours);
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testInDays() {
        final long timePeriod = 1;
        final Interval inDays = Interval.inDays(timePeriod);
        assertNotNull(inDays);
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testAsLong() {
        assertEquals(0, new Interval().asLong());
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testAsMilliSeconds() {
        assertEquals(0, new Interval().asMilliSeconds());
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testAsSeconds() {
        assertEquals(0, new Interval().asSeconds());
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testAsMinutes() {
        assertEquals(0, new Interval().asMinutes());
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testAsHours() {
        assertEquals(0, new Interval().asHours());
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testAsDays() {
        assertEquals(0, new Interval().asDays());
    }

    /**
     * Test method for {@link Interval}.
     */
    @Test
    public void testIntervalToString() {
        this.log.info(new Interval().toString());
    }

}
