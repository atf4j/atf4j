// generated at 2018-06-21 07:44.19 from main/resources/templates/PageObject.vm

package net.atf4j.generated;

import org.openqa.selenium.WebDriver;

import net.atf4j.webdriver.page.AbstractPageObject;

public class LandingPage extends AbstractPageObject {

    public LandingPage() {
        super();
    }

    public LandingPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public LandingPage open() {
        super.open("http://atf4j.net");
        return this;
    }

    @Override
    public LandingPage verify() {
        super.verifyPageTitle("Landing Page");
        return this;
    }

    // Navigation Elements.

    // Input Elements

    // Content Elements
}
