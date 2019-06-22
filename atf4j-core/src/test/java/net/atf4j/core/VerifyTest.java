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

import static net.atf4j.core.Verify.verifyEqual;
import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * Unit test for the Verify class.
 */
@Slf4j
public final class VerifyTest {

    /**
     * Verify not null.
     */
    @Test
    public void testVerifyNotNull() {
        verifyNotNull(this);
    }

    /**
     * Unit Test to verify object not null.
     */
    @Test(expected = VerificationError.class)
    public void testVerifyNotNullWithNull() {
        verifyNotNull(null);
    }

    /**
     * Verify not null with message.
     */
    @Test
    public void testVerifyNotNullMessage() {
        verifyNotNull(this, "Message.");
    }

    /**
     * Verify not null message with null.
     */
    @Test(expected = VerificationError.class)
    public void testVerifyNotNullMessageWithNull() {
        verifyNotNull(null, "Message.");
    }

    /**
     * Unit Test to verify equal byte.
     */
    @Test
    public void testVerifyEqualByte() {
        final byte expected = Byte.MAX_VALUE;
        verifyEqual(expected, expected);
    }

    /**
     * Test verify not equal byte.
     */
    @Test(expected = AssertionError.class)
    public void testVerifyNotEqualByte() {
        final byte actual = Byte.MAX_VALUE;
        final byte expected = Byte.MIN_VALUE;
        verifyEqual(expected, actual);
    }

    /**
     * Test verify equal char.
     */
    @Test
    public void testVerifyEqualChar() {
        final char expected = 'a';
        verifyEqual(expected, expected);
    }

    /**
     * Test verify not equal char.
     */
    @Test(expected = AssertionError.class)
    public void testVerifyNotEqualChar() {
        final char actual = 'a';
        final char expected = 'z';
        verifyEqual(expected, actual);
    }

    /**
     * Test verify equal int.
     */
    @Test
    public void testVerifyEqualInt() {
        final int expected = Integer.MAX_VALUE;
        verifyEqual(expected, expected);
    }

    /**
     * Test verify not equal int.
     */
    @Test(expected = AssertionError.class)
    public void testVerifyNotEqualInt() {
        final int actual = Integer.MIN_VALUE;
        final int expected = Integer.MAX_VALUE;
        verifyEqual(expected, actual);
    }

    /**
     * Test verify equal long.
     */
    @Test
    public void testVerifyEqualLong() {
        final long expected = Long.MAX_VALUE;
        verifyEqual(expected, expected);
    }

    /**
     * Test verify not equals long.
     */
    @Test(expected = AssertionError.class)
    public void testVerifyNotEqualsLong() {
        verifyEqual(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Verify equal objects.
     */
    @Test
    public void testVerifyEqualObjects() {
        final Object expected = new Object();
        verifyEqual(expected, expected);
    }

    /**
     * Verify not equal objects.
     */
    @Test(expected = AssertionError.class)
    public void testVerifyNotEqualObjects() {
        final Object actual = new Object();
        final Object expected = new Object();
        verifyEqual(expected, actual);
    }

}
