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
import net.atf4j.pog.PageWebElement.Strategy;

/**
 * A UnitTest for PageWebElement objects.
 */
public final class PageWebElementTest extends TestResultsReporting {

    @Test
    public void testFluentInterface() {
        final PageWebElement pageWebElement = new PageWebElement();
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
        pageWebElement.setName("className");
        pageWebElement.setStrategy(Strategy.CLASS_NAME);
        pageWebElement.setLocator("class-name");
        log.info("pageWebElement.toString() = {}", pageWebElement.toString());
        log.info("pageWebElement.toCode() = {}", pageWebElement.toCode());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testClassNameStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("className", Strategy.CLASS_NAME, "class-name");
        log.info("pageWebElement.toString() = {}", pageWebElement.toString());
        log.info("pageWebElement.toCode() = {}", pageWebElement.toCode());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testLinkTextStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("linkText", Strategy.LINK_TEXT, "link");
        log.info("pageWebElement.toString() = {}", pageWebElement.toString());
        log.info("pageWebElement.toCode() = {}", pageWebElement.toCode());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testPartialLinkText() {
        final PageWebElement pageWebElement = new PageWebElement("partialLinkText", Strategy.PARTIAL_LINK_TEXT, "Link");
        log.info("pageWebElement.toString() = {}", pageWebElement.toString());
        log.info("pageWebElement.toCode() = {}", pageWebElement.toCode());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCssStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("byCss", Strategy.CSS, "#");
        log.info("pageWebElement.toString() = {}", pageWebElement.toString());
        log.info("pageWebElement.toCode() = {}", pageWebElement.toCode());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testXpathStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("byXpath", Strategy.XPATH, "//A");
        log.info("pageWebElement.toString() = {}", pageWebElement.toString());
        log.info("pageWebElement.toCode() = {}", pageWebElement.toCode());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testIdStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("byId", Strategy.ID, "id");
        log.info("pageWebElement.toString() = {}", pageWebElement.toString());
        log.info("pageWebElement.toCode() = {}", pageWebElement.toCode());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testNameStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("byName", Strategy.NAME, "name");
        log.info("pageWebElement.toString() = {}", pageWebElement.toString());
        log.info("pageWebElement.toCode() = {}", pageWebElement.toCode());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testPageWebElementStringStrategyString() {
        final PageWebElement pageWebElement = new PageWebElement("byName", Strategy.UNKNOWN, "name");
        log.info("pageWebElement.toString() = {}", pageWebElement.toString());
        log.info("pageWebElement.toCode() = {}", pageWebElement.toCode());
        assertNotNull(UNEXPECTED_NULL, pageWebElement);
    }

}
