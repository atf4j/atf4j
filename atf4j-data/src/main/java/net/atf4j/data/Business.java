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

/**
 * Business data.
 */
public class Business extends Name {

    private PostalAddress address;

    /**
     * Create new instance of create.
     *
     * @return the business
     */
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
     * @param name
     *            the string
     */
    public Business(final String name) {
        super(name);
    }

    /**
     * Instantiates a new business.
     *
     * @param name
     *            the name
     * @param address
     *            the address
     */
    public Business(final String name, final PostalAddress address) {
        super(name);
        setAddress(address);
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
    @Override
    public String debugString() {
        return String.format("%s [name=%s, address=%s]",this.getClass().getSimpleName(), this.getName(), this.getAddress());
    }

}
