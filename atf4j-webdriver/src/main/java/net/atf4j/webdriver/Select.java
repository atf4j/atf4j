package net.atf4j.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Select extends Gesture {

    public Select(By by) {
        super(by);
    }

    public Select(WebElement webElement) {
        super(webElement);
    }

}
