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
    private static BankDataFactory instance = null;

    /**
     * Instantiates a new bank data factory.
     * 
     * @throws FileNotFoundException
     * 
     * @throws Exception
     */
    protected BankDataFactory() throws FileNotFoundException {
        super(BANK_DATA);
    }

    /**
     * Gets the single instance of BankDataFactory.
     *
     * @return single instance of BankDataFactory
     * @throws FileNotFoundException
     */
    public static BankDataFactory getInstance() throws FileNotFoundException {
        if (BankDataFactory.instance == null) {
            BankDataFactory.instance = new BankDataFactory();
        }
        return BankDataFactory.instance;
    }

    /**
     * Create new instance of create.
     *
     * @return the bank
     */
    public Bank create() {
        Bank bank = Bank.create();
        return bank;
    }

    /**
     * Random.
     *
     * @return the string
     * @throws FileNotFoundException
     */
    public Bank random() {
        Bank bank = new Bank();
        try {
            instance = BankDataFactory.getInstance();
            String randomEntry = instance.randomEntry();
            String[] bankDetails = randomEntry.split(",");
            bank.setBankSortCode(bankDetails[0]);
            bank.setBankName(bankDetails[1]);
        } catch (FileNotFoundException e) {
        }
        return bank;
    }

}
