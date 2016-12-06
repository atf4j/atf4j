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

import net.atf4j.data.factory.AddressFactory;

/**
 * Bank data class.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public abstract class Bank extends Business {
	private AddressFactory bankAddress;
	private BankSortCode bankSortCode;

	/**
	 * @return the bankAddress
	 */
	public AddressFactory getBankAddress() {
		return this.bankAddress;
	}

	/**
	 * @param bankAddress
	 *            the bankAddress to set
	 */
	public void setBankAddress(final AddressFactory bankAddress) {
		this.bankAddress = bankAddress;
	}

	/**
	 * @return the bankSortCode
	 */
	public BankSortCode getBankSortCode() {
		return this.bankSortCode;
	}

	/**
	 * @param bankSortCode
	 *            the bankSortCode to set
	 */
	public void setBankSortCode(final BankSortCode bankSortCode) {
		this.bankSortCode = bankSortCode;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Bank [");
		if (this.bankAddress != null) {
			builder.append("bankAddress=").append(this.bankAddress).append(", ");
		}
		if (this.bankSortCode != null) {
			builder.append("bankSortCode=").append(this.bankSortCode);
		}
		builder.append("]");
		return builder.toString();
	}

}
