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

import net.atf4j.core.ResultsReporting;

/**
 * A Unit test class for BankAccount objects.
 */
public final class BankAccountTest extends ResultsReporting {

    /**
     * Unit Test for BankAccount.
     */
    @Test
    public void testExpected() {
        final BankAccount bankAccount = BankAccount.random();
        assertNotNull(bankAccount);
        this.log.info("{}", bankAccount);
    }

    /**
     * Unit Test for BankAccount default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new BankAccount());
    }

    /**
     * Unit Test for BankAccount constructor with null string.
     */
    @Test
    public void testBankAccountNull() {
        final String nullString = null;
        final BankAccount bankAccount = new BankAccount(nullString);
        assertNotNull(bankAccount);
        this.log.info("{}", bankAccount);
    }

    /**
     * Unit Test for BankAccount constructor with null object.
     */
    @Test
    public void testBankAccountNullObject() {
        final Bank nullBank = null;
        final BankAccount bankAccount = new BankAccount(nullBank);
        assertNotNull(bankAccount);
        this.log.info("{}", bankAccount);
    }

    /**
     * Unit Test for BankAccount constructor with empty string.
     */
    @Test
    public void testBankAccountString() {
        final BankAccount bankAccount = new BankAccount("");
        assertNotNull(bankAccount);
        this.log.info("{}", bankAccount);
    }

    /**
     * Unit Test for BankAccount.
     */
    @Test
    public void testCreate() {
        final BankAccount bankAccount = BankAccount.create();
        assertNotNull(bankAccount);
        this.log.info("{}", bankAccount);
    }

    /**
     * Unit Test for BankAccount.
     */
    @Test
    public void testSetGetAccountNo() {
        final BankAccount bankAccount = new BankAccount();
        assertNotNull(bankAccount);
        final String accountNo = "00001234";
        assertNotNull(bankAccount.setAccountNo(accountNo));
        assertEquals(accountNo, bankAccount.getAccountNo());
        this.log.info("{}", bankAccount);
    }

    /**
     * Unit Test for BankAccount.
     */
    @Test
    public void testSetGetBank() {
        final Bank testBank = new Bank("TestBank");
        assertNotNull(testBank);
        final BankAccount bankAccount = new BankAccount(testBank);
        assertEquals(testBank, bankAccount.getBank());
        assertNotNull(bankAccount.setBank(testBank));
        assertEquals(testBank, bankAccount.getBank());
        this.log.info("{}", bankAccount);
    }

    /**
     * Unit Test for BankAccount.
     */
    @Test
    public void testToString() {
        final String string = new BankAccount().toString();
        assertNotNull(string);
        this.log.info("{}", string);
    }

}
