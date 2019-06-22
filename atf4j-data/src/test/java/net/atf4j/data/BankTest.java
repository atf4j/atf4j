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

import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import lombok.extern.slf4j.Slf4j;

/**
 * A Unit test class for Bank objects.
 */
@Slf4j
public final class BankTest {

    /**
     * Unit tests to create a blank Bank object.
     */
    @Test
    public void testCreate() {
        final Bank bank = Bank.create();
        verifyNotNull(bank);
        log.debug("Bank.create() = {}", bank);
    }

    /**
     * Unit test to create a random Bank object.
     */
    @Test
    public void testRandom() {
        final Bank bank = Bank.random();
        verifyNotNull(bank);
        log.debug("Bank.random() = {}", bank);
    }

    /**
     * Unit tests for the Bank object.
     */
    @Test
    public void testDefaultConstructor() {
        final Bank bank = new Bank();
        verifyNotNull(bank);
        log.debug("new Bank() = {}", bank);
    }

    /**
     * Unit tests for the Bank object.
     */
    @Test
    public void testBank() {
        final Bank bank = new Bank("");
        verifyNotNull(bank);
        log.debug("new Bank('') = {}", bank);
    }

    /**
     * Unit tests for the Bank object.
     */
    @Test
    public void testSetGetName() {
        final String bankName = "Bank Name";
        final Bank bank = new Bank(bankName);
        verifyNotNull(bank);
        assertEquals(bankName, bank.setName(bankName).getName());
    }

    /**
     * Unit tests for the Bank object.
     */
    @Test
    public void testDebugString() {
        final String string = new Bank().debugString();
        verifyNotNull(string);
        log.debug("Bank().debugString() = {}", string);
    }

    /**
     * Unit tests for the Bank object.
     */
    @Test
    public void testToString() {
        final String string = new Bank().toString();
        verifyNotNull(string);
        log.debug("Bank().toString() = {}", string);
    }
}
