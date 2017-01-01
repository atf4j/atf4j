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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import net.atf4j.csv.CsvRow;
import net.atf4j.csv.HeaderLine;

/**
 * A UnitTest for AbstractDataFactory objects.
 */
public class AbstractDataFactoryTest {

    /**
     * Mock Test Data.
     */
    public class TestData extends AbstractDataFactory {
        /**
         * Instantiates a new test data.
         *
         * @throws Exception
         *             the exception
         */
        public TestData() throws Exception {
            super();
        }
    }

    /**
     * The MissingData Class.
     */
    public class MissingData extends AbstractDataFactory {
        /**
         * Instantiates a new test data.
         *
         * @throws Exception
         *             the exception
         */
        public MissingData() throws Exception {
            super();
        }
    }

    /**
     * Test method for {@link AbstractDataFactory}.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testDefaultConstructor() throws Exception {
        assertNotNull(new TestData());
    }

    /**
     * Test method for {@link AbstractDataFactory}.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testLoad() throws Exception {
        final TestData mockDataFactory = new TestData();
        assertNotNull(mockDataFactory);
        assertNotNull(mockDataFactory.load());
    }

    /**
     * Test method for {@link AbstractDataFactory}.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testGetColumnNames() throws Exception {
        final TestData mockDataFactory = new TestData();
        assertNotNull(mockDataFactory);
        final HeaderLine columnNames = mockDataFactory.getColumnNames();
        assertNull(columnNames);
    }

    /**
     * Test method for {@link AbstractDataFactory}.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testGetColumnName() throws Exception {
        final TestData mockDataFactory = new TestData();
        assertNotNull(mockDataFactory);
        final String columnName = mockDataFactory.getColumnName(0);
        assertNotNull(columnName);
    }

    /**
     * Test method for {@link AbstractDataFactory}.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testRowCount() throws Exception {
        final TestData mockDataFactory = new TestData();
        assertNotNull(mockDataFactory);
        final int rowCount = mockDataFactory.rowCount();
        assertNotNull(rowCount);
    }

    /**
     * Test method for {@link AbstractDataFactory}.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testGetRow() throws Exception {
        final TestData mockDataFactory = new TestData();
        assertNotNull(mockDataFactory);
        final CsvRow row = mockDataFactory.getRow(0);
        assertNotNull(row);
    }

}
