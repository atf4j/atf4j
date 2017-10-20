
package net.atf4j.data.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;
import net.atf4j.data.Postcode;

public class PostcodeDataFactoryTest extends TestResultsReporting {

    /**
     * Test postcode random.
     */
    @Test
    public void testPostcodeRandom() {
        final Postcode postcode = PostcodeDataFactory.random();
        assertNotNull(UNEXPECTED_NULL, postcode);
        assertTrue(Postcode.verify(postcode.toString()));
        log.info("postcode = {}", postcode);
    }

}
