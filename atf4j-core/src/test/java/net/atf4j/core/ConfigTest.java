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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Unit tests for configuration class.
 */
public final class ConfigTest extends TestResultsReporting {

    /**
     * Test get instance.
     */
    @Test
    public void testGetInstance() {
        Config config = Config.getInstance();
        assertNotNull(UNEXPECTED_NULL, config);
        this.log.info("{}", config.toString());
    }

    /**
     * Test string value for key.
     */
    @Test
    public void testStringValueForKey() {
        String value = Config.valueFor("keyForString");
        assertNotNull(UNEXPECTED_NULL, value);
        log.info("{}", value);
    }

    /**
     * Test int value for key.
     */
    @Test
    public void testIntValueForKey() {
        int value = Config.intValueFor("keyForInt");
        assertNotNull(UNEXPECTED_NULL, value);
        log.info("{}", value);
    }

    /**
     * Test long value for key.
     */
    @Test
    public void testLongValueForKey() {
        long value = Config.longValueFor("keyForLong");
        assertNotNull(UNEXPECTED_NULL, value);
        log.info("{}", value);
    }

    /**
     * Test true value for key.
     */
    @Test
    public void testTrueValueForKey() {
        boolean value = Config.booleanValueFor("keyForTrue");
        assertNotNull(UNEXPECTED_NULL, value);
        log.info("{}", value);
    }

    /**
     * Test false value for key.
     */
    @Test
    public void testFalseValueForKey() {
        boolean value = Config.booleanValueFor("keyForFalse");
        assertNotNull(UNEXPECTED_NULL, value);
        log.info("{}", value);
    }

    /**
     * Test value for missing key.
     */
    @Test
    public void testValueForMissingKey() {
        String value = Config.valueFor("missing");
        assertNull(value);
        log.info("{}", value);
    }

}
