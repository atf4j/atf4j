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
package net.atf4j.core.webdriver.example.frontend.pages;

import org.openqa.selenium.WebDriver;

import net.atf4j.webdriver.page.WebPage;

/**
 * FrontendPage
 *
 * 
 *
 */
public class FrontendPage extends WebPage {

	public FrontendPage() {
		super();
	}

	public FrontendPage(String url) {
		super(url);
	}

	/**
	 * @param webDriver
	 */
	public FrontendPage(final WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * Open.
	 *
	 * @return the open as PageInterface
	 * @see net.atf4j.webdriver.page.PageInterface#open()
	 */
	@Override
	public FrontendPage open() {
		// get from config in real system.
		open("http://front.example.net");
		return this;
	}

	/**
	 * Verify that.
	 *
	 * @return true, if successful otherwise false.
	 * @see net.atf4j.webdriver.page.PageInterface#verify()
	 */
	@Override
	public boolean verify() {
		return true;
	}

}