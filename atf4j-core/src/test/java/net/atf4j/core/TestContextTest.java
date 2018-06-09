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

package net.atf4j.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * A UnitTest for TestContext objects.
 */
public class TestContextTest extends TestResultsReporting {

	/**
	 * Unit Test Context.isLocal().
	 */
	@Test
	public void testIsLocal() {
		assertFalse(TestContext.isLocal());
		System.setProperty("isLocal", "true");
		assertTrue(TestContext.isLocal());
	}

	/**
	 * Test method for TestContext. Unit Test Context.isLocal().
	 */
	@Test
	public void testIsSeleniumGrid() {
		assertFalse(TestContext.isSeleniumGrid());
		System.setProperty("isSeleniumGrid", "true");
		assertTrue(TestContext.isSeleniumGrid());
	}

	/**
	 * Unit Test Context.isLocal(). Test method for TestContext.
	 */
	@Test
	public void testIsJenkins() {
		assertFalse(TestContext.isJenkins());
		System.setProperty("isJenkins", "true");
		assertTrue(TestContext.isJenkins());
	}

	@Test
	public void testIsActiveMQ() {
		assertFalse(TestContext.isActiveMQ());
		System.setProperty("isActiveMQ", "true");
		assertTrue(TestContext.isActiveMQ());
	}

}
