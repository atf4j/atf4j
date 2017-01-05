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

import org.junit.Assert;
import org.junit.Test;

import net.atf4j.core.AbstractConfig.ConfigurationNotLoaded;

/**
 * A UnitTest for Config objects.
 */
public class ConfigTest extends ResultsReporting {

    /**
     * The DefaultConfig Class.
     */
    private class DefaultConfig extends AbstractConfig {
    }

    /**
     * MissingPropertiesMock Class.
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
    }

    /**
     * A Test Configuration from file.
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
    }

    /**
     * Test method for Default Configuration.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new DefaultConfig());
    }

    /**
     * Test method for MissingProperties.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public void testConfig() throws ConfigurationNotLoaded {
        assertNotNull(new MissingProperties());
    }

    /**
     * Test method for void.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public void testLoad() throws ConfigurationNotLoaded {
        final AbstractConfig mockConfig = new MissingProperties();
        assertNotNull(mockConfig);
        this.log.info(mockConfig.toString());
    }

    /**
     * Test method for void.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public void testConfigFromFile() throws ConfigurationNotLoaded {
        final ConfigFromFile config = new ConfigFromFile();
        assertNotNull(config);
        assertEquals("true", config.get("loaded"));
        assertEquals(true, config.get("loaded", false));
        assertEquals("ConfigFromSystem.properties", config.get("name"));
        assertEquals(null, config.get("missing"));
    }

    /**
     * Test method for void.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public final void testSystemOveridesConfig() throws ConfigurationNotLoaded {
        final ConfigFromFile config = new ConfigFromFile();
        assertNotNull(config);
        final String key = "property";
        final String value = "FromSystem";
        System.setProperty(key, value);
        Assert.assertEquals(value, config.get(key));
    }

}
