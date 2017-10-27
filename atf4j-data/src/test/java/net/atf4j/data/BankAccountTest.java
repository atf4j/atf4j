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
 * A Unit test class for BankAccount objects.
 */
public final class BankAccountTest extends TestResultsReporting {

    /**
     * Unit Test for BankAccount constructor with null string.
     */
    @Test
    public void testBankAccountNullString() {
        final String nullString = null;
        final BankAccount bankAccount = new BankAccount(nullString);
        log.debug("new BankAccount(nullString) = {}", bankAccount);
        verifyNotNull(bankAccount);
    }

    /**
     * Unit Test for BankAccount constructor with null object.
     */
    @Test
    public void testBankAccountNullBank() {
        final Bank nullBank = null;
        final BankAccount bankAccount = new BankAccount(nullBank);
        log.debug("new BankAccount(nullBank) = {}", bankAccount);
        verifyNotNull(bankAccount);
    }

    /**
     * Unit Test for BankAccount constructor with empty string.
     */
    @Test
    public void testBankAccountString() {
        final BankAccount bankAccount = new BankAccount("");
        log.debug("new BankAccount('') = {}", bankAccount);
        verifyNotNull(bankAccount);
    }

    /**
     * Unit Test for BankAccount.
     */
    @Test
    public void testCreate() {
        final BankAccount bankAccount = BankAccount.create();
        log.debug("BankAccount.create() = {}", bankAccount);
        verifyNotNull(bankAccount);
    }

    /**
     * Unit Test for BankAccount.
     */
    @Test
    public void testExpected() {
        final BankAccount bankAccount = BankAccount.random();
        log.debug("BankAccount.random() = {}", bankAccount);
        verifyNotNull(bankAccount);
    }

    /**
     * Unit Test for BankAccount.
     */
    @Test
    public void testSetGetAccountNo() {
        final BankAccount bankAccount = BankAccount.create();
        verifyNotNull(bankAccount);
        final String accountNo = "00001234";
        verifyNotNull(bankAccount.setAccountNo(accountNo));
        assertEquals(accountNo, bankAccount.getAccountNo());
    }

    /**
     * Unit Test for BankAccount.
     */
    @Test
    public void testSetGetBank() {
        final Bank testBank = new Bank("Test Bank");
        verifyNotNull(testBank);
        final BankAccount bankAccount = new BankAccount(testBank);
        assertEquals(testBank, bankAccount.getBank());
        verifyNotNull(bankAccount.setBank(testBank));
        assertEquals(testBank, bankAccount.getBank());
    }

    /**
     * Test debug string.
     */
    @Test
    public void testdebugString() {
        final BankAccount bankAccount = BankAccount.create();
        final String string = bankAccount.debugString();
        log.debug("bankAccount.debugString() = {}", string);
        verifyNotNull(string);
    }

    /**
     * Unit Test for BankAccount.
     */
    @Test
    public void testToString() {
        final BankAccount bankAccount = BankAccount.create();
        final String string = bankAccount.toString();
        log.error("bankAccount.toString() = {}", string);
        verifyNotNull(string);
    }

}
