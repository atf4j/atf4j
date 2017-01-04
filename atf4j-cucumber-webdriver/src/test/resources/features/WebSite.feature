@Ignore
Feature: Gherkin for Selenium WebDriver
	As an Automated Tester
	I want a quick and easy way to use Selenium WebDriver
	In order to smoke test website development

Scenario: Open URL with Chrome Browser
	Given the "Chrome" Browser
	When the target Url is "http://127.0.0.1:8080" is opened
	Then the pageTitle is "Tomcat"
	And the cookie "name" exists

Scenario: Open URL with Chromium Browser
	Given the 'Chromium' Browser
	When the target Url is 'http://127.0.0.1:8080' is opened
	Then the pageTitle is 'Tomcat'
	And the cookie 'name' exists

Scenario: Open URL with Firefox Browser
	Given the (Firefox) Browser
	When the target URL http://127.0.0.1:8080 is opened
	Then the pageTitle is (Tomcat)
	And the cookie (name) exists

Scenario: Additional Steps
	When the link (Text) is clicked
	When the button (Name) is clicked
	When the text (text) is entered into the control (Name)
	When the target Url is http://127.0.0.1:8080 is opened
	Then the pageTitle is "Tomcat"
	And the cookie "name" exists

Scenario: Open URL with Chromium Browser
	Given the 'Chromium' Browser
	When the target Url is http://127.0.0.1:8080 is opened
	Then the pageTitle is 'Tomcat'
	And the cookie 'name' exists

Scenario: Open URL with Firefox Browser
	Given the (Firefox) Browser
	When the target URL http://127.0.0.1:8080 is opened
	Then the pageTitle is (Tomcat)
	And the cookie (name) exists
