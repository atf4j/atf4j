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
package net.atf4j.webdriver;

import java.util.Enumeration;
import java.util.MissingResourceException;

import org.junit.Assert;
import org.junit.Test;

import net.atf4j.core.LoggedTest;

/**
 * LogicalGuiMapTest
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class LogicalGuiMapTest extends LoggedTest {

    public class LogicalGuiMap extends AbstractGuiMap {
    }

    /**
     * Test method for {@link net.atf4j.webdriver.AbstractGuiMap#getKeys()}.
     */
    @Test(expected = MissingResourceException.class)
    public final void testGuiMapping() {
        final AbstractGuiMap instance = new LogicalGuiMap();
        final Enumeration<String> bundleKeys = instance.getKeys();
        while (bundleKeys.hasMoreElements()) {
            final String key = bundleKeys.nextElement();
            Assert.assertNotNull(key);
            Assert.assertTrue(instance.containsKey(key));
            final String value = instance.getString(key);
            Assert.assertNotNull(value);
        }
    }
}
