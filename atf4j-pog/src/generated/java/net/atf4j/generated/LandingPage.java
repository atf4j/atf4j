// generated from main/resources/PageObject.vm
// $timeStamp

package net.atf4j.generated;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.atf4j.webdriver.page.AbstractPageObject;

public class LandingPage extends AbstractPageObject {

	public LandingPage(WebDriver webDriver) {
		super(webDriver);
	}

	public LandingPage open() {
		super.open("http://atf4j.net/bootstrap");
		return this;
	}

	public LandingPage verify() {
		super.verifyPageTitle("Landing Page");
		return this;
	}

// Nav

// Input

// Content
}
