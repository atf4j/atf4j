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
package net.atf4j.webdriver;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.atf4j.core.Reporting;

public class WebDriverSmokeTest extends Reporting {

    @Test
    public void testChromeTomcat() {
        System.setProperty("webdriver.chrome.driver", "");
        final ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://127.0.0.1:8080/");
        final String pageTitle = chromeDriver.getTitle();
        this.log.info("pageTitle={}", pageTitle);
    }

    @Test
    public void testFirefoxTomcat() {
        final FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("http://127.0.0.1:8080/");
        final String pageTitle = firefoxDriver.getTitle();
        this.log.info("pageTitle={}", pageTitle);
    }

}
