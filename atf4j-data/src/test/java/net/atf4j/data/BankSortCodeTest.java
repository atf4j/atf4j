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

package net.atf4j.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A Unit test class for BankSortCode objects.
 */
public final class BankSortCodeTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test method for BankSortCode.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(UNEXPECTED_NULL, new BankSortCode());
    }

    /**
     * Test method for BankSortCode.
     */
    @Test
    public void testBankSortCodeString() {
        final String actual = "99:99:99";
        assertNotNull(UNEXPECTED_NULL, new BankSortCode(actual));
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        final BankSortCode sortCode = BankSortCode.create();
        assertNotNull(UNEXPECTED_NULL, sortCode);
        this.log.info("{}", sortCode);
    }

    /**
     * Test method for BankSortCode.
     */
    @Test
    public void testSetGetBankSortCode() {
        final String actual = "99:99:99";
        assertEquals(actual, new BankSortCode().setBankSortCode(actual).getBankSortCode());
    }

    /**
     * Test method for BankSortCode.
     */
    @Test
    @Ignore
    public void testVerifyData() {
        assertTrue(BankSortCode.verify("00-00-00"));
        assertTrue(BankSortCode.verify("00:00:00"));
        assertTrue(BankSortCode.verify("00 00 00"));
        assertTrue(BankSortCode.verify("99-99-99"));
        assertTrue(BankSortCode.verify("99:99:99"));
        assertTrue(BankSortCode.verify("99 99 99"));
        assertFalse(BankSortCode.verify("AA:AA:AA"));
        assertFalse(BankSortCode.verify("aaaaaaaa"));
        assertFalse(BankSortCode.verify("XXXXXXXX"));
    }

    /**
     * Unit Test for test verify null.
     */
    @Test(expected = AssertionError.class)
    public void testVerifyNull() {
        assertFalse(BankSortCode.verify(null));
    }

    /**
     * Unit Test for test verify empty.
     */
    @Test
    public void testVerifyEmpty() {
        assertFalse(BankSortCode.verify(""));
    }

    /**
     * Test method for BankSortCode.
     */
    @Test
    public void testToString() {
        final String string = new BankSortCode().toString();
        assertNotNull(UNEXPECTED_NULL, string);
        this.log.info("{}", string);
    }

}
