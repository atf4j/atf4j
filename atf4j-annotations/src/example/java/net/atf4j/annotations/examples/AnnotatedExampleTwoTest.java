package net.atf4j.annotations.examples;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.atf4j.annotations.AnnotatedTest;
import net.atf4j.annotations.Atf4j;

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
		log.trace(this.getClass().getSimpleName() + ".testAnnotationsWithPass");
		log.info("Test ID : = {} ", testId());
		log.info("Test Name : = {} ", testName());
		log.info("Test Description : = {} ", testDescription());
		assertTrue(true);
	}

}
