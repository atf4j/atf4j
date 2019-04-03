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

import net.atf4j.core.AbstractConfig;

/**
 * Atf4jConfiguration for WebDriver.
 */
public class WebDriverConfig extends AbstractConfig {

    /** LOCAL_GRID 			constant. */
    private static final String LOCAL_GRID = "http://localhost:4444/wd/hub";
    
    /** LOCAL_TARGET 			constant. */
    private static final String LOCAL_TARGET = "http://localhost:8080/";

    /**
     * Default constructor.
     */
    public WebDriverConfig() {
        super();
    }

    /**
     * Gets the targetBrowser from the configuration.
     *
     * @return the name of target browser as String object.
     */
    public String targetBrowser() {
        final String targetBrowser = this.get("targetBrowser", "Firefox");
        return targetBrowser;
    }

    /**
     * Path to the Chrome driver binary.
     *
     * @return path as String object.
     */
    public String chromeBinaryDriver() {
        return this.valueFor("chromeBinaryDriver");
    }

    /**
     * Path to the Firefox binary driver.
     *
     * @return path as String object.
     */
    public String firefoxBinaryDriver() {
        return this.valueFor("firefoxBinaryDriver");
    }

    /**
     * get the seleniumUrl from the configuration.
     *
     * @return seleniumUrl as String object.
     */
    public String seleniumUrl() {
        return this.valueFor("seleniumUrl", WebDriverConfig.LOCAL_GRID);
    }

    /**
     * Gets the targetUrl from the configuration.
     *
     * @return the targetURL as String object.
     */
    public String targetUrl() {
        return this.valueFor("targetUrl", WebDriverConfig.LOCAL_TARGET);
    }

    /**
     * Gets the page load timeout.
     *
     * @return the page load timeout
     */
    public long pageLoadTimeout() {
        return this.valueFor("pageLoadTimeOut", 1);
    }

    /**
     * Gets the implicit wait.
     *
     * @return the implicit wait
     */
    public long implicitWait() {
        return this.valueFor("implicitWait", 1);
    }

    /**
     * Explicit wait.
     *
     * @return the long
     */
    public long explicitWait() {
        return this.valueFor("explicitWait", 1);
    }

    /**
     * Polling interval.
     *
     * @return the long
     */
    public long pollingInterval() {
        return this.valueFor("pollingInterval", 1);
    }

    /**
     * Maximise browser.
     *
     * @return the boolean
     */
    public boolean maximiseBrowser() {
        return this.valueFor("maximiseBrowser", false);
    }

    /**
     * Playback interval.
     *
     * @return the long
     */
    public long playbackInterval() {
        return this.valueFor("playbackInterval", 1);
    }

    /**
     * Script timeout.
     *
     * @return the long
     */
    public long scriptTimeout() {
        return this.valueFor("scriptTimeout", 1000);
    }

    /**
     * Time out in seconds.
     *
     * @return the long
     */
    public long timeOutInSeconds() {
        return this.valueFor("timeOutInSeconds", 1);
    }

}
