
package net.atf4j.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EnterText extends Gesture {

    public EnterText(final By by) {
        super(by);
    }

    protected void slowly(final String text) {
        /// wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        final WebElement element = this.webDriver.findElement(this.by);
        element.click();
        element.clear();

        for (int index = 0; index < text.length(); index++) {
            try {
                Thread.sleep(100);
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            final char chr = text.charAt(index);
            final String key = new StringBuilder().append(chr).toString();
            element.sendKeys(key);
        }
    }
}
