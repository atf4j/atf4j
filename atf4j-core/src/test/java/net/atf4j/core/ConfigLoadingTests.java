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

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

import net.atf4j.core.AbstractConfig.MissingPropertyFileException;

/**
 * ConfigLoadingTests Class.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class ConfigLoadingTests extends LoggedTest {

    /**
     * MissingPropertiesMock Class.
     */
    private class MissingProperties extends AbstractConfig {
        public MissingProperties() throws MissingPropertyFileException {
            super();
        }
    }

    private class SimpleConfiguration extends AbstractConfig {
        public SimpleConfiguration() throws MissingPropertyFileException {
            super();
        }

        public String getPropertyFilename() {
            logger.info(get("loaded"));
            final String propertiesFilename = super.get("propertiesFilename");
            logger.info(propertiesFilename);
            return propertiesFilename;
        }
    }

    /**
     * Test method for {@link net.atf4j.core.AbstractConfig#Config()}.
     *
     * @throws MissingPropertyFileException
     *             the missing property file exception
     */
    @Test(expected = MissingPropertyFileException.class)
    public void testConfig() throws MissingPropertyFileException {
        new MissingProperties();
    }

    /**
     * Test method for {@link net.atf4j.core.AbstractConfig#load()}.
     *
     * @throws MissingPropertyFileException
     *             the missing property file exception
     */
    @Test(expected = MissingPropertyFileException.class)
    public void testLoad() throws MissingPropertyFileException {
        final AbstractConfig mockConfig = new MissingProperties();
        assertNotNull(mockConfig);
        log.info(mockConfig.toString());
    }

    @Test
    public void testSuggestedUsage() throws MissingPropertyFileException {
        final SimpleConfiguration simpleConfig = new SimpleConfiguration();
        final String propertyFilename = simpleConfig.getPropertyFilename();
        Assert.assertEquals("/SimpleConfiguration.properties", propertyFilename);
    }

}
