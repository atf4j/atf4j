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

import org.junit.Test;

/**
 * Unit test for the Verify class.
 */
public final class VerifyTest {

    /**
     * Unit Test to verify object not null.
     */
    @Test
    public void verifyNotNull() {
        Verify.verifyNotNull(null);
    }

    @Test
    public void verifyNotNullMessage() {
        Verify.verifyNotNull(null, "Message.");
    }

    /**
     * Unit Test to verify equal byte.
     */
    @Test
    public void verifyEqualByte() {
        final byte expected = Byte.MAX_VALUE;
        Verify.verifyEqual(expected, expected);
    }

    /**
     * Test verify not equal byte.
     */
    @Test(expected = AssertionError.class)
    public void verifyNotEqualByte() {
        final byte actual = Byte.MAX_VALUE;
        final byte expected = Byte.MIN_VALUE;
        Verify.verifyEqual(expected, actual);
    }

    /**
     * Test verify equal char.
     */
    @Test
    public void verifyEqualChar() {
        final char expected = 'a';
        Verify.verifyEqual(expected, expected);
    }

    /**
     * Test verify not equal char.
     */
    @Test(expected = AssertionError.class)
    public void verifyNotEqualChar() {
        final char actual = 'a';
        final char expected = 'z';
        Verify.verifyEqual(expected, actual);
    }

    /**
     * Test verify equal int.
     */
    @Test
    public void verifyEqualInt() {
        final int expected = Integer.MAX_VALUE;
        Verify.verifyEqual(expected, expected);
    }

    /**
     * Test verify not equal int.
     */
    @Test(expected = AssertionError.class)
    public void verifyNotEqualInt() {
        final int actual = Integer.MIN_VALUE;
        final int expected = Integer.MAX_VALUE;
        Verify.verifyEqual(expected, actual);
    }

    /**
     * Test verify equal long.
     */
    @Test
    public void verifyEqualLong() {
        final long expected = Long.MAX_VALUE;
        Verify.verifyEqual(expected, expected);
    }

    /**
     * Test verify not equals long.
     */
    @Test(expected = AssertionError.class)
    public void verifyNotEqualsLong() {
        Verify.verifyEqual(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Verify equal objects.
     */
    @Test
    public void verifyEqualObjects() {
        final Object expected = new Object();
        Verify.verifyEqual(expected, expected);
    }

    /**
     * Verify not equal objects.
     */
    @Test(expected = AssertionError.class)
    public void verifyNotEqualObjects() {
        final Object actual = new Object();
        final Object expected = new Object();
        Verify.verifyEqual(expected, actual);
    }

}
