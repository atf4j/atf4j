
package net.atf4j.webdriver;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

import net.atf4j.webdriver.page.AbstractPageObject;

/**
 * An abstract class for a web-site that abstract a WebDriver instance.
 */
public abstract class AbstractWebSite {

    /** provides logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The webDriver. */
    protected WebDriver webDriver;

    /** The page. */
    protected AbstractPageObject page;

    /**
     * Default Constructor.
     */
    public AbstractWebSite() {
        this(WebDriverFactory.defaultWebDriver());
    }

    /**
     * Constructor using webDriver instance.
     *
     * @param webDriver the web driver
     */
    public AbstractWebSite(final WebDriver webDriver) {
        assertNotNull(webDriver);
        this.webDriver = webDriver;
    }

    /**
     * Constructor using site url.
     *
     * @param siteUrl the site url
     */
    public AbstractWebSite(final String siteUrl) {
        this(WebDriverFactory.defaultWebDriver());
        open(siteUrl);
    }

    /**
     * Open parameterised URL.
     *
     * @param siteUrl the site url
     */
    public void open(final String siteUrl) {
        assertNotNull(this.webDriver);
        this.log.debug("webDriver = {}", this.webDriver);

        // Navigate to the right place
        this.webDriver.get(siteUrl);
        this.log.debug("siteUrl = {}", siteUrl);
    }

    /**
     * The page is loaded.
     */
    public void thePageIsLoaded() {
        this.page.isLoaded();
    }

    /**
     * Click.
     */
    // public void click(final String text) {
    // this.page.click(text);
    // }

    /**
     * close the page.
     */
    public void close() {
        if (this.webDriver != null) {
            this.webDriver.close();
            this.webDriver = null;
        }
    }

    /**
     * Quit the browser.
     */
    public void quit() {
        if (this.webDriver != null) {
            this.webDriver.quit();
            this.webDriver = null;
        }
    }
}
