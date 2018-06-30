package net.atf4j.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EnterText extends Gesture {
   
    public EnterText(By by) {
        super(by);
    }

    protected void slowly(String text){
        /// wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        WebElement element = this.webDriver.findElement(by);
        element.click();
        element.clear();

        for (int index = 0; index < text.length(); index++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            char chr = text.charAt(index);
            String key = new StringBuilder().append(chr).toString();
            element.sendKeys(key);
        }
    }
}
