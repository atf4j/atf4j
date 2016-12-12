package net.atf4j.annotations;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Annotated Test Example Two, 
 * using static imports.
 * Allows annotations to be accessed directly with the functions
 *      getTestId();
 *      getTestName();
 *      getTestDescription();
 */
public class AnnotatedExampleTwoTest extends AnnotatedTest {

	/**
	 * Annotated Test example two.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Atf4j.TestId("EXAMPLE-0002")
	@Atf4j.TestName("testEample")
	@Atf4j.TestDescription("Example showing annotations with inherited context")
	public final void testExample() throws Exception {
        log.trace("{}.testExample",this.getClass().getSimpleName());
		log.info("Test ID : = {} ", AnnotationHelper.getTestId());
		log.info("Test Name : = {} ", AnnotationHelper.getTestName());
		log.info("Test Description : = {} ", AnnotationHelper.getTestDescription());
		assertTrue(true);
	}

}
