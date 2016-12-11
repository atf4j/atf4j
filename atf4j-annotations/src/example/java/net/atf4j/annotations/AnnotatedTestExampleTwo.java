package net.atf4j.annotations;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class AnnotatedTestExampleTwo.
 */
public class AnnotatedTestExampleTwo extends AbstractAtf4jAnnotatedTest {

	/**
	 * Annotated Test example.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Atf4j.TestId("EXAMPLE-0002")
	@Atf4j.TestName("testEample")
	@Atf4j.TestDescription("Example showing annotations with inherited context")
	public final void testExample() throws Exception {
		log.trace(this.getClass().getSimpleName() + ".testAnnotationsWithPass");
		log.info("Test ID : = {} ", getTestId());
		log.info("Test Name : = {} ", getTestName());
		log.info("Test Description : = {} ", getTestDescription());
		assertTrue(true);
	}

}
