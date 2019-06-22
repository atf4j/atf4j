package net.atf4j.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The Select.
 */
public class Select extends Gesture {

    /**
     * Instantiates a new select.
     *
     * @param by the by
     */
    public Select(By by) {
        super(by);
    }

    /**
     * Instantiates a new select.
     *
     * @param webElement the web element
     */
    public Select(WebElement webElement) {
        super(webElement);
    }

}
