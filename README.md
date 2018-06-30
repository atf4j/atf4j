# atf4j
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/9689b2cfb86e4d5a934e031decb1f1ac)](https://www.codacy.com/app/Martin-Spamer/atf4j?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=atf4j/atf4j&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/atf4j/atf4j.svg?branch=master)](https://travis-ci.org/atf4j/atf4j)

## Automation Test Framework for Java

An automated test framework for Java, acts as glue for a testing tools, coded with a strong mind to Computer Science and Software Engineering principles.  It follows the convention over configuration allows test suites to be build that will run reliable across environments.

## Usage 

### Clone the project locally

	git clone https://github.com/atf4j/atf4j.git

### Build and Install using Maven

To install atf4j into your local repository.

	mvn install

### Maven Dependency

The project artifact will now be installed in your local repository and can be included in your project with the following dependency.

	<dependency>
		<groupId>net.atf4j</groupId>
		<artifactId>atf4j</artifactId>
		<version>${atf4j.version}</version>
	</dependency>

### Framework Features
- [ActiveMQ integration with atf4j-amq](/atf4j-amq)
- [Testing Annotations atf4j-annotations](/atf4j-annotations)
- [Core Testing classes atf4j-core](/atf4j-core)
- [CSV files for testing atf4j-csv](/atf4j-csv)
- [Cucumber and WebDriver integration atf4j-cucumber-webdriver](/atf4j-cucumber-webdriver)
- [Test Data Manager and Factory atf4j-data](/atf4j-data)
- [Feature Driven Development atf4j-fdd](/atf4j-fdd)
- [JUnit support atf4j-junit](/atf4j-junit)
- [Page Object Generator with atf4j-pog](/atf4j-pog)
- [SOAPUI integration atf4j-soapui](/atf4j-soapui)
- [Selenium WebDriver support with atf4j-webdriver](/atf4j-webdriver)
