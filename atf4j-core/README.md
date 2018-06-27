# atf4j-core

## Automation Test Framework for Java - Core

Core for the Automation Test Framework for Java.

## Maven Dependency

	<dependency>
		<groupId>net.atf4j</groupId>
		<artifactId>atf4j-core</artifactId>
		<version>${atf4j.version}</version>
	</dependency>

## Overriding options

    mvn -Doptions="value" test

### Maven usage on local machine

	mvn test -DisLocal=true

### Maven usage on Jenkins 

	mvn test -DisJenkins=true

### Maven usage with Selenium Grid

	mvn test -DisSeleniumGrid=true

The following is a list of options that can be used to describe and configure the test context.

	-DisLocal={true|false}				- Expect and use local browsers
	-DisSeleniumGrid={true|false}		- expects selenium grid hub, use remote web driver. 
	-DlocalServer={true|false}			- expects selenium grid hub on localhost, uses remote web driver, 
	-DisJenkins={true|false}			- running on jenkins (in most case this idiom should work).
	-DisActiveMQ={true|false}			- activeMQ available on localhost

## Example Code

