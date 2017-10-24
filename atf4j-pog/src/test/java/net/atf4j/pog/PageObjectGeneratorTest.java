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
import net.atf4j.pog.WebElementField.Strategy;

/**
 * A UnitTest for PageObjectGenerator objects.
 */
public final class PageObjectGeneratorTest extends TestResultsReporting {

    /** HTTP_ATF4J_NET. */
    private static final String HTTP_ATF4J_NET = "http://atf4j.net";

    /** BOILERPLATE_PAGE. */
    private static final String BOILERPLATE_PAGE = "http://atf4j.net/boilerplate";

    /** BOOTSTRAP_PAGE. */
    private static final String BOOTSTRAP_PAGE = "http://atf4j.net/bootstrap";

    /**
     * Test method for void.
     *
     * @throws Exception the exception
     */
    @Test
    public void testExpected() throws Exception {
        final PageObjectData pageObjectData = new PageObjectData();
        assertNotNull(UNEXPECTED_NULL, pageObjectData);

        final WebElementField idElement = new WebElementField("findById", Strategy.ID, "id");
        final WebElementField nameElement = new WebElementField("findByName", Strategy.NAME, "name");
        final WebElementField classNameElement = new WebElementField("findByClassName", Strategy.CLASS_NAME, "className");
        final WebElementField linkTextElement = new WebElementField("findByLinkText", Strategy.LINK_TEXT, "linkText");
        final WebElementField partialLinkTextElement = new WebElementField("findByPartialLinkText",
                Strategy.PARTIAL_LINK_TEXT, "partialLinkText");
        final WebElementField xpathElement = new WebElementField("findByXpath", Strategy.XPATH,
                "//a[contains(text(), 'ATF4J')]");
        final WebElementField cssElement = new WebElementField("findByCss", Strategy.CSS, ".");

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
        pog.generate();
    }

    /**
     * Test method for void.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPageObjectTargetSurvey() throws Exception {
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        assertNotNull(UNEXPECTED_NULL, pageObjectGenerator);
        pageObjectGenerator.target(HTTP_ATF4J_NET).survey();
    }

    /**
     * Test method for void.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPageObjectSurvey() throws Exception {
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        assertNotNull(UNEXPECTED_NULL, pageObjectGenerator);
        pageObjectGenerator.survey(HTTP_ATF4J_NET);
    }

    /**
     * Test method for void.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPageObjectGenerator() throws Exception {
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        assertNotNull(UNEXPECTED_NULL, pageObjectGenerator);
        pageObjectGenerator.target(HTTP_ATF4J_NET).survey().generate();
    }

    /**
     * Test method for void.
     *
     * @throws Exception the exception
     */
    @Test
    public void testBoilerPlatePageObjectGenerator() throws Exception {
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        assertNotNull(UNEXPECTED_NULL, pageObjectGenerator);
        pageObjectGenerator.target(BOILERPLATE_PAGE).survey().generate();
    }

    /**
     * Test method for void.
     *
     * @throws Exception the exception
     */
    @Test
    public void testBootstrapPageObjectGenerator() throws Exception {
        final PageObjectGenerator pageObjectGenerator = new PageObjectGenerator();
        assertNotNull(UNEXPECTED_NULL, pageObjectGenerator);
        pageObjectGenerator.target(BOOTSTRAP_PAGE).survey().generate();
    }
}
