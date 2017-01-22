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
package net.atf4j.imperative;

import org.openqa.selenium.WebDriver;

import net.atf4j.core.AbstractConfig.ConfigurationNotLoaded;
import net.atf4j.webdriver.BrowserFactory;

/**
 * A UnitTest for SystemUnder objects.
 */
public class WebAppModel extends AbstractBehaviourModel {

    protected WebDriver webDriver;
    protected String targetUrl = "http://127.0.0.1:8080";
    protected LandingPage page;

    /**
     * A browser.
     */
    public void aBrowser() {
        log.info("aBrowser()");
        this.webDriver = BrowserFactory.webDriver();
    }

    /**
     * Use browser.
     *
     * @param browserName
     *            the browser name
     */
    public void useBrowser(final String browserName) {
        log.debug("useBrowser({})", browserName);
    }

    /**
     * Open default landing page.
     * 
     * @throws ConfigurationNotLoaded the configuration not loaded
     */
    public void open() throws ConfigurationNotLoaded {
        log.debug("open()");
        this.page = new LandingPage();
    }

    /**
     * Open the target page.
     *
     * @param targetUrl
     *            the target url
     */
    public void open(final String targetUrl) {
        log.debug("open({})", targetUrl);
        this.page.open(targetUrl);
    }

    /**
     * Verify.
     */
    public void verify() {
        log.debug("verify()");
        this.page.verify();
    }

    /**
     * Page title should be.
     *
     * @param expectedPageTitle
     *            the expected page title
     */
    public void pageTitleShouldBe(final String expectedPageTitle) {
        log.debug("pageTitleShouldBe({})", expectedPageTitle);
        this.page.verifyPageTitle(expectedPageTitle);
    }

    /**
     * Ensure cookie exists.
     * 
     * @param expectedCookieName the expected cookie name
     */
    public void ensureCookieExists(final String expectedCookieName) {
        log.debug("ensureCookieExists({})", expectedCookieName);
    }

    /**
     * The cookie has value.
     * 
     * @param expectedCookieName the expected cookie name
     */
    public void theCookieHasValue(final String expectedCookieName) {
        log.debug("{}.theCookieHasValue({})", this, expectedCookieName);
    }

}
