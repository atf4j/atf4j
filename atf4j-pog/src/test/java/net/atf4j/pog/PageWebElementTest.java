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

import net.atf4j.core.ResultsReporting;
import net.atf4j.pog.PageWebElement.Strategy;

/**
 * A UnitTest for PageWebElement objects.
 */
public class PageWebElementTest extends ResultsReporting {

    /**
     * Test method for void.
     */
    @Test
    public void testClassNameStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("className", Strategy.CLASS_NAME, "class-name");
        assertNotNull("unexpected null",pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testLinkTextStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("linkText", Strategy.LINK_TEXT, "link");
        assertNotNull("unexpected null",pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testPartialLinkText() {
        final PageWebElement pageWebElement = new PageWebElement("partialLinkText", Strategy.PARTIAL_LINK_TEXT, "Link");
        assertNotNull("unexpected null",pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCssStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("byCss", Strategy.CSS, "#");
        assertNotNull("unexpected null",pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testXpathStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("byXpath", Strategy.XPATH, "//A");
        assertNotNull("unexpected null",pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testIdStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("byId", Strategy.ID, "id");
        assertNotNull("unexpected null",pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testNameStrategy() {
        final PageWebElement pageWebElement = new PageWebElement("byName", Strategy.NAME, "name");
        assertNotNull("unexpected null",pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testPageWebElementStringStrategyString() {
        final PageWebElement pageWebElement = new PageWebElement("byName", Strategy.UNKNOWN, "name");
        assertNotNull("unexpected null",pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

}
