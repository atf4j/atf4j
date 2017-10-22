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

import net.atf4j.data.Customer;

/**
 * CustomerDataFactory, a data factory to create data representing customers.
 */
public final class CustomerDataFactory extends AbstractDataFactory {

    private static CustomerDataFactory instance = null;
    private String[] data;

    /**
     * Instantiates a new customer data factory.
     */
    protected CustomerDataFactory() {
        super();
        initialise();
    }

    /**
     * Initialise.
     */
    protected void initialise() {
        try {
            data = load("data.txt");
        } catch (final FileNotFoundException e) {
            log.error(e.toString());
        }
    }

    /**
     * Gets the single INSTANCE of CustomerDataFactory.
     *
     * @return single INSTANCE of CustomerDataFactory
     */
    public static CustomerDataFactory getInstance() {
        if (CustomerDataFactory.instance == null) {
            CustomerDataFactory.instance = new CustomerDataFactory();
        }
        return CustomerDataFactory.instance;
    }

    /**
     * Create new INSTANCE of create.
     *
     * @return the customer
     */
    public static Customer create() {
        return new Customer();
    }

    /**
     * Random thing.
     *
     * @return the string
     */
    public static Customer random() {
        return new Customer();
    }

}
