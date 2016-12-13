# atf4j-annotations
## Automation Test Framework for Java

## Code

A simple example using the logger to report

	@Test
	@Atf4j.TestId("EXAMPLE-0001-1")
	@Atf4j.TestName("testEample")
	@Atf4j.TestDescription("Example showing test annotation definition and retrieval")
	public final void testExample() throws Exception {
		log.trace(this.getClass().getSimpleName() + ".testAnnotationsWithPass");
		log.info("Test ID : = {} ", AnnotationHelper.getTestId());
		log.info("Test Name : = {} ", getTestName());
		log.info("Test Description : = {} ", getTestDescription());
		assertTrue(true);
	}

## Usage

In command line shell run:

    mvn test
