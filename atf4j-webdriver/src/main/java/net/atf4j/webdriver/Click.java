package net.atf4j.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Click extends Gesture {

    public Click(By by) {
        super(by);
    }

    public Click(WebElement webElement) {
        super(webElement);
    }

}
