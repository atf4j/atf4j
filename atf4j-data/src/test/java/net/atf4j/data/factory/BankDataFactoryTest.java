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

import org.junit.Ignore;
import org.junit.Test;

import net.atf4j.core.ResultsReporting;
import net.atf4j.data.Bank;

/**
 * A UnitTest for BankDataFactory objects.
 */
public final class BankDataFactoryTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test method for expected usage.
     */
    @Test
    @Ignore
    public void testExpectedUsage() {
        final String randomThing = BankDataFactory.random();
        assertNotNull(UNEXPECTED_NULL,randomThing);
        this.log.info("{}", randomThing);
    }

    /**
     * Test default constructor.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testDefaultConstructor() throws Exception {
        assertNotNull(UNEXPECTED_NULL,new BankDataFactory());
    }

    /**
     * Test method of get singleton instance of PersonDataFactory.
     */
    @Test
    public void testGetInstance() {
        final BankDataFactory instance = BankDataFactory.getInstance();
        assertNotNull(UNEXPECTED_NULL,instance);
        this.log.info("{}", instance.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        final Bank bank = BankDataFactory.create();
        assertNotNull(UNEXPECTED_NULL,bank);
        this.log.info("{}", bank.toString());
    }

}
