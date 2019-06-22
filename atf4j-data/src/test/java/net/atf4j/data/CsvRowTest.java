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

import java.util.Iterator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * A UnitTest for CsvRow objects.
 */
public class CsvRowTest {

    private static final String TEST_ROW = "One, Two, Three, Four";
    private static final String EXPECTED = "CsvRow [values=[One, Two, Three, Four]]";

    @Test
    public void testDefaultCsvRow() {
        final CsvRow csvRow = new CsvRow();
        assertNotNull(csvRow);
        assertTrue(csvRow.isEmpty());
        assertEquals(0, csvRow.length());
    }

    @Test
    public void testEmptyCsvRow() {
        final CsvRow csvRow = new CsvRow("");
        assertNotNull(csvRow);
        assertEquals(1, csvRow.length());
    }

    @Test
    public void testCsvRow() {
        final CsvRow csvRow = new CsvRow(TEST_ROW);
        assertNotNull(csvRow);
        assertEquals(4, csvRow.length());
        assertEquals(TEST_ROW, csvRow.toString());
        assertEquals(EXPECTED, csvRow.debugString());
    }

    @Test
    public void testSetGetClearField() {
        final CsvRow csvRow = new CsvRow(TEST_ROW);
        assertNotNull(csvRow);
        assertEquals(csvRow, csvRow.setField(1, "One"));
        assertEquals(csvRow, csvRow.setField(2, "Two"));
        assertEquals(csvRow, csvRow.setField(3, "Three"));
        assertEquals(csvRow, csvRow.setField(4, "Four"));
        assertEquals(4, csvRow.length());

        assertEquals("One", csvRow.getField(1));
        assertEquals("Two", csvRow.getField(2));
        assertEquals("Three", csvRow.getField(3));
        assertEquals("Four", csvRow.getField(4));
        assertEquals(4, csvRow.length());

        assertEquals("One", csvRow.clearField(1));
        assertEquals("Two", csvRow.clearField(2));
        assertEquals("Three", csvRow.clearField(3));
        assertEquals("Four", csvRow.clearField(4));
        assertEquals(4, csvRow.length());
    }

    @Test
    public void testAddRemoveField() {
        final CsvRow csvRow = new CsvRow();
        assertNotNull(csvRow);
        assertEquals(0, csvRow.length());
        assertEquals(csvRow, csvRow.addField("One"));
        assertEquals(csvRow, csvRow.addField("Two"));
        assertEquals(csvRow, csvRow.addField("Three"));
        assertEquals(csvRow, csvRow.addField("Four"));
        assertEquals(4, csvRow.length());
        assertEquals("Four", csvRow.removeField(4));
        assertEquals("Three", csvRow.removeField(3));
        assertEquals("Two", csvRow.removeField(2));
        assertEquals("One", csvRow.removeField(1));
        assertEquals(0, csvRow.length());
    }

    @Test
    public void testGetFields() {
        final CsvRow csvRow = new CsvRow(TEST_ROW);
        final String[] fields = csvRow.getFields();
        assertNotNull(fields);
        assertEquals(4, fields.length);
    }

    @Test
    public void testIterator() {
        final CsvRow csvRow = new CsvRow(TEST_ROW);
        Iterator<String> iterator = csvRow.iterator();
        assertNotNull(iterator);
        while (iterator.hasNext()) {
            assertNotNull(iterator.next());
        }
    }

    @Test
    public void testToString() {
        final CsvRow csvRow = new CsvRow(TEST_ROW);
        assertNotNull(csvRow);
        assertEquals(TEST_ROW, csvRow.toString());
        assertEquals(EXPECTED, csvRow.debugString());
    }

}
