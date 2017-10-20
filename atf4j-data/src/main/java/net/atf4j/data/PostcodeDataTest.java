
package net.atf4j.data;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

public class PostcodeDataTest extends TestResultsReporting {

    @Test
    public void testPostcodeData() throws FileNotFoundException {
        PostcodeData postcodeData = new PostcodeData();
        assertNotNull(postcodeData);
        log.info("{}", postcodeData.toString());
    }

    @Test
    public void testGetInstance() throws FileNotFoundException {
        PostcodeData postcodeData = PostcodeData.getInstance();
        assertNotNull(postcodeData);
        log.info("{}", postcodeData.toString());
    }

}
