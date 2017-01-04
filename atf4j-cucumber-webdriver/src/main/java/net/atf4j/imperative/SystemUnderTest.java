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
package net.atf4j.imperative;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A UnitTest for SystemUnder objects.
 */
public abstract class SystemUnderTest {

    protected static final Logger log = LoggerFactory.getLogger(WebSiteSteps.class);

    /**
     * Use browser.
     *
     * @param browserName
     *            the browser name
     */
    public void useBrowser(final String browserName) {
        log.debug("{}.useBrowser({})", this, browserName);
    }

    /**
     * Open.
     *
     * @param targetUrl
     *            the target url
     */
    public void open(final String targetUrl) {
        log.debug("{}.open({})", this, targetUrl);
    }

    /**
     * Verify.
     */
    public void verify() {
        log.debug("{}.verify({})", this);
    }

    /**
     * Ensure page title is.
     *
     * @param expectedPageTitle
     *            the expected page title
     */
    public void ensurePageTitleIs(final String expectedPageTitle) {
        log.debug("{}.ensurePageTitleIs({})", this);
    }

    /**
     * Page title sould be.
     *
     * @param expectedPageTitle
     *            the expected page title
     */
    public void pageTitleSouldBe(final String expectedPageTitle) {
        log.debug("{}.pageTitleSouldBe({})", this);
    }

    /**
     * Ensure cookie exists.
     *
     * @param cookieName
     *            the cookie name
     */
    public void ensureCookieExists(final String cookieName) {
        log.debug("{}.ensureCookieExists({})", this);
    }

    /**
     * The cookie has value.
     *
     * @param cookieName
     *            the cookie name
     */
    public void theCookieHasValue(final String cookieName) {
        log.debug("{}.theCookieHasValue({})", this);
    }
}
