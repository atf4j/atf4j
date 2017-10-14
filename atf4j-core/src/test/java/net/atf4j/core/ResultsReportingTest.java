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
public class ResultsReportingTest extends ResultsReporting {

    /**
     * Test method for ResultsReporting}.
     */
    @Test
    public void testVerifyEqualObjects() {
        final Object expected = new Object();
        super.verifyEquals(expected, expected);
    }

    /**
     * Test method for ResultsReporting}.
     */
    @Test
    public void testVerifyNotEqualObjects() {
        try {
            super.verifyEquals(new Object(), new Object());
        } catch (final AssertionError assertionError) {
            final String actualMessage = assertionError.toString();
            assertNotNull("unexpected null",actualMessage);
            this.log.info(actualMessage);
        }
    }

    /**
     * Test method for ResultsReporting}.
     */
    @Test
    public void testVerifyEqualLongs() {
        final long expected = Long.MAX_VALUE;
        super.verifyEquals(expected, expected);
    }

    /**
     * Test method for ResultsReporting}.
     */
    @Test
    public void testVerifyNotEqualsLong() {
        try {
            super.verifyEquals(Long.MIN_VALUE, Long.MAX_VALUE);
        } catch (final AssertionError assertionError) {
            final String actualMessage = assertionError.toString();
            assertNotNull("unexpected null",actualMessage);
            this.log.info(actualMessage);
        }
    }

    /**
     * Test method for ResultsReporting}.
     */
    @Test
    public void testToDescription() {
        final String description = super.toDescription();
        assertNotNull("unexpected null",description);
        this.log.info(description);
    }

}
