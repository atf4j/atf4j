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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * A UnitTest for Reporting Test Results.
 */
public final class ResultsReportingTest extends TestResultsReporting {

    @Test
    public void testVerifyEqualByte() {
        final Byte expected = Byte.MAX_VALUE;
        super.verifyEquals(expected, expected);
    }

    @Test(expected = AssertionError.class)
    public void testVerifyNotEqualByte() {
        Byte actual = Byte.MAX_VALUE;
        Byte expected = Byte.MIN_VALUE;
        super.verifyEquals(expected, actual);
    }

    @Test
    public void testVerifyEqualChar() {
        final char expected = 'a';
        super.verifyEquals(expected, expected);
    }

    @Test(expected = AssertionError.class)
    public void testVerifyNotEqualChar() {
        final char actual = 'a';
        final char expected = 'z';
        super.verifyEquals(expected, actual);
    }

    @Test
    public void testVerifyEqualInt() {
        final int expected = Integer.MAX_VALUE;
        super.verifyEquals(expected, expected);
    }

    @Test(expected = AssertionError.class)
    public void testVerifyNotEqualInt() {
        final int actual = Integer.MIN_VALUE;
        final int expected = Integer.MAX_VALUE;
        super.verifyEquals(expected, actual);
    }

    @Test
    public void testVerifyEqualLong() {
        final long expected = Long.MAX_VALUE;
        super.verifyEquals(expected, expected);
    }

    @Test(expected = AssertionError.class)
    public void testVerifyNotEqualsLong() {
        super.verifyEquals(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Test method for ResultsReporting.
     */
    @Test
    public void testVerifyEqualObjects() {
        final Object expected = new Object();
        super.verifyEquals(expected, expected);
    }

    /**
     * Test method for ResultsReporting.
     */
    @Test(expected = AssertionError.class)
    public void testVerifyNotEqualObjects() {
        Object actual = new Object();
        Object expected = new Object();
        super.verifyEquals(expected, actual);
    }

    /**
     * Test method for ResultsReporting.
     */
    @Test
    public void testToDescription() {
        final String description = super.toDescription();
        assertNotNull(UNEXPECTED_NULL, description);
        this.log.info(description);
    }

}
