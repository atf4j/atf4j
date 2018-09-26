
package net.atf4j.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Gesture {
    protected WebDriver webDriver;
    protected WebElement webElement;
    protected By by;

    public Gesture(final By by) {
        this.by = by;
    }

    public Gesture(final WebElement webElement) {
        this.webElement = webElement;
    }

    public static Gesture on(final WebElement webElement) {
        final Gesture gesture = new Gesture(webElement);
        return gesture;
    }

    public static Gesture on(final By by) {
        final Gesture gesture = new Gesture(by);
        return gesture;
    }

    protected WebElement findElement(final WebDriver driver) {
        final String selector = "";
        final By id = By.id(selector);
        WebElement element = driver.findElement(id);
        if (element == null) {
            final By name = By.name(selector);
            element = driver.findElement(name);
        }
        return element;
    }
}
