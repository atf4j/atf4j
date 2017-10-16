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

package net.atf4j.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.AbstractConfig.ConfigurationNotLoadedException;
import net.atf4j.core.AbstractConfig.PropertyNotFoundException;

/**
 * ConfigLoadingTests Class.
 */
public final class ConfigLoadingTests extends TestResultsReporting {

    /**
     * Missing Properties class.
     */
    private class MissingProperties extends AbstractConfig {

        /**
         * Instantiates a new missing properties.
         *
         * @throws ConfigurationNotLoadedException the configuration not loaded
         */
        public MissingProperties() throws ConfigurationNotLoadedException {
            super();
        }
    }

    /**
     * A Mock Test Configuration from file.
     */
    private class ConfigFromFile extends AbstractConfig {

        /**
         * Instantiates a new config from file.
         *
         * @throws ConfigurationNotLoadedException the configuration not loaded
         */
        public ConfigFromFile() throws ConfigurationNotLoadedException {
            super("/ConfigFromFile.properties");
        }

        public String getPropertyFilename() {
            // TODO Auto-generated method stub
            return null;
        }
    }

    /**
     * Test method for MissingProperties.
     *
     * @throws ConfigurationNotLoadedException the configuration not loaded
     */
    @Test
    public void testMissingConfig() throws Exception {
        final ConfigurationInterface missingConfig = new MissingProperties();
        assertNotNull(UNEXPECTED_NULL, missingConfig);
        this.log.info("{}", missingConfig.toString());
    }

    /**
     * Test method for value from file.
     *
     * @throws ConfigurationNotLoadedException the configuration not loaded
     * @throws PropertyNotFoundException the property not found
     */
    @Test
    public void testConfigFromFile() throws Exception {
        final ConfigFromFile config = new ConfigFromFile();
        assertNotNull(UNEXPECTED_NULL, config);
        assertEquals("true", config.get("loaded"));
        assertEquals(true, config.valueFor("loaded", false));
        assertEquals("ConfigFromSystem.properties", config.get("name"));
        assertEquals(null, config.get("missing"));
        this.log.info("{}", config.toString());
        final String propertyFilename = config.getPropertyFilename();
        assertEquals("ConfigFromFile.properties", propertyFilename);
    }

    /**
     * Test method for System overriding.
     *
     * @throws ConfigurationNotLoadedException the configuration not loaded
     * @throws PropertyNotFoundException the property not found
     */
    @Test
    public void testSystemOveridesConfig() throws Exception {
        final ConfigFromFile config = new ConfigFromFile();
        assertNotNull(UNEXPECTED_NULL, config);
        final String key = "property";
        final String value = "FromSystem";
        System.setProperty(key, value);
        assertEquals(value, config.get(key));
        this.log.info("{}", config.toString());
    }

}
