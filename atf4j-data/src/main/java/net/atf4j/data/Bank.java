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
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.data;

/**
 * Bank data class.
 *
 *
 */
public class Bank extends Business {

    private BankSortCode bankSortCode;

    /**
     * Bank object factory method.
     *
     * @return initialised instance of Bank
     */
    public static Bank create() {
        return new Bank();
    }

    /**
     * Instantiates a new bank.
     */
    public Bank() {
        this.bankSortCode = new BankSortCode();
    }

    /* (non-Javadoc)
     * @see net.atf4j.data.Business#setName(java.lang.String)
     */
    @Override
    public Bank setName(final String bankName) {
        super.setName(bankName);
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

    /* (non-Javadoc)
     * @see net.atf4j.data.Business#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

    /* (non-Javadoc)
     * @see net.atf4j.data.Business#debugString()
     */
    @Override
    public String debugString() {
        return String.format("Bank [bankSortCode=%s]", this.bankSortCode);
    }

}
