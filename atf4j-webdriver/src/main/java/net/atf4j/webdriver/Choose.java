package net.atf4j.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Choose extends Gesture {

    public Choose(By by) {
        super(by);
    }

    public Choose(WebElement webElement) {
        super(webElement);
    }

}
