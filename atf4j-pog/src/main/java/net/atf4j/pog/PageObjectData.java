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

import java.util.ArrayList;

/**
 * PageObject data class.
 *
 * @FindBy(id = "")
 * @FindBy(name = "")
 * @FindBy(linkText = "")
 * @FindBy(partialLinkText = "")
 * @FindBy(className = "")
 * @FindBy(xpath = "")
 * @FindBy(css = "")
 */
public class PageObjectData {
    private String pageName;
    private final ArrayList<PageWebElement> pageElements = new ArrayList<PageWebElement>();

    public PageObjectData() {
        super();
    }

    public PageObjectData(final String pageName) {
        super();
        setName(pageName);
    }

    public PageObjectData setName(final String name) {
        this.pageName = name;
        return this;
    }

    public String getName() {
        return this.pageName;
    }

    public PageObjectData addAttribute(final PageWebElement attribute) {
        this.pageElements.add(attribute);
        return this;
    }

    public ArrayList<PageWebElement> getAttributes() {
        return this.pageElements;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final PageWebElement pageWebElement : this.pageElements) {
            stringBuilder.append(pageWebElement);
        }
        return stringBuilder.toString();
    }

}
