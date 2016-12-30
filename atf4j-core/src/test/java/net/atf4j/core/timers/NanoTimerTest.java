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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

public class NanoTimerTest extends ResultsReporting {

    @Test
    public void testNanoTimer() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer);
    }

    @Test
    public void testNanoTimerString() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer);
        fail("Not yet implemented");
    }

    @Test
    public void testStart() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer);
        fail("Not yet implemented");
    }

    @Test
    public void testStop() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer);
        fail("Not yet implemented");
    }

    @Test
    public void testGetStartTime() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer);
        fail("Not yet implemented");
    }

    @Test
    public void testGetElapsedTime() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer);
        fail("Not yet implemented");
    }

    @Test
    public void testToString() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer);
        fail("Not yet implemented");
    }

    @Test
    public void testGetTimerName() {
        final NanoTimer nanoTimer = new NanoTimer();
        assertNotNull(nanoTimer);
        fail("Not yet implemented");
    }

}
