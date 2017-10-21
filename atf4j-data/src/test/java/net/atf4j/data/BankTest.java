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

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A Unit test class for Bank objects.
 */
public final class BankTest extends TestResultsReporting {

    /**
     * Test method for Bank.
     */
    @Test
    public void testCreate() {
        final Bank bank = Bank.create();
        log.debug("Bank.create() = {}", bank);
        assertNotNull(UNEXPECTED_NULL, bank);
    }

    /**
     * Test random.
     */
    @Test
    public void testRandom() {
        final Bank bank = Bank.random();
        log.debug("Bank.random() = {}", bank);
        assertNotNull(UNEXPECTED_NULL, bank);
    }

    /**
     * Test method for Bank.
     */
    @Test
    public void testDefaultConstructor() {
        final Bank bank = new Bank();
        log.debug("new Bank() = {}", bank);
        assertNotNull(UNEXPECTED_NULL, bank);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testBank() {
        final Bank bank = new Bank("");
        log.debug("new Bank('') = {}", bank);
        assertNotNull(UNEXPECTED_NULL, bank);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testSetGetName() {
        final String bankName = "Bank Name";
        final Bank bank = new Bank(bankName);
        log.debug("new Bank('Bank Name') = {}", bank);
        assertEquals(bankName, bank.setName(bankName).getName());
    }

    /**
     * Test method for Bank.
     */
    @Test
    public void testDebugString() {
        final String string = new Bank().debugString();
        log.debug("Bank().debugString() = {}", string);
        assertNotNull(UNEXPECTED_NULL, string);
    }

    /**
     * Test method for Bank.
     */
    @Test
    public void testToString() {
        final String string = new Bank().toString();
        log.debug("Bank().toString() = {}", string);
        assertNotNull(UNEXPECTED_NULL, string);
    }

}
