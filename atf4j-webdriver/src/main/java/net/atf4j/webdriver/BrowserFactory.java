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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.AbstractConfig.PropertyNotFound;
import net.atf4j.core.model.TestContext;

/**
 * A factory class for creating Browser objects.
 */
public class BrowserFactory implements BrowserFactoryInterface {

    private static final Logger log = LoggerFactory.getLogger(BrowserFactory.class);
    private static WebDriverConfig config;

    /**
     * Initialise web driver.
     *
     * @param webDriver
     *            the web driver
     */
    private static void initialiseWebDriver(final WebDriver webDriver) {
        final Options manage = webDriver.manage();
        final Timeouts timeouts = manage.timeouts();
        timeouts.pageLoadTimeout(BrowserFactory.config.pageLoadTimeout(), TimeUnit.SECONDS);
        timeouts.implicitlyWait(BrowserFactory.config.implicitWait(), TimeUnit.SECONDS);
        timeouts.setScriptTimeout(BrowserFactory.config.scriptTimeout(), TimeUnit.MILLISECONDS);
    }

    /**
     * Local webDriver instance.
     *
     * @return the webDriver instance.
     */
    protected static WebDriver localWebDriver() {
        BrowserFactory.log.trace("localWebDriver()");
        final String targetBrowser = BrowserFactory.config.targetBrowser();
        return localWebDriver(targetBrowser);
    }

    /**
     * Local webDriver instance.
     *
     * @param targetBrowser
     *            the target browser
     * @return the webDriver
     */
    protected static WebDriver localWebDriver(final String targetBrowser) {
        WebDriver webDriver = null;

        switch (targetBrowser) {
        case "Chrome":
            webDriver = new ChromeDriver();
            break;
        case "Firefox":
            webDriver = new FirefoxDriver();
            break;
        }

        initialiseWebDriver(webDriver);

        return webDriver;
    }

    /**
     * Default remote webDriver instance.
     *
     * @return the web driver
     * @throws PropertyNotFound
     *             the property not found
     */
    protected static WebDriver remoteWebDriver() throws PropertyNotFound {
        final String targetBrowser = BrowserFactory.config.targetBrowser();
        return remoteWebDriver(targetBrowser);
    }

    /**
     * Named remote webDriver instance.
     *
     * @param targetBrowser
     *            the target browser
     * @return the web driver
     */
    protected static WebDriver remoteWebDriver(final String targetBrowser) {
        BrowserFactory.log.trace("remoteWebDriver(targetBrowser={})", targetBrowser);

        final DesiredCapabilities desiredCapabilities;

        switch (targetBrowser.toLowerCase()) {
        case "firefox":
            desiredCapabilities = DesiredCapabilities.firefox();
            break;
        case "chrome":
            desiredCapabilities = DesiredCapabilities.chrome();
            break;
        case "ie":
            desiredCapabilities = DesiredCapabilities.internetExplorer();
            break;
        default:
            desiredCapabilities = DesiredCapabilities.htmlUnit();
            break;
        }

        final String targetSeleniumGrid = BrowserFactory.config.seleniumUrl();
        final URL GRID_URL;
        try {
            GRID_URL = new URL(targetSeleniumGrid);
            final RemoteWebDriver remoteWebDriver = new RemoteWebDriver(GRID_URL, desiredCapabilities);
            initialiseWebDriver(remoteWebDriver);
            return remoteWebDriver;
        } catch (final MalformedURLException e) {
            BrowserFactory.log.error("{}", e);
        }
        return null;
    }

    /**
     * Factory method for Selenium WebDriver.instance.
     *
     * @return webDriver
     */
    public static WebDriver webDriver() {
        if (BrowserFactory.config == null) {
            BrowserFactory.config = new BrowserFactorConfig();
        }
        return webDriver(BrowserFactory.config.targetBrowser());
    }

    /**
     * Factory method of webDriver instance.
     *
     * @param browser
     *            the browser
     * @return instance of webDriver
     */
    protected static WebDriver webDriver(final String browser) {
        if (BrowserFactory.config == null) {
            BrowserFactory.config = new BrowserFactorConfig();
        }
        if (TestContext.isLocal()) {
            return localWebDriver(browser);
        } else if (TestContext.isGrid()) {
            return remoteWebDriver(browser);
        }
        return null;
    }

}
