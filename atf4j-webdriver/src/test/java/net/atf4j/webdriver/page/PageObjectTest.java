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
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.webdriver.page;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import net.atf4j.core.AbstractConfig.MissingPropertyFileException;

/**
 * PageObjectTest.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class PageObjectTest {

    /**
     * The Class MockPage.
     */
    public class MockPage extends AbstractPageObject {

        protected static final String TARGET_URL = "http://127.0.0.1:8080";

        public MockPage() throws MissingPropertyFileException {
            super();
        }

        public MockPage(final String targetUrl) throws MissingPropertyFileException {
            super(targetUrl);
        }

        /**
         * Instantiates a new mock page.
         *
         * @param webDriver
         *            the web driver
         */
        public MockPage(final WebDriver webDriver) {
            super(webDriver);
        }
    }

    /**
     * Test method for
     * {@link net.net.atf4j.webdriver.page.AbstractPageObject#AbstractPageObject()}.
     * 
     * @throws MissingPropertyFileException
     */
    @Test
    public final void testDefaultConstruction() throws MissingPropertyFileException {
        new MockPage();
    }

    /**
     * Test method for
     * {@link net.net.atf4j.webdriver.page.AbstractPageObject#open()}.
     * 
     * @throws MissingPropertyFileException
     */
    @Test
    public final void testDefaultOpen() throws MissingPropertyFileException {
        new MockPage().open();
    }

    /**
     * Test method for
     * {@link net.net.atf4j.webdriver.page.AbstractPageObject#open()}.
     * 
     * @throws MissingPropertyFileException
     */
    @Test
    public final void testOpen() throws MissingPropertyFileException {
        new MockPage(MockPage.TARGET_URL).open();
    }

    /**
     * Test method for
     * {@link net.net.atf4j.webdriver.page.AbstractPageObject#open(java.lang.String)}.
     * 
     * @throws MissingPropertyFileException
     */
    @Test
    public final void testOpenString() throws MissingPropertyFileException {
        new MockPage().open(MockPage.TARGET_URL);
    }

    /**
     * Test method for
     * {@link net.net.atf4j.webdriver.page.AbstractPageObject#verify()}.
     * 
     * @throws MissingPropertyFileException
     */
    @Test
    public final void testVerify() throws MissingPropertyFileException {
        new MockPage().open().verify();
    }

}
