# Cucumber Selenium WebDriver

## Automated Test Framework for Feature Driven Development

Java Automated Test Framework for Feature Driven Development

## Maven Dependency

	<dependency>
		<groupId>net.atf4j</groupId>
		<artifactId>atf4j-cucumber-webdriver</artifactId>
		<version>${atf4j.version}</version>
	</dependency>

## Usage

This is the simplest possible build script setup for Cucumber using Java.
There is nothing fancy like a webapp or browser testing.
All this does is to show you how to install and run Cucumber!

Open a command window and run:

    mvn test

This runs Cucumber's runner as a test, which runs the feature files, see the `@RunWith(Cucumber.class)` annotation.

## Overriding convention using cucumber.options

The cucumber.options can be overridden using system properties.

    mvn -Dcucumber.options="..." test

### Run a subset of Features or Scenarios

Use `classpath:features` instead of `./src/test/resources/features` on your `classpath`.

### Run a particular scenario by tag

You can also specify what to run by *wip*:

    -Dcucumber.options="--tags @wip --plugin pretty"

    -Dcucumber.options="--tags not @ignore --plugin pretty"

### Specify a different formatter:

For example a JUnit formatter:

    -Dcucumber.options="--plugin junit:target/cucumber-junit-report.xml"
