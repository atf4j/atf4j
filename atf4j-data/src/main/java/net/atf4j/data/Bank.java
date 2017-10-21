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
 * Bank data class.
 */
public final class Bank extends Business {

    private static final String UNEXPECTED_NULL = "unexpected null";
    private BankSortCode bankSortCode;
    private String bankName;
    private String sortCode;
    private String iban;

    /**
     * Create new INSTANCE of create.
     *
     * @return the bank
     */
    public static Bank create() {
        final Bank bank = new Bank();
        final BankSortCode bankSortCode = BankSortCode.create();
        bank.setBankSortCode(bankSortCode);
        return bank;
    }

    /**
     * Random.
     *
     * @return the bank
     */
    public static Bank random() {
        return create();
    }

    /**
     * Instantiates a new bank.
     */
    public Bank() {
        super();
        setBankSortCode(BankSortCode.create());
        setName("Bank Name");
    }

    /**
     * Instantiates a new bank.
     *
     * @param sortcode the sortcode
     * @param name the name
     */
    public Bank(final BankSortCode sortcode, final String name) {
        super();
        setBankSortCode(bankSortCode);
        setName(bankName);
    }

    /**
     * Instantiates a new bank.
     *
     * @param bankName the bank name
     */
    public Bank(final String bankName) {
        super();
        bankSortCode = BankSortCode.create();
        setName(bankName);
    }

    /**
     * Sets the bank sort code.
     *
     * @param bankSortCode the bank sort code
     * @return the bank
     */
    public Bank setBankSortCode(final String bankSortCode) {
        assertNotNull(UNEXPECTED_NULL, bankSortCode);
        this.bankSortCode.setBankSortCode(bankSortCode);
        return this;
    }

    /**
     * Sets the bank sort code.
     *
     * @param bankSortCode the bankSortCode to set
     * @return the bank
     */
    public Bank setBankSortCode(final BankSortCode bankSortCode) {
        assertNotNull(UNEXPECTED_NULL, bankSortCode);
        this.bankSortCode = bankSortCode;
        return this;
    }

    /**
     * Sets the bank name.
     *
     * @param bankName the bank name
     * @return the bank
     */
    public Bank setBankName(final String bankName) {
        assertNotNull(UNEXPECTED_NULL, bankName);
        this.bankName = bankName;
        return this;
    }

    /**
     * Sets the sort code.
     *
     * @param sortCode the sort code
     * @return the bank
     */
    public Bank setSortCode(final String sortCode) {
        assertNotNull(UNEXPECTED_NULL, sortCode);
        this.sortCode = sortCode;
        return this;
    }

    /**
     * Sets the iban.
     *
     * @param iban the iban
     * @return the bank
     */
    public Bank setIban(final String iban) {
        assertNotNull(UNEXPECTED_NULL, iban);
        this.iban = iban;
        return this;
    }

    /**
     * Gets the bank sort code.
     *
     * @return the bankSortCode
     */
    public BankSortCode getBankSortCode() {
        return bankSortCode;
    }

    /**
     * Gets the bank name.
     *
     * @return the bank name
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Gets the sort code.
     *
     * @return the sort code
     */
    public String getSortCode() {
        return sortCode;
    }

    /**
     * Gets the iban.
     *
     * @return the iban
     */
    public String getIban() {
        return iban;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.data.Business#toString()
     */
    @Override
    public String toString() {
        return String.format("Bank [bankSortCode=%s, bankName=%s, sortCode=%s, iban=%s]",
                bankSortCode,
                bankName,
                sortCode,
                iban);
    }

}
