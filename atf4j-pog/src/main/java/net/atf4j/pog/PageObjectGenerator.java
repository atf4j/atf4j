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

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Generator for Selenium WebDriver PageObject.
 */
public class PageObjectGenerator extends AbstractCodeGenerator {

    private static final String DEFAULT_TARGET = "http://atf4j.net";
    private static final String PAGE_OBJECT_TEMPLATE = "/templates/PageObject.vm";
    private PageObjectData pageObjectData;
    private String pageUrl = DEFAULT_TARGET;
    private URL targetUrl = new URL(this.pageUrl);

    /**
     * Instantiates a new page object generator.
     *
     * @throws Exception
     *             the exception
     */
    public PageObjectGenerator() throws Exception {
        super(PAGE_OBJECT_TEMPLATE);
    }

    /**
     * Instantiates a new page object generator.
     *
     * @param templateFilename
     *            the template filename
     * @throws Exception
     *             the exception
     */
    public PageObjectGenerator(final String templateFilename) throws Exception {
        super(templateFilename);
    }

    /**
     * The URL of the Target Page.
     *
     * @param targetUrl
     *            the target url
     * @return the page object generator
     * @throws MalformedURLException
     *             the malformed URL exception
     */
    public PageObjectGenerator target(final String targetUrl) throws MalformedURLException {
        this.targetUrl = new URL(targetUrl);
        return target(this.targetUrl);
    }

    /**
     * The URL of the Target Page.
     *
     * @param targetUrl
     *            the targetUrl
     * @return the page object generator
     */
    public PageObjectGenerator target(final URL targetUrl) {
        this.targetUrl = targetUrl;
        this.pageUrl = targetUrl.toString();
        super.contextBinding("pageUrl", this.pageUrl);
        return this;
    }

    /**
     * Adds the page title.
     *
     * @param pageTitle
     *            the page title
     */
    public void addPageTitle(final String pageTitle) {
        contextBinding("pageTitle", pageTitle);
    }

    /**
     * Adds the.
     *
     * @param pageObjectData
     *            the page object data
     * @return the page object generator
     */
    public PageObjectGenerator add(final PageObjectData pageObjectData) {
        assertNotNull("unexpected null", pageObjectData);
        this.pageObjectData = pageObjectData;
        super.contextBinding("pageElements", this.pageObjectData.get());
        super.contextBinding("navigation", this.pageObjectData.getNav());
        super.contextBinding("inputs", this.pageObjectData.getInput());
        super.contextBinding("contents", this.pageObjectData.getContent());
        return this;
    }

    /**
     * Adds the.
     *
     * @param pageWebElement
     *            the page web element
     * @return the page object generator
     */
    public PageObjectGenerator add(final PageWebElement pageWebElement) {
        assertNotNull("unexpected null", pageWebElement);
        assertNotNull("unexpected null", this.pageObjectData);
        this.pageObjectData.add(pageWebElement);
        return this;
    }

    /**
     * Adds the navigation.
     *
     * @param pageWebElement
     *            the page web element
     * @return the page object generator
     */
    public PageObjectGenerator addNavigation(final PageWebElement pageWebElement) {
        assertNotNull("unexpected null", pageWebElement);
        assertNotNull("unexpected null", this.pageObjectData);
        this.pageObjectData.addNav(pageWebElement);
        return this;
    }

    /**
     * Adds the content.
     *
     * @param pageWebElement
     *            the page web element
     * @return the page object generator
     */
    public PageObjectGenerator addContent(final PageWebElement pageWebElement) {
        assertNotNull("unexpected null", pageWebElement);
        assertNotNull("unexpected null", this.pageObjectData);
        this.pageObjectData.addContent(pageWebElement);
        return this;
    }

    /**
     * Adds the input.
     *
     * @param pageWebElement
     *            the page web element
     * @return the page object generator
     */
    public PageObjectGenerator addInput(final PageWebElement pageWebElement) {
        assertNotNull("unexpected null", pageWebElement);
        assertNotNull("unexpected null", this.pageObjectData);
        this.pageObjectData.addInput(pageWebElement);
        return this;
    }

    /**
     * Survey.
     *
     * @return the page object generator
     */
    public PageObjectGenerator survey() {
        this.log.info("survey");
        this.log.info("this.pageUrl={}", this.pageUrl);
        return survey(this.pageUrl);
    }

    /**
     * Survey.
     *
     * @param pageUrl
     *            the page url
     * @return the page object generator
     */
    public PageObjectGenerator survey(final String pageUrl) {
        this.log.info("survey(pageUrl={})", pageUrl);
        addPageTitle("Landing Page");
        setClassName("LandingPage");
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.pog.CodeGenerator#toString()
     */
    @Override
    public String toString() {
        assertNotNull("unexpected null", this.pageObjectData);
        return this.pageObjectData.toString();
    }

}
