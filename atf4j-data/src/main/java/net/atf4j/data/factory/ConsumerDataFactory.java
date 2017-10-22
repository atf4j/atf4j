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

import net.atf4j.data.Consumer;

/**
 * CustomerDataFactory.
 */
public final class ConsumerDataFactory extends AbstractDataFactory {

    private static ConsumerDataFactory consumerDataFactory = null;
    private String[] data;

    /**
     * Instantiates a new consumer data factory.
     */
    protected ConsumerDataFactory() {
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
     * Gets the single INSTANCE of ConsumerDataFactory.
     *
     * @return single INSTANCE of ConsumerDataFactory
     */
    public static ConsumerDataFactory getInstance() {
        if (ConsumerDataFactory.consumerDataFactory == null) {
            ConsumerDataFactory.consumerDataFactory = new ConsumerDataFactory();
        }
        return ConsumerDataFactory.consumerDataFactory;
    }

    /**
     * Create new INSTANCE of create.
     *
     * @return the consumer
     */
    public static Consumer create() {
        return new Consumer();
    }

}
