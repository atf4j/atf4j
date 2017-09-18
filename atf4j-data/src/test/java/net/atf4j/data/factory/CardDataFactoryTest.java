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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;
import net.atf4j.data.Card;

/**
 * A UnitTest for CardDataFactory objects.
 */
public class CardDataFactoryTest extends ResultsReporting {

    /**
     * Test method for expected usage.
     */
    @Test
    public void testExpectedUsage() {
        final String randomCard = CardDataFactory.randomCard();
        assertNotNull(randomCard);
        this.log.info("{}", randomCard);
    }

    /**
     * Test default constructor.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testDefaultConstructor() throws Exception {
        final CardDataFactory cardDataFactory = new CardDataFactory();
        assertNotNull(cardDataFactory);
        this.log.info("{}", cardDataFactory);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testGetInstance() {
        final CardDataFactory cardDataFactory = CardDataFactory.getInstance();
        assertNotNull(cardDataFactory);
        this.log.info("{}", cardDataFactory.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        final Card card = CardDataFactory.create();
        assertNotNull(card);
        this.log.info("{}", card.toString());
    }

}
