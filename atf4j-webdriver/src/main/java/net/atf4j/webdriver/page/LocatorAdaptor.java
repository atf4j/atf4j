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
package net.atf4j.webdriver.page;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * WebElement Locator Adaptor.
 */
public class LocatorAdaptor {

    /** The web driver. */
    private final WebDriver webDriver;

    /**
     * The Enum LocatorType.
     */
    public enum LocatorType {

        CLASSNAME, CSS, ID, LINK, NAME, TAGNAME, XPATH;
    }

    /**
     * Instantiates a new locator adaptor.
     *
     * @param webDriver
     *            the web driver
     */
    public LocatorAdaptor(final WebDriver webDriver) {
        super();
        assertNotNull(webDriver);
        this.webDriver = webDriver;
    }

    /**
     * Object locator.
     *
     * @param identifier
     *            the identifier
     * @return the web element
     */
    public WebElement objectLocator(final String identifier) {
        final String typeString = identifier.substring(0, identifier.indexOf('='));
        final String ref = identifier.substring(identifier.indexOf('=') + 1, identifier.length());
        if (typeString.toLowerCase().contains("classname")) {
            return objectLocator(LocatorType.CLASSNAME, ref);
        } else if (typeString.toLowerCase().contains("css")) {
            return objectLocator(LocatorType.CSS, ref);
        } else if (typeString.toLowerCase().contains("id")) {
            return objectLocator(LocatorType.ID, ref);
        } else if (typeString.toLowerCase().contains("link")) {
            return objectLocator(LocatorType.LINK, ref);
        } else if (typeString.toLowerCase().contains("name")) {
            return objectLocator(LocatorType.NAME, ref);
        } else if (typeString.toLowerCase().contains("tagname")) {
            return objectLocator(LocatorType.TAGNAME, ref);
        } else if (typeString.toLowerCase().contains("xpath")) {
            return objectLocator(LocatorType.XPATH, ref);
        } else {
            return null;
        }
    }

    /**
     * Object locator.
     *
     * @param type
     *            the type
     * @param ref
     *            the ref
     * @return the web element
     */
    public WebElement objectLocator(final LocatorType type, final String ref) {
        assertNotNull(this.webDriver);
        assertNotNull(type);
        assertNotNull(ref);
        switch (type) {
        case ID:
            return this.webDriver.findElement(By.id(ref));
        case CLASSNAME:
            return this.webDriver.findElement(By.className(ref));
        case XPATH:
            return this.webDriver.findElement(By.xpath(ref));
        case CSS:
            return this.webDriver.findElement(By.cssSelector(ref));
        case LINK:
            return this.webDriver.findElement(By.linkText(ref));
        case NAME:
            return this.webDriver.findElement(By.name(ref));
        case TAGNAME:
            return this.webDriver.findElement(By.tagName(ref));
        }
        return null;
    }
}