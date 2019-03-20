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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for configuration class.
 */
public class ConfigTest extends TestResultsReporting {

    /** The Constant MISSING_KEY. */
    private static final String MISSING_KEY = "missingKey";

    /**
     * Mock a Default configuration class.
     */
    private class DefaultConfig extends AbstractConfig {

        /**
         * Instantiates a new default config.
         */
        private DefaultConfig() {
            super();
        }
    }

    /**
     * Mock a Simple ExampleConfiguration Class.
     */
    private class SimpleConfiguration extends AbstractConfig {
        /**
         * Instantiates a new simple configuration.
         */
        public SimpleConfiguration() {
            super();
        }
    }

    private class NamedConfig extends AbstractConfig {
        /**
         * Instantiates a new default config.
         */
        private NamedConfig() {
            super("Config.properties");
        }
    }

    /**
     * Unit Test method for Default ExampleConfiguration.
     */
    @Test
    public void testDefaultConfig() {
        final DefaultConfig defaultConfig = new DefaultConfig();
        this.log.debug("defaultConfig.toString() = {}", defaultConfig.toString());
        verifyNotNull(defaultConfig);
    }

    @Test
    public void testNamedConfig() {
        final ConfigurationInterface config = new NamedConfig();
        this.log.debug("NamedConfig.toString() = {}", config.toString());
        verifyNotNull(config);
    }

    /**
     * Unit Test method for PrettyString method.
     */
    @Test
    public void testPrettyString() {
        final DefaultConfig defaultConfig = new DefaultConfig();
        this.log.debug("defaultConfig.prettyString() = {}", defaultConfig.prettyString());
        verifyNotNull(defaultConfig);
    }

    /**
     * Unit Test Simple ExampleConfiguration constructor.
     */
    @Test
    public void testSimpleConfiguration() {
        final SimpleConfiguration config = new SimpleConfiguration();
        this.log.debug("config = {}", config.toString());
        verifyNotNull(config);
    }

    /**
     * Unit Test typical usage.
     */
    @Test
    public void testTypicalUsage() {
        final SimpleConfiguration simpleConfig = new SimpleConfiguration();
        verifyNotNull(simpleConfig);
        this.log.debug("simpleConfig = {}", simpleConfig.toString());

        final String defaultValue = "defaultValue";
        assertEquals(defaultValue, simpleConfig.valueFor(MISSING_KEY, defaultValue));
        assertEquals(Integer.MAX_VALUE, simpleConfig.valueFor(MISSING_KEY, Integer.MAX_VALUE));
        assertEquals(Long.MAX_VALUE, simpleConfig.valueFor(MISSING_KEY, Long.MAX_VALUE));
        assertTrue(simpleConfig.valueFor(MISSING_KEY, true));

        assertEquals("stringValue", simpleConfig.valueFor("keyForString", defaultValue));
        assertEquals(1, simpleConfig.valueFor("keyForIntOne", Integer.MAX_VALUE));
        assertEquals(1, simpleConfig.valueFor("keyForLongOne", Long.MAX_VALUE));
        assertTrue(simpleConfig.valueFor("keyForTrue", false));
        assertFalse(simpleConfig.valueFor("keyForFalse", true));
    }

}
