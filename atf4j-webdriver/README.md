# atf4j-webdriver

## Automated Test Framework for Java Selenium WebDriver

Java support classes for use with Selenium WebDriver.

### W3c WebDriver

	https://www.w3.org/TR/webdriver/

## Maven Dependency

	<dependency>
		<groupId>net.atf4j</groupId>
		<artifactId>atf4j-webdriver</artifactId>
		<version>${atf4j.version}</version>
	</dependency>

## Initial Setup

Download the required binary webDrivers into the ./web-driver-bin/ folder and set the location system properties for those you wish to use.

	-Dwebdriver.gecko.driver=./web-driver-bin/geckodriver64.exe
	-Dwebdriver.edge.driver=./web-driver-bin/MicrosoftWebDriver.exe
	-Dphantomjs.binary.path=./web-driver-bin/PhantomJS.exe

## Usage

In command line shell run:

	mvn test

	mvn test -Dheadless=true
	
## Overriding options

    mvn -Doptions="value" test

Options that can be used to describe and configure the test context.
    
	-DisLocal={true|false}	- Expect and uses local browsers, requires binary webdrivers to be available
	-DisSeleniumGrid={true|false} - expects selenium grid hub, use remote web driver
	-DlocalServer={true|false} - expects selenium grid hub on localhost, uses remote web driver 
	-DisJenkins={true|false} - running on jenkins (in most case this idiom should work)
	-DisActiveMQ={true|false} - activeMQ available on localhost

### WebDriver configuration options

	 -Dwebdriver.gecko.driver=./web-driver-bin/geckodriver64.exe
	 -Dwebdriver.edge.driver=./web-driver-bin/MicrosoftWebDriver.exe
	 -Dphantomjs.binary.path=./web-driver-bin/PhantomJS.exe
