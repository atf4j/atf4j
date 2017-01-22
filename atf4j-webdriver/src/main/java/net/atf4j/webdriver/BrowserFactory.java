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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.AbstractConfig.ConfigurationNotLoaded;
import net.atf4j.core.model.TestContext;

/**
 * A factory for creating Browser objects.
 */
public class BrowserFactory {
    private static final Logger log = LoggerFactory.getLogger(BrowserFactory.class);
    private static WebDriverConfig config;

    /**
     * Factory method of webDriver instance.
     *
     * @return instance of webDriver
     */
    public static WebDriver webDriver() {
        log.trace("webDriver()");
        try {
            if (config == null) {
                config = new WebDriverConfig();
                log.trace(config.toString());
            }
            if (TestContext.isLocal()) {
                return localWebDriver();
            } else if (TestContext.isSelenium()) {
                return remoteWebDriver();
            } else {
                log.error("Unknown Test Context : defaulting to headless HtmlUnitDriver");
                final HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver(true);
                return htmlUnitDriver;
            }
        } catch (final ConfigurationNotLoaded e) {
            log.error(e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * Remote web driver.
     *
     * @return the web driver
     */
    public static WebDriver remoteWebDriver() {
        log.trace("remoteWebDriver()");
        final String targetBrowser = config.targetBrowser();
        log.trace("targetBrowser = ", targetBrowser);
        final DesiredCapabilities desiredCapabilities;

        switch (targetBrowser.toLowerCase()) {
        case "firefox":
            desiredCapabilities = DesiredCapabilities.firefox();
            break;
        case "chrome":
            desiredCapabilities = DesiredCapabilities.chrome();
            break;
        case "IE":
            desiredCapabilities = DesiredCapabilities.internetExplorer();
            break;
        default:
            desiredCapabilities = DesiredCapabilities.htmlUnit();
            break;
        }

        final String targetSeleniumGrid = config.seleniumUrl();
        URL GRID_URL;
        try {
            GRID_URL = new URL(targetSeleniumGrid);
            return new RemoteWebDriver(GRID_URL, desiredCapabilities);
        } catch (final MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Local web driver.
     *
     * @return the web driver
     */
    private static WebDriver localWebDriver() {
        log.trace("localWebDriver()");
        WebDriver webDriver = null;
        final String targetBrowser = config.targetBrowser();
        switch (targetBrowser) {
        case "Chrome":
            webDriver = new ChromeDriver();
            break;
        case "Firefox":
            webDriver = new FirefoxDriver();
            break;
        default:
            webDriver = new HtmlUnitDriver();
            break;
        }
        return webDriver;
    }
}
