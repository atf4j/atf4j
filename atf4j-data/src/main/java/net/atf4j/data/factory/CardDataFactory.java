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
 * ChargeCard.
 */
public class CardDataFactory extends AbstractDataFactory {

    private static CardDataFactory instance = null;
    private String[] data;

    /**
     * Instantiates a new card data factory.
     */
    protected CardDataFactory() {
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
     * Gets the single instance of CardDataFactory.
     *
     * @return single instance of CardDataFactory
     */
    public static CardDataFactory getInstance() {
        if (CardDataFactory.instance == null) {
            CardDataFactory.instance = new CardDataFactory();
        }
        return CardDataFactory.instance;
    }

    /**
     * Create new instance of create.
     *
     * @return the card
     */
    public static Card create() {
        return new Card();
    }

    public static String randomCard() {
        return null;
    }

}
