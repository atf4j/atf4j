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
package net.atf4j.webdriver;

import static org.junit.Assume.assumeNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for BrowserFactory objects.
 */
public class BrowserFactoryTest extends ResultsReporting {

    /**
     * test BrowserFactory returns Chrome.
     */
    @Test
    @Ignore
    public void testChromeDriver() {
        System.setProperty("targetBrowser", "chromeDriver");
        final WebDriver webDriver = AbstractBrowserFactory.webDriver();
        assumeNotNull("Chrome webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * test BrowserFactory returns Firefox.
     */
    @Test
    @Ignore
    public void testFirefoxDriver() {
        System.setProperty("targetBrowser", "firefoxDriver");
        final WebDriver webDriver = AbstractBrowserFactory.webDriver();
        assumeNotNull("Firefox webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * Unit Test for test remote driver.
     */
    @Test
    @Ignore
    public void testRemoteDriver() {
        System.setProperty("targetBrowser", "remoteDriver");
        final WebDriver webDriver = AbstractBrowserFactory.webDriver();
        assumeNotNull("remote webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * test BrowserFactory default browser.
     */
    @Test
    public void testWebDriver() {
        BrowserFactory.create();
        final WebDriver webDriver = AbstractBrowserFactory.webDriver();
        assumeNotNull("default webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * Verify that verify page loaded.
     * 
     * @param webDriver
     *            the web driver
     */
    private void verifyPageLoaded(final WebDriver webDriver) {
        webDriver.get("http://127.0.0.1:8080");
        final String currentUrl = webDriver.getCurrentUrl();
        this.log.info(currentUrl);
        final String pageTitle = webDriver.getTitle();
        this.log.info(pageTitle);
    }

}
