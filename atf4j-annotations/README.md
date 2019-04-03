# atf4j-annotations

## Feature List

* Annotate Tests
* Access annotations programatically

## Automation Test Framework for Java - Annotations

Provides Annotations for enhanced reporting for automated unit tests for enhanced reporting.

## Maven Dependency

	<dependency>
		<groupId>net.atf4j</groupId>
		<artifactId>atf4j-annotations</artifactId>
		<version>${atf4j.version}</version>
	</dependency>

## Annotation Example
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

## Annotation Example with static imports

	import static net.atf4j.annotations.AnnotationHelper.getTestDescription;
	import static net.atf4j.annotations.AnnotationHelper.getTestId;
	import static net.atf4j.annotations.AnnotationHelper.getTestName;

    @Test
    @TestId("EXAMPLE-0001")
    @TestName("testEample")
    @TestDescription("Example showing annotations with static context")
    public void testExampleOne() throws Exception {
        this.log.info("Test ID : = {} ", AnnotationHelper.getTestId());
        this.log.info("Test Name : = {} ", AnnotationHelper.getTestName());
        this.log.info("Test Description : = {} ", AnnotationHelper.getTestDescription());
        assertTrue(true);
    }

## Usage

In command line shell run:

    mvn test
