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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for Card objects.
 */
public class CardTest extends ResultsReporting {

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testDefaultConstructor() {
        new Card();
    }

    /**
     * Test method for {@link Card}.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testVerify() throws Exception {
        final Card card = new Card();
        assertNotNull(card);
        final boolean verify = card.verify("1234");
        assertTrue(verify);
    }

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testDebugString() {
        final String string = new Card().debugString();
        assertNotNull(string);
        this.log.info(string);
    }

    /**
     * Test method for {@link Card}.
     */
    @Test
    public void testToString() {
        final Card card = new Card();
        final String string = card.toString();
        assertNotNull(string);
        this.log.info(string);
    }

}
