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

    /**
     * Test method for Business.
     */
    @Test
    public void testDefaultConstructor() {
        final Business business = new Business();
        log.debug("new Business() = {}", business);
        assertNotNull(UNEXPECTED_NULL, business);
    }

    /**
     * Test business.
     */
    @Test
    public void testBusiness() {
        final Business business = new Business();
        log.debug("new Business() = {}", business);
        assertNotNull(UNEXPECTED_NULL, business);
    }

    /**
     * Test business string.
     */
    @Test
    public void testBusinessString() {
        final String businessName = "Business Name";
        final Business business = new Business(businessName);
        log.debug("new Business(businessName) = {}", business);
        assertNotNull(UNEXPECTED_NULL, business);
    }

    /**
     * Test business string postcode.
     */
    @Test
    public void testBusinessStringPostcode() {
        final String businessName = "Business Name";
        final PostalAddress postalAddress = new PostalAddress();
        log.debug("new PostalAddress() = {}", postalAddress);
        final Business business = new Business(businessName, postalAddress);
        log.debug("new Business(businessName, postalAddress) = {}", business);
        assertNotNull(UNEXPECTED_NULL, business);
    }

    /**
     * Test create.
     */
    @Test
    public void testCreate() {
        final Business business = Business.create();
        log.debug("Business.create() = {}", business);
        assertNotNull(UNEXPECTED_NULL, business);
    }

    /**
     * Test method for Business.
     */
    @Test
    public void testDebugString() {
        final String string = new Business().debugString();
        log.debug("new Business().debugString() = {}", string);
        assertNotNull(UNEXPECTED_NULL, string);
    }

    /**
     * Test method for Business.
     */
    @Test
    public void testToString() {
        final String string = new Business().toString();
        log.debug("new Business().toString() = {}", string);
        assertNotNull(UNEXPECTED_NULL, string);
    }

}
