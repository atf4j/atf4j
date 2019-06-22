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

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assume.assumeNotNull;

import lombok.extern.slf4j.Slf4j;

/**
 * A UnitTest for a BootstrapPage object.
 */
@Ignore
@Slf4j public final class BootstrapPageTest {

    // private static final String PAGE_URL = "http://atf4j.net/bootstrap/";
    private static final String PAGE_URL = "http://127.0.0.1:8080/bootstrap";

    @Test
    public void testBootstrapPage() {
        final BootstrapPage bootstrapPage = new BootstrapPage();
        assumeNotNull(bootstrapPage);
        assertNotNull(bootstrapPage.open());
        assertNotNull(bootstrapPage.verify());
        assertNotNull(bootstrapPage.close());
    }

    @Test
    public void testBootstrapPageUrl() {
        final BootstrapPage bootstrapPage = new BootstrapPage(PAGE_URL);
        assumeNotNull(bootstrapPage);
        assertNotNull(bootstrapPage.open());
        assertNotNull(bootstrapPage.verify());
        assertNotNull(bootstrapPage.close());
    }

    @Test
    public void testBootstrapPageWebDriver() {
        final WebDriver webDriver = new ChromeDriver();
        assumeNotNull(webDriver);
        final BootstrapPage bootstrapPage = new BootstrapPage(webDriver);
        assumeNotNull(bootstrapPage);
        assertNotNull(bootstrapPage.open(PAGE_URL));
        assertNotNull(bootstrapPage.verify());
        assertNotNull(bootstrapPage.close());
    }

    @Test
    public void testInitializr() {
        final WebDriver webDriver = new ChromeDriver();
        assumeNotNull(webDriver);
        final BootstrapPage bootstrapPage = new BootstrapPage(webDriver);
        assumeNotNull(bootstrapPage);
        assertNotNull(bootstrapPage.open("http://127.0.0.1:8080/initializr"));
        assertNotNull(bootstrapPage.verify());
        assertNotNull(bootstrapPage.close());
    }

}
