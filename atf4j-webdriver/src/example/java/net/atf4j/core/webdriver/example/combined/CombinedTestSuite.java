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
package net.atf4j.core.webdriver.example.combined;

import java.util.Properties;

import org.junit.Test;

import net.atf4j.core.AbstractConfig.MissingPropertyFileException;
import net.atf4j.core.webdriver.example.backoffice.testsuite.WebDriverTestSuite;

/**
 * CombinedTestSuite.
 *
 * 
 */
public class CombinedTestSuite extends WebDriverTestSuite {

	protected Properties properties;

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @throws MissingPropertyFileException
	 */
	public CombinedTestSuite() throws MissingPropertyFileException {
		super("id", "name", "description");
	}

	@Override
	public Properties execute(final Properties properties) {
		startTestSuite();
		executeTestCases(properties);
		endTestSuite();
		return properties;
	}

	/**
	 * Execute test cases.
	 *
	 * @param properties
	 *            the properties
	 * @return
	 */
	public CombinedTestSuite executeTestCases(final Properties properties) {
		return this;
	}

	/**
	 * Execute test.
	 *
	 * @return
	 */
	@Test
	public CombinedTestSuite executeTestCases() {
		// final BackOfficePage backOfficeHomePage = new BackOfficeHomePage(new
		// InternetExplorerDriver());
		// backOfficeHomePage.open();
		// backOfficeHomePage.verify();

		// final SportBookPage sportsBookHomePage = new SportsBookHomePage(new
		// FirefoxDriver());
		// sportsBookHomePage.open();
		// sportsBookHomePage.verify();
		return this;
	}

}
