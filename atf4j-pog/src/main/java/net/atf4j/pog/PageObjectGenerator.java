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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Generator for Selenium WebDriver PageObject.
 */
public class PageObjectGenerator extends JavaClassGenerator {
    private static final String PAGE_OBJECT_TEMPLATE = "/templates/PageObject.vm";
    protected URL targetUrl;

    public PageObjectGenerator() throws Exception {
        super(PAGE_OBJECT_TEMPLATE);
    }

    /**
     * Instantiates a new page object generator.
     *
     * @param templateFilename
     *            the template filename
     * @throws TemplateNotLoaded
     *             the template not loaded
     */
    public PageObjectGenerator(final String templateFilename) throws Exception {
        super(templateFilename);
    }

    /**
     * Target Page
     *
     * @param targetUrl
     *            the target url
     * @return the page object generator
     * @throws MalformedURLException
     *             the malformed URL exception
     */
    public PageObjectGenerator target(final String targetUrl) throws MalformedURLException {
        return target(new URL(targetUrl));
    }

    /**
     * Target.
     *
     * @param url
     *            the url
     * @return the page object generator
     */
    private PageObjectGenerator target(final URL targetUrl) {
        this.targetUrl = targetUrl;
        return this;
    }

    public void showPageObjectData() {
        for (int i = 0; i < this.fields.size(); i++) {
            final PageObjectData pageObjectData = new PageObjectData();
            System.out.println(pageObjectData.getName());
            System.out.println(pageObjectData.toString());

            final ArrayList<?> attrs = pageObjectData.getAttributes();
            final ClassField classField = this.fields.get(i);
            System.out.println(classField.toString());

            for (int j = 0; j < attrs.size(); j++) {
                final PageWebElement at = (PageWebElement) attrs.get(j);
                System.out.print("\t" + at.getLocatorType());
                System.out.print("\t " + at.getLocator());
                // System.out.print("\t" + at.getAttributeType());
                // System.out.println("\t " + at.getAttributName());
            }
        }
    }
}
