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
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

import static org.junit.Assume.assumeNotNull;

import net.atf4j.core.TestContext;
import net.atf4j.core.TestResultsReporting;

/**
 * Smoke Tests for WebDriver.
 */
public final class WebDriverSmokeTest extends TestResultsReporting {

    /**
     * Smoke Test ChromeDriver with Tomcat.
     */
    @Test
    public void testChromeTomcat() {
        // TestContext.assumeLocal();
        final WebDriver webDriver = new ChromeDriver();
        verifyNotNull(webDriver);
        verifyTomcatPresent(webDriver);
        webDriver.close();
    }

    /**
     * Smoke Test FirefoxDriver with Tomcat.
     */
    @Test
    public void testFirefoxTomcat() {
        TestContext.assumeLocal();
        assumeNotNull("Expected webdriver.gecko.driver to be defined", System.getProperty("webdriver.gecko.driver"));
        // final WebDriver webDriver = new FirefoxDriver();
        // verifyNotNull(webDriver);
        // verifyTomcatPresent(webDriver);
        // webDriver.close();
    }

    /**
     * Smoke Test EdgeDriver with Tomcat.
     */
    @Test
    public void testEdgeTomcat() {
        TestContext.assumeLocal();
        assumeNotNull("Expected webdriver.edge.driver to be defined", System.getProperty("webdriver.edge.driver"));
        // final WebDriver webDriver = new EdgeDriver();
        // verifyNotNull(webDriver);
        // verifyTomcatPresent(webDriver);
        // webDriver.close();
    }

    /**
     * Test phantomjs tomcat.
     */
    @Test
    public void testPhantomJsTomcat() {
        TestContext.assumeLocal();
        assumeNotNull("Expected phantomjs.binary.path to be defined", System.getProperty("phantomjs.binary.path"));
        // final DesiredCapabilities desiredCapabilities = new
        // DesiredCapabilities();
        // desiredCapabilities.setJavascriptEnabled(true);
        // desiredCapabilities.setCapability(
        // PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
        // "../web-driver-bin/phantomjs.exe");
        // final WebDriver webDriver = new PhantomJSDriver(desiredCapabilities);
        // verifyNotNull(webDriver);
        // verifyTomcatPresent(webDriver);
        // webDriver.close();
    }

    private void verifyTomcatPresent(final WebDriver webDriver) {
        TestContext.assumeLocalServer();
        webDriver.get("http://127.0.0.1:8080/");
        final String pageTitle = webDriver.getTitle();
        verifyNotNull(pageTitle);
        assertTrue(pageTitle.contains("Apache Tomcat"));
        this.log.info("pageTitle = {}", pageTitle);
    }

}
