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
package net.atf4j.webdriver;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * Utility Class.
 */
public class Utility {

    public static WebDriver webDriver;

    /**
     * Clear and set value.
     *
     * @param field the field
     * @param text the text
     */
    public static void clearAndSetValue(final WebElement field, final String text) {
        field.clear();
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), text);
    }

    /**
     * Clear and type.
     *
     * @param field the field
     * @param text the text
     */
    public static void clearAndType(final WebElement field, final String text) {
        field.clear();
        field.sendKeys(text);
    }

    /**
     * Method: clickElementWithJSE
     * Create the object of JavaScript Executor and execute click command
     * through Javascript method.
     *
     * @param id The id of a web element in a menu.
     */
    public static void clickElementWithJSE(final String id) {
        JavascriptExecutor js = (JavascriptExecutor) Utility.webDriver;
        final WebElement element = Utility.webDriver.findElement(By.id(id));
        js.executeScript("arguments[0].click();", element);
        js = null;
    }

    /**
     * Initialize browser.
     *
     * @param type the type
     */
    public static void initializeBrowser(final String type) {
        if (type.equalsIgnoreCase("firefox")) {
            Utility.webDriver = new FirefoxDriver();
        } else if (type.equalsIgnoreCase("ie")) {
            Utility.webDriver = new InternetExplorerDriver();
        }
        Utility.webDriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Utility.webDriver.manage().window().setPosition(new Point(200, 10));
        Utility.webDriver.manage().window().setSize(new Dimension(1200, 800));
    }

    /**
     * Visibility of element located.
     *
     * @param locator the locator
     * @return the expected condition
     */
    public static ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
        return new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(final WebDriver driver) {
                final WebElement toReturn = driver.findElement(locator);
                if (toReturn.isDisplayed()) {
                    return toReturn;
                }
                return null;
            }
        };
    }

    /**
     * Wait timer.
     *
     * @param units the units
     * @param mills the mills
     */
    public static void waitTimer(final int units, final int mills) {
        final DecimalFormat df = new DecimalFormat("###.##");
        final double totalSeconds = (double) units * mills / 1000;
        System.out.print(
                "Explicit pause for " + df.format(totalSeconds) + " seconds divided by " + units + " units of time: ");
        try {
            Thread.currentThread();
            int x = 0;
            while (x < units) {
                Thread.sleep(mills);
                System.out.print(".");
                x = x + 1;
            }
            System.out.print('\n');
        } catch (final InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Instantiates a new utility.
     */
    private Utility() {
        // Prevent wild instantiation.
        throw new AssertionError("Static Methods");
    }
}
