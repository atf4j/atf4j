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

import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * Browser Cookie Manager, save and restore cookies to their original state.
 */
public class CookieManager {

    private WebDriver webDriver = null;
    private Set<Cookie> cookies = null;

    /**
     * CookieManager constructor.
     *
     * @param webDriver
     *            associated with Browser Session.
     */
    public CookieManager(final WebDriver webDriver) {
        setWebDriver(webDriver);
    }

    /**
     * Add a the cookie to the local cache.
     *
     * @param cookie
     *            the cookie to be added to store.
     * @return true, if successful, otherwise false.
     */
    public boolean add(final Cookie cookie) {
        return cookies.add(cookie);
    }

    /**
     * Delete all the cookie associated with the site page.
     */
    public void clear() {
        webDriver.manage().deleteAllCookies();
    }

    /**
     * Checks to see if a specific cookie is stored in the local cache.
     *
     * @param cookie
     *            the cookie to be checked.
     * @return true, if cookie is stored, otherwise false.
     */
    public boolean contains(final Cookie cookie) {
        return cookies.contains(cookie);
    }

    /**
     * Checks if cookies have been stored in the local cache.
     *
     * @return true, if there are no cookies, otherwise false.
     */
    public boolean isEmpty() {
        return cookies.isEmpty();
    }

    /**
     * Removes the cookie from the local cache.
     *
     * @param cookie
     *            the cookie to be removed.
     * @return true, if successful, otherwise false.
     */
    public boolean remove(final Cookie cookie) {
        return cookies.remove(cookie);
    }

    /**
     * Restore the Browser cookies to previous state from the local cache.
     */
    public void restore() {
        if (cookies != null) {
            cookies = webDriver.manage().getCookies();
            for (final Cookie cookie : cookies) {
                webDriver.manage().addCookie(cookie);
            }
        }
    }

    /**
     * Save the cookies associated with the site page to the local cache.
     */
    public void save() {
        cookies = webDriver.manage().getCookies();
    }

    /**
     * Set the webDriver.
     *
     * @param webDriver
     *            the web driver
     * @return the web driver
     */
    private WebDriver setWebDriver(final WebDriver webDriver) {
        assertNotNull(this.webDriver);
        return this.webDriver = webDriver;
    }
}
