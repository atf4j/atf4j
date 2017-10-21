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

import net.atf4j.data.Customer;

/**
 * CustomerDataFactory, a data factory to create data representing customers.
 */
public class CustomerDataFactory extends AbstractDataFactory {

    private static CustomerDataFactory INSTANCE = null;
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
            this.data = load("data.txt");
        } catch (final Exception e) {
            this.log.error(e.getMessage());
        }
    }

    /**
     * Gets the single INSTANCE of CustomerDataFactory.
     *
     * @return single INSTANCE of CustomerDataFactory
     */
    public static CustomerDataFactory getInstance() {
        if (CustomerDataFactory.INSTANCE == null) {
            CustomerDataFactory.INSTANCE = new CustomerDataFactory();
        }
        return CustomerDataFactory.INSTANCE;
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
