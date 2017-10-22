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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * A UnitTest for Atf4jException objects.
 */
public final class Atf4jExceptionTest extends TestResultsReporting {

    private static final String EXCEPTION_MESSAGE = "Force a Atf4jException";

    /**
     * test Atf4jException object.
     *
     * @throws Atf4jException the atf4j exception
     */
    @Test(expected = Atf4jException.class)
    public void testAtf4jException() throws Atf4jException {
        throw new Atf4jException();
    }

    /**
     * Test method for Atf4jException.
     *
     * @throws Atf4jException the Atf4j exception
     */
    @Test(expected = Atf4jException.class)
    public void testAtf4jExceptionString() throws Atf4jException {
        try {
            throw new Atf4jException(EXCEPTION_MESSAGE);
        } catch (final Atf4jException e) {
            log.debug(e.toString());
            assertEquals(EXCEPTION_MESSAGE, e.getMessage());
            assertEquals(EXCEPTION_MESSAGE, e.getLocalizedMessage());
            throw e;
        }
    }

    /**
     * Test method for Atf4jException.
     *
     * @throws Atf4jException the Atf4j exception
     */
    @Test(expected = Atf4jException.class)
    public void testAtf4jExceptionAssertion() throws Atf4jException {
        try {
            throw new Atf4jException(new AssertionError(EXCEPTION_MESSAGE));
        } catch (final Atf4jException e) {
            log.debug(e.toString());
            assertTrue(e.getMessage().contains(EXCEPTION_MESSAGE));
            assertTrue(e.getMessage().contains("java.lang.AssertionError"));
            throw e;
        }
    }
}
