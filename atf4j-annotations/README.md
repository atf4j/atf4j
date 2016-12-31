# atf4j-annotations
## Automation Test Framework for Java

## Maven Dependency

	<dependencies>
		<dependency>
			<groupId>net.atf4j</groupId>
			<artifactId>atf4j-core</artifactId>
			<version>0.0.3-SNAPSHOT</version>
		</dependency>
	</dependencies>


## Code

A simple example using the logger to log a test audit trail.

	@Test
	@Atf4j.TestId("EXAMPLE")
	@Atf4j.TestName("testExample")
	@Atf4j.TestDescription("Example showing test annotation definition and retrieval")
	public final void testExample() throws Exception {
		log.info("Test ID : = {} ", AnnotationHelper.getTestId());
		log.info("Test Name : = {} ", getTestName());
		log.info("Test Description : = {} ", getTestDescription());
		assertTrue(true);
	}

## Usage

In command line shell run:

    mvn test
