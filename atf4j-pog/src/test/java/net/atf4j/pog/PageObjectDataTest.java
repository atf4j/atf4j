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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

public class PageObjectDataTest extends ResultsReporting {

    @Test
    public void testDefaultConstructor() {
        final PageObjectData pageObjectData = new PageObjectData();
        assertNotNull(pageObjectData);
        final String string = pageObjectData.toString();
        this.log.info(string);
    }

    @Test
    public void testPageObjectData() {
        final PageObjectData pageObjectData = new PageObjectData();
        assertNotNull(pageObjectData);
        final String string = pageObjectData.toString();
        this.log.info(string);
    }

    @Test
    public void testSetGetName() {
        final PageObjectData pageObjectData = new PageObjectData();
        final String expected = "TestSetName";
        assertEquals(expected, pageObjectData.setName(expected).getName());
    }

    @Test
    public void testAttribute() {
        final PageObjectData pageObjectData = new PageObjectData();
        final PageWebElement attribute = new PageWebElement();
        pageObjectData.addAttribute(attribute);
        final ArrayList<PageWebElement> attributes = pageObjectData.getAttributes();
        for (final PageWebElement pageWebElement : attributes) {
            this.log.info(pageWebElement.toString());
        }
    }

    @Test
    public void testExpected() {
        final PageObjectData pageObjectData = new PageObjectData();
        pageObjectData.addAttribute(new PageWebElement());
        pageObjectData.addAttribute(new PageWebElement());
        pageObjectData.addAttribute(new PageWebElement());
        pageObjectData.addAttribute(new PageWebElement());
        this.log.info(pageObjectData.toString());
    }

}
