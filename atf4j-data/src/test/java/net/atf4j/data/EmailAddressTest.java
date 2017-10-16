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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A Unit test class for EmailAddress objects.
 */
public final class EmailAddressTest extends TestResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";
    private static final String NAME_EXAMPLE_COM = "name@example.com";

    /**
     * Unit Test for test expected.
     */
    @Test
    public void testExpected() {
        final EmailAddress emailAddress = new EmailAddress();
        this.log.info(emailAddress.toString());

        final EmailAddress atExample = EmailAddress.at("example.com");
        this.log.info(atExample.toString());
    }

    /**
     * Test method for EmailAddress.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(UNEXPECTED_NULL, new EmailAddress());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        final EmailAddress emailAddress = EmailAddress.create();
        assertNotNull(UNEXPECTED_NULL, emailAddress);
        final String string = emailAddress.toString();
        this.log.info(string);
    }

    /**
     * Test method for EmailAddress.
     */
    @Test
    public void testEmailAddressString() {
        this.log.info(new EmailAddress(NAME_EXAMPLE_COM).toString());
    }

    /**
     * Test method for EmailAddress.
     */
    @Test
    public void testVerify() {
        this.log.info(new EmailAddress(NAME_EXAMPLE_COM).toString());
    }

    /**
     * Test method for EmailAddress.
     */
    @Test
    public void testToString() {
        final EmailAddress emailAddress = new EmailAddress();
        assertNotNull(UNEXPECTED_NULL, emailAddress);
        final String string = emailAddress.toString();
        assertNotNull(UNEXPECTED_NULL, string);
        this.log.info(string);
    }

}
