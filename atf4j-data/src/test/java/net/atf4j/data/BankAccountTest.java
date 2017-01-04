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

/**
 * A UnitTest for BankAccount objects.
 */
public class BankAccountTest {

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testDefaultConstructor() {
        final BankAccount bankAccount = new BankAccount();
        assertNotNull(bankAccount);
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testBankAccount() {
        final BankAccount bankAccount = new BankAccount("");
        assertNotNull(bankAccount);
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testCreate() {
        final BankAccount bankAccount = BankAccount.create();
        assertNotNull(bankAccount);
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testSetGetAccountNo() {
        final BankAccount bankAccount = new BankAccount();
        assertNotNull(bankAccount);
        final String accountNo = "00001234";
        assertNotNull(bankAccount.setAccountNo(accountNo));
        assertEquals(accountNo, bankAccount.getAccountNo());
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testSetGetBank() {
        final Bank bank = new Bank();
        assertNotNull(bank);
        final BankAccount bankAccount = new BankAccount();
        assertNotNull(bankAccount.setBank(bank));
        assertEquals(bank, bankAccount.getBank());
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testDebugString() {
        final String string = new BankAccount().debugString();
        assertNotNull(string);
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testToString() {
        final String string = new BankAccount().toString();
        assertNotNull(string);
    }

}
