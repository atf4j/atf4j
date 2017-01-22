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
package net.atf4j.webdriver.page;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import net.atf4j.core.AbstractConfig.ConfigurationNotLoaded;

/**
 * PageObjectTest.
 */
@Ignore
public class PageObjectTest {

    /**
     * Mock Page.
     */
    public class MockPage extends AbstractPageObject {

        /** The Constant TARGET_URL. */
        protected static final String TARGET_URL = "http://127.0.0.1:8080";

        /**
         * Instantiates a new mock page.
         *
         * @throws ConfigurationNotLoaded
         *             the configuration not loaded
         */
        public MockPage() throws ConfigurationNotLoaded {
            super();
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

        /**
         * Instantiates a new mock page.
         *
         * @param targetUrl
         *            the target url
         * @throws ConfigurationNotLoaded
         *             the configuration not loaded
         */
        public MockPage(final String targetUrl) throws ConfigurationNotLoaded {
            super(targetUrl);
        }

    }

    /**
     * Test method for
     * { net.atf4j.webdriver.page.AbstractPageObject#AbstractPageObject()}.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public final void testDefaultConstructor() throws ConfigurationNotLoaded {
        new MockPage();
    }

    /**
     * test PageObject object.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public final void testWebDriverConstructor() throws ConfigurationNotLoaded {
        new MockPage(new HtmlUnitDriver());
    }

    /**
     * test PageObject object.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public final void testTargetUrlConstruction() throws ConfigurationNotLoaded {
        new MockPage("http://localhost:8080/");
    }

    /**
     * Test method for
     * { net.net.atf4j.webdriver.page.AbstractPageObject#open()}.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public final void testDefaultOpen() throws ConfigurationNotLoaded {
        new MockPage().open();
    }

    /**
     * Test method for
     * { net.net.atf4j.webdriver.page.AbstractPageObject#open()}.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public final void testOpen() throws ConfigurationNotLoaded {
        new MockPage(MockPage.TARGET_URL).open();
    }

    /**
     * Test method for
     * {
     * net.net.atf4j.webdriver.page.AbstractPageObject#open(java.lang.String)}.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public final void testOpenString() throws ConfigurationNotLoaded {
        new MockPage().open(MockPage.TARGET_URL);
    }

    /**
     * Test method for
     * { net.net.atf4j.webdriver.page.AbstractPageObject#verify()}.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public final void testVerify() throws ConfigurationNotLoaded {
        new MockPage().open().verify();
    }

}
