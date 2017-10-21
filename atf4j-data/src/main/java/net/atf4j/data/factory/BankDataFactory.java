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

import java.io.FileNotFoundException;

import net.atf4j.data.Bank;

/**
 * BankAccountFactory.
 */
public class BankDataFactory extends AbstractDataFactory {

    private static final String BANK_DATA = "sortcodesData.csv";
    private static BankDataFactory INSTANCE = null;

    /**
     * Instantiates a new bank data factory.
     *
     * @throws FileNotFoundException the file not found exception
     */
    protected BankDataFactory() throws FileNotFoundException {
        super(BANK_DATA);
    }

    /**
     * Gets the single INSTANCE of BankDataFactory.
     *
     * @return single INSTANCE of BankDataFactory
     * @throws FileNotFoundException the file not found exception
     */
    public static BankDataFactory getInstance() throws FileNotFoundException {
        if (BankDataFactory.INSTANCE == null) {
            BankDataFactory.INSTANCE = new BankDataFactory();
        }
        return BankDataFactory.INSTANCE;
    }

    /**
     * Create new INSTANCE of create.
     *
     * @return the bank
     */
    public Bank create() {
        final Bank bank = Bank.create();
        return bank;
    }

    /**
     * Random.
     *
     * @return the string
     */
    public Bank random() {
        final Bank bank = new Bank();
        final String randomEntry = INSTANCE.randomEntry();
        final String[] bankDetails = randomEntry.split(",");
        bank.setBankSortCode(bankDetails[0]);
        bank.setBankName(bankDetails[1]);
        return bank;
    }

}
