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

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for configuration class.
 */
public class ConfigTest extends TestResultsReporting {

    /** DEFAULT_VALUE 			constant. */
    private static final String DEFAULT_VALUE = "defaultValue";
    
    /** MISSING_KEY 			constant. */
    private static final String MISSING_KEY = "missingKey";

    /**
     * Mock a Default configuration class.
     */
    private class TestConfig extends AbstractConfig {

        /**
         * Instantiates a new default config.
         */
        private TestConfig() {
            super();
        }
    }

    /**
     * The Class NamedConfig.
     */
    private class NamedConfig extends AbstractConfig {
        
        /**
         * Instantiates a new named config.
         */
        private NamedConfig() {
            super("TestConfig.properties");
        }
    }

    /**
     * Unit Test method for Default ExampleConfiguration.
     */
    @Test
    public void testDefaultConfig() {
        final Configuration defaultConfig = new TestConfig();
        this.log.debug("defaultConfig.toString() = {}", defaultConfig.toString());
        verifyNotNull(defaultConfig);
    }

    /**
     * Unit test to named config.
     */
    @Test
    public void testNamedConfig() {
        final Configuration config = new NamedConfig();
        this.log.debug("NamedConfig.toString() = {}", config.toString());
        verifyNotNull(config);
    }

    /**
     * Unit Test method for PrettyString method.
     */
    @Test
    public void testPrettyString() {
        final Configuration defaultConfig = new TestConfig();
        this.log.debug("defaultConfig.prettyString() = {}", defaultConfig.prettyString());
        verifyNotNull(defaultConfig);
    }

    /**
     * Unit test to typical usage.
     */
    @Test
    public void testTypicalUsage() {
        final Configuration simpleConfig = new TestConfig();
        verifyNotNull(simpleConfig);
        this.log.debug("simpleConfig = {}", simpleConfig.toString());

        assertEquals(DEFAULT_VALUE, simpleConfig.valueFor(MISSING_KEY, DEFAULT_VALUE));
        assertEquals(Integer.MAX_VALUE, simpleConfig.valueFor(MISSING_KEY, Integer.MAX_VALUE));
        assertEquals(Long.MAX_VALUE, simpleConfig.valueFor(MISSING_KEY, Long.MAX_VALUE));
        assertTrue(simpleConfig.valueFor(MISSING_KEY, true));

        assertEquals("valueForString", simpleConfig.valueFor("keyForString", DEFAULT_VALUE));
        assertEquals(1, simpleConfig.valueFor("keyForInt", Integer.MAX_VALUE));
        assertEquals(1, simpleConfig.valueFor("keyForLong", Long.MAX_VALUE));
        assertTrue(simpleConfig.valueFor("keyForTrue", false));
        assertFalse(simpleConfig.valueFor("keyForFalse", true));
    }

}
