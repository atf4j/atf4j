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

public abstract class SystemUnderTest {

    protected static final Logger log = LoggerFactory.getLogger(WebSiteSteps.class);

    public void useBrowser(final String browserName) {
        log.debug("{}.useBrowser({})", this, browserName);
    }

    public void open(final String targetUrl) {
        log.debug("{}.open({})", this, targetUrl);
    }

    public void verify() {
        log.debug("{}.verify({})", this);
    }

    public void ensurePageTitleIs(final String expectedPageTitle) {
        log.debug("{}.ensurePageTitleIs({})", this);
    }

    public void pageTitleSouldBe(final String expectedPageTitle) {
        log.debug("{}.pageTitleSouldBe({})", this);
    }

    public void ensureCookieExists(final String cookieName) {
        log.debug("{}.ensureCookieExists({})", this);
    }

    public void theCookieHasValue(final String cookieName) {
        log.debug("{}.theCookieHasValue({})", this);
    }
}
