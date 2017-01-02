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
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.data;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

/**
 * A UnitTest for Card objects.
 */
public class CardTest {

    private static final String INVALID_NUMBER = "1111-1111-1111-1111";
    private static final String AMEX_1 = "3714-4963-539-8431";
    private static final String AMEX_2 = "0000 1234 5678 9999";
    private static final String MASTERCARD_1 = "5500-0055-5555-5559";
    private static final String MASTERCARD_2 = "5555 5555 5555 4444";
    private static final String VISA_CARD_1 = "4444-4444-4444-4448";
    private static final String VISA_CARD_2 = "4111 1111 1111 1111"; // 4012888888881881

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testCreate() {
        assertNotNull(Card.create());
    }

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new Card());
    }

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testCardInitialiser() {
        final String provider = "Provider";
        final String cardNumber = "CardNumber";
        final String cardName = "Card Name";
        final Date endDate = new Date();
        final Date startDate = new Date();
        assertNotNull(new Card(provider, cardNumber, cardName, endDate, startDate));
    }

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testCardFluentInterface() {
        final String provider = "Provider";
        final String cardNumber = "CardNumber";
        final String cardName = "Card Name";
        final Date endDate = new Date();
        final Date startDate = new Date();
        final Card card = new Card().setProvider(provider)
                                    .setCardNumber(cardNumber)
                                    .setCardName(cardName)
                                    .setStartDate(startDate)
                                    .setEndDate(endDate);
        assertNotNull(card);
    }

    /**
     * Test method for {@link Card}.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testVerifyInvalid() {
        assertFalse(Card.luhnCheck(INVALID_NUMBER));
    }

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testVerifyAmex() {
        // assertFalse(Card.verifyAmex(AMEX_1));
        assertFalse(Card.verifyAmex(AMEX_2));
    }

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testVerifyVisa() {
        assertTrue(Card.verifyVisa(VISA_CARD_1));
        assertTrue(Card.verifyVisa(VISA_CARD_2));
    }

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testVerifyMasterCard() {
        assertTrue(Card.verifyMasterCard(MASTERCARD_1));
        assertTrue(Card.verifyMasterCard(MASTERCARD_2));
    }

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testDebugString() {
        final String string = new Card().debugString();
        assertNotNull(string);
    }

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testToString() {
        final Card card = new Card();
        final String string = card.toString();
        assertNotNull(string);
    }

}
