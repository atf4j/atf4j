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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * A UnitTest for BankSortCode objects.
 */
public class BankSortCodeTest {

    /**
     * Test method for {@link BankSortCode}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new BankSortCode());
    }

    /**
     * Test method for {@link BankSortCode}.
     */
    @Test
    public void testBankSortCodeString() {
        final String actual = "99:99:99";
        assertNotNull(new BankSortCode(actual));
    }

    @Test
    public void testCreate() {
        assertNotNull(BankSortCode.create());
    }

    /**
     * Test method for {@link BankSortCode}.
     */
    @Test
    public void testSetGetBankSortCode() {
        final String actual = "99:99:99";
        assertEquals(actual, new BankSortCode().setBankSortCode(actual).getBankSortCode());
    }

    /**
     * Test method for {@link BankSortCode}.
     */
    @Test
    public void testVerify() {
        BankSortCode.verify("00:00:00");
        BankSortCode.verify("99:99:99");
    }

    /**
     * Test method for {@link BankSortCode}.
     */
    @Test
    public void testVerifyNull() {
        BankSortCode.verify(null);
    }

    /**
     * Test method for {@link BankSortCode}.
     */
    @Test
    public void testVerifyEmpty() {
        BankSortCode.verify("");
    }

    /**
     * Test method for {@link BankSortCode}.
     */
    @Test
    public void testDebugString() {
        final String string = new BankSortCode().debugString();
        assertNotNull(string);
    }

    /**
     * Test method for {@link BankSortCode}.
     */
    @Test
    public void testToString() {
        final String string = new BankSortCode().toString();
        assertNotNull(string);
    }

}
