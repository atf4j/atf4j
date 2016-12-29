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

import java.util.Collection;

/**
 * ProductCatalog.
 *
 *
 */
public class ProductCatalog {

    /** The catalog. */
    private Collection<Product> catalog;

    /**
     * add a Product to catalog.
     *
     * @param e
     *            the e
     * @return true, if successful
     * @see java.util.Collection#add(java.lang.Object)
     */
    public boolean add(final Product e) {
        return this.catalog.add(e);
    }

    /**
     * Gets the product list.
     *
     * @return the productList
     */
    public Collection<Product> getProductList() {
        return this.catalog;
    }

    /**
     * Sets the product list.
     *
     * @param productList
     *            the productList to set
     */
    public void setProductList(final Collection<Product> productList) {
        this.catalog = productList;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("ProductCatalog [catalog=%s]", this.catalog);
    }

}
