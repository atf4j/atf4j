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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.AbstractConfig.ConfigurationNotLoadedException;
import net.atf4j.core.TestResultsReporting;

/**
 * WebDriverConfigTest class.
 */
public final class WebDriverConfigTest extends TestResultsReporting {

    /**
     * Test method for {net.atf4j.webdriver.WebDriverConfig#WebDriverConfig()}.
     *
     * @throws ConfigurationNotLoadedException the missing property file
     *             exception
     */
    @Test
    public void testDefaultConstructor() throws ConfigurationNotLoadedException {
        final WebDriverConfig config = new WebDriverConfig();
        verifyNotNull(config);
        this.log.info(config.toString());
    }

    /**
     * test WebDriverConfig object.
     *
     * @throws ConfigurationNotLoadedException the configuration not loaded
     */
    @Test
    public void testHappyPath() throws ConfigurationNotLoadedException {
        final WebDriverConfig config = new WebDriverConfig();
        assertNotNull(config);
        assertNotNull(config.targetBrowser());
        assertNotNull(config.targetUrl());
        assertNotNull(config.seleniumUrl());
        assertNotNull(config.chromeBinaryDriver());
        assertNotNull(config.firefoxBinaryDriver());
        assertEquals(1000, config.pageLoadTimeout());
        assertEquals(1L, config.implicitWait());
        assertEquals(1L, config.explicitWait());
        assertFalse(config.maximiseBrowser());
        assertEquals(1, config.playbackInterval());
        assertEquals(1000, config.scriptTimeout());
        assertEquals(1, config.timeOutInSeconds());
    }

}
