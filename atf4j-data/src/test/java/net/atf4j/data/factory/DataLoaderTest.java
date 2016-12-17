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
package net.atf4j.data.factory;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.Reporting;
import net.atf4j.data.AbstractDataLoader;

/**
 * The Class DataLoaderTest.
 */
public class DataLoaderTest extends Reporting {

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * The Class MissingData.
     */
    protected class MissingData extends AbstractDataLoader {
    }

    /**
     * The Class TestData.
     */
    protected class TestData extends AbstractDataLoader {
    }

    /**
     * Test missing data.
     */
    @Test
    public void testMissingData() {
        final MissingData missingData = new MissingData();
        Assert.assertNotNull(missingData);
    }

    /**
     * Test load data.
     *
     * @throws Exception
     */
    @Test
    public void testLoadData() throws Exception {
        final TestData testData = new TestData();
        Assert.assertNotNull(testData);
        Assert.assertNotNull(testData.load());
    }

}
