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

import static org.junit.Assert.assertNotNull;

/**
 * Bank Account Data. UK Bank Account Number @”^\d{8,8}$”;
 */
public final class BankAccount {

    private static final String UNEXPECTED_NULL = "unexpected null";
    private Bank bank = new Bank();
    private String accountNo = "";

    /**
     * Creates the BankAccount object.
     *
     * @return the bank account
     */
    public static BankAccount create() {
        final BankAccount bankAccount = new BankAccount();
        bankAccount.setBank(Bank.create());
        return bankAccount;
    }

    /**
     * Creates the BankAccount with random data.
     *
     * @return the bank account
     */
    public static BankAccount random() {
        final BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNo(Text.randomDigits(8));
        bankAccount.setBank(Bank.create());
        return bankAccount;
    }

    /**
     * Instantiates a new bank account.
     */
    private BankAccount() {
        super();
    }

    /**
     * Instantiates a new bank account.
     *
     * @param bank the bank
     */
    public BankAccount(final Bank bank) {
        super();
        this.bank = bank;
    }

    /**
     * Instantiates a new bank account.
     *
     * @param accountNo the account no
     */
    public BankAccount(final String accountNo) {
        super();
        this.accountNo = accountNo;
    }

    /**
     * Instantiates a new bank account.
     *
     * @param bank the bank
     * @param accountNo the account no
     */
    public BankAccount(final Bank bank, final String accountNo) {
        super();
        this.bank = bank;
        this.accountNo = accountNo;
    }

    /**
     * Sets the bank.
     *
     * @param bank the bank
     * @return the bank account
     */
    public BankAccount setBank(final Bank bank) {
        assertNotNull(UNEXPECTED_NULL, bank);
        this.bank = bank;
        return this;
    }

    /**
     * Sets the account no.
     *
     * @param accountNo the account no
     * @return the bank account
     */
    public BankAccount setAccountNo(final String accountNo) {
        assertNotNull(UNEXPECTED_NULL, accountNo);
        this.accountNo = accountNo;
        return this;
    }

    /**
     * Gets the bank.
     *
     * @return the bank
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * Gets the account no.
     *
     * @return the account no
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("BankAccount [bank=%s, accountNo=%s]", bank, accountNo);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s - %s", bank, accountNo);
    }

}
