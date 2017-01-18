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
package net.atf4j.webdriver.page;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.AbstractConfig.ConfigurationNotLoaded;

/**
 * PageConfigTest.
 *
 *
 */
public class PageConfigTest {

    /**
     * Mock Page Configuration.
     */
    public class MockPageConfig extends AbstractPageConfig {

        /**
         * Instantiates a new mock page config.
         *
         * @throws ConfigurationNotLoaded
         *             the missing property file exception
         */
        public MockPageConfig() throws ConfigurationNotLoaded {
            super();
        }
    }

    /**
     * Test method for
     * { net.atf4j.webdriver.page.AbstractPageConfig#AbstractPageConfig()}.
     *
     * @throws ConfigurationNotLoaded
     *             the missing property file exception
     */
    @Test
    public final void testPageConfig() throws ConfigurationNotLoaded {
        final AbstractPageConfig pageConfig = new MockPageConfig();
        assertNotNull(pageConfig);
    }
}