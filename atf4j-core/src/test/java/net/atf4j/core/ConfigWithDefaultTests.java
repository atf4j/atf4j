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

import net.atf4j.core.AbstractConfig.ConfigurationNotLoaded;

/**
 * ConfigDefaultsTest Class.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class ConfigWithDefaultTests extends Reporting {

    /**
     * A Mock Configuration with default values.
     */
    private class ConfigWithDefaults extends AbstractConfig {
        public ConfigWithDefaults() throws ConfigurationNotLoaded {
            super();
        }

        public boolean getTrueAsBoolean(final String key) {
            return super.get(key, true);
        }

        public boolean getFalseAsBoolean(final String key) {
            return super.get(key, false);
        }

        public String getFooAsString(final String key) {
            return super.get(key, "DEFAULT_STRING");
        }

        public Object getMax(final String key) {
            return super.get(key, Integer.MAX_VALUE);
        }

        public Object getMin(final String key) {
            return super.get(key, Integer.MIN_VALUE);
        }
    }

    @Test
    public void testDefaultString() throws ConfigurationNotLoaded {
        final ConfigWithDefaults mockConfig = new ConfigWithDefaults();
        assertNotNull(mockConfig);
        assertEquals("DEFAULT_STRING", mockConfig.getFooAsString("missing"));
    }

    @Test
    public void testDefaultBoolean() throws ConfigurationNotLoaded {
        final ConfigWithDefaults mockConfig = new ConfigWithDefaults();
        assertNotNull(mockConfig);
        assertEquals(true, mockConfig.getTrueAsBoolean("missing"));
        assertEquals(false, mockConfig.getFalseAsBoolean("missing"));
    }

    @Test
    public void testDefaultInt() throws ConfigurationNotLoaded {
        final ConfigWithDefaults mockConfig = new ConfigWithDefaults();
        assertNotNull(mockConfig);
        assertEquals(Integer.MAX_VALUE, mockConfig.getMax("missing"));
        assertEquals(Integer.MIN_VALUE, mockConfig.getMin("missing"));
    }

}
