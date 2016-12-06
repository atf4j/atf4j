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
package net.atf4j.webdriver.page;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * PageObjectTest
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class PageObjectTest {
	public static final String url = null;

	public class MockPage extends WebPage {
		public MockPage() {
			super();
		}

		public MockPage(final String url) {
			super(url);
		}

		public MockPage(final WebDriver webDriver) {
			super(webDriver);
		}
	}

	/**
	 * Test method for
	 * {@link net.atf4j.webdriver.page.WebPage#AbstractPageObject()}.
	 */
	@Test
	public final void testDefaultConstruction() {
		new MockPage();
	}

	/**
	 * Test method for {@link net.atf4j.webdriver.page.WebPage#open()}.
	 */
	@Test
	public final void testDefaultOpen() {
		new MockPage().open();
	}

	/**
	 * Test method for {@link net.atf4j.webdriver.page.WebPage#open()}.
	 */
	@Test
	public final void testOpen() {
		new MockPage("http://127.0.0.1:8080").open();
	}

	/**
	 * Test method for
	 * {@link net.atf4j.webdriver.page.WebPage#open(java.lang.String)}.
	 */
	@Test
	public final void testOpenString() {
		new MockPage().open("http://127.0.0.1:8080");
	}

	/**
	 * Test method for {@link net.atf4j.webdriver.page.WebPage#verify()}.
	 */
	@Test
	public final void testVerify() {
		new MockPage().open().verify();
	}

	/**
	 * Test method for {@link net.atf4j.webdriver.page.WebPage#getWebDriver()}.
	 */
	@Test
	public final void testGetWebDriver() {
		Assert.assertNotNull(new MockPage().webDriver);
	}

	/**
	 * Test method for
	 * {@link net.atf4j.webdriver.page.WebPage#setWebDriver(org.openqa.selenium.WebDriver)}.
	 */
	@Test
	public final void testSetWebDriver() {
		new MockPage().setWebDriver(new ChromeDriver());
	}

}
