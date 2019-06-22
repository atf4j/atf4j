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

import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;

/**
 * A Unit test class for BankSortCode objects.
 */
@Slf4j
public final class BankSortCodeTest {

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        final BankSortCode sortCode = BankSortCode.create();
        verifyNotNull(sortCode);
        log.debug("BankSortCode.create() = {}", sortCode);
    }

    /**
     * Test method for void.
     */
    @Test
    @Ignore
    public void testRandom() {
        final BankSortCode sortCode = BankSortCode.random();
        verifyNotNull(sortCode);
        log.debug("BankSortCode.random() = {}", sortCode);
    }

    /**
     * Test method for BankSortCode.
     */
    @Test
    public void testBankSortCodeString() {
        final String actual = "99:99:99";
        final BankSortCode sortCode = new BankSortCode(actual);
        verifyNotNull(sortCode);
        log.debug("new BankSortCode({}) = {}", actual, sortCode);
    }

    /**
     * Test method for BankSortCode.
     */
    @Test
    public void testSetGetBankSortCode() {
        final String actual = "99:99:99";
        final BankSortCode sortCode = BankSortCode.create();
        verifyNotNull(sortCode);
        assertEquals(actual, sortCode.setBankSortCode(actual).getBankSortCode());
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
     * test BankSortCode object.
     */
    public void testDebugString() {
        final BankSortCode sortCode = BankSortCode.create();
        verifyNotNull(sortCode);
        log.debug("BankSortCode().debugString() = {}", sortCode.debugString());
    }

    /**
     * Test method for BankSortCode.
     */
    @Test
    public void testToString() {
        final BankSortCode sortCode = BankSortCode.create();
        verifyNotNull(sortCode);
        log.debug("BankSortCode().toString() = {}", sortCode.toString());
    }
}
