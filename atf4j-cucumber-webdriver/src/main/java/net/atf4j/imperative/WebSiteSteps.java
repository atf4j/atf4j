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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * The WebSiteSteps Class.
 */
public class WebSiteSteps {

    protected static final Logger log = LoggerFactory.getLogger(WebSiteSteps.class);

    private SystemUnderTest webSite;

    /**
     * Named browser.
     *
     * @param browserName
     *            the browser name
     * @throws Throwable
     *             the throwable
     */
    @Given("^ the [Chrome|Firefox|Headless] Browser$")
    public void namedBrowser(final String browserName) throws Throwable {
        this.webSite.useBrowser(browserName);
    }

    /**
     * The target url is http is opened.
     *
     * @param targetUrl
     *            the target url
     * @throws Throwable
     *             the throwable
     */
    @When("^the target url (\\a*) is opened$")
    public void theTargetUrlIsHttpIsOpened(final String targetUrl) throws Throwable {
        this.webSite.open(targetUrl);
    }

    /**
     * The page title is.
     *
     * @param expectedPageTitle
     *            the expected page title
     * @throws Throwable
     *             the throwable
     */
    @Then("^the pageTitle is \"([^\"]*)\"$")
    public void thePageTitleIs(final String expectedPageTitle) throws Throwable {
        this.webSite.ensurePageTitleIs(expectedPageTitle);
        this.webSite.pageTitleSouldBe(expectedPageTitle);
    }

    /**
     * The cookie exists.
     *
     * @param cookieName
     *            the cookie name
     * @throws Throwable
     *             the throwable
     */
    @Then("^the cookie \"([^\"]*)\" exists$")
    public void theCookieExists(final String cookieName) throws Throwable {
        this.webSite.ensureCookieExists(cookieName);
    }

    /**
     * The cookie has value.
     *
     * @param cookieName
     *            the cookie name
     * @param cookieValue
     *            the cookie value
     * @throws Throwable
     *             the throwable
     */
    @Then("^the cookie \"([^\"]*)\" has value \"([^\"]*)\"$")
    public void theCookieHasValue(final String cookieName, final String cookieValue) throws Throwable {
        this.webSite.theCookieHasValue(cookieName);
    }

}
