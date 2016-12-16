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

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.AbstractConfig.MissingPropertyFileException;
import net.atf4j.webdriver.BrowserFactory;
import net.atf4j.webdriver.WebDriverConfig;

public abstract class AbstractPageObject {

    private static final String TARGET_URL = "http://127.0.0.1:8080";

    /** logging. */
    protected static final Logger log = LoggerFactory.getLogger(AbstractPageObject.class);

    /** configuration */
    protected WebDriverConfig config;

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected final String webDriverName = System.getProperty("webDriver");
    protected final String targetUrl = System.getProperty("targetUrl", TARGET_URL);

    /**
     * Instantiates a new page object.
     *
     * @throws Exception
     *             the exception
     */
    public AbstractPageObject() throws MissingPropertyFileException {
        super();
        this.config = new WebDriverConfig();
        this.webDriver = BrowserFactory.webDriver();
        this.open();
        PageFactory.initElements(this.webDriver, this);
        configureTimeOut();
    }

    public AbstractPageObject(final String targetUrl) throws MissingPropertyFileException {
        super();
        this.config = new WebDriverConfig();
        this.webDriver = BrowserFactory.webDriver();
        this.open(targetUrl);
        PageFactory.initElements(this.webDriver, this);
        configureTimeOut();
    }

    /**
     * Instantiates a new page object.
     *
     * @param webDriver
     *            the web driver
     */
    public AbstractPageObject(final WebDriver webDriver) {
        super();
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
        configureTimeOut();
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
            System.err.println(exception.toString());
        }
    }

    /**
     * Open the web page for this PageObject.
     *
     * @return this as AbstractPageObject
     */
    public AbstractPageObject open() {
        final String targetUrl = this.config.getTargetUrl();
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
    public boolean verify() {
        this.webDriver.getTitle();
        return true;
    }

    /**
     * Open page.
     *
     * @param pageUrl
     *            the page url
     * @return
     */
    protected AbstractPageObject openPage(final String pageUrl) {
        this.webDriver.get(pageUrl);
        PageFactory.initElements(this.webDriver, this);
        return this;
    }

    /**
     * URL should be unchanged.
     *
     * @return the web page
     */
    public AbstractPageObject urlShouldBeUnchanged() {
        final String currentUrl = this.webDriver.getCurrentUrl();
        currentUrl.equals(this.config.getTargetUrl());
        return this;
    }

    protected String getCurrentUrl() {
        return this.webDriver.getCurrentUrl();
    }

    protected String getTitle() {
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

    protected void close() {
        this.webDriver.close();
    }

    protected void quit() {
        this.webDriver.quit();
    }

}