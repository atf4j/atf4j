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

import static net.atf4j.core.Verify.verifyEqual;
import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for configuration class.
 */
public class ConfigTest {

    private static final String VALUE_FOR_STRING = "valueForString";
    private static final String KEY_FOR_STRING = "keyForString";
    private static final String DEFAULT_VALUE = "defaultValue";
    private static final String MISSING_KEY = "missingKey";

    /**
     * Mock a Default configuration class.
     */
    private class TestConfig extends AbstractConfig {
        String expected = "TestConfig [properties={\n"
                + "\tkeyForLong=1\n"
                + "\tfilename=Config.properties\n"
                + "\tloaded=true\n"
                + "\tkeyForTrue=true\n"
                + "\tkeyForFalse=false\n"
                + "\tkeyForInt=1\n"
                + "\tkeyForString=valueForString\n"
                + "\t}]";

        /**
         * Instantiates a new default config.
         */
        private TestConfig() {
            super();
        }
    }

    /**
     * NamedConfig class.
     */
    private class NamedConfig extends AbstractConfig {
        String expected = "NamedConfig [properties={\n"
                + "\tkeyForLong=1\n"
                + "\tfilename=Config.properties\n"
                + "\tloaded=true\n"
                + "\tkeyForTrue=true\n"
                + "\tkeyForFalse=false\n"
                + "\tkeyForInt=1\n"
                + "\tkeyForString=valueForString\n"
                + "\t}]";

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
        TestConfig testConfig = new TestConfig();
        verifyNotNull(testConfig);
        verifyEqual(VALUE_FOR_STRING, testConfig.valueFor(KEY_FOR_STRING));
        // verifyEqual(DEFAULT_VALUE, testConfig.valueFor(MISSING_KEY));
        verifyEqual(testConfig.expected, testConfig.toString());
        verifyEqual(testConfig.expected, testConfig.prettyString());
        testConfig.toLog();
    }

    /**
     * Unit test to named configuration.
     */
    @Test
    public void testNamedConfig() {
        NamedConfig testConfig = new NamedConfig();
        verifyNotNull(testConfig);
        verifyEqual(VALUE_FOR_STRING, testConfig.valueFor(KEY_FOR_STRING));
        // verifyEqual(DEFAULT_VALUE, testConfig.valueFor(MISSING_KEY));
        verifyEqual(testConfig.expected, testConfig.toString());
        verifyEqual(testConfig.expected, testConfig.prettyString());
        testConfig.toLog();
    }

    /**
     * Unit test to typical usage.
     */
    @Test
    public void testTypicalUsage() {
        final Configuration simpleConfig = new TestConfig();
        verifyNotNull(simpleConfig);

        assertEquals(DEFAULT_VALUE, simpleConfig.valueFor(MISSING_KEY, DEFAULT_VALUE));
        assertEquals(Integer.MAX_VALUE, simpleConfig.valueFor(MISSING_KEY, Integer.MAX_VALUE));
        assertEquals(Long.MAX_VALUE, simpleConfig.valueFor(MISSING_KEY, Long.MAX_VALUE));
        assertTrue(simpleConfig.valueFor(MISSING_KEY, true));

        assertEquals(VALUE_FOR_STRING, simpleConfig.valueFor(KEY_FOR_STRING, DEFAULT_VALUE));
        assertEquals(1, simpleConfig.valueFor("keyForInt", Integer.MAX_VALUE));
        assertEquals(1, simpleConfig.valueFor("keyForLong", Long.MAX_VALUE));
        assertTrue(simpleConfig.valueFor("keyForTrue", false));
        assertFalse(simpleConfig.valueFor("keyForFalse", true));
    }

}
