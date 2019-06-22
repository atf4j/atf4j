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

package net.atf4j.core;

import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import lombok.extern.slf4j.Slf4j;

/**
 * The Atf4jTest class.
 */
@Slf4j
public class Atf4jTest {

    /**
     * When the code uses business domain language in method calls.
     * The method <code>Atf4j.document();</code> will provide a
     * plausible natural language description of the scenario that
     * lead to the current situation.
     */
    @Test
    public void testDocument() {
        Atf4j.start();
        Atf4j.document();
        Atf4j.end();
    }

    /**
     * Test start end.
     */
    @Test
    public void testStartEnd() {
        Atf4j.start();
        verifyNotNull(this);
        Atf4j.end();
    }

    /**
     * Unit test to unroll.
     */
    @Test
    public void testUnroll() {
        final String input = "aLongStringToUnrollIntoASentence";
        final String expected = "A long string to unroll into a sentence.";
        final String unrolled = Atf4j.unroll(input);
        assertEquals(expected, unrolled);
        log.info(unrolled);
    }

    /**
     * Unit test to unroll empty.
     */
    @Test
    public void testUnrollEmpty() {
        log.info(Atf4j.unroll(""));
        log.info(Atf4j.unroll("_"));
        log.info(Atf4j.unroll("a"));
        log.info(Atf4j.unroll("_a"));
        log.info(Atf4j.unroll("A"));
        log.info(Atf4j.unroll("_A"));
    }

    /**
     * Unit test to unroll null.
     */
    @Test
    public void testUnrollNull() {
        log.info(Atf4j.unroll(null));
    }

}
