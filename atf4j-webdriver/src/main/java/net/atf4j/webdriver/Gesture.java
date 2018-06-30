package net.atf4j.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Gesture {
    protected WebDriver webDriver;
    protected WebElement webElement;
    protected By by;

    public Gesture(By by) {
        this.by = by;
    }

    public Gesture(WebElement webElement) {
        this.webElement = webElement;
    }

    public static Gesture on(WebElement webElement) {
        Gesture gesture = new Gesture(webElement);
        return gesture;
    }

    public static Gesture on(By by) {
        Gesture gesture = new Gesture(by);
        return gesture;
    }

    private WebElement findElement(WebDriver driver) { 
        String selector = "";
        By id = By.id(selector);
        WebElement element = driver.findElement(id); 
        if (element == null) {
            By name = By.name(selector);
            element = driver.findElement(name);
            } 
        return element;
        }
}
