/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with atf4j. If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.timers.NestedTimers;

public class Atf4j {

	protected static final Logger log = LoggerFactory.getLogger(Atf4j.class);
	protected static final NestedTimers multiTimers = NestedTimers.getInstance();

	public static void startTest() {
		log.info(document(Thread.currentThread().getStackTrace()));
	}

	public static void startTest(final String description) {
		log.info(description);
		log.info(multiTimers.startTimer(description).toString());
	}

	public static void endTest() {
		log.info(multiTimers.stopTimer().toString());
		log.info("endTest");
	}

	public static void startStep() {
		log.info("startStep");
	}

	public static void startStep(final String description) {
		log.info(description);
	}

	public static void endStep() {
		log.info("endStep");
	}

	private static String document(final StackTraceElement[] stackTrace) {
		for (final StackTraceElement stackTraceElement : stackTrace) {
			log.info(stackTraceElement.toString());
			final String methodName = stackTraceElement.getMethodName();
		}
		return null;
	}
}
