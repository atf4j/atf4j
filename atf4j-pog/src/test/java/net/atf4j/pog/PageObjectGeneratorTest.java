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

import net.atf4j.core.TestResultsReporting;
import net.atf4j.pog.PageWebElement.Strategy;

/**
 * A UnitTest for PageObjectGenerator objects.
 */
public class PageObjectGeneratorTest extends TestResultsReporting {

    private static final String HTTP_ATF4J_NET = "http://atf4j.net";

    /**
     * Test method for void.
     *
     * @throws Exception the exception
     */
    @Test
    public void testExpected() throws Exception {
        this.log.info("==============================================");
        final PageObjectData pageObjectData = new PageObjectData();
        assertNotNull("unexpected null", pageObjectData);

        final PageWebElement idElement = new PageWebElement("findById", Strategy.ID, "id");
        final PageWebElement nameElement = new PageWebElement("findByName", Strategy.NAME, "name");
        final PageWebElement classNameElement = new PageWebElement("findByClassName", Strategy.CLASS_NAME, "className");
        final PageWebElement linkTextElement = new PageWebElement("findByLinkText", Strategy.LINK_TEXT, "linkText");
        final PageWebElement partialLinkTextElement = new PageWebElement("findByPartialLinkText",
                Strategy.PARTIAL_LINK_TEXT, "partialLinkText");
        final PageWebElement xpathElement = new PageWebElement("findByXpath", Strategy.XPATH,
                "//a[contains(text(), 'ATF4J')]");
        final PageWebElement cssElement = new PageWebElement("findByCss", Strategy.CSS, ".");

        pageObjectData
            .add(idElement)
            .add(nameElement)
            .add(classNameElement)
            .add(linkTextElement)
            .add(partialLinkTextElement)
            .add(xpathElement)
            .add(cssElement);

        pageObjectData.addNav(linkTextElement);
        pageObjectData.addNav(partialLinkTextElement);

        final PageObjectGenerator pog = new PageObjectGenerator();
        pog.target(HTTP_ATF4J_NET);
        pog.addPageTitle("Example Page");
        pog.setClassName("ExamplePageObject");
        pog.add(pageObjectData);

        this.log.info("{}", pog.generate());
        pog.generate();
    }

    /**
     * Test method for void.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPageObjectTargetSurvey() throws Exception {
        this.log.info("==============================================");
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        pageObjectGenerator.target(HTTP_ATF4J_NET).survey();
    }

    /**
     * Test method for void.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPageObjectSurvey() throws Exception {
        this.log.info("==============================================");
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        pageObjectGenerator.survey(HTTP_ATF4J_NET);
    }

    /**
     * Test method for void.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPageObjectGenerator() throws Exception {
        this.log.info("==============================================");
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        pageObjectGenerator.target(HTTP_ATF4J_NET).survey().generate();

        pageObjectGenerator.generate();
    }

}
