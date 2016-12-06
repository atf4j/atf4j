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
 * Product.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class Product {

	/** The details. */
	private String details;

	/**
	 * Product.
	 *
	 * @param details
	 *            the details
	 */
	public Product(final String details) {
		super();
		setDetails(details);
	}

	/**
	 * Sets the details.
	 *
	 * @param details
	 *            the details to set
	 */
	public void setDetails(final String details) {
		this.details = details;
	}

	/**
	 * Gets the details.
	 *
	 * @return the details
	 */
	public String getDetails() {
		return this.details;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Product [");
		if (this.details != null) {
			builder.append("details=").append(this.details);
		}
		builder.append("]");
		return builder.toString();
	}

}
