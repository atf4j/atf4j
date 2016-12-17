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

import org.junit.Assert;
import org.junit.Test;

import net.atf4j.core.AbstractConfig.ConfigurationNotLoaded;

/**
 * ConfigLoadingTests Class.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class ConfigLoadingTests extends Reporting {

    private class SimpleConfiguration extends AbstractConfig {
        public SimpleConfiguration() throws ConfigurationNotLoaded {
            super();
        }

        public String getPropertyFilename() {
            this.log.info(get("loaded"));
            final String propertiesFilename = super.get("propertiesFilename");
            this.log.info(propertiesFilename);
            return propertiesFilename;
        }
    }

    @Test
    public void testSuggestedUsage() throws ConfigurationNotLoaded {
        final SimpleConfiguration simpleConfig = new SimpleConfiguration();
        final String propertyFilename = simpleConfig.getPropertyFilename();
        Assert.assertEquals("/SimpleConfiguration.properties", propertyFilename);
    }

}
