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

import java.io.FileNotFoundException;

import org.junit.Ignore;
import org.junit.Test;

import net.atf4j.core.TestResultsReporting;
import net.atf4j.data.Bank;

/**
 * A UnitTest for BankDataFactory objects.
 */
public final class BankDataFactoryTest extends TestResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test method for expected usage.
     *
     * @throws FileNotFoundException the file not found exception
     */
    @Test
    @Ignore
    public void testExpectedUsage() throws FileNotFoundException {
        final BankDataFactory instance = BankDataFactory.getInstance();
        final Bank randomBank = instance.random();
        assertNotNull(UNEXPECTED_NULL, randomBank);
        this.log.info("{}", randomBank);
    }

    /**
     * Test default constructor.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDefaultConstructor() throws Exception {
        final BankDataFactory banKDataFactory = new BankDataFactory();
        assertNotNull(UNEXPECTED_NULL, banKDataFactory);
    }

    /**
     * Test method of get singleton instance of PersonDataFactory.
     *
     * @throws FileNotFoundException the file not found exception
     */
    @Test
    public void testGetInstance() throws FileNotFoundException {
        final BankDataFactory instance = BankDataFactory.getInstance();
        assertNotNull(UNEXPECTED_NULL, instance);
        this.log.info("{}", instance.toString());
    }

    /**
     * Test method for void.
     *
     * @throws FileNotFoundException the file not found exception
     */
    @Test
    public void testCreate() throws FileNotFoundException {
        final BankDataFactory instance = BankDataFactory.getInstance();
        final Bank bank = instance.create();
        assertNotNull(UNEXPECTED_NULL, bank);
        this.log.info("{}", bank.toString());
    }

}
