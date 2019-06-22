# Automated Test Framework for Java

## Automated Test Framework for Java - ATF4J-AMQ

Automation Test Framework for Apache ActiveMQ

## Maven Dependency

	<dependency>
		<groupId>net.atf4j</groupId>
		<artifactId>atf4j-amq</artifactId>
		<version>${atf4j.version}</version>
	</dependency>

## Usage

In command line shell run:

    mvn test

## Example Code
### Message Finder
Find all the message files within a folder, traversing sub-directories as necessary, allows file filters to be applied.


        final MessageFinder folderWalker = new MessageFinder();
        verifyNotNull(folderWalker);

        final List<File> messages = folderWalker.walk();
        verifyNotNull(messages);
        for (final File file : messages) {
            log.info("{} = {}", file.getName(), file.toString());
        }

### Message Producer

Messages can be added to a queue.

        final String[] messages = ...;

        final Producer producer = new Producer();
        producer.execute(messages);

### Message Consumer

Messages can be consumed from a queue.

        final Consumer consumer = new Consumer();
        final String[] messages = consumer.execute();
 

