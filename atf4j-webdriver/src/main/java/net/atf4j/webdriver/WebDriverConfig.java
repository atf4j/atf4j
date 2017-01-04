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
 * Configuration for WebDriver instance.
 */
public class WebDriverConfig extends AbstractConfig {

    /**
     * Default constructor.
     *
     * @throws ConfigurationNotLoaded
     *             the missing property file exception
     */
    public WebDriverConfig() throws ConfigurationNotLoaded {
        super();
    }

    /**
     * Gets the targetBrowser from the configuration.
     *
     * @return the name of target browser as String object.
     */
    public String targetBrowser() {
        return this.get("targetBrowser");
    }

    /**
     * Gets the targetUrl from the configuration.
     *
     * @return the targetURL as String object.
     */
    public String targetUrl() {
        return this.get("targetUrl");
    }

    /**
     * get the seleniumUrl from the configuration.
     *
     * @return seleniumUrl as String object.
     */
    public String seleniumUrl() {
        return this.get("seleniumUrl");
    }

    /**
     * Path to the Chrome driver binary.
     *
     * @return path as String object.
     */
    public String chromeBinaryDriver() {
        return this.get("chromeBinaryDriver");
    }

    /**
     * PAth to the Firefox binary driver.
     *
     * @return path as String object.
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
