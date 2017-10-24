// generated from main/resources/templates/PageObject.vm
// $timeStamp

package net.atf4j.generated;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.atf4j.webdriver.page.AbstractPageObject;

public class ExamplePageObject extends AbstractPageObject {

		@FindBy(id = "id")
	private WebElement findById;


		@FindBy(name = "name")
	private WebElement findByName;


		@FindBy(className = "className")
	private WebElement findByClassName;


		@FindBy(linkText = "linkText")
	private WebElement findByLinkText;


		@FindBy(partialLinkText = "partialLinkText")
	private WebElement findByPartialLinkText;


		@FindBy(xpath = "//a[contains(text(), 'ATF4J')]")
	private WebElement findByXpath;


		@FindBy(css = ".")
	private WebElement findByCss;



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
