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

import static org.junit.Assume.assumeNotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * BankSortCode data class.
 */
public class BankSortCode {

    /** REGULAR EXPRESSION. */
    private static final Pattern pattern = Pattern.compile("^(\\d){2}-(\\d){2}-(\\d){2}$");

    /** The bank sort code. */
    private String bankSortCode;

    /**
     * Instantiates a new bank sort code.
     */
    public BankSortCode() {
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
        this.bankSortCode = bankSortCode;
        return this;
    }

    /**
     * Gets the bank sort code.
     *
     * @return the bankSortCode as String.
     */
    public String getBankSortCode() {
        return this.bankSortCode;
    }

    /**
     * Verify.
     *
     * @param code
     *            the code
     * @return true, if successful
     */
    public static boolean verify(final String code) {
        assumeNotNull("Cannot verify null", code);
        final Matcher matcher = pattern.matcher(code);
        return matcher.find();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("BankSortCode [bankSortCode=%s]", this.bankSortCode);
    }
}
