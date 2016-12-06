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
package net.atf4j.core.webdriver.example.backoffice.testsuite;

import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.atf4j.core.AbstractConfig.MissingPropertyFileException;
<<<<<<< HEAD
import net.atf4j.core.webdriver.example.backoffice.page_object_model.BackOfficeHomePage;
import net.atf4j.core.webdriver.example.backoffice.page_object_model.BackOfficePage;

/**
 * BackOfficeTestSuite.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public final class BackOfficeTestSuite extends WebDriverTestSuite {

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @throws MissingPropertyFileException
	 */
	public BackOfficeTestSuite() throws MissingPropertyFileException {
		super("id", "name", "description");
	}

	/**
	 * Execute test.
	 */
	@Test
	public void executeTest() {
		final BackOfficePage backOfficeHomePage = new BackOfficeHomePage(getWebDriver());
		backOfficeHomePage.open();
		backOfficeHomePage.verify();
	}

	private WebDriver getWebDriver() {
		// TODO Auto-generated method stub
		return null;
=======
import net.atf4j.core.webdriver.example.backoffice.pages.BackOfficeHomePage;
import net.atf4j.core.webdriver.example.backoffice.pages.BackOfficePage;

/**
 * BackOfficeTestSuite.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public final class BackOfficeTestSuite extends WebDriverTestSuite {

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @throws MissingPropertyFileException
	 */
	public BackOfficeTestSuite() throws MissingPropertyFileException {
		super("id", "name", "description");
	}

	/**
	 * Execute test.
	 */
	@Test
	public void executeTest() {
		final BackOfficePage backOfficeHomePage = new BackOfficeHomePage();
		backOfficeHomePage.open();
		backOfficeHomePage.verify();
>>>>>>> branch 'master' of https://github.com/atf4j/atf4j.git
	}

	@Override
	public Properties execute(final Properties properties) {
		startTestSuite();
		endTestSuite();
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
