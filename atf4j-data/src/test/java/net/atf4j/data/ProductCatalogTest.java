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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A Unit test class for ProductCatalog objects.
 */
public final class ProductCatalogTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test method for ProductCatalog.
     */
    @Test
    public void testDefaultConstructor() {
        ProductCatalog catalog = new ProductCatalog();
        assertNotNull(UNEXPECTED_NULL, catalog);
        log.info("{}", catalog);
    }

    /**
     * test ProductCatalog object.
     */
    @Test
    public void testProductCatalog() {
        final ProductCatalog productCatalog = new ProductCatalog();
        assertNotNull(UNEXPECTED_NULL, productCatalog);
        Product product = new Product();
        productCatalog.add(product);
        log.info("{}", productCatalog);
    }

    /**
     * Test method for ProductCatalog.
     */
    @Test
    public void testToString() {
        final String string = new ProductCatalog().toString();
        assertNotNull(UNEXPECTED_NULL, string);
    }

}
