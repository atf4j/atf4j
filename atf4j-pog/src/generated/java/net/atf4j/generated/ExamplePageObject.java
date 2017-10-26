// generated from main/resources/templates/PageObject.vm
// 2017-10-26 20:24.55

package net.atf4j.generated;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.atf4j.webdriver.page.AbstractPageObject;

public class ExamplePageObject extends AbstractPageObject {

		@FindBy(id = "id")
	protected WebElement findById;

		@FindBy(name = "name")
	protected WebElement findByName;

		@FindBy(className = "className")
	protected WebElement findByClassName;

		@FindBy(linkText = "linkText")
	protected WebElement findByLinkText;

		@FindBy(partialLinkText = "partialLinkText")
	protected WebElement findByPartialLinkText;

		@FindBy(xpath = "//a[contains(text(), 'ATF4J')]")
	protected WebElement findByXpath;

		@FindBy(css = ".")
	protected WebElement findByCss;


	public ExamplePageObject() {
		super();
	}

	public ExamplePageObject(WebDriver webDriver) {
		super(webDriver);
	}

	public ExamplePageObject open() {
		super.open("http://atf4j.net");
		return this;
	}

	public ExamplePageObject verify() {
		super.verifyPageTitle("Example Page");
		return this;
	}

	// Navigation Elements.
	// findByLinkText
	public ExamplePageObject navToFindByLinkText() {
		assertNotNull(findByLinkText);
		findByLinkText.click();
		return this;
	}
	// findByPartialLinkText
	public ExamplePageObject navToFindByPartialLinkText() {
		assertNotNull(findByPartialLinkText);
		findByPartialLinkText.click();
		return this;
	}

	// Input Elements

	// Content Elements
}
