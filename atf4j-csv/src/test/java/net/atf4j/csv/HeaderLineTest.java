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

package net.atf4j.csv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A UnitTest for HeaderLine objects.
 */
public class HeaderLineTest {

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private static final String HEADER_LINE = "ColumnOne, ColumnTwo";
    private static final String EXPECTED_HEADER = "HeaderLine [fields=[ColumnOne, ColumnTwo]]";

    /**
     * test HeaderLine object.
     */
    @Test
    public void testBlankHeaderLine() {
        final HeaderLine headerLine = new HeaderLine("");
        assertNotNull("unexpected null", headerLine);
        assertEquals(1, headerLine.length());
        this.log.info(headerLine.toString());
    }

    /**
     * test HeaderLine object.
     */
    @Test
    public void testHeaderConstructor() {
        final HeaderLine headerLine = new HeaderLine(HEADER_LINE);
        assertNotNull("unexpected null", headerLine);
        assertEquals(2, headerLine.length());
        final String headerLineString = headerLine.debugString();
        assertEquals(EXPECTED_HEADER, headerLineString);
        assertEquals("ColumnOne", headerLine.getField(1));
        assertEquals("ColumnTwo", headerLine.getField(2));
        this.log.info(headerLine.toString());
    }

    /**
     * test HeaderLine object.
     */
    @Test
    public void testHeaderLine() {
        final HeaderLine headerLine = new HeaderLine();
        assertNotNull("unexpected null", headerLine);
        assertEquals(0, headerLine.length());
        headerLine.initialise(HEADER_LINE);
        assertEquals(2, headerLine.length());
        final String headerLineString = headerLine.debugString();
        assertEquals(EXPECTED_HEADER, headerLineString);
        assertEquals("ColumnOne", headerLine.getField(1));
        assertEquals("ColumnTwo", headerLine.getField(2));
        this.log.trace(headerLine.toString());
    }

}
