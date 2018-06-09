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

package net.atf4j.webdriver;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.atf4j.core.TestContext;
import net.atf4j.core.TestResultsReporting;

/**
 * Smoke Tests for WebDriver.
 */
public final class WebDriverSmokeTest extends TestResultsReporting {

	/**
	 * ChromeDriver Smoke test.
	 */
	@Test
	public void testChromeTomcat() {
		TestContext.assumeLocal();
		final WebDriver webDriver = new ChromeDriver();
		verifyNotNull(webDriver);
		verifyTomcatPresent(webDriver);
	}

	/**
	 * FirefoxDriver Smoke test.
	 */
	@Test
	public void testFirefoxTomcat() {
		TestContext.assumeLocal();
		final WebDriver webDriver = new FirefoxDriver();
		verifyNotNull(webDriver);
		verifyTomcatPresent(webDriver);
	}

	private void verifyTomcatPresent(final WebDriver webDriver) {
		TestContext.assumeLocalServer();
		webDriver.get("http://127.0.0.1:8080/");
		final String pageTitle = webDriver.getTitle();
		verifyNotNull(pageTitle);
		assertTrue(pageTitle.contains("Apache Tomcat"));
		this.log.info("pageTitle = {}", pageTitle);
	}

}
