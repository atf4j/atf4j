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
 * A UnitTest for PageObjectGenerator objects.
 */
public class PageObjectGeneratorTest extends ResultsReporting {

    private static final String HTTP_ATF4J_NET = "http://atf4j.net";

    @Test
    public void testExpected() throws Exception {
        final PageObjectData pageObjectData = new PageObjectData();
        assertNotNull(pageObjectData);

        pageObjectData.add(new PageWebElement("id", Strategy.ID, "id"))
                      .add(new PageWebElement("name", Strategy.NAME, "name"))
                      .add(new PageWebElement("className", Strategy.CLASS_NAME, "className"))
                      .add(new PageWebElement("linkText", Strategy.LINK_TEXT, "linkText"))
                      .add(new PageWebElement("partialLinkText", Strategy.PARTIAL_LINK_TEXT, "partialLinkText"))
                      .add(new PageWebElement("xpath", Strategy.XPATH, "//a[contains(text(), 'ATF4J')]"))
                      .add(new PageWebElement("css", Strategy.CSS, "."));

        pageObjectData.addNav(new PageWebElement("findByLinkText", Strategy.LINK_TEXT, "linkText"));
        pageObjectData.addNav(
                new PageWebElement("findByPartialLinkText", Strategy.PARTIAL_LINK_TEXT, "partialLinkText"));

        final PageObjectGenerator pog = new PageObjectGenerator();
        pog.target(HTTP_ATF4J_NET);
        pog.addPageTitle("Example Page");
        pog.setClassName("ExamplePageObject");
        pog.add(pageObjectData);

        this.log.info(pog.prototype());
        pog.generate();
    }

    @Test
    public void testPageObjectTargetSurvey() throws Exception {
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        pageObjectGenerator.target(HTTP_ATF4J_NET).survey();
    }

    @Test
    public void testPageObjectSurvey() throws Exception {
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        pageObjectGenerator.survey(HTTP_ATF4J_NET);
    }

    @Test
    public void testPageObjectPrototype() throws Exception {
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        pageObjectGenerator.target(HTTP_ATF4J_NET).prototype();
    }

    @Test
    public void testPageObjectGenerator() throws Exception {
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        pageObjectGenerator.target(HTTP_ATF4J_NET)
                           .survey()
                           .setClassName("LandingPage")
                           .contextBinding("pageName", "LandingPage")
                           .contextBinding("pageTitle", "Landing Page")
                           .contextBinding("packageName", "net.atf4j.webdriver.page")
                           .generate();
    }
}
