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

package net.atf4j.core.model;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;
import net.atf4j.fdd.model.FailSuite;

/**
 * A UnitTest for FailSuite objects.
 */
public class FailSuiteTest extends TestResultsReporting {

    /**
     * Unit Test for test fail case.
     */
    @Test
    public void testFailSuite() {
        verifyNotNull(new FailSuite());
    }

    /**
     * Test fail suite null.
     */
    @Test
    public void testFailSuiteNull() {
        verifyNotNull(new FailSuite(null));
    }

    /**
     * Test fail suite string.
     */
    @Test
    public void testFailSuiteString() {
        verifyNotNull(new FailSuite("FailSuite"));
    }

}
