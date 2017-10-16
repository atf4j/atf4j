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

import net.atf4j.core.ResultsReporting;
import net.atf4j.data.PostalAddress;

/**
 * A UnitTest for AddressDataFactory objects.
 */
public final class AddressDataFactoryTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test method for expected usage.
     */
    @Test
    public void testExpectedUsage() {
        final PostalAddress address = AddressDataFactory.random();
        assertNotNull(UNEXPECTED_NULL, address);
        this.log.info("{}", address);
    }

    /**
     * Test default constructor.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDefaultConstructor() throws Exception {
        final AddressDataFactory addressFactory = new AddressDataFactory();
        assertNotNull(UNEXPECTED_NULL, addressFactory);
    }

    /**
     * Test method get single instance of AddressDataFactory.
     */
    @Test
    public void testGetInstance() {
        final AddressDataFactory addressFactory = AddressDataFactory.getInstance();
        assertNotNull(UNEXPECTED_NULL, addressFactory);
        this.log.info("{}", addressFactory.toString());
    }

    /**
     * Test method for AddressDataFactory create.
     */
    @Test
    public void testCreate() {
        final PostalAddress address = AddressDataFactory.create();
        assertNotNull(UNEXPECTED_NULL, address);
        this.log.info("{}", address.toString());
    }

    /**
     * Test random.
     */
    @Test
    public void testRandom() {
        final PostalAddress address = AddressDataFactory.random();
        assertNotNull(UNEXPECTED_NULL, address);
        this.log.info("{}", address.toString());
    }

    /**
     * Test get from tag.
     */
    @Test
    public void testGetFromTag() {
        final PostalAddress address = AddressDataFactory.forTag("WIP");
        assertNotNull(UNEXPECTED_NULL, address);
        this.log.info("{}", address.toString());
    }

}
