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

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A UnitTest for HeaderLine objects.
 */
public class HeaderLineTest {

    /** The logger. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * test HeaderLine object.
     */
    @Test
    public void testBlankHeaderLine() {
        final HeaderLine headerLine = new HeaderLine("");
        assertEquals("HeaderLine [fields=[]]", headerLine.toString());
    }

    /**
     * test HeaderLine object.
     */
    @Test
    public void testHeaderLine() {
        final HeaderLine headerLine = new HeaderLine("ColumnOne,ColumnTwo");
        final String headerLineString = headerLine.toString();
        assertEquals("HeaderLine [fields=[ColumnOne, ColumnTwo]]", headerLineString);
        assertEquals("ColumnOne", headerLine.getField(1));
        assertEquals("ColumnTwo", headerLine.getField(2));
    }

}
