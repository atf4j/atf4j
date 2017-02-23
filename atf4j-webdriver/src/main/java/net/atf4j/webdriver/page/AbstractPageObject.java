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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.AbstractConfig.ConfigurationNotLoaded;
import net.atf4j.webdriver.BrowserFactory;
import net.atf4j.webdriver.TargetUrl;
import net.atf4j.webdriver.WebDriverConfig;

/**
 * AbstractPageObject Class.
 */
public abstract class AbstractPageObject {
    private static final String TARGET_URL = "http://127.0.0.1:8080";
    protected static final Logger log = LoggerFactory.getLogger(AbstractPageObject.class);
    protected WebDriverConfig config;
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected final String webDriverName = System.getProperty("webDriver");
    protected final String targetUrl = System.getProperty("targetUrl", TARGET_URL);

    /**
     * Instantiates a new page object.
     */
    public AbstractPageObject() {
        super();
        initialise();
        this.webDriver = BrowserFactory.webDriver();
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
        this.webDriver = BrowserFactory.webDriver();
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

    private void initialise() {
        try {
            this.config = new WebDriverConfig();
        } catch (final ConfigurationNotLoaded e) {
            log.info("Using Defaults : {}", e);
        }
    }

    /**
     * Configure time out.
     */
    private void configureTimeOut() {
        try {
            // long implicitWait = this.properties.getImplicitWait();
            this.webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

            // long pageWait = this.properties.getPageWait();
            this.webDriver.manage().timeouts().pageLoadTimeout(8, TimeUnit.SECONDS);

            this.webDriverWait = new WebDriverWait(this.webDriver, 8000, 1000);

        } catch (final Exception exception) {
            log.error(exception.toString());
        }
    }

    /**
     * Open the web page for this PageObject.
     *
     * @return this as AbstractPageObject
     */
    public AbstractPageObject open() {
        assumeNotNull(this.config);
        final String targetUrl = getTargetUrl();
        return open(targetUrl);
    }

    private String getTargetUrl() {
        String targetUrl = System.getProperty("targetUrl");
        if (targetUrl == null) {
            targetUrl = this.config.targetUrl();
            if (targetUrl == null) {
                targetUrl = getTargetUrlAnnotation();
                log.error("targetUrl from annotation");
            } else {
                log.error("targetUrl from config");
            }
        } else {
            log.info("targetUrl from System");
        }
        log.info("targetUrl={}", targetUrl);
        return targetUrl;
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
        assumeNotNull(this.webDriver);
        this.webDriver.get(pageUrl);
        PageFactory.initElements(this.webDriver, this);
        return this;
    }

    /**
     * Verify that page is valid.
     *
     * @return false to ensure this method is implemented.
     * @see net.atf4j.webdriver.page.PageInterface#verify()
     */
    public AbstractPageObject verify() {
        assumeNotNull(this.webDriver);
        this.webDriver.getTitle();
        return this;
    }

    /**
     * Verify page title.
     *
     * @param expectedPageTitle the expected page title
     * @return the abstract page object
     */
    public AbstractPageObject verifyPageTitle(final String expectedPageTitle) {
        assumeNotNull(this.webDriver);
        final String actualPageTitle = this.webDriver.getTitle();
        assertEquals(expectedPageTitle, actualPageTitle);
        return this;
    }

    /**
     * URL should be unchanged.
     *
     * @return the web page
     */
    public AbstractPageObject urlShouldBeUnchanged() {
        assumeNotNull(this.webDriver);
        final String currentUrl = this.webDriver.getCurrentUrl();
        currentUrl.equals(this.config.targetUrl());
        return this;
    }

    /**
     * Gets the current url.
     *
     * @return the current url
     */
    protected String getCurrentUrl() {
        assumeNotNull(this.webDriver);
        return this.webDriver.getCurrentUrl();
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    protected String getTitle() {
        assumeNotNull(this.webDriver);
        return this.webDriver.getTitle();
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

    public WebElement waitUntilVisible(final WebElement webElement) {
        return this.webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitUntilReady(final WebElement webElement) {
        return this.webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void clickWhenReady(final WebElement webElement) {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Close.
     */
    protected void close() {
        assumeNotNull(this.webDriver);
        this.webDriver.close();
    }

    /**
     * Quit.
     */
    protected void quit() {
        assumeNotNull(this.webDriver);
        this.webDriver.quit();
    }

    private String getTargetUrlAnnotation() {
        final Class<? extends AbstractPageObject> thisClass = this.getClass();
        final TargetUrl annotation = thisClass.getAnnotation(TargetUrl.class);
        final String targetUrlValue = annotation.value();
        System.out.println(targetUrlValue);
        return targetUrlValue;
    }

}
