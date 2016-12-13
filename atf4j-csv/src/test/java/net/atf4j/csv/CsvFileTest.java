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
package net.atf4j.csv;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class CsvFileTest.
 */
public class CsvFileTest {
    protected static final Logger log = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    /** The Constant MISSING_CSV. */
    private static final String MISSING_CSV = "missing.csv";

    /** The Constant TEST_DATA_CSV. */
    private static final String TEST_DATA_CSV = "TestData.csv";

    /**
     * Test constructor with missing file.
     *
     * @throws Exception
     *             the exception
     */
    @Test(expected = FileNotFoundException.class)
    public void testConstructorWithMissingFile() throws Exception {
        final CsvFile csvFile = new CsvFile(MISSING_CSV);
        assertNotNull(csvFile);
    }

    /**
     * Test read missing file.
     *
     * @throws Exception
     *             the exception
     */
    @Test(expected = FileNotFoundException.class)
    public void testReadMissingFile() throws Exception {
        final CsvFile data = CsvFile.read(MISSING_CSV);
        assertNotNull(data);
    }

    /**
     * Test load missing file.
     *
     * @throws Exception
     *             the exception
     */
    @Test(expected = FileNotFoundException.class)
    public void testLoadMissingFile() throws Exception {
        final CsvFile csvFile = new CsvFile();
        csvFile.load(MISSING_CSV);
    }

    /**
     * Test constructor with data present.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testConstructorWithDataPresent() throws Exception {
        final CsvFile csvFile = new CsvFile(TEST_DATA_CSV);
        Assert.assertNotNull(csvFile);
        log.info(csvFile.toString());
    }

    /**
     * Test read present data.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testReadPresentData() throws Exception {
        final CsvFile csvFile = CsvFile.read(TEST_DATA_CSV);
        Assert.assertNotNull(csvFile);
        log.info(csvFile.toString());
    }

    /**
     * Test load present data.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testLoadPresentData() throws Exception {
        final CsvFile csvFile = new CsvFile();
        Assert.assertNotNull(csvFile);
        csvFile.load(TEST_DATA_CSV);
        log.info(csvFile.toString());
    }

}
