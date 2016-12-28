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
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for LogicalGuiMap objects.
 *
 *
 */

public class AbstractGuiMapTest extends ResultsReporting {

    public class LogicalGuiMap extends AbstractGuiMap {
    }

    public class MissingGuiMap extends AbstractGuiMap {
    }

    /**
     * test AbstractGuiMap object.
     */
    @Test(expected = MissingResourceException.class)
    public final void testMissingGuiMapping() {
        new MissingGuiMap();
    }

    /**
     * Test method for { net.atf4j.webdriver.AbstractGuiMap#getKeys()}.
     */
    @Test
    public final void testGuiMapping() {
        final AbstractGuiMap instance = new LogicalGuiMap();
        final Enumeration<String> bundleKeys = instance.getKeys();
        while (bundleKeys.hasMoreElements()) {
            final String key = bundleKeys.nextElement();
            Assert.assertNotNull(key);
            Assert.assertTrue(instance.containsKey(key));
            Assert.assertNotNull(instance.getString(key));
            this.log.info("{}={}", key, instance.getString(key));
        }
    }

    @Test
    public void testToString() throws Exception {
        final AbstractGuiMap abstractGuiMap = new LogicalGuiMap();
        Assert.assertNotNull(abstractGuiMap);
        this.log.info(abstractGuiMap.toString());
        this.log.info(abstractGuiMap.getBaseBundleName());
        this.log.info(abstractGuiMap.getLocale().toString());
    }

    @Test
    public void testKeySet() throws Exception {
        final AbstractGuiMap abstractGuiMap = new LogicalGuiMap();
        Assert.assertNotNull(abstractGuiMap);
        final Set<String> keySet = abstractGuiMap.keySet();
        for (final String key : keySet) {
            final String value = abstractGuiMap.getString(key);
            Assert.assertNotNull(value);
        }
    }

    @Test
    public void testName() throws Exception {
        final AbstractGuiMap abstractGuiMap = new LogicalGuiMap();
        Assert.assertNotNull(abstractGuiMap);
        abstractGuiMap.dumpTo(System.out);
    }

}
