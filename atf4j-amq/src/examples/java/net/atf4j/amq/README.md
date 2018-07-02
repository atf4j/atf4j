# Automated Test Framework for Java

## Automated Test Framework for Java - ATF4J-AMQ

Automation Test Framework for Apache ActiveMQ

## Example Code

### Message Consumer Example

	final Consumer consumer = new Consumer();
	final String[] messages = consumer.execute();

### Message Finder Example

	final MessageFinder folderWalker = new MessageFinder();
	for (final File file : folderWalker.walk()) {
		log.info("{} = {}", file.getName(), file.toString());
	}

### Message Producer Example

	final String[] messages = ...;

	final Producer producer = new Producer();
	producer.execute(messages);

## Usage

On the command line shell run:

### Clone from GitHub

	git clone ...

### Install into local Maven repository

    mvn install

### Maven Dependency

Add the following dependency to the POM.XML of your test project

	<dependency>
		<groupId>net.atf4j</groupId>
		<artifactId>atf4j-amq</artifactId>
		<version>${atf4j.version}</version>
	</dependency>

### Usage

In command line shell run:

    mvn test

### Overriding options

    mvn -Doptions="value" test
