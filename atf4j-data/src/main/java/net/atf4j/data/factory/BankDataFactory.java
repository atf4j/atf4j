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

import net.atf4j.data.Bank;

/**
 * BankAccountFactory.
 *
 *
 */
public class BankDataFactory extends AbstractDataFactory {

    /**
     * Instantiates a new bank data factory.
     *
     * @throws Exception
     *             the exception
     */
    protected BankDataFactory() throws Exception {
        super();
    }

    /**
     * Creates the.
     *
     * @return the bank
     */
    public static Bank create() {
        return new Bank();
    }

}
