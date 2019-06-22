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

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;

import lombok.extern.slf4j.Slf4j;
import net.atf4j.core.TestContext;

/**
 * BrowserFactoryn unit tests.
 */
@Slf4j public final class BrowserFactoryTest {

    private static final String TEST_URL = "http://127.0.0.1:8080";

    /**
     * test BrowserFactory default browser.
     */
    @Test
    public void testWebDriver() {
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull("default webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * test BrowserFactory returns Chrome.
     */
    @Test
    public void testChromeDriver() {
        System.setProperty("targetBrowser", "CHROME");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull("Chrome webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * test BrowserFactory returns Firefox.
     */
    @Test
    public void testFirefoxDriver() {
        assumeNotNull("Expected webdriver.gecko.driver to be defined", System.getProperty("webdriver.gecko.driver"));
        System.setProperty("targetBrowser", "FIREFOX");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull("Firefox webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * test BrowserFactory returns Firefox.
     */
    @Test
    public void testEdgeDriver() {
        assumeNotNull("Expected webdriver.edge.driver to be defined", System.getProperty("webdriver.edge.driver"));
        System.setProperty("targetBrowser", "EDGE");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull("Edge webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * test BrowserFactory returns Firefox.
     */
    @Test
    public void testInternetExplorerDriver() {
        System.setProperty("targetBrowser", "IE");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull("IE webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * test BrowserFactory returns Safari.
     */
    @Test
    public void testSafariDriver() {
        System.setProperty("targetBrowser", "SAFARI");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull("Safari webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * test BrowserFactory returns Opera.
     */
    @Test
    public void testOperaDriver() {
        System.setProperty("targetBrowser", "OPERA");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull("Opera webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * test BrowserFactory returns PhantomJS.
     */
    @Test
    public void testPhantomJS() {
        assumeNotNull("Expected webdriver.edge.driver to be defined", System.getProperty("webdriver.edge.driver"));
        System.setProperty("targetBrowser", "PHANTOMJS");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull("PhantomJS webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * test BrowserFactory returns Opera.
     */
    @Test
    public void testHtmlUnit() {
        System.setProperty("targetBrowser", "HtmlUnit");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull("HtmlUnit webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * test BrowserFactory returns Opera.
     */
    @Test
    public void testHtmlHeadless() {
        System.setProperty("targetBrowser", "HEADLESS");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull("Headless webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * Unit Test for test remote driver.
     */
    @Test
    public void testRemoteDriver() {
        assumeTrue(TestContext.isSeleniumGrid());
        System.setProperty("targetBrowser", "REMOTE");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull("remote webDriver not available", webDriver);
        verifyPageLoaded(webDriver);
    }

    /**
     * Verify that verify page loaded.
     *
     * @param webDriver the web driver
     */
    private void verifyPageLoaded(final WebDriver webDriver) {
        webDriver.get(TEST_URL);
        final String currentUrl = webDriver.getCurrentUrl();
        log.info(currentUrl);
        final String pageTitle = webDriver.getTitle();
        log.info(pageTitle);
    }

}
