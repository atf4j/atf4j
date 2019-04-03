
package net.atf4j.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The Class Gesture.
 */
public class Gesture {
    
    /** The web driver. */
    protected WebDriver webDriver;
    
    /** The web element. */
    protected WebElement webElement;
    
    /** The by. */
    protected By by;

    /**
     * Instantiates a new gesture.
     *
     * @param by the by
     */
    public Gesture(final By by) {
        this.by = by;
    }

    /**
     * Instantiates a new gesture.
     *
     * @param webElement the web element
     */
    public Gesture(final WebElement webElement) {
        this.webElement = webElement;
    }

    /**
     * On.
     *
     * @param webElement the web element
     * @return the gesture
     */
    public static Gesture on(final WebElement webElement) {
        final Gesture gesture = new Gesture(webElement);
        return gesture;
    }

    /**
     * On.
     *
     * @param by the by
     * @return the gesture
     */
    public static Gesture on(final By by) {
        final Gesture gesture = new Gesture(by);
        return gesture;
    }

    /**
     * Find element.
     *
     * @param driver the driver
     * @return the web element
     */
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
