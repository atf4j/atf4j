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
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class WebDriverConfig extends AbstractConfig {

    /**
     * Instantiates a new web driver config.
     *
     * @throws MissingPropertyFileException
     *             the missing property file exception
     */
    public WebDriverConfig() throws MissingPropertyFileException {
        super();
    }

    /**
     * Gets the target browser.
     *
     * @return the target browser
     */
    public String getTargetBrowser() {
        return this.get("targetBrowser");
    }

    /**
     * Gets the target url.
     *
     * @return the target url
     */
    public String getTargetUrl() {
        return this.get("targetUrl");
    }

    /**
     * Gets the page load timeout.
     *
     * @return the page load timeout
     */
    public String getPageLoadTimeout() {
        return this.get("pageLoadTimeOut");
    }

    /**
     * Gets the page load timeout unit.
     *
     * @return the page load timeout unit
     */
    public String getPageLoadTimeoutUnit() {
        return this.get("pageLoadTimeOutUnit");
    }

    /**
     * Gets the implicitly wait.
     *
     * @return the implicitly wait
     */
    public String getImplicitlyWait() {
        return this.get("implicitlyWait");
    }

    /**
     * Gets the implicitly wait unit.
     *
     * @return the implicitly wait unit
     */
    public String getImplicitlyWaitUnit() {
        return this.get("implicitlyWaitUnit");
    }

}
