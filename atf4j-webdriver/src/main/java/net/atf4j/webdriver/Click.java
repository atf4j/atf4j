package net.atf4j.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The Class Click.
 */
public class Click extends Gesture {

    /**
     * Instantiates a new click.
     *
     * @param by the by
     */
    public Click(By by) {
        super(by);
    }

    /**
     * Instantiates a new click.
     *
     * @param webElement the web element
     */
    public Click(WebElement webElement) {
        super(webElement);
    }

}
