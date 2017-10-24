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

package net.atf4j.pog;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;
import net.atf4j.pog.PageWebElement.Strategy;

/**
 * A UnitTest for PageObjectData objects.
 */
public final class PageObjectDataTest extends TestResultsReporting {

    /**
     * Test method for void.
     */
    @Test
    public void testExpected() {
        final PageObjectData pageObjectData = new PageObjectData();
        assertNotNull(UNEXPECTED_NULL, pageObjectData);

        pageObjectData
            .add(new PageWebElement("findById", Strategy.ID, "id"))
            .add(new PageWebElement("findByName", Strategy.NAME, "name"))
            .add(new PageWebElement("findByLinkText", Strategy.LINK_TEXT, "linkText"))
            .add(new PageWebElement("findByPartialLinkText", Strategy.PARTIAL_LINK_TEXT, "partialLinkText"))
            .add(new PageWebElement("findByName", Strategy.NAME, "name"))
            .add(new PageWebElement("findByXpath", Strategy.XPATH, "//A"))
            .add(new PageWebElement("findByCss", Strategy.CSS, "."));

        logAttributes(pageObjectData);
        log.info(pageObjectData.toString());
    }

    /**
     * test PageObjectData class.
     */
    @Test
    public void testDefaultConstructor() {
        final PageObjectData pageObjectData = new PageObjectData();
        assertNotNull(UNEXPECTED_NULL, pageObjectData);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testPageObjectData() {
        final PageObjectData pageObjectData = new PageObjectData();
        assertNotNull(UNEXPECTED_NULL, pageObjectData);
    }

    /**
     * Log attributes.
     *
     * @param pageObjectData the page object data
     */
    private void logAttributes(final PageObjectData pageObjectData) {
        final List<PageWebElement> attributes = pageObjectData.get();
        for (final PageWebElement pageWebElement : attributes) {
            log.debug(pageWebElement.toString());
        }
    }
}
