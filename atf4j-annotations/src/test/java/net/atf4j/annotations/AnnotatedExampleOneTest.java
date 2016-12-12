package net.atf4j.annotations;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.annotations.AnnotationHelper;
import net.atf4j.annotations.Atf4j.*;

/**
 * Annotated Test Example One.
 * using static imports.
 * Allows annotations to be accessed directly with the functions
 *      getTestId();
 *      getTestName();
 *      getTestDescription();
 */
public class AnnotatedExampleOneTest {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

	/**
	 * Annotated Test example.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@TestId("EXAMPLE-0001")
	@TestName("testEample")
	@TestDescription("Example showing annotations with static context")
	public final void testExample() throws Exception {
		log.trace("{}.testExample",this.getClass().getSimpleName());
        log.info("Test ID : = {} ", AnnotationHelper.getTestId());
        log.info("Test Name : = {} ", AnnotationHelper.getTestName());
        log.info("Test Description : = {} ", AnnotationHelper.getTestDescription());
		assertTrue(true);
	}
}
