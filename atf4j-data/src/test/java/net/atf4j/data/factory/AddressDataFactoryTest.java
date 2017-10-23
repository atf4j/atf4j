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

package net.atf4j.data.factory;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;
import net.atf4j.data.PostalAddress;

/**
 * A UnitTest for AddressDataFactory objects.
 */
public final class AddressDataFactoryTest extends TestResultsReporting {

    /**
     * Test method to create a postal address.
     */
    @Test
    public void testCreate() {
        final PostalAddress address = AddressDataFactory.create();
        log.debug("AddressDataFactory.create() = {}", address);
        assertNotNull(UNEXPECTED_NULL, address);
    }

    /**
     * Unit Test to create a random postal address.
     */
    @Test
    public void testRandom() {
        final PostalAddress address = AddressDataFactory.random();
        log.debug("AddressDataFactory.random() = {}", address);
        assertNotNull(UNEXPECTED_NULL, address);
    }

    /**
     * Test method get single INSTANCE of AddressDataFactory.
     */
    @Test
    public void testGetInstance() {
        final AddressDataFactory addressFactory = AddressDataFactory.getInstance();
        log.debug("AddressDataFactory.getInstance() = {}", addressFactory);
        assertNotNull(UNEXPECTED_NULL, addressFactory);
    }

}
