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

import net.atf4j.core.ResultsReporting;

/**
 * A Unit test class for Bag objects.
 */
public final class SimpleBagTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test method for SimpleBag.
     */
    @Test
    public void testNullBag() {
        assertNotNull(UNEXPECTED_NULL, new SimpleBag(null));
    }

    /**
     * Test method for SimpleBag.
     */
    @Test
    public void testEmptyBag() {
        final SimpleBag bag = new SimpleBag(new String[0]);
        assertNotNull(UNEXPECTED_NULL, bag);
        assertEquals(0, bag.count());
        assertEquals(0, bag.clear().count());
        assertEquals(0, bag.reset().count());
    }

    /**
     * Test method for SimpleBag.
     */
    @Test
    public void testBag() {
        final String[] pets = { "Fish", "Cat", "Dog", "Rabbit", "Bird" };
        final SimpleBag bag = new SimpleBag(pets);
        assertNotNull(UNEXPECTED_NULL, bag);
        assertEquals(5, bag.count());
        assertEquals(0, bag.clear().count());
        assertEquals(5, bag.reset().count());
        while (!bag.isEmpty()) {
            assertNotNull(UNEXPECTED_NULL, bag.pick());
        }
        bag.clear().reset();
    }

    /**
     * Test method for SimpleBag.
     */
    @Test
    public void testDebugString() {
        final String string = new SimpleBag().debugString();
        assertNotNull(UNEXPECTED_NULL, string);
    }

    /**
     * Test method for SimpleBag.
     */
    @Test
    public void testToString() {
        final String string = new SimpleBag().toString();
        assertNotNull(UNEXPECTED_NULL, string);
    }

}
