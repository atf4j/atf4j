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

import org.junit.Assert;
import org.junit.Test;

import net.atf4j.core.AbstractConfig.ConfigurationNotLoaded;
import net.atf4j.core.AbstractConfig.PropertyNotFound;

/**
 * ConfigLoadingTests Class.
 */
public class ConfigLoadingTests extends ResultsReporting {

    /**
     * The SimpleConfiguration Class.
     */
    private class SimpleConfiguration extends AbstractConfig {

        /**
         * Instantiates a new simple configuration.
         *
         * @throws ConfigurationNotLoaded
         *             the configuration not loaded
         */
        public SimpleConfiguration() throws ConfigurationNotLoaded {
            super();
        }

        /**
         * Gets the property filename.
         * @return the property filename
         * @throws PropertyNotFound the property not found
         */
        public String getPropertyFilename() throws PropertyNotFound {
            this.log.info("getPropertyFilename");
            final String propertiesFilename = get("propertiesFilename");
            this.log.info(propertiesFilename);
            return propertiesFilename;
        }

        /* (non-Javadoc)
         * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String)
         */
        @Override
        public String valueFor(final String key) {
            // TODO Auto-generated method stub
            return null;
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
        new SimpleConfiguration();
    }

    /**
     * Test suggested usage.
     * @throws ConfigurationNotLoaded the configuration not loaded
     * @throws PropertyNotFound the property not found
     */
    @Test
    public void testSuggestedUsage() throws ConfigurationNotLoaded, PropertyNotFound {
        final SimpleConfiguration simpleConfig = new SimpleConfiguration();
        final String propertyFilename = simpleConfig.getPropertyFilename();
        Assert.assertEquals("/SimpleConfiguration.properties", propertyFilename);
    }

}
