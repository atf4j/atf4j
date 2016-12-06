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
package net.atf4j.core.webdriver.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * AbstractPageObject.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public abstract class WebPage {

	private WebDriver webDriver;
	private String url;

	public WebPage() {
		final String str = System.getProperty("atf4j.target.browser", "phantomjs");
		this.url = System.getProperty("atf4j.target.url", "http://127.0.0.1:8080");
		this.webDriver = WebDriverFactory.newWebDriver();
	}

	/**
	 * @param url
	 */
	public WebPage(final String url) {
		this();
		open(url);
	}

	/**
	 * Instantiates a new abstract page object.
	 *
	 * @param webDriver
	 *            the web driver
	 */
	public WebPage(final WebDriver webDriver) {
		setWebDriver(webDriver);
	}

	public WebPage open() {
		getWebDriver().get(this.url);
		return this;
	}

	/**
	 * Open.
	 *
	 * @param pageUrl
	 * @return the open as PageInterface
	 * @see net.atf4j.core.webdriver.page.PageInterface#open()
	 */
	public WebPage open(final String pageUrl) {
		getWebDriver().get(pageUrl);
		PageFactory.initElements(getWebDriver(), this);
		return this;
	}

	/**
	 * Verify that page is valid.
	 *
	 * @return false to ensure this method is implemented.
	 * @see net.atf4j.core.webdriver.page.PageInterface#verify()
	 */
	public boolean verify() {
		return false;
	}

	/**
	 * Gets the web driver.
	 *
	 * @return the getWebDriver as WebDriver
	 */
	protected WebDriver getWebDriver() {
		return this.webDriver;
	}

	/**
	 * Sets the web driver.
	 *
	 * @param webDriver
	 *            the new web driver
	 */
	protected void setWebDriver(final WebDriver webDriver) {
		this.webDriver = webDriver;
	}

}
