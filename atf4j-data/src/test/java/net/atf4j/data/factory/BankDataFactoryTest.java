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

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;
import net.atf4j.data.Bank;

/**
 * A UnitTest for BankDataFactory objects.
 */
public final class BankDataFactoryTest extends TestResultsReporting {

    /**
     * Test create.
     */
    @Test
    public void testCreate() {
        final Bank bank = BankDataFactory.create();
        this.log.debug("bankDataFactory.create() = {}", bank);
        verifyNotNull(bank);
    }

    /**
     * Test random.
     */
    @Test
    public void testRandom() {
        final Bank randomBank = BankDataFactory.random();
        this.log.debug("BankDataFactory.random() = {}", randomBank);
        verifyNotNull(randomBank);
    }

    /**
     * Test get instance.
     */
    @Test
    public void testGetInstance() {
        final BankDataFactory bankDataFactory = BankDataFactory.getInstance();
        this.log.debug("BankDataFactory.getInstance() = {}", bankDataFactory);
        verifyNotNull(bankDataFactory);
    }

}
