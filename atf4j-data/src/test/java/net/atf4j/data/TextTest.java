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
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A Unit test class for Text objects.
 */
public final class TextTest extends TestResultsReporting {

    /**
     * Test expected usage.
     */
    @Test
    public void testTextFill() {
        String fill = Text.fill(10);
        this.log.debug("{}", fill);
        assertNotNull(fill);
        assertEquals(10, fill.length());
    }

    /**
     * Test text fill star.
     */
    @Test
    public void testTextFillStar() {
        String fill = Text.fill(10, '*');
        this.log.debug("{}", fill);
        assertNotNull(fill);
        assertEquals(10, fill.length());
    }

    /**
     * Unit Test for test capitalise.
     */
    @Test
    public void testCapitalise() {
        assertEquals("", Text.capitalise(null));
        assertEquals("", Text.capitalise(""));
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
        String padToLength = Text.padToLength("Stem", 5);
        this.log.debug("{}", padToLength);
        assertEquals(5, padToLength.length());
        assertEquals("Stem ", padToLength);
    }

    /**
     * Unit Test for test pad to length string int char.
     */
    @Test
    public void testPadToLengthStringIntChar() {
        String padToLength = Text.padToLength("Stem", 5, '*');
        this.log.debug("{}", padToLength);
        assertEquals(5, padToLength.length());
        assertEquals("Stem*", padToLength);
    }
}
