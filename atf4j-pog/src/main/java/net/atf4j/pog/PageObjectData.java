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

    private final ArrayList<PageWebElement> pageElements = new ArrayList<PageWebElement>();
    private final ArrayList<PageWebElement> navElements = new ArrayList<PageWebElement>();
    private final ArrayList<PageWebElement> contentElements = new ArrayList<PageWebElement>();
    private final ArrayList<PageWebElement> inputElements = new ArrayList<PageWebElement>();

    public PageObjectData() {
        super();
    }

    public PageObjectData add(final PageWebElement pageWebElement) {
        this.pageElements.add(pageWebElement);
        return this;
    }

    public PageObjectData addNav(final PageWebElement attribute) {
        this.navElements.add(attribute);
        return this;
    }

    public PageObjectData addContent(final PageWebElement attribute) {
        this.contentElements.add(attribute);
        return this;
    }

    public PageObjectData addInput(final PageWebElement attribute) {
        this.inputElements.add(attribute);
        return this;
    }

    public ArrayList<PageWebElement> get() {
        return this.pageElements;
    }

    public ArrayList<PageWebElement> getContent() {
        return this.contentElements;
    }

    public ArrayList<PageWebElement> getInput() {
        return this.inputElements;
    }

    public ArrayList<PageWebElement> getNav() {
        return this.navElements;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final PageWebElement pageWebElement : this.pageElements) {
            stringBuilder.append(pageWebElement);
        }
        for (final PageWebElement pageWebElement : this.navElements) {
            stringBuilder.append(pageWebElement);
        }
        for (final PageWebElement pageWebElement : this.contentElements) {
            stringBuilder.append(pageWebElement);
        }
        for (final PageWebElement pageWebElement : this.inputElements) {
            stringBuilder.append(pageWebElement);
        }
        return stringBuilder.toString();
    }

}
