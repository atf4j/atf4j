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

import java.util.Arrays;

/**
 * Address data class.
 */
public class Address {

	/** The address. */
	private String[] address;

	/** The postcode. */
	private Postcode postcode;

	/**
	 * Instantiates a new address.
	 */
	public Address() {
		super();
	}

	/**
	 * Instantiates a new address.
	 *
	 * @param address
	 *            the address
	 * @param postcode
	 *            the postcode
	 */
	public Address(final String[] address, final Postcode postcode) {
		super();
		setAddress(address);
		setPostcode(postcode);
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String[] getAddress() {
		return this.address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address
	 *            the new address
	 * @return
	 */
	public Address setAddress(final String[] address) {
		this.address = address;
		return this;
	}

	/**
	 * Gets the postcode.
	 *
	 * @return the postcode
	 */
	public Postcode getPostcode() {
		return this.postcode;
	}

	/**
	 * Sets the postcode.
	 *
	 * @param postcode
	 *            the new postcode
	 * @return
	 */
	public Address setPostcode(final Postcode postcode) {
		this.postcode = postcode;
		return this;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Address [address=%s, postcode=%s]", Arrays.toString(this.address), this.postcode);
	}

}
