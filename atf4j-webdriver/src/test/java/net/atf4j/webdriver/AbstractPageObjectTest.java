
package net.atf4j.webdriver;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import lombok.extern.slf4j.Slf4j;
import net.atf4j.webdriver.page.AbstractPageObject;

/**
 * Unit Test class for the AbstractPageObject class.
 */
@Slf4j
public final class AbstractPageObjectTest {

    /**
     * A Mock Page object to test the PageUrl annotation.
     */
    @PageUrl("http://127.0.0.1:8080")
    public class TestPageUrl extends AbstractPageObject {
    }

    /**
     * A Mock Page object to test overriding page URL.
     */
    public class LandingPage extends AbstractPageObject {

        /*
         * (non-Javadoc)
         * @see automation.webdriver.AbstractPageObject#pageUrl()
         */
        @Override
        protected String pageUrl() {
            return "http://127.0.0.1:8080";
        }
    }

    /**
     * A Mock Page object to test a site landing page.
     */
    public class SitePage extends AbstractPageObject {

        /**
         * When all pages for a site include a PageHeader.
         */
        public class PageHeader extends AbstractPageObject {

            /**
             * The Constructor.
             *
             * @param webDriver the web driver
             */
            public PageHeader(final WebDriver webDriver) {
                super(webDriver);
            }
        }

        /**
         * When all pages for a site include a PageFooter.
         */
        public class PageFooter extends AbstractPageObject {

            /**
             * The Constructor.
             *
             * @param webDriver the web driver
             */
            public PageFooter(final WebDriver webDriver) {
                super(webDriver);
            }
        }

        /** The page header. */
        private final PageHeader pageHeader;

        /** The page footer. */
        private final PageFooter pageFooter;

        /**
         * Default Constructor for a site page.
         */
        public SitePage() {
            super();
            this.pageHeader = new PageHeader(this.webDriver);
            this.pageFooter = new PageFooter(this.webDriver);
        }

        /**
         * The Constructor.
         *
         * @param webDriver the web driver
         */
        public SitePage(final WebDriver webDriver) {
            super();
            this.pageHeader = new PageHeader(webDriver);
            this.pageFooter = new PageFooter(webDriver);
        }

        /*
         * (non-Javadoc)
         * @see automation.webdriver.AbstractPageObject#pageUrl()
         */
        @Override
        protected String pageUrl() {
            return "http://127.0.0.1:8080";
        }

        /*
         * (non-Javadoc)
         * @see automation.webdriver.AbstractPageObject#verify()
         */
        @Override
        public AbstractPageObject verify() {
            super.verify();
            this.pageHeader.verify();
            this.pageFooter.verify();
            return this;
        }

    }

    /**
     * Unit test to landing page.
     */
    @Test
    public void testLandingPage() {
        final LandingPage aPage = new LandingPage();
        assertNotNull(aPage);
        assertEquals(aPage, aPage.open());
        assertEquals(aPage, aPage.verify());
        log.info(aPage.toString());
        aPage.quit();
    }

    /**
     * Unit test to site page.
     */
    @Test
    public void testSitePage() {
        final SitePage sitePage = new SitePage();
        assertNotNull(sitePage);
        assertEquals(sitePage, sitePage.open());
        assertEquals(sitePage, sitePage.verify());
        log.info(sitePage.toString());
        sitePage.quit();
    }

}
