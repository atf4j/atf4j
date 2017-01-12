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

import org.junit.Test;

import net.atf4j.core.ResultsReporting;
import net.atf4j.pog.JavaClassGenerator.TemplateNotLoaded;

/**
 * A UnitTest for PageObjectGenerator objects.
 */
public class PageObjectGeneratorTest extends ResultsReporting {

    private static final String MISSING_TEMPLATE = "/templates/Missing.vm";

    /**
     * Test method for PageObjectGenerator.
     *
     * @throws TemplateNotLoaded
     *             the template not loaded
     */
    @Test(expected = TemplateNotLoaded.class)
    public void testMissingTemplate() throws Exception {
        new PageObjectGenerator(MISSING_TEMPLATE);
    }

    /**
     * Test method for PageObjectGenerator.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testPageObjectGenerator() throws Exception {
        final PageObjectGenerator pog = new PageObjectGenerator();
        pog.target("http://atf4j.net");
        final String className = "LandingPage";
        pog.setClassName(className);
        pog.contextBinding("pageName", className);
        pog.contextBinding("packageName", "net.atf4j.webdriver.page");
        pog.generate();
    }

}
