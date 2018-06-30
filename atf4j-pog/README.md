# atf4j-pog

## Automated Test Framework for Java - POG

Page Object Generator for Selenium WebDriver, in its simples form :-

	PageObjectGenerator.survey(targetUrl);

Will generate a PageObject for web page on the Url, the page object will by default include useful test features and methods.

 * Methods to open the page and initialise all locators.
 * Navigation methods for all named anchors and buttons such as navToFoo(), pressSubmit().
 * Data entry methods for all input fields, enterName(...), selectBrand(...).

See the generated [ExamplePageObject](https://github.com/atf4j/atf4j/blob/master/atf4j-pog/src/generated/java/net/atf4j/generated/ExamplePageObject.java).

The default template for the PageObject will extend AbstractPageObject, the generator uses a [Velocity template](https://github.com/atf4j/atf4j/blob/master/atf4j-pog/src/main/resources/templates/PageObject.vm)

### Automation Test Framework for Java

	<dependency>
		<groupId>net.atf4j</groupId>
		<artifactId>atf4j-pog</artifactId>
		<version>${atf4j.version}</version>
	</dependency>
