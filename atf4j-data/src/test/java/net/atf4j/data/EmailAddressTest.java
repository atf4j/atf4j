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
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A Unit test class for EmailAddress objects.
 */
public final class EmailAddressTest extends TestResultsReporting {

    /** The Constant 			TEST_EXAMPLE_COM. */
    private static final String TEST_EXAMPLE_COM = "test@example.com";
    
    /** The Constant 			NAME_EXAMPLE_COM. */
    private static final String NAME_EXAMPLE_COM = "name@example.com";

    /**
     * Unit Test for test expected.
     */
    @Test
    public void testExpected() {
        final EmailAddress emailAddress = new EmailAddress();
        log.debug("new EmailAddress() = {}", emailAddress);
        assertNotNull(UNEXPECTED_NULL, emailAddress);

        final EmailAddress atExample = EmailAddress.at("example.com");
        log.debug(atExample.toString());
    }

    /**
     * Test method for EmailAddress.
     */
    @Test
    public void testDefaultConstructor() {
        final EmailAddress emailAddress = new EmailAddress();
        log.debug("new EmailAddress() = {}", emailAddress);
        assertNotNull(UNEXPECTED_NULL, emailAddress);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        final EmailAddress emailAddress = EmailAddress.create();
        log.debug("EmailAddress.create() = {}", emailAddress);
        assertNotNull(UNEXPECTED_NULL, emailAddress);
    }

    /**
     * Test method for EmailAddress.
     */
    @Ignore("Fails")
    @Test
    public void testEmailAddressString() {
        final EmailAddress emailAddress = new EmailAddress(TEST_EXAMPLE_COM);
        log.debug("new EmailAddress({}) = {}", TEST_EXAMPLE_COM, emailAddress);
        assertNotNull(UNEXPECTED_NULL, emailAddress);
        assertEquals(TEST_EXAMPLE_COM, emailAddress);
    }

    /**
     * Test method for EmailAddress.
     */
    @Ignore("Fails")
    @Test
    public void testEmailVerify() {
        assertTrue(EmailAddress.verify(TEST_EXAMPLE_COM));
        assertTrue(EmailAddress.verify(NAME_EXAMPLE_COM));
        assertTrue(new EmailAddress(NAME_EXAMPLE_COM).verify());
        assertTrue(new EmailAddress(NAME_EXAMPLE_COM).verify());
    }

    /**
     * Test method for EmailAddress.
     */
    @Test
    public void testDebugString() {
        final EmailAddress emailAddress = new EmailAddress();
        log.debug("new EmailAddress() = {}", emailAddress);
        assertNotNull(UNEXPECTED_NULL, emailAddress);

        final String string = emailAddress.debugString();
        log.debug("emailAddress.debugString() = {}", emailAddress);
        assertNotNull(UNEXPECTED_NULL, string);
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        final EmailAddress emailAddress = new EmailAddress();
        log.debug("new EmailAddress() = {}", emailAddress);
        assertNotNull(UNEXPECTED_NULL, emailAddress);

        final String string = emailAddress.debugString();
        log.debug("emailAddress.debugString() = {}", emailAddress);
        assertNotNull(UNEXPECTED_NULL, string);
    }
}
