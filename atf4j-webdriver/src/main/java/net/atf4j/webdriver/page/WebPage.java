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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.AbstractConfig.MissingPropertyFileException;
import net.atf4j.webdriver.WebDriverConfig;

/**
 * AbstractPageObject.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public abstract class WebPage {
	protected static final Logger log = LoggerFactory.getLogger(WebPage.class);
	protected WebDriverConfig config;
	protected WebDriver webDriver;
	protected int timeout = 15;
	protected String pageUrl = "http://127.0.0.1:8080";

	public WebPage() {
		try {
			this.config = new WebDriverConfig();
		} catch (final MissingPropertyFileException e) {
			WebPage.log.error(e.toString());
		}
		this.webDriver = new HtmlUnitDriver();
	}

	/**
	 * @param url
	 */
	public WebPage(final String url) {
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
		final String targetUrl = this.config.getTargetUrl();
		return open(targetUrl);
	}

	/**
	 * Open.
	 *
	 * @param pageUrl
	 *
	 * @return the open as PageInterface
	 * @see net.atf4j.webdriver.page.PageInterface#open()
	 */
	public WebPage open(final String pageUrl) {
		this.webDriver.get(pageUrl);
		PageFactory.initElements(this.webDriver, this);
		return this;
	}

	/**
	 * Verify that page is valid.
	 *
	 * @return false to ensure this method is implemented.
	 * @see net.atf4j.webdriver.page.PageInterface#verify()
	 */
	public boolean verify() {
		this.webDriver.getTitle();
		return true;
	}

	/**
	 * Sets the web driver.
	 *
	 * @param webDriver
	 *            the new web driver
	 * @return
	 */
	protected WebPage setWebDriver(final WebDriver webDriver) {
		this.webDriver = webDriver;
		return this;
	}

	public WebPage close() {
		this.webDriver.close();
		return this;
	}

}
