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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.atf4j.data.factory.DataFactory;

/**
 * EmailAddress.
 */
public class EmailAddress {

    private static final Pattern LOCAL_PART = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*$");
    private static final Pattern DOMAIN = Pattern.compile("^@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private static final Pattern PATTERN = Pattern.compile(LOCAL_PART + "@" + DOMAIN);

    private String domain = "example.com";
    private String localPart = null;
    private String email = null;

    public static EmailAddress at(final String domain) {
        final EmailAddress emailAddress = new EmailAddress(domain);
        emailAddress.setLocalPart(DataFactory.randomString(10));
        return emailAddress;
    }

    public static EmailAddress create() {
        final EmailAddress emailAddress = new EmailAddress();
        emailAddress.setLocalPart(DataFactory.randomString(10));
        return emailAddress;
    }

    /**
     * Instantiates a new email address.
     */
    protected EmailAddress() {
        super();
        setEmail(String.format("%s@%s", this.localPart, this.domain));
    }

    /**
     * Instantiates a new email address.
     * 
     * @param domain the domain
     */
    public EmailAddress(final String domain) {
        super();
        setDomain(domain);
    }

    /**
     * Sets the email.
     *
     * @param email the email
     * @return the email address
     */
    public EmailAddress setEmail(final String email) {
        this.email = email;
        return this;
    }

    public EmailAddress setDomain(final String domain) {
        this.domain = domain;
        return this;
    }

    public EmailAddress setLocalPart(final String localPart) {
        this.localPart = localPart;
        return this;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getLocalPart() {
        return this.localPart;
    }

    public String getEmail() {
        return this.email;
    }

    /**
     * Verify.
     *
     * @param email the email
     * @return true, if successful
     */
    public static boolean verify(final String email) {
        final Matcher matcher = PATTERN.matcher(email);
        return matcher.find();
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("EmailAddress [email=%s, domain=%s, localPart=%s]",
                this.email,
                this.domain,
                this.localPart);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.email;
    }

}
