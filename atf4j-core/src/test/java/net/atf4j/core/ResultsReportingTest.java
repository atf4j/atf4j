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
package net.atf4j.core;

import org.junit.Test;

/**
 * A UnitTest for Reporting Test Results.
 */
public class ResultsReportingTest extends ResultsReporting {

    /**
     * Test method for {@link ResultsReporting}.
     */
    @Test
    public void testVerifyEqualLong() {
        final long expected = Long.MAX_VALUE;
        super.verify(expected, expected);
    }

    /**
     * Test method for {@link ResultsReporting}.
     */
    @Test(expected = AssertionError.class)
    public void testVerifyLongLong() {
        super.verify(Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Test method for {@link ResultsReporting}.
     */
    @Test
    public void testVerifyEqual() {
        final Object expected = new Object();
        super.verify(expected, expected);
    }

    /**
     * Test method for {@link ResultsReporting}.
     */
    @Test(expected = AssertionError.class)
    public void testVerifyNotEqual() {
        super.verify(new Object(), new Object());
    }

    /**
     * Test method for {@link ResultsReporting}.
     *
     * @throws ClassNotFoundException the class not found exception
     */
    @Test
    public void testToDescription() throws ClassNotFoundException {
        this.log.info(super.toDescription());
    }

}
