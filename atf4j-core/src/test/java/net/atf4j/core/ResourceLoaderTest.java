
package net.atf4j.core;

import java.net.URI;
import java.net.URL;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test class for ResourceLoader.
 */
public class ResourceLoaderTest {

    /**
     * Unit test to stream for string.
     */
    @Test
    public void testStreamForString() {
        assertNotNull(ResourceLoader.streamFor("TestConfig.properties"));
    }

    /**
     * Unit test to stream for empty string.
     */
    @Test
    public void testStreamForEmptyString() {
        assertNotNull(ResourceLoader.streamFor(""));
    }

    /**
     * Unit test to stream for null string.
     */
    @Test
    public void testStreamForNullString() {
        String resourceName = null;
        ResourceLoader.streamFor(resourceName);
    }

    /**
     * Unit test to stream for null URL.
     */
    @Test
    public void testStreamForNullURL() {
        URL resourceName = null;
        ResourceLoader.streamFor(resourceName);
    }

    /**
     * Unit test to stream for null URI.
     */
    @Test
    public void testStreamForNullURI() {
        URI resourceName = null;
        ResourceLoader.streamFor(resourceName);
    }

}
