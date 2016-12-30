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

public class MappedTimersTest extends ResultsReporting {

    @Test
    public void testGetInstance() {
        final MappedTimers instance = MappedTimers.getInstance();
        assertNotNull(instance);
    }

    @Test
    public void testStart() {
        MappedTimers.start("testStart");
        fail("Not yet implemented");
    }

    @Test
    public void testStop() {
        MappedTimers.stop("testStop");
        fail("Not yet implemented");
    }

    @Test
    public void testStartTimer() {
        final MappedTimers instance = MappedTimers.getInstance();
        assertNotNull(instance);
        final String timerName = "testStartTimer";
        instance.startTimer(timerName);
        fail("Not yet implemented");
    }

    @Test
    public void testStopTimer() {
        final MappedTimers instance = MappedTimers.getInstance();
        assertNotNull(instance);
        final String timerName = "testStopTimer";
        instance.startTimer(timerName);
        fail("Not yet implemented");
    }

    @Test
    public void testStopAll() {
        final MappedTimers instance = MappedTimers.getInstance();
        assertNotNull(instance);
        fail("Not yet implemented");
    }

    @Test
    public void testStopAllTimers() {
        final MappedTimers instance = MappedTimers.getInstance();
        assertNotNull(instance);
        fail("Not yet implemented");
    }

    @Test
    public void testToString() {
        final MappedTimers instance = MappedTimers.getInstance();
        assertNotNull(instance);
        fail("Not yet implemented");
    }

}
