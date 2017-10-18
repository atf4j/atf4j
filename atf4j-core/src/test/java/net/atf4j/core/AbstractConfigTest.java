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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit tests for configuration class.
 */
public class AbstractConfigTest extends TestResultsReporting {

    private static final String MISSING_KEY = "missingKey";

    /**
     * Default configuration class.
     */
    private class DefaultConfig extends AbstractConfig {
    }

    /**
     * The SimpleConfiguration Class.
     */
    private class SimpleConfiguration extends AbstractConfig {

        /**
         * Instantiates a new simple configuration.
         *
         * @throws ConfigurationNotLoadedException the configuration not loaded
         */
        public SimpleConfiguration() throws ConfigurationNotLoadedException {
            super();
        }
    }

    /**
     * Test method for Default Configuration.
     */
    @Ignore
    @Test
    public void testDefaultConfig() {
        DefaultConfig config = new DefaultConfig();
        assertNotNull(UNEXPECTED_NULL, config);
        this.log.info("{}", config.toString());
    }

    /**
     * Test default constructor.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSimpleConfiguration() throws Exception {
        SimpleConfiguration config = new SimpleConfiguration();
        assertNotNull(config);
        log.info("{}", config);
    }

    /**
     * Test suggested usage.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSuggestedUsage() throws Exception {
        final SimpleConfiguration config = new SimpleConfiguration();
        assertNotNull(config);
        log.info("{}", config);

        String defaultValue = "defaultValue";
        assertEquals(defaultValue, config.valueFor(MISSING_KEY, defaultValue));
        assertEquals(Integer.MAX_VALUE, config.valueFor(MISSING_KEY, Integer.MAX_VALUE));
        assertEquals(Long.MAX_VALUE, config.valueFor(MISSING_KEY, Long.MAX_VALUE));
        assertEquals(true, config.valueFor(MISSING_KEY, true));
        assertEquals("stringValue", config.valueFor("keyForString", defaultValue));
        assertEquals(1, config.valueFor("keyForIntOne", Integer.MAX_VALUE));
        assertEquals(1, config.valueFor("keyForLongOne", Long.MAX_VALUE));
        assertTrue(config.valueFor("keyForTrue", false));
        assertFalse(config.valueFor("keyForFalse", true));
    }

    /**
     * Test int value for key.
     */
    @Test
    public void testIntValueForKey() {
        String value = Config.valueFor("keyForInt");
        assertNotNull(UNEXPECTED_NULL, value);
        log.info("{}", value);
    }

    /**
     * Test long value for key.
     */
    @Test
    public void testLongValueForKey() {
        String value = Config.valueFor("keyForLong");
        assertNotNull(UNEXPECTED_NULL, value);
        log.info("{}", value);
    }

    /**
     * Test boolean value for key.
     */
    @Test
    public void testBooleanValueForKey() {
        assertTrue(Config.booleanValueFor("keyForTrue"));
        assertFalse(Config.booleanValueFor("keyForFalse"));
    }

}
