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

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Card Data.
 */
public class Card {
    String provider;
    String cardNumber;
    String cardName;
    Date endDate;
    Date startDate;
    // Card CVV

    /**
     * Instantiates a new card.
     */
    public Card() {
        super();
    }

    /**
     * Verify.
     *
     * @param string
     *            the string
     * @return true, if successful
     */
    public boolean verify(final String string) {
        return false;
    }

    /**
     * Verify amex.
     *
     * @param candidate
     *            the candidate
     * @return true, if successful
     */
    public boolean verifyAmex(final String candidate) {
        final Pattern pattern = Pattern.compile("^(?<amex>3[47][0-9]{13})$");
        final Matcher matcher = pattern.matcher(candidate.replaceAll("-", ""));
        return matcher.matches();
    }

    /**
     * Verify visa.
     *
     * @param candidate
     *            the candidate
     * @return true, if successful
     */
    public boolean verifyVisa(final String candidate) {
        final Pattern pattern = Pattern.compile("^(?<visa>4[0-9]{12}(?:[0-9]{3})?)$");
        final Matcher matcher = pattern.matcher(candidate.replaceAll("-", ""));
        return matcher.matches();
    }

    /**
     * Verify master card.
     *
     * @param candidate
     *            the candidate
     * @return true, if successful
     */
    public boolean verifyMasterCard(final String candidate) {
        final Pattern pattern = Pattern.compile("^(?<mastercard>5[1-5][0-9]{14})$");
        final Matcher matcher = pattern.matcher(candidate.replaceAll("-", ""));
        return matcher.matches();
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("Card [provider=%s, cardNumber=%s, cardName=%s, endDate=%s, startDate=%s]", this.provider,
                this.cardNumber, this.cardName, this.endDate, this.startDate);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

}
