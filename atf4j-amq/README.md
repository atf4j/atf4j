# ATF4J-AMQ Automated Test Framework for Java

## Apache ActiveMQ support 

Automation Test Framework for use with Apache ActiveMQ.  The module of the Automation Test Framework for Java provides support for use with Apache ActiveMQ.  It can be used to initialise a MessageQueue before a test.  It provides support to inject individual message to whole directories.  Messages can be retrieved from a queue for testing.

## Example Code

Find all the message files within a folder, traversing sub-directories as necessary, allows file filters to be applied.

### Message Finder

	final MessageFinder folderWalker = new MessageFinder();
	for (final File file : folderWalker.walk()) {
		log.info("{} = {}", file.getName(), file.toString());
	}

### Message Producer

Messages can be added to a queue.

	final String[] messages = ...;

	final Producer producer = new Producer();
	producer.execute(messages);

### Message Producer

Messages can be added to a queue.

	final Consumer consumer = new Consumer();
	final String[] messages = consumer.execute();

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
