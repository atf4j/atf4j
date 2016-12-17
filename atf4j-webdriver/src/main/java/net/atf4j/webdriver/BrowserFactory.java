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
package net.atf4j.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import net.atf4j.core.AbstractConfig.ConfigurationNotLoaded;
import net.atf4j.core.model.TestContext;

public class BrowserFactory {
    private static WebDriverConfig config;

    public static WebDriver webDriver() {
        try {
            config = new WebDriverConfig();
            if (TestContext.isLocal()) {
                return localWebDriver();
            } else if (TestContext.isSelenium()) {
                return remoteWebDriver();
            }
        } catch (final ConfigurationNotLoaded e) {
            e.printStackTrace();
        }
        return null;
    }

    public static WebDriver remoteWebDriver() {
        final String targetBrowser = config.getTargetBrowser();
        final DesiredCapabilities desiredCapabilities;
        switch (targetBrowser) {
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
        // final String targetSeleniumGrid =
        // config.getSeleniumUrl("seleniumUrl", "http://localhost:4444/wd/hub");
        // final URL GRID_URL = new URL(targetSeleniumGrid);
        // final RemoteWebDriver remoteWebDriver = new RemoteWebDriver(GRID_URL,
        // desiredCapabilities);
        return new RemoteWebDriver(desiredCapabilities);
    }

    private static WebDriver localWebDriver() {
        WebDriver webDriver = null;
        final String targetBrowser = config.getTargetBrowser();
        switch (targetBrowser) {
        case "Chrome":
            webDriver = new ChromeDriver();
            break;
        case "Firefox":
            webDriver = new FirefoxDriver();
            break;
        }
        return webDriver;
    }
}
