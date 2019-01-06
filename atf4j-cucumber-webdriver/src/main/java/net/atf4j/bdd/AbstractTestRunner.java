
package net.atf4j.bdd;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assume.assumeNotNull;

/**
 * AbstractTestRunner class.
 *
 * If you wish to use a common Abstract base for your TestRunner(s) Then you
 * must use 1.1.8+ of Cucumber-jvm other wise you will receive unexpected
 * DuplicateStepDefinitionException errors
 *
 */
public abstract class AbstractTestRunner {

    /** Provides logging. */
    protected static final Logger LOG = LoggerFactory.getLogger(AbstractTestRunner.class);

    /**
     * Before test, an excellent place to test any assumptions common to the
     * entire test suite such as any required environmental configurations or
     * data setup.
     */
    @Before
    public void beforeTests() {
        LOG.info("beforeTests - Executed before all tests in test suite.  Ideal place for data setup.");
        final String targetEnvironment = System.getProperty("targetEnvironment", "local");
        assumeNotNull("Expected the target environment to be specified in a Java System property (use -DtargetEnvironment={DEV|SIT|...})", targetEnvironment);
    }

    /**
     * After tests.
     */
    @After
    public void afterTests() {
        LOG.info("afterTests - Executed after all tests in test suite.  Ideal place for data cleanup.");
    }

}
