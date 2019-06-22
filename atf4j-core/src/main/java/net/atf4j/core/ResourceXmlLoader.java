
package net.atf4j.core;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import static org.junit.Assert.fail;

import lombok.extern.slf4j.Slf4j;

/**
 * XML resource loader class.
 *
 * Loads a properties file by name from the classpath.
 *
 * The resource must be a file with .properties extension.
 *
 * The properties file can be placed in the projects src/main/resource.
 */
@Slf4j
public final class ResourceXmlLoader {

    /** SUFFIX constant. */
    private static final String DEFAULT_SUFFIX = ".xml";

    /**
     * Instantiates a new xml resource loader.
     */
    private ResourceXmlLoader() {
        fail("Class not intended for intantiation, use static factory methods.");
    }

    /**
     * Gets the xml resource.
     *
     * @param resourceLocation the resource location
     * @param resourceName the resource name
     * @return the xml resource
     */
    public static Document documentFor(final String resourceLocation, final String resourceName) {
        if (resourceLocation != null && resourceName != null) {
            return documentFor(resourceLocation + resourceName);
        }
        return null;
    }

    /**
     * Gets the xml resource.
     *
     * @param resourceName the resource name
     * @return the xml resource
     */
    public static Document documentFor(final String resourceName) {
        if (resourceName != null) {
            final InputStream stream = ResourceLoader.streamFor(xmlFilename(resourceName));
            try {
                final DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                return builder.parse(stream);
            } catch (final Exception exception) {
                final String message = String.format("Failed to parse resource %s", resourceName);
                log.error(message, exception);
                throw new ResourceNotLoadedException(message, exception);
            }
        }
        return null;
    }

    /**
     * Xml filename.
     *
     * @param resourceName the resource name
     * @return the string
     */
    private static String xmlFilename(final String resourceName) {
        if (resourceName != null) {
            final String suffix = DEFAULT_SUFFIX;
            if (resourceName.endsWith(suffix)) {
                return resourceName;
            } else {
                return String.format("%s%s", resourceName, suffix);
            }
        }
        return null;
    }

    /**
     * XML Document to string.
     *
     * @param xml the xml
     * @return the string
     */
    public static String xmlToString(final Document xml) {
        if (xml != null) {
            try {
                final TransformerFactory factory = TransformerFactory.newInstance();
                final Transformer transformer = factory.newTransformer();
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                final StringWriter stringWriter = new StringWriter();
                final DOMSource xmlSource = new DOMSource(xml);
                final StreamResult outputTarget = new StreamResult(stringWriter);
                transformer.transform(xmlSource, outputTarget);
                return stringWriter.toString();
            } catch (IllegalArgumentException | TransformerFactoryConfigurationError | TransformerException e) {
                final String message = String.format("Failed to parse XML Document. %s", e.getLocalizedMessage());
                log.error(message, e);
            }
        }
        return null;
    }
}
