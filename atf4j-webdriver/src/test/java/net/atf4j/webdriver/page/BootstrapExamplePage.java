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

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BootstrapExamplePage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(css = "a[href='#about']")
	@CacheLookup
	private WebElement about;

	@FindBy(css = "a[href='#contact']")
	@CacheLookup
	private WebElement contact;

	@FindBy(css = "#navbar ul.nav.navbar-nav li:nth-of-type(1) a")
	@CacheLookup
	private WebElement home;

	private final String pageLoadedText = "Use this document as a way to quickly start any new project";

	private final String pageUrl = "/bootstrap/docs/examples/starter-template/";

	@FindBy(css = "a.navbar-brand")
	@CacheLookup
	private WebElement projectName;

	@FindBy(css = "button.navbar-toggle.collapsed")
	@CacheLookup
	private WebElement toggleNavigation;

	private BootstrapExamplePage() {
	}

	public BootstrapExamplePage(final WebDriver driver) {
		this();
		this.driver = driver;
	}

	public BootstrapExamplePage(final WebDriver driver, final Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public BootstrapExamplePage(final WebDriver driver, final Map<String, String> data, final int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on About Link.
	 *
	 * @return the BootStrapPage class instance.
	 */
	public BootstrapExamplePage clickAboutLink() {
		this.about.click();
		return this;
	}

	/**
	 * Click on Contact Link.
	 *
	 * @return the BootStrapPage class instance.
	 */
	public BootstrapExamplePage clickContactLink() {
		this.contact.click();
		return this;
	}

	/**
	 * Click on Home Link.
	 *
	 * @return the BootStrapPage class instance.
	 */
	public BootstrapExamplePage clickHomeLink() {
		this.home.click();
		return this;
	}

	/**
	 * Click on Project Name Link.
	 *
	 * @return the BootStrapPage class instance.
	 */
	public BootstrapExamplePage clickProjectNameLink() {
		this.projectName.click();
		return this;
	}

	/**
	 * Click on Toggle Navigation Button.
	 *
	 * @return the BootStrapPage class instance.
	 */
	public BootstrapExamplePage clickToggleNavigationButton() {
		this.toggleNavigation.click();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the BootStrapPage class instance.
	 */
	public BootstrapExamplePage verifyPageLoaded() {
		new WebDriverWait(this.driver, this.timeout).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(final WebDriver d) {
				return d.getPageSource().contains(BootstrapExamplePage.this.pageLoadedText);
			}
		});
		return this;
	}

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the BootStrapPage class instance.
	 */
	public BootstrapExamplePage verifyPageUrl() {
		new WebDriverWait(this.driver, this.timeout).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(final WebDriver d) {
				return d.getCurrentUrl().contains(BootstrapExamplePage.this.pageUrl);
			}
		});
		return this;
	}
}
