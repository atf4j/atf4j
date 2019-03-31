
package net.atf4j.core;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test class for ResourcePropertiesLoader.
 */
public class ResourcePropertiesLoaderTest {

    /**
     * Unit test to properties for.
     */
    @Test
    public void testPropertiesFor() {
        assertNotNull(ResourcePropertiesLoader.propertiesFor("TestConfig.properties"));
    }

    /**
     * Unit test to properties for empty string.
     */
    @Test(expected = ResourceNotLoadedException.class)
    public void testPropertiesForEmptyString() {
        ResourcePropertiesLoader.propertiesFor("");
    }

    /**
     * Unit test to properties for null.
     */
    @Test
    public void testPropertiesForNull() {
        assertNotNull(ResourcePropertiesLoader.propertiesFor(null));
    }

    /**
     * Unit test to properties from xml.
     */
    @Test
    public void testPropertiesFromXml() {
        assertNotNull(ResourcePropertiesLoader.propertiesFromXml("TestConfig.xml"));
    }

    /**
     * Unit test to properties from xml empty string.
     */
    @Test(expected = ResourceNotLoadedException.class)
    public void testPropertiesFromXmlEmptyString() {
        ResourcePropertiesLoader.propertiesFromXml("");
    }

    /**
     * Unit test to properties from xml null.
     */
    @Test
    public void testPropertiesFromXmlNull() {
        assertNotNull(ResourcePropertiesLoader.propertiesFromXml(null));
    }

}
