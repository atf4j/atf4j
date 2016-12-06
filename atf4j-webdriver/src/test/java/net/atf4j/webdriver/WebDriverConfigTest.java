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
package net.atf4j.webdriver;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import net.atf4j.core.AbstractConfig.MissingPropertyFileException;

/**
 * WebDriverConfigTest Class.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class WebDriverConfigTest {

	/**
	 * The Class MockWebDriverConfig.
	 */
	public class TestWebDriverConfig extends WebDriverConfig {

		/**
		 * Instantiates a new mock web driver config.
		 *
		 * @throws MissingPropertyFileException
		 *             the missing property file exception
		 */
		public TestWebDriverConfig() throws MissingPropertyFileException {
			super();
		}

	}

	/**
	 * Test method for
	 * {@link net.atf4j.webdriver.WebDriverConfig#WebDriverConfig()}.
	 *
	 * @throws MissingPropertyFileException
	 *             the missing property file exception
	 */
	@Test
	public final void testDefaultConstructor() throws MissingPropertyFileException {
		final TestWebDriverConfig config = new TestWebDriverConfig();
		assertNotNull(config);
	}

	/**
	 * Test method for
	 * {@link net.atf4j.webdriver.WebDriverConfig#WebDriverConfig()}.
	 *
	 * @throws MissingPropertyFileException
	 *             the missing property file exception
	 */
	@Test
	public final void testSystemOveridesConfig() throws MissingPropertyFileException {
		final TestWebDriverConfig config = new TestWebDriverConfig();
		assertNotNull(config);
		final String key = "targetUrl";
		final String value = "SystemOveridesConfig";
		System.setProperty(key, value);
		Assert.assertEquals(value, config.getTargetUrl());
	}

	@Test
	public final void testHappyPath() throws MissingPropertyFileException {
		final TestWebDriverConfig config = new TestWebDriverConfig();
		assertNotNull(config);
		config.getPageLoadTimeout();
		config.getPageLoadTimeoutUnit();
		config.getImplicitlyWait();
		config.getImplicitlyWaitUnit();
		// assertNotNull(config.get);
	}
}
