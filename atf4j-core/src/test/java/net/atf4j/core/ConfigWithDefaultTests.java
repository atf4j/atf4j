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

/**
 * ConfigDefaultsTest Class.
 *
 *
 */
public class ConfigWithDefaultTests extends ResultsReporting {

    /**
     * A Mock Configuration with default values.
     */
    private class ConfigWithDefaults extends AbstractConfig {

        /**
         * Instantiates a new config with defaults.
         *
         * @throws ConfigurationNotLoaded
         *             the configuration not loaded
         */
        public ConfigWithDefaults() throws ConfigurationNotLoaded {
            super();
        }

        /**
         * Gets the true as boolean.
         *
         * @param key
         *            the key
         * @return the true as boolean
         */
        public boolean getTrueAsBoolean(final String key) {
            return super.get(key, true);
        }

        /**
         * Gets the false as boolean.
         *
         * @param key
         *            the key
         * @return the false as boolean
         */
        public boolean getFalseAsBoolean(final String key) {
            return super.get(key, false);
        }

        /**
         * Gets the foo as string.
         *
         * @param key
         *            the key
         * @return the foo as string
         */
        public String getFooAsString(final String key) {
            return super.get(key, "DEFAULT_STRING");
        }

        /**
         * Gets the max.
         *
         * @param key
         *            the key
         * @return the max
         */
        public Object getMax(final String key) {
            return super.get(key, Integer.MAX_VALUE);
        }

        /**
         * Gets the min.
         *
         * @param key
         *            the key
         * @return the min
         */
        public Object getMin(final String key) {
            return super.get(key, Integer.MIN_VALUE);
        }
    }

    /**
     * Test default constructor.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public void testDefaultConstructor() throws ConfigurationNotLoaded {
        new ConfigWithDefaults();
    }

    /**
     * Test default string.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public void testDefaultString() throws ConfigurationNotLoaded {
        final ConfigWithDefaults mockConfig = new ConfigWithDefaults();
        assertNotNull(mockConfig);
        assertEquals("DEFAULT_STRING", mockConfig.getFooAsString("missing"));
    }

    /**
     * Test default boolean.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public void testDefaultBoolean() throws ConfigurationNotLoaded {
        final ConfigWithDefaults mockConfig = new ConfigWithDefaults();
        assertNotNull(mockConfig);
        assertEquals(true, mockConfig.getTrueAsBoolean("missing"));
        assertEquals(false, mockConfig.getFalseAsBoolean("missing"));
    }

    /**
     * Test default int.
     *
     * @throws ConfigurationNotLoaded
     *             the configuration not loaded
     */
    @Test
    public void testDefaultInt() throws ConfigurationNotLoaded {
        final ConfigWithDefaults mockConfig = new ConfigWithDefaults();
        assertNotNull(mockConfig);
        assertEquals(Integer.MAX_VALUE, mockConfig.getMax("missing"));
        assertEquals(Integer.MIN_VALUE, mockConfig.getMin("missing"));
    }

}
