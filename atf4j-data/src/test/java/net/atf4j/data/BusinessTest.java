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
 * A Unit test class for Business objects.
 */
public final class BusinessTest extends TestResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test method for Business.
     */
    @Test
    public void testDefaultConstructor() {
        final Business business = new Business();
        assertNotNull(UNEXPECTED_NULL, business);
        this.log.info("{}", business);
    }

    /**
     * Test business.
     */
    @Test
    public void testBusiness() {
        final Business business = new Business();
        assertNotNull(UNEXPECTED_NULL, business);
        this.log.info("{}", business);
    }

    /**
     * Test business string.
     */
    @Test
    public void testBusinessString() {
        final String businessName = "Business Name";
        final Business business = new Business(businessName);
        assertNotNull(UNEXPECTED_NULL, business);
    }

    /**
     * Test business string postcode.
     */
    @Test
    public void testBusinessStringPostcode() {
        final String businessName = "Business Name";
        final PostalAddress postalAddress = new PostalAddress();
        final Business business = new Business(businessName, postalAddress);
        assertNotNull(UNEXPECTED_NULL, business);
        this.log.info("{}", business);
    }

    /**
     * Test create.
     */
    @Test
    public void testCreate() {
        final Business business = Business.create();
        assertNotNull(UNEXPECTED_NULL, business);
    }

    /**
     * Test method for Business.
     */
    @Test
    public void testDebugString() {
        final String string = new Business().debugString();
        assertNotNull(UNEXPECTED_NULL, string);
        this.log.info("{}", string);
    }

    /**
     * Test method for Business.
     */
    @Test
    public void testToString() {
        final String string = new Business().toString();
        assertNotNull(UNEXPECTED_NULL, string);
        this.log.info("{}", string);
    }

}
