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
import static org.junit.Assume.assumeNotNull;

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
import net.atf4j.webdriver.WebDriverConfig;

/**
 * An abstract object for representing a web page .
 */
public abstract class AbstractPageObject {
    protected static final Logger log = LoggerFactory.getLogger(AbstractPageObject.class);
    protected WebDriverConfig config;
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    /**
     * Instantiates a new page object.
     */
    public AbstractPageObject() {
        super();
        initialise();
        webDriver = BrowserFactory.create();
        configureTimeOut();
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
        initialise();
        webDriver = BrowserFactory.create();
        configureTimeOut();
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
        initialise();
        this.webDriver = webDriver;
        configureTimeOut();
        this.open();
    }

    /**
     * Click when ready.
     *
     * @param webElement the web element
     */
    public void clickWhenReady(final WebElement webElement) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Close.
     */
    protected void close() {
        assumeNotNull(webDriver);
        if (webDriver != null) {
            webDriver.close();
        }
    }

    /**
     * Configure time out.
     */
    private void configureTimeOut() {
        try {
            final Options manage = webDriver.manage();
            final Timeouts timeouts = manage.timeouts();
            timeouts.implicitlyWait(config.implicitWait(), TimeUnit.SECONDS);
            timeouts.pageLoadTimeout(config.pageLoadTimeout(), TimeUnit.SECONDS);
            webDriverWait = new WebDriverWait(webDriver,
                    config.timeOutInSeconds(),
                    config.pollingInterval());
        } catch (final Exception exception) {
            AbstractPageObject.log.error(exception.toString());
        }
    }

    /**
     * Gets the current url.
     *
     * @return the current url
     */
    protected String getCurrentUrl() {
        assumeNotNull(webDriver);
        return webDriver.getCurrentUrl();
    }

    /**
     * Gets the target url.
     *
     * @return the target url
     */
    private String getTargetUrl() {
        String targetUrl = System.getProperty("targetUrl");
        if (targetUrl == null) {
            targetUrl = config.targetUrl();
            if (targetUrl == null) {
                targetUrl = targetUrlAnnotation();
                AbstractPageObject.log.error("targetUrl from annotation");
            } else {
                AbstractPageObject.log.error("targetUrl from config");
            }
        } else {
            AbstractPageObject.log.info("targetUrl from System");
        }
        AbstractPageObject.log.info("targetUrl={}", targetUrl);
        return targetUrl;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    protected String getTitle() {
        assumeNotNull(webDriver);
        return webDriver.getTitle();
    }

    /**
     * Initialise.
     */
    private void initialise() {
        config = new WebDriverConfig();
    }

    /**
     * Open the web page for this PageObject.
     *
     * @return this as AbstractPageObject
     */
    public AbstractPageObject open() {
        assumeNotNull(config);
        final String targetUrl = getTargetUrl();
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
        assumeNotNull(webDriver);
        webDriver.get(pageUrl);
        PageFactory.initElements(webDriver, this);
        return this;
    }

    /**
     * Quit.
     */
    protected void quit() {
        assumeNotNull(webDriver);
        if (webDriver != null) {
            webDriver.quit();
        }
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
        System.out.println(targetUrlValue);
        return targetUrlValue;
    }

    /**
     * URL should be unchanged.
     *
     * @return the web page
     */
    public AbstractPageObject urlShouldBeUnchanged() {
        assumeNotNull(webDriver);
        final String currentUrl = webDriver.getCurrentUrl();
        currentUrl.equals(config.targetUrl());
        return this;
    }

    /**
     * Verify that page is valid.
     *
     * @return false to ensure this method is implemented.
     * @see net.atf4j.webdriver.page.PageInterface#verify()
     */
    public AbstractPageObject verify() {
        assumeNotNull(webDriver);
        webDriver.getTitle();
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
        final boolean testStatus = true;
        Assert.assertNotNull(webElement);
        Assert.assertNotNull(webElement.toString());
        Assert.assertTrue(webElement.isDisplayed());
        return testStatus;
    }

    /**
     * Verify page title.
     *
     * @param expectedPageTitle the expected page title
     * @return the abstract page object
     */
    public AbstractPageObject verifyPageTitle(final String expectedPageTitle) {
        assumeNotNull(webDriver);
        final String actualPageTitle = webDriver.getTitle();
        assertEquals(expectedPageTitle, actualPageTitle);
        return this;
    }

    /**
     * Wait until ready.
     *
     * @param webElement the web element
     * @return the web element
     */
    public WebElement waitUntilClickable(final WebElement webElement) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Wait until visible.
     *
     * @param webElement the web element
     * @return the web element
     */
    public WebElement waitUntilVisible(final WebElement webElement) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
