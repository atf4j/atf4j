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
 *
 */
public class Product {

    private String id;
    private String name;
    private String details;

    public static Product create() {
        return new Product();
    }

    /**
     * Instantiates a new product.
     */
    public Product() {
    }

    /**
     * Instantiates a new product.
     *
     * @param id
     *            the id
     * @param name
     *            the name
     * @param details
     *            the details
     */
    public Product(final String id, final String name, final String details) {
        super();
        this.id = id;
        this.name = name;
        this.details = details;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the id
     * @return the product
     */
    public Product setId(final String id) {
        this.id = id;
        return this;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the name
     * @return the product
     */
    public Product setName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the details.
     *
     * @param details
     *            the details to set
     * @return the product
     */
    public Product setDetails(final String details) {
        this.details = details;
        return this;
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
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("Product [id=%s, name=%s, details=%s]", this.id, this.name, this.details);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

}
