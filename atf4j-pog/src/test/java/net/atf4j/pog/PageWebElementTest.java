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

public class PageWebElementTest extends ResultsReporting {

    @Test
    public void testDefaultConstructor() {
        final PageWebElement pageWebElement = new PageWebElement();
        assertNotNull(pageWebElement);
    }

    @Test
    public void testPageWebElement() {
        final PageWebElement pageWebElement = new PageWebElement();
        assertNotNull(pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

    @Test
    public void testPageWebElementStringStrategyString() {
        final PageWebElement pageWebElement = new PageWebElement("name", Strategy.UNKNOWN, "locator");
        assertNotNull(pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

    @Test
    public void testPageWebElementStringStringStrategyString() {
        final PageWebElement pageWebElement = new PageWebElement("type", "name", Strategy.UNKNOWN, "locator");
        assertNotNull(pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

    @Test
    public void testPageWebElementStringStringString() {
        final PageWebElement pageWebElement = new PageWebElement("name", "Unknown", "locator");
        assertNotNull(pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

    @Test
    public void testPageWebElementStringStringStringString() {
        final PageWebElement pageWebElement = new PageWebElement("type", "name", "locatorType", "locator");
        assertNotNull(pageWebElement);
        final String string = pageWebElement.toString();
        this.log.info(string);
    }

}
