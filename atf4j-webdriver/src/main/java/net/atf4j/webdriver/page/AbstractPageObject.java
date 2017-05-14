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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.webdriver.BrowserFactory;
import net.atf4j.webdriver.TargetUrl;

/**
 * An abstract object for representing a web page .
 */
public abstract class AbstractPageObject {

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    protected PageConfig config;
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected String targetUrl;

    /**
     * Instantiates a new page object.
     */
    public AbstractPageObject() {
        super();
        this.config = initialiseConfiguration();
        this.webDriver = BrowserFactory.create();
        initialiseWebDriverTimeOut();
        this.open();
    }

    /**
     * Instantiates a new abstract page object.
     *
     * @param targetUrl
     *            the target url
     */
    public AbstractPageObject(final String targetUrl) {
        super();
        this.config = initialiseConfiguration();
        this.webDriver = BrowserFactory.create();
        initialiseWebDriverTimeOut();
        this.open(targetUrl);
    }

    /**
     * Instantiates a new page object.
     *
     * @param webDriver
     *            the web driver
     */
    public AbstractPageObject(final WebDriver webDriver) {
        super();
        this.config = initialiseConfiguration();
        this.webDriver = webDriver;
        initialiseWebDriverTimeOut();
        this.open();
    }

    /**
     * Configure time out.
     */
    private void initialiseWebDriverTimeOut() {
        assertNotNull(this.webDriver);
        final Options manage = this.webDriver.manage();
        final Timeouts timeouts = manage.timeouts();
        timeouts.implicitlyWait(this.config.implicitWait(), TimeUnit.SECONDS);
        timeouts.pageLoadTimeout(this.config.pageLoadTimeout(), TimeUnit.SECONDS);
        this.webDriverWait = new WebDriverWait(this.webDriver,
                this.config.timeOutInSeconds(),
                this.config.pollingInterval());
    }

    /**
     * Gets the current url.
     *
     * @return the current url
     */
    protected String currentUrl() {
        assertNotNull(this.webDriver);
        return this.webDriver.getCurrentUrl();
    }

    /**
     * Gets the target url.
     *
     * @return the target url
     */
    protected String targetUrl() {
        String targetUrl = System.getProperty("targetUrl");
        if (targetUrl == null) {
            targetUrl = this.config.targetUrl();
            if (targetUrl == null) {
                targetUrl = targetUrlAnnotation();
                this.log.error("targetUrl from annotation");
            } else {
                this.log.error("targetUrl from config");
            }
        } else {
            this.log.info("targetUrl from System");
        }
        this.log.info("targetUrl={}", targetUrl);
        return targetUrl;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    protected String getTitle() {
        assertNotNull(this.webDriver);
        return this.webDriver.getTitle();
    }

    /**
     * Initialise.
     */
    private PageConfig initialiseConfiguration() {
        // todo add a system property override
        return new PageConfig();
    }

    /**
     * Open the web page for this PageObject.
     *
     * @return this as AbstractPageObject
     */
    public AbstractPageObject open() {
        final String targetUrl = targetUrl();
        return open(targetUrl);
    }

    /**
     * Open.
     *
     * @param pageUrl
     *            the page url
     * @return the open as PageInterface
     * @see net.atf4j.webdriver.page.PageInterface#open()
     */
    public AbstractPageObject open(final String pageUrl) {
        assertNotNull(this.webDriver);
        this.webDriver.get(pageUrl);
        PageFactory.initElements(this.webDriver, this);
        return this;
    }

    /**
     * Gets the target url annotation.
     *
     * @return the target url annotation
     */
    private String targetUrlAnnotation() {
        final Class<? extends AbstractPageObject> thisClass = this.getClass();
        final TargetUrl annotation = thisClass.getAnnotation(TargetUrl.class);
        final String targetUrlValue = annotation.value();
        return targetUrlValue;
    }

    /**
     * URL should be unchanged.
     *
     * @return the web page
     */
    public AbstractPageObject urlShouldBeUnchanged() {
        assertNotNull(this.webDriver);
        final String currentUrl = this.webDriver.getCurrentUrl();
        currentUrl.equals(this.targetUrl());
        return this;
    }

    /**
     * Verify that page is valid.
     *
     * @return false to ensure this method is implemented.
     * @see net.atf4j.webdriver.page.PageInterface#verify()
     */
    public AbstractPageObject verify() {
        assertNotNull(this.webDriver);
        this.webDriver.getTitle();
        return this;
    }

    /**
     * Verify.
     *
     * @param webElement
     *            the web element
     * @return true, if successful
     */
    protected boolean verifyElement(final WebElement webElement) {
        assertNotNull(webElement);
        final boolean testStatus = true;
        assertNotNull(webElement);
        assertNotNull(webElement.toString());
        assertTrue(webElement.isDisplayed());
        return testStatus;
    }

    /**
     * Click when ready.
     *
     * @param webElement the web element
     */
    public void clickWhenReady(final WebElement webElement) {
        assertNotNull(webElement);
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Wait until webElement is clickable.
     *
     * @param webElement the web element
     * @return the web element when clickable, otherwise TimeoutException.
     */
    public WebElement waitUntilClickable(final WebElement webElement) {
        Assert.assertNotNull(webElement);
        return this.webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Wait until webElement is visible.
     *
     * @param webElement the web element
     * @return the webElement when visible, otherwise TimeoutException.
     */
    public WebElement waitUntilVisible(final WebElement webElement) {
        Assert.assertNotNull(webElement);
        return this.webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Wait until url is value.
     *
     * @param url the url
     * @return true if within timeout, otherwise false.
     */
    public Boolean waitUntilUrlIs(final String url) {
        return this.webDriverWait.until(ExpectedConditions.urlToBe(url));
    }

    /**
     * Verify page title.
     *
     * @param expectedPageTitle the expected page title
     * @return the abstract page object
     */
    public AbstractPageObject verifyPageTitle(final String expectedPageTitle) {
        assertNotNull(this.webDriver);
        final String actualPageTitle = this.webDriver.getTitle();
        assertEquals(expectedPageTitle, actualPageTitle);
        return this;
    }

    /**
     * Wait for title to become equal to specific text.
     *
     * @param pageTitle the page title
     * @return true if within timeout, otherwise false.
     */
    public Boolean waitUntilTitle(final String pageTitle) {
        return this.webDriverWait.until(ExpectedConditions.titleIs(pageTitle));
    }

    /**
     * Wait until title contains partial text.
     *
     * @param pageTitle the partial page title
     * @return true if within timeout, otherwise false.
     */
    public Boolean waitUntilTitleContains(final String pageTitle) {
        return this.webDriverWait.until(ExpectedConditions.titleContains(pageTitle));
    }

    /**
     * Close page.
     */
    protected void close() {
        assertNotNull(this.webDriver);
        if (this.webDriver != null) {
            this.webDriver.close();
        }
    }

    /**
     * Quit webDriver, closes browser.
     */
    protected void quit() {
        assertNotNull(this.webDriver);
        if (this.webDriver != null) {
            this.webDriver.quit();
        }
    }
}
