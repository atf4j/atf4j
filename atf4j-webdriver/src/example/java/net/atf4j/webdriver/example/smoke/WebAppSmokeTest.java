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
package net.atf4j.webdriver.example.smoke;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import net.atf4j.core.annotations.TargetUrl;
import net.atf4j.webdriver.page.WebPage;

/**
 * WebAppSmokeTest.
 */
public class WebAppSmokeTest {

	@Test
	public void testTargetUrlAnnotation() {
		final WebPageWithTargetUrl mockPage = new WebPageWithTargetUrl();
		mockPage.open();
		mockPage.verify();
	}

	@Test
	public void testOpenOveride() {
		final WebPageWithTargetUrl mockPage = new WebPageWithTargetUrl();
		mockPage.open();
		mockPage.verify();
	}

	/**
	 * UseTargetUrl.
	 */
	@TargetUrl("http:127.0.0.0.1:8080")
	public class WebPageWithTargetUrl extends WebPage {
		/**
		 * Instantiates a new use target url.
		 */
		public WebPageWithTargetUrl() {
			this(new HtmlUnitDriver());
		}

		/**
		 * Instantiates a new use target url.
		 *
		 * @param webDriver
		 *            the web driver
		 */
		public WebPageWithTargetUrl(final WebDriver webDriver) {
			super(webDriver);
		}

		@Override
		public WebPage open() {
			final String targetUrl = this.config.getTargetUrl();
			return open(targetUrl);
		}

	}

	/**
	 * MockPage.
	 */
	public class MockPage extends WebPage {

		/** The Constant url. */
		public static final String url = "http:127.0.0.0.1:8080";

		/**
		 * Instantiates a new mock page.
		 */
		public MockPage() {
			this(new HtmlUnitDriver());
		}

		/**
		 * Instantiates a new mock page.
		 *
		 * @param webDriver
		 *            the web driver
		 */
		public MockPage(final WebDriver webDriver) {
			super(webDriver);
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see net.atf4j.webdriver.page.WebPage#open()
		 */
		@Override
		public WebPage open() {
			return super.open(MockPage.url);
		}
	}
}
