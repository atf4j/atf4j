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

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for BankAccount objects.
 */
public class BankAccountTest extends ResultsReporting {

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testDefaultConstructor() {
        new BankAccount();
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testBankAccount() {
        new BankAccount();
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testBankAccountBigDecimal() {
        new BankAccount();
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testCreate() {
        new BankAccount();
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testGetAccountNo() {
        new BankAccount();
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testSetAccountNo() {
        new BankAccount();
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testGetBank() {
        new BankAccount();
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testSetBank() {
        new BankAccount();
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testGetSortcode() {
        new BankAccount();
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testSetSortcode() {
        new BankAccount();
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testDebugString() {
        final String string = new BankAccount().debugString();
        assertNotNull(string);
        this.log.info(string);
    }

    /**
     * Test method for {@link BankAccount}.
     */
    @Test
    public void testToString() {
        final String string = new BankAccount().toString();
        assertNotNull(string);
        this.log.info(string);
    }

}
