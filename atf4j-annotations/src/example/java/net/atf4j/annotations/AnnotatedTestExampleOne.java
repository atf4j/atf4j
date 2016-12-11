package net.atf4j.annotations;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static net.atf4j.annotations.AnnotationHelper.*;

/**
 * The Class AnnotatedTestExampleOne.
 */
public class AnnotatedTestExampleOne {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
	
	/**
	 * Annotated Test example.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Atf4j.TestId("EXAMPLE-0001-1")
	@Atf4j.TestName("testEample")
	@Atf4j.TestDescription("Example showing annotations with static context")
	public final void testExample() throws Exception {
		log.trace(this.getClass().getSimpleName() + ".testAnnotationsWithPass");
		log.info("Test ID : = {} ", AnnotationHelper.getTestId());
		log.info("Test Name : = {} ", getTestName());
		log.info("Test Description : = {} ", getTestDescription());
		assertTrue(true);
	}

}
