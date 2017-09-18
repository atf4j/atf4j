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
 * PageObject data class. <code>
 * &#64;FindBy(id = "")
 * &#64;FindBy(name = "")
 * &#64;FindBy(linkText = "")
 * &#64;FindBy(partialLinkText = "")
 * &#64;FindBy(className = "")
 * &#64;FindBy(xpath = "")
 * &#64;FindBy(css = "")
 * </code>
 */
public class PageObjectData {

    private final ArrayList<PageWebElement> pageElements = new ArrayList<PageWebElement>();
    private final ArrayList<PageWebElement> navElements = new ArrayList<PageWebElement>();
    private final ArrayList<PageWebElement> inputElements = new ArrayList<PageWebElement>();
    private final ArrayList<PageWebElement> contentElements = new ArrayList<PageWebElement>();

    /**
     * Instantiates a new page object data.
     */
    public PageObjectData() {
        super();
    }

    /**
     * Adds the.
     *
     * @param pageWebElement
     *            the page web element
     * @return the page object data
     */
    public PageObjectData add(final PageWebElement pageWebElement) {
        this.pageElements.add(pageWebElement);
        return this;
    }

    /**
     * Adds the nav.
     *
     * @param navElement
     *            the nav element
     * @return the page object data
     */
    public PageObjectData addNav(final PageWebElement navElement) {
        this.navElements.add(navElement);
        return this;
    }

    /**
     * Adds the content.
     *
     * @param contentMethod
     *            the content method
     * @return the page object data
     */
    public PageObjectData addContent(final PageWebElement contentMethod) {
        this.contentElements.add(contentMethod);
        return this;
    }

    /**
     * Adds the input.
     *
     * @param inputMethod
     *            the input method
     * @return the page object data
     */
    public PageObjectData addInput(final PageWebElement inputMethod) {
        this.inputElements.add(inputMethod);
        return this;
    }

    /**
     * Gets the.
     *
     * @return the array list
     */
    public ArrayList<PageWebElement> get() {
        return this.pageElements;
    }

    /**
     * Gets the content.
     *
     * @return the content
     */
    public ArrayList<PageWebElement> getContent() {
        return this.contentElements;
    }

    /**
     * Gets the input.
     *
     * @return the input
     */
    public ArrayList<PageWebElement> getInput() {
        return this.inputElements;
    }

    /**
     * Gets the nav.
     *
     * @return the nav
     */
    public ArrayList<PageWebElement> getNav() {
        return this.navElements;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final PageWebElement pageWebElement : this.pageElements) {
            stringBuilder.append(pageWebElement);
        }
        for (final PageWebElement pageWebElement : this.navElements) {
            stringBuilder.append(pageWebElement);
        }
        for (final PageWebElement pageWebElement : this.inputElements) {
            stringBuilder.append(pageWebElement);
        }
        for (final PageWebElement pageWebElement : this.contentElements) {
            stringBuilder.append(pageWebElement);
        }
        return stringBuilder.toString();
    }
}
