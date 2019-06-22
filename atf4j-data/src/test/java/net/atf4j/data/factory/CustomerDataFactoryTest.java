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

import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import net.atf4j.data.Customer;

/**
 * Unit Test Suite for the CustomerDataFactory.
 */
@Slf4j
public final class CustomerDataFactoryTest {

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        final Customer customer = CustomerDataFactory.create();
        verifyNotNull(customer);
        log.debug("CustomerDataFactory.create() = {}", customer);
    }

    /**
     * Test method for expected usage.
     */
    @Test
    public void testRandom() {
        final Customer customer = CustomerDataFactory.random();
        verifyNotNull(customer);
        log.debug("CustomerDataFactory.random() = {}", customer);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testGetInstance() {
        final CustomerDataFactory customerDataFactory = CustomerDataFactory.getInstance();
        verifyNotNull(customerDataFactory);
        log.debug("new CustomerDataFactory() = {}", customerDataFactory);
    }
}
