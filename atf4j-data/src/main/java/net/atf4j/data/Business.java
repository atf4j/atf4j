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

/**
 * Business data.
 */
public class Business {

    private Name name;
    private PostalAddress address;

    public static Business create() {
        return new Business();
    }

    /**
     * Instantiates a new business.
     */
    public Business() {
        super();
    }

    /**
     * Instantiates a new business.
     *
     * @param string
     *            the string
     */
    public Business(final String string) {
        this(new Name(string));
    }

    /**
     * Instantiates a new business.
     *
     * @param name
     *            the name
     */
    public Business(final Name name) {
        super();
        this.name = name;
    }

    /**
     * Instantiates a new business.
     *
     * @param name
     *            the name
     * @param address
     *            the address
     */
    public Business(final Name name, final PostalAddress address) {
        super();
        setName(name);
        setAddress(address);
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the name
     * @return the business
     */
    public Business setName(final String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the name to set
     * @return the business
     */
    public Business setName(final Name name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public PostalAddress getAddress() {
        return this.address;
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the address
     * @return the business
     */
    public Business setAddress(final PostalAddress address) {
        this.address = address;
        return this;
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
        return String.format("Business [name=%s, address=%s]", this.name, this.address);
    }

}
