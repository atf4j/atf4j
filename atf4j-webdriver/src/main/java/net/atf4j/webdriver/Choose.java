package net.atf4j.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The Choose.
 */
public class Choose extends Gesture {

    /**
     * Instantiates a new choose.
     *
     * @param by the by
     */
    public Choose(By by) {
        super(by);
    }

    /**
     * Instantiates a new choose.
     *
     * @param webElement the web element
     */
    public Choose(WebElement webElement) {
        super(webElement);
    }

}
