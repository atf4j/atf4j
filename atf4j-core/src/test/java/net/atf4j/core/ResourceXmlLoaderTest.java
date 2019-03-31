
package net.atf4j.core;

import org.junit.Test;
import org.w3c.dom.Document;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Unit test class for ResourceXmlLoader.
 */
public class ResourceXmlLoaderTest {

    /**
     * Unit test to document for string string.
     */
    @Test
    public void testDocumentForStringString() {
        String resourceName = "TestConfig.xml";
        assertNotNull(ResourceXmlLoader.documentFor(resourceName));
    }

    /**
     * Unit test to xml to string.
     */
    @Test
    public void testXmlToString() {
        String resourceName = "TestConfig.xml";
        Document xml = ResourceXmlLoader.documentFor(resourceName);
        assertNotNull(ResourceXmlLoader.xmlToString(xml));
    }

    /**
     * Unit test to document for null null.
     */
    @Test
    public void testDocumentForNullNull() {
        String resourceName = null;
        String resourceLocation = null;
        assertNull(ResourceXmlLoader.documentFor(resourceLocation, resourceName));
    }

    /**
     * Unit test to document for string.
     */
    @Test
    public void testDocumentForString() {
        String resourceName = "TestConfig.xml";
        String resourceLocation = "";
        assertNotNull(ResourceXmlLoader.documentFor(resourceLocation, resourceName));
    }

}
