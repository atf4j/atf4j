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

import net.atf4j.core.AbstractConfig;

/**
 * WebDriverConfig.
 *
 *
 */
public class WebDriverConfig extends AbstractConfig {

    /**
     * Instantiates a new web driver config.
     *
     * @throws ConfigurationNotLoaded
     *             the missing property file exception
     */
    public WebDriverConfig() throws ConfigurationNotLoaded {
        super();
    }

    /**
     * Gets the target browser.
     *
     * @return the target browser
     */
    public String targetBrowser() {
        return this.get("targetBrowser");
    }

    /**
     * Gets the target url.
     *
     * @return the target url
     */
    public String targetUrl() {
        return this.get("targetUrl");
    }

    /**
     * Selenium url.
     *
     * @return the string
     */
    public String seleniumUrl() {
        return this.get("seleniumUrl");
    }

    /**
     * Chrome binary driver.
     *
     * @return the string
     */
    public String chromeBinaryDriver() {
        return this.get("chromeBinaryDriver");
    }

    /**
     * Firefox binary driver.
     *
     * @return the string
     */
    public String firefoxBinaryDriver() {
        return this.get("firefoxBinaryDriver");
    }

    /**
     * Gets the page load timeout.
     *
     * @return the page load timeout
     */
    public long pageLoadTimeout() {
        return this.get("pageLoadTimeOut", 1000);
    }

    /**
     * Gets the implicitly wait.
     *
     * @return the implicitly wait
     */
    public long implicitlyWait() {
        return this.get("implicitlyWait", 1000);
    }

    /**
     * Gets the implicitly wait unit.
     *
     * @return the implicitly wait unit
     */
    public long implicitlyWaitUnit() {
        return this.get("implicitlyWaitUnit", 1000);
    }

}
