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

package net.atf4j.data;

import java.io.FileNotFoundException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import net.atf4j.core.ResourceNotLoadedException;
import net.atf4j.core.TestResultsReporting;

/**
 * Unit Test for CsvFile class.
 */
public class CsvFileTest extends TestResultsReporting {

    private static final String EXPECTED_HEADER = "HeaderLine [fields=[ColumnOne, ColumnTwo, ColumnThree, ColumnFour]]";
    private static final String MISSING_CSV = "missing.csv";
    private static final String TEST_DATA_CSV = "TestData.csv";

    public class TestData extends CsvFile {
        public TestData() {
            super();
        }
    }

    /**
     * Test method for CsvFile.
     *
     * @throws Exception the exception
     */
    @Test
    public void testExpectedUsage() throws Exception {
        final TestData testData = new TestData();
        this.log.debug(testData.toString());
        assertNotNull(testData);
        verifyContent(testData);
    }

    /**
     * Test constructor with data present.
     *
     * @throws Exception the exception
     */
    @Test
    public void testConstructorWithDataPresent() throws Exception {
        final CsvFile csvFile = new CsvFile(TEST_DATA_CSV);
        verifyNotNull(csvFile);
        verifyContent(csvFile);
    }

    /**
     * Test constructor with missing file.
     *
     * @throws FileNotFoundException the file not found exception
     */
    @Test(expected = ResourceNotLoadedException.class)
    public void testConstructorWithMissingFile() throws ResourceNotLoadedException {
        new CsvFile(MISSING_CSV);
        fail("expected FileNotFoundException");
    }

    /**
     * Test read missing file.
     *
     * @throws FileNotFoundException the file not found exception
     */
    @Test(expected = ResourceNotLoadedException.class)
    public void testReadMissingFile() throws ResourceNotLoadedException {
        CsvFile.read(MISSING_CSV);
        fail("expected FileNotFoundException");
    }

    /**
     * Test load missing file.
     *
     * @throws FileNotFoundException the file not found exception
     */
    @Test(expected = ResourceNotLoadedException.class)
    public void testLoadMissingFile() throws ResourceNotLoadedException {
        final CsvFile csvFile = new CsvFile();
        verifyNotNull(csvFile);
        csvFile.load(MISSING_CSV);
        fail("expected FileNotFoundException");
    }

    /**
     * Test read present data.
     *
     * @throws Exception the exception
     */
    @Test
    public void testReadTestData() throws Exception {
        final CsvFile csvFile = CsvFile.read(TEST_DATA_CSV);
        verifyNotNull(csvFile);
        verifyContent(csvFile);
    }

    /**
     * Verify CsvFile object.
     *
     * @param csvFile the csv file
     */
    private void verifyContent(final CsvFile csvFile) {
        verifyNotNull(csvFile);
        // verifyNotNull(csvFile.getHeaderLine());
        for (int row = 1; row < csvFile.rowCount(); row++) {
            final CsvRow csvRow = csvFile.row(row);
            verifyNotNull(csvRow);
            for (int col = 1; col < csvRow.length(); col++) {
                final String expected = String.format("data-%s-%s", row, col);
                final String actual = csvRow.getField(col);
                assertEquals(expected, actual);
            }
        }
    }
}
