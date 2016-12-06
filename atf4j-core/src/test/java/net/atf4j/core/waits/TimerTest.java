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

import org.junit.Assert;
import org.junit.Test;

import net.atf4j.core.LoggedTest;
import net.atf4j.core.annotations.TestName;
import net.atf4j.core.timers.ITimer;
import net.atf4j.core.timers.MilliTimer;

/**
 * TimerTest.
 */
public class TimerTest extends LoggedTest {

	/** The Constant DEFAULT_INTERVAL. */
	private static final int DEFAULT_INTERVAL = 100;

	/** The delta. */
	private long delta = 1000;

	/**
	 * Instrument the actual timer its self. Calculates the delta for tests.
	 * Test method for
	 * {@link net.atf4j.core.timers.MilliTimer#Timer(java.lang.String)}.
	 */
	@Test
	@TestName("Zero timer: Establish delta")
	public final void testTimer0() {
		final ITimer timer = new MilliTimer(this.getClass().getSimpleName());
		timer.start();
		// NOP elapsed time should be close to zero
		timer.stop();
		log.info("testTimer0.Start Time=" + timer.getStartTime());
		log.info("testTimer0.Elapsed Time=" + timer.getElapsedTime());
		log.info("testTimer0." + timer.toString() + " Elapsed time not within delta (" + delta + ")");
		org.junit.Assume.assumeTrue(timer.getElapsedTime() <= delta);
		delta = timer.getElapsedTime();
	}

	/**
	 * Test method for
	 * {@link net.atf4j.core.timers.MilliTimer#Timer(java.lang.String)}.
	 */
	@Test
	@TestName("Test one second timer.")
	public final void testTimerOneSec() {
		final ITimer timer = new MilliTimer(this.getClass().getSimpleName());
		timer.start();
		waitDefaultInterval();
		timer.stop();
		log.info("testTimerOneSec.Start Time=" + timer.getStartTime());
		log.info("testTimerOneSec.Elapsed Time=" + timer.getElapsedTime());
		Assert.assertTrue(timer.toString() + " Elapsed time not within delta (" + delta + ")",
				timer.getElapsedTime() <= (DEFAULT_INTERVAL + delta));
	}

	/**
	 * Wait default interval.
	 */
	private void waitDefaultInterval() {
		try {
			Thread.sleep(TimerTest.DEFAULT_INTERVAL);
		} catch (final InterruptedException interruptedException) {
			interruptedException.printStackTrace(System.err);
		}
	}

}
