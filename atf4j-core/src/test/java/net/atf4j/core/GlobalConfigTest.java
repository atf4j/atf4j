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

import org.junit.Test;

public class GlobalConfigTest extends TestResultsReporting {

    @Test
    public void testGetInstance() {
        final GlobalConfig globalConfig = GlobalConfig.getInstance();
        log.debug("GlobalConfig.getInstance() = {}", globalConfig.toString());
        assertNotNull(UNEXPECTED_NULL, globalConfig);
    }

    /**
     * Unit Test for Static method valuefor(key).
     */
    @Test
    public void testStaticValueForKey() {
        final String key = "keyForString";
        final String value = GlobalConfig.valueFor(key);
        log.debug("Config.valueFor(key='{}') = {}", key, value);
        assertNotNull(UNEXPECTED_NULL, value);
        assertEquals("valueForString", value);
    }

    @Test
    public void testStaticValueForMissingKey() {
        final String key = "missingKey";
        GlobalConfig.valueFor(key);
    }

    /**
     * Unit Test for Static method valuefor(key).
     */
    @Test
    public void testStaticIntValueForKey() {
        final String key = "keyForInt";
        final long intValue = GlobalConfig.intValueFor(key);
        log.debug("Config.intValueFor(key='{}') = {}", key, intValue);
        assertNotNull(UNEXPECTED_NULL, intValue);
        assertEquals(1, intValue);
    }

    @Test
    public void testStaticIntValueForMissingKey() {
        final String key = "missingKey";
        GlobalConfig.intValueFor(key);
    }

    /**
     * Unit Test for Static method valuefor(key).
     */
    @Test
    public void testStaticLongValueForKey() {
        final String key = "keyForLong";
        final long longValue = GlobalConfig.longValueFor(key);
        log.debug("Config.longValueFor(key='{}') = {}", key, longValue);
        assertNotNull(UNEXPECTED_NULL, longValue);
        assertEquals(1L, longValue);
    }

    @Test
    public void testStaticLongValueFor() {
        final String key = "missingKey";
        GlobalConfig.longValueFor(key);
    }

    /**
     * Unit Test for Static method valuefor(key).
     */
    @Test
    public void testStaticBooleanValueForKey() {
        final String key = "keyForBoolean";
        final boolean booleanValueFor = GlobalConfig.booleanValueFor(key);
        log.debug("Config.longValueFor(key='{}') = {}", key, booleanValueFor);
        assertNotNull(UNEXPECTED_NULL, booleanValueFor);
        assertEquals(false, booleanValueFor);
        assertTrue(GlobalConfig.booleanValueFor("keyForTrue"));
        assertFalse(GlobalConfig.booleanValueFor("keyForFalse"));
    }

    @Test
    public void testStaticBooleanValueForMissingKey() {
        final String key = "missingKey";
        GlobalConfig.booleanValueFor(key);
    }
}
