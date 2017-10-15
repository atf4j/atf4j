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

import net.atf4j.core.AbstractConfig.ConfigurationNotLoaded;
import net.atf4j.core.AbstractConfig.PropertyNotFound;

/**
 * Unit tests for configuration class.
 */
public final class ConfigTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Default configuration class.
     */
    private class DefaultConfig extends AbstractConfig {
        /*
         * (non-Javadoc)
         *
         * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String)
         */
        @Override
        public String valueFor(final String key) {
            return null;
        }
    }

    /**
     * Missing Properties class.
     */
    private class MissingProperties extends AbstractConfig {

        /**
         * Instantiates a new missing properties.
         *
         * @throws ConfigurationNotLoaded
         *             the configuration not loaded
         */
        public MissingProperties() throws ConfigurationNotLoaded {
            super();
        }

        /*
         * (non-Javadoc)
         *
         * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String)
         */
        @Override
        public String valueFor(final String key) {
            return null;
        }
    }

    /**
     * A Mock Test Configuration from file.
     */
    private class ConfigFromFile extends AbstractConfig {

        /**
         * Instantiates a new config from file.
         *
         * @throws ConfigurationNotLoaded
         *             the configuration not loaded
         */
        public ConfigFromFile() throws ConfigurationNotLoaded {
            super("/ConfigFromFile.properties");
        }

        /*
         * (non-Javadoc)
         *
         * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String)
         */
        @Override
        public String valueFor(final String key) {
            // TODO Auto-generated method stub
            return null;
        }
    }

    private static Config config = Config.getInstance();

    /**
     * Test method for Default Configuration.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(UNEXPECTED_NULL, new DefaultConfig());
    }

    /**
     * Test method for MissingProperties.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public void testMissingConfig() throws ConfigurationNotLoaded {
        final ConfigurationInterface missingConfig = new MissingProperties();
        assertNotNull(UNEXPECTED_NULL, missingConfig);
        this.log.info(missingConfig.toString());
    }

    /**
     * Test method for void.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public void testLoad() throws ConfigurationNotLoaded {
        final ConfigurationInterface mockConfig = new MissingProperties();
        assertNotNull(UNEXPECTED_NULL, mockConfig);
        this.log.info(mockConfig.toString());
    }

    /**
     * Test method for value from file.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     * @throws PropertyNotFound
     *             the property not found
     */
    @Test
    public void testConfigFromFile() throws ConfigurationNotLoaded, PropertyNotFound {
        final ConfigFromFile config = new ConfigFromFile();
        assertNotNull(UNEXPECTED_NULL, config);
        assertEquals("true", config.get("loaded"));
        assertEquals(true, config.valueFor("loaded", false));
        assertEquals("ConfigFromSystem.properties", config.get("name"));
        assertEquals(null, config.get("missing"));
    }

    /**
     * Test method for System overriding.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     * @throws PropertyNotFound
     *             the property not found
     */
    @Test
    public void testSystemOveridesConfig() throws ConfigurationNotLoaded, PropertyNotFound {
        final ConfigFromFile config = new ConfigFromFile();
        assertNotNull(UNEXPECTED_NULL, config);
        final String key = "property";
        final String value = "FromSystem";
        System.setProperty(key, value);
        assertEquals(value, config.get(key));
    }

    /**
     * Unit Test for test static config.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public void testStaticConfig() throws ConfigurationNotLoaded {
        assertNotNull(UNEXPECTED_NULL, ConfigTest.config);
    }
}
