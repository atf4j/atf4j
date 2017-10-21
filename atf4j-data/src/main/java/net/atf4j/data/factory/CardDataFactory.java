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

import net.atf4j.data.Card;

/**
 * ChargeCardFactory.
 */
public class CardDataFactory extends AbstractDataFactory {

    private static CardDataFactory INSTANCE = null;
    private String[] data;

    /**
     * Instantiates a new card data factory.
     */
    protected CardDataFactory() {
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
     * Gets the single INSTANCE of CardDataFactory.
     *
     * @return single INSTANCE of CardDataFactory
     */
    public static CardDataFactory getInstance() {
        if (CardDataFactory.INSTANCE == null) {
            CardDataFactory.INSTANCE = new CardDataFactory();
        }
        return CardDataFactory.INSTANCE;
    }

    /**
     * Create new INSTANCE of create.
     *
     * @return the card
     */
    public static Card create() {
        return new Card();
    }

    /**
     * Random card.
     *
     * @return the string
     */
    public static Card random() {
        return new Card();
    }

}
