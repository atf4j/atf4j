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

/**
 * Bank data class.
 */
public class Bank extends Business {

    private BankSortCode bankSortCode;
    private String bankName;
    private String sortCode;
    private String iban;

    /**
     * Create new instance of create.
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
     * Instantiates a new bank.
     */
    public Bank() {
        this.bankSortCode = new BankSortCode();
    }

    /**
     * Instantiates a new bank.
     *
     * @param bankName the bank name
     */
    public Bank(final String bankName) {
        this.bankSortCode = new BankSortCode();
        setName(bankName);
    }

    /**
     * Sets the bank sort code.
     *
     * @param bankSortCode the bank sort code
     * @return the bank
     */
    public Bank setBankSortCode(final String bankSortCode) {
        this.bankSortCode.setBankSortCode(bankSortCode);
        return this;
    }

    /**
     * Sets the bank sort code.
     *
     * @param bankSortCode
     *            the bankSortCode to set
     * @return the bank
     */
    public Bank setBankSortCode(final BankSortCode bankSortCode) {
        this.bankSortCode = bankSortCode;
        return this;
    }

    /**
     * Gets the bank sort code.
     *
     * @return the bankSortCode
     */
    public BankSortCode getBankSortCode() {
        return this.bankSortCode;
    }

    /**
     * Gets the bank name.
     * 
     * @return the bank name
     */
    public String getBankName() {
        return this.bankName;
    }

    /**
     * Sets the bank name.
     * 
     * @param bankName the bank name
     * @return the bank
     */
    public Bank setBankName(final String bankName) {
        this.bankName = bankName;
        return this;
    }

    /**
     * Gets the sort code.
     * 
     * @return the sort code
     */
    public String getSortCode() {
        return this.sortCode;
    }

    /**
     * Sets the sort code.
     * 
     * @param sortCode the sort code
     * @return the bank
     */
    public Bank setSortCode(final String sortCode) {
        this.sortCode = sortCode;
        return this;
    }

    /**
     * Gets the iban.
     * 
     * @return the iban
     */
    public String getIban() {
        return this.iban;
    }

    /**
     * Sets the iban.
     * 
     * @param iban the iban
     * @return the bank
     */
    public Bank setIban(final String iban) {
        this.iban = iban;
        return this;
    }

    /* (non-Javadoc)
     * @see net.atf4j.data.Business#toString()
     */
    @Override
    public String toString() {
        return String.format("Bank [bankSortCode=%s, bankName=%s, sortCode=%s, iban=%s]",
                this.bankSortCode,
                this.bankName,
                this.sortCode,
                this.iban);
    }

}
