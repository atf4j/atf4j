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
package net.atf4j.core.webdriver.example.frontend.testsuite;

import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.atf4j.core.AbstractConfig.MissingPropertyFileException;
import net.atf4j.core.webdriver.example.backoffice.testsuite.WebDriverTestSuite;
<<<<<<< HEAD
import net.atf4j.core.webdriver.example.frontend.po.FrontendHomePage;
import net.atf4j.core.webdriver.example.frontend.po.FrontendPage;
=======
import net.atf4j.core.webdriver.example.frontend.pages.FrontendHomePage;
import net.atf4j.core.webdriver.example.frontend.pages.FrontendPage;
>>>>>>> branch 'master' of https://github.com/atf4j/atf4j.git

/**
 * FrontendTestSuite.
 *
 * 
 */
public class FrontendTestSuite extends WebDriverTestSuite {

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @throws MissingPropertyFileException
	 */
	public FrontendTestSuite() throws MissingPropertyFileException {
		super("id", "name", "description");
	}

	/**
	 * Execute test.
	 */
	@Test
	public void executeTest() {
		final FrontendPage sportsBookHomePage = new FrontendHomePage(getWebDriver());
		sportsBookHomePage.open();
		sportsBookHomePage.verify();
	}

	private WebDriver getWebDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Properties execute(final Properties properties) {
		return null;
	}

	/**
	 * @see net.atf4j.core.Command#command(java.util.Properties)
	 */
	public Properties command(final Properties properties) {
		return null;
	}

	/**
	 * @see net.atf4j.core.test.TestSuite#startTestSuite()
	 */
	@Override
	public void startTestSuite() {
	}

	/**
	 * @see net.atf4j.core.test.TestSuite#endTestSuite()
	 */
	@Override
	public void endTestSuite() {
	}

}
