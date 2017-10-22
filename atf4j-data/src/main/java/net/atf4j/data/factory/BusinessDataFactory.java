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

import net.atf4j.data.Business;

/**
 * Business Data Factory.
 */
public final class BusinessDataFactory extends AbstractDataFactory {

    private static BusinessDataFactory businessDataFactory = null;
    private String[] data;

    /**
     * Instantiates a new business data factory.
     */
    protected BusinessDataFactory() {
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
     * Gets the single INSTANCE of BusinessDataFactory.
     *
     * @return single INSTANCE of BusinessDataFactory
     */
    public static BusinessDataFactory getInstance() {
        if (BusinessDataFactory.businessDataFactory == null) {
            BusinessDataFactory.businessDataFactory = new BusinessDataFactory();
        }
        return BusinessDataFactory.businessDataFactory;
    }

    /**
     * Factory method to create new instance of business.
     *
     * @return the business
     */
    public static Business create() {
        return Business.create();
    }

    /**
     * Factory method to create new instance of business with random data.
     *
     * @return the business
     */
    public static Business random() {
        return Business.random();
    }

}
