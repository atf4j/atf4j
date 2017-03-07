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
package net.atf4j.webdriver.page;

import org.junit.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class BoilerplatePageTest {

    private static final String KEY = "targetUrl";
    private static final String PAGE_URL = "http://127.0.0.1:8080/bootstrap";

    @Test
    public void testBoilerplatePage() {
        final BoilerplatePage boilerplatePage = new BoilerplatePage();
        boilerplatePage.open();
        boilerplatePage.verify();
        boilerplatePage.close();
    }

    @Test
    public void testBoilerplatePageUrl() {
        final BoilerplatePage boilerplatePage = new BoilerplatePage(BoilerplatePageTest.PAGE_URL);
        boilerplatePage.open();
        boilerplatePage.verify();
        boilerplatePage.close();
    }

    @Test
    public void testBoilerplatePageWebDriver() {
        final HtmlUnitDriver webDriver = new HtmlUnitDriver();
        final BoilerplatePage boilerplatePage = new BoilerplatePage(webDriver);
        boilerplatePage.open();
        boilerplatePage.verify();
        boilerplatePage.close();
    }

}
