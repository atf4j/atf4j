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

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;
import net.atf4j.pog.WebElementField.Strategy;

/**
 * A UnitTest for PageWebElement objects.
 */
public final class PageWebElementTest extends TestResultsReporting {

    @Test
    public void testWebElementField() {
        final WebElementField pageWebElement = new WebElementField();
        verifyNotNull(pageWebElement);
        log.debug("pageWebElement\n{}", pageWebElement.toString());
    }

    /**
     * Test fluent interface.
     */
    @Test
    public void testFluentInterface() {
        final WebElementField pageWebElement = new WebElementField();
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
        pageWebElement.setName("className");
        pageWebElement.setStrategy(Strategy.CLASS_NAME);
        pageWebElement.setLocator("class-name");
        log.debug("pageWebElement\n{}", pageWebElement.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testClassNameStrategy() {
        final WebElementField pageWebElement = new WebElementField("className", Strategy.CLASS_NAME, "class-name");
        log.debug("pageWebElement\n{}", pageWebElement.toString());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testLinkTextStrategy() {
        final WebElementField pageWebElement = new WebElementField("linkText", Strategy.LINK_TEXT, "link");
        log.debug("pageWebElement\n{}", pageWebElement.toString());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testPartialLinkText() {
        final WebElementField pageWebElement = new WebElementField("partialLinkText", Strategy.PARTIAL_LINK_TEXT,
                "Link");
        log.debug("pageWebElement\n{}", pageWebElement.toString());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCssStrategy() {
        final WebElementField pageWebElement = new WebElementField("byCss", Strategy.CSS, "#");
        log.debug("pageWebElement\n{}", pageWebElement.toString());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testXpathStrategy() {
        final WebElementField pageWebElement = new WebElementField("byXpath", Strategy.XPATH, "//A");
        log.debug("pageWebElement\n{}", pageWebElement.toString());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testIdStrategy() {
        final WebElementField pageWebElement = new WebElementField("byId", Strategy.ID, "id");
        log.debug("pageWebElement\n{}", pageWebElement.toString());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testNameStrategy() {
        final WebElementField pageWebElement = new WebElementField("byName", Strategy.NAME, "name");
        log.debug("pageWebElement\n{}", pageWebElement.toString());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testPageWebElementStringStrategyString() {
        final WebElementField pageWebElement = new WebElementField("byName", Strategy.UNKNOWN, "name");
        log.debug("pageWebElement\n{}", pageWebElement.toString());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

}
