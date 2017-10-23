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
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Unit tests for configuration class.
 */
public final class ConfigTest extends TestResultsReporting {

    /**
     * Test get INSTANCE.
     */
    @Test
    public void testGetInstance() {
        final GlobalConfig config = GlobalConfig.getInstance();
        log.debug("Config.getInstance() = {}", config.toString());
        assertNotNull(UNEXPECTED_NULL, config);
    }

    /**
     * Test value for missing key.
     */
    @Test
    public void testValueForMissingKey() {
        final String value = GlobalConfig.valueFor("missing");
        log.debug("Config.valueFor(missing) = {}", value);
        assertNull(UNEXPECTED_NULL, value);
    }

    /**
     * Test string value for key.
     */
    @Test
    public void testStringValueForKey() {
        final String value = GlobalConfig.valueFor("keyForString");
        log.debug("Config.valueFor(keyForString) = {}", value);
        assertNotNull(UNEXPECTED_NULL, value);
        assertEquals("valueForString", value);
    }

    /**
     * Test int value for key.
     */
    @Test
    public void testIntValueForKey() {
        final int value = GlobalConfig.intValueFor("keyForInt");
        log.debug("Config.valueFor(keyForInt) = {}", value);
        assertNotNull(UNEXPECTED_NULL, value);
        assertEquals(1, value);
    }

    /**
     * Test long value for key.
     */
    @Test
    public void testLongValueForKey() {
        final long value = GlobalConfig.longValueFor("keyForLong");
        log.debug("Config.valueFor(keyForLong) = {}", value);
        assertNotNull(UNEXPECTED_NULL, value);
        assertEquals(1L, value);
    }

    /**
     * Test true value for key.
     */
    @Test
    public void testTrueValueForKey() {
        final boolean value = GlobalConfig.booleanValueFor("keyForTrue");
        log.debug("Config.valueFor(keyForTrue) = {}", value);
        assertNotNull(UNEXPECTED_NULL, value);
        assertEquals(true, value);
    }

    /**
     * Test false value for key.
     */
    @Test
    public void testFalseValueForKey() {
        final boolean value = GlobalConfig.booleanValueFor("keyForFalse");
        log.debug("Config.valueFor(keyForFalse) = {}", value);
        assertNotNull(UNEXPECTED_NULL, value);
        assertEquals(false, value);
    }

}
