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
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.AbstractConfig.MissingPropertyFileException;

/**
 * UnitTests for ConfigFromSystem.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class ConfigFromSystemTests extends LoggedTest {

    /**
     * MockConfig Class.
     */
    private class ConfigFromSystem extends AbstractConfig {
        public ConfigFromSystem() throws MissingPropertyFileException {
            super();
        }

        public boolean getSystemPropertyAsBoolean(final String key) {
            final boolean property = Boolean.getBoolean(key);
            return property;
        }

        public String getSystemPropertyAsString(final String key) {
            final String property = System.getProperty(key);
            return property;
        }
    }

    @Test
    public void testSystemString() throws MissingPropertyFileException {
        final String systemPropertyKey = "stringFromSystem";
        final String systemPropertyValue = "present";
        System.setProperty(systemPropertyKey, systemPropertyValue);

        // When
        final ConfigFromSystem mockConfig = new ConfigFromSystem();
        assertNotNull(mockConfig);
        final String systemPropertyAsString = mockConfig.getSystemPropertyAsString(systemPropertyKey);
        assertEquals(systemPropertyValue, systemPropertyAsString);
    }

    @Test
    public void testSystemBoolean() throws MissingPropertyFileException {
        final String systemPropertyKey = "booleanFromSystem";
        final String systemPropertyValue = "true";
        System.setProperty(systemPropertyKey, systemPropertyValue);
        this.log.info(System.getProperties().toString());

        // When
        final ConfigFromSystem mockConfig = new ConfigFromSystem();
        assertNotNull(mockConfig);
        final boolean booleanFromSystem = mockConfig.getSystemPropertyAsBoolean(systemPropertyKey);
        assertEquals(true, booleanFromSystem);
    }
}
