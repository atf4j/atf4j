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

import static org.junit.Assume.assumeNotNull;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for BrowserFactory objects.
 */
public class BrowserFactoryTest extends ResultsReporting {

    /**
     * test BrowserFactory object.
     */
    @Test
    public void testWebDriver() {
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull(webDriver);
        webDriver.get("http://127.0.0.1:8080");
        this.log.info(webDriver.getCurrentUrl());
        this.log.info(webDriver.getTitle());
    }

    /**
     * test BrowserFactory object.
     */
    @Test
    public void testChromeDriver() {
        System.setProperty("targetBrowser", "chromeDriver");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull(webDriver);
        webDriver.get("http://127.0.0.1:8080");
        this.log.info(webDriver.getCurrentUrl());
        this.log.info(webDriver.getTitle());
    }

    /**
     * test BrowserFactory object.
     */
    @Test
    public void testFirefoxDriver() {
        System.setProperty("targetBrowser", "firefoxDriver");
        final WebDriver webDriver = BrowserFactory.webDriver();
        assumeNotNull(webDriver);
        webDriver.get("http://127.0.0.1:8080");
        this.log.info(webDriver.getCurrentUrl());
        this.log.info(webDriver.getTitle());
    }

}
