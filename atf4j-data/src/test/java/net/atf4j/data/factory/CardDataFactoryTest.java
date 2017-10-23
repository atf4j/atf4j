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

import net.atf4j.core.TestResultsReporting;
import net.atf4j.data.Card;

/**
 * A UnitTest for CardDataFactory objects.
 */
public final class CardDataFactoryTest extends TestResultsReporting {

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        final Card card = CardDataFactory.create();
        log.debug("CardDataFactory.create() = {}", card);
        assertNotNull(UNEXPECTED_NULL, card);
    }

    /**
     * Test random.
     */
    @Test
    public void testRandom() {
        final Card card = CardDataFactory.random();
        log.debug("CardDataFactory.random() = {}", card);
        assertNotNull(UNEXPECTED_NULL, card);
    }

    /**
     * Test get instance.
     */
    @Test
    public void testGetInstance() {
        final CardDataFactory cardDataFactory = CardDataFactory.getInstance();
        log.debug("CardDataFactory.getInstance() = {}", cardDataFactory);
        assertNotNull(UNEXPECTED_NULL, cardDataFactory);
    }

}
