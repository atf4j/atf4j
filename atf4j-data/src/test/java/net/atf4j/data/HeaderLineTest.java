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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import net.atf4j.core.TestResultsReporting;

/**
 * A UnitTest for HeaderLine objects.
 */
public class HeaderLineTest extends TestResultsReporting {

    private static final String TEST_HEADER = "ColumnOne, ColumnTwo";
    private static final String EXPECTED_HEADER = "HeaderLine [values=[ColumnOne, ColumnTwo]]";

    @Test
    public void testNullHeaderLine() {
        final HeaderLine headerLine = new HeaderLine(null);
        verifyNotNull(headerLine);
        assertEquals(0, headerLine.length());
    }

    @Test
    public void testBlankHeaderLine() {
        final HeaderLine headerLine = new HeaderLine("");
        verifyNotNull(headerLine);
        assertEquals(1, headerLine.length());
    }

    @Test
    public void testHeaderLine() {
        final HeaderLine headerLine = new HeaderLine(TEST_HEADER);
        verifyNotNull(headerLine);
        assertEquals(2, headerLine.length());
        assertEquals(TEST_HEADER, headerLine.toString());
        assertEquals(EXPECTED_HEADER, headerLine.debugString());
        assertEquals("ColumnOne", headerLine.getField(1));
        assertEquals("ColumnTwo", headerLine.getField(2));
        this.log.info("{}", headerLine);
    }

}
