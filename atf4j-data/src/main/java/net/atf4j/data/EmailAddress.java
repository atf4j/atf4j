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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * EmailAddress.
 *
 *
 */
public class EmailAddress {

    /** The Constant pattern. */
    private static final Pattern pattern = Pattern
                                                  .compile(
                                                          "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    /** The email. */
    private String email;

    public static EmailAddress create() {
        return new EmailAddress();
    }

    /**
     * Instantiates a new email address.
     */
    public EmailAddress() {
        super();
    }

    /**
     * Instantiates a new email address.
     *
     * @param email
     *            the email
     */
    public EmailAddress(final String email) {
        super();
        this.email = email;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email.
     *
     * @param email
     *            the email
     * @return the email address
     */
    public EmailAddress setEmail(final String email) {
        this.email = email;
        return this;
    }

    /**
     * Verify.
     *
     * @param postcode
     *            the postcode
     * @return true, if successful
     */
    public boolean verify(final String postcode) {
        final Matcher matcher = pattern.matcher(postcode);
        return matcher.find();
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("EmailAddress [email=%s]", this.email);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }
}
