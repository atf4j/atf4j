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

import static org.junit.Assert.assertNotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * BankSortCode data class.
 */
public class BankSortCode {

    private static final Pattern pattern = Pattern.compile("^(\\d){2}-(\\d){2}-(\\d){2}$");

    private final String bankName = "";
    private String sortcode;

    /**
     * Create new instance of create.
     *
     * @return the bank sort code
     */
    public static BankSortCode create() {
        return new BankSortCode();
    }

    /**
     * Instantiates a new bank sort code.
     */
    public BankSortCode() {
        setBankSortCode("00-00-00");
    }

    /**
     * Instantiates a new bank sort code.
     *
     * @param bankSortCode
     *            the bank sort code
     */
    public BankSortCode(final String bankSortCode) {
        setBankSortCode(bankSortCode);
    }

    /**
     * Sets the bank sort code.
     *
     * @param bankSortCode
     *            the bank sort code
     * @return the bank sort code
     */
    public BankSortCode setBankSortCode(final String bankSortCode) {
        assertNotNull(bankSortCode);
        this.sortcode = bankSortCode;
        return this;
    }

    /**
     * Gets the bank sort code.
     *
     * @return the bankSortCode as String.
     */
    public String getBankSortCode() {
        return this.sortcode;
    }

    /**
     * Verify the sort code format.
     *
     * @param sortcode
     *            the sortcode
     * @return true, if successful, otherwise false.
     */
    public static boolean verify(final String sortcode) {
        assertNotNull(sortcode);
        final Matcher matcher = pattern.matcher(sortcode);
        return matcher.find();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("BankSortCode [bankName=%s, sortcode=%s]", this.bankName, this.sortcode);
    }

}
