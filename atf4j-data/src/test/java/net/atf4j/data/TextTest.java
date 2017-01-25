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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for Text objects.
 */
public class TextTest extends ResultsReporting {

    /**
     * Test expected usage.
     */
    @Test
    public void testExpected() {
        this.log.info(Text.fill(10));
        this.log.info(Text.fill(10, '*'));
    }

    /**
     * Unit Test for test capitalise.
     */
    @Test
    public void testCapitalise() {
        assertEquals("Set", Text.capitalise("Set"));
        assertEquals("Set", Text.capitalise("Set"));
        assertEquals("Set.", Text.capitalise("sET."));
        assertEquals("Set.", Text.capitalise("sET."));
    }

    /**
     * Unit Test for test fill int.
     */
    @Test
    public void testFillInt() {
        assertEquals("", Text.fill(0));
        assertEquals(" ", Text.fill(1));
        assertEquals("  ", Text.fill(2));
    }

    /**
     * Unit Test for test fill int char.
     */
    @Test
    public void testFillIntChar() {
        assertEquals("", Text.fill(0, '*'));
        assertEquals("*", Text.fill(1, '*'));
        assertEquals("**", Text.fill(2, '*'));
    }

    /**
     * Unit Test for test pad to length string int.
     */
    @Test
    public void testPadToLengthStringInt() {
        assertEquals("Stem ", Text.padToLength("Stem", 5));
    }

    /**
     * Unit Test for test pad to length string int char.
     */
    @Test
    public void testPadToLengthStringIntChar() {
        assertEquals("Stem*", Text.padToLength("Stem", 5, '*'));
    }

}
