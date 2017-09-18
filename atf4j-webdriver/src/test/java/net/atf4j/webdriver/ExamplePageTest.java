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
package net.atf4j.webdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * A UnitTest for ExamplePage objects.
 */
public class ExamplePageTest {

    /**
     * PageObject representing Home.
     */
    public class HomePage extends PageObject {
    }

    /**
     * The PageObject Class.
     */
    public abstract class PageObject {
        public WebDriver driver;

        /**
         * Instantiates a new page object.
         */
        PageObject() {
            this.driver = AbstractBrowserFactory.webDriver();
        }

        /**
         * Instantiates a new page object.
         * 
         * @param webDriver
         *            the web driver
         */
        PageObject(final WebDriver webDriver) {
            this.driver = webDriver;
        }
    }

    /**
     * Test.
     */
    @Test
    public void test() {
        new HomePage();
    }

}
