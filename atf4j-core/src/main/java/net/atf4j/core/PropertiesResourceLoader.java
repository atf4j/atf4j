
package net.atf4j.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.fail;

/**
 * Property Loader class.
 *
 * Loads a properties file by name from the classpath.
 *
 * The resource must be a file with .properties extension.
 *
 * The properties file should be placed in the projects src/main/resource.
 *
 * The name is assumed to be absolute and can use either "/" or "." for package
 * segment separation with an optional leading "/" and The ".properties" suffix
 * optional. The following names refer to the same resource: some.pkg.Resource
 * some.pkg.Resource.properties some/pkg/Resource some/pkg/Resource.properties
 * /some/pkg/Resource /some/pkg/Resource.properties
 */
public final class PropertiesResourceLoader {

    /** SUFFIX constant. */
    private static final String DEFAULT_SUFFIX = ".properties";
    private static final String XML_SUFFIX = ".xml";

    /** provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesResourceLoader.class);

    /**
     * Instantiates a new properties loader.
     */
    private PropertiesResourceLoader() {
        fail("Class not intended for intantiation, use static factory methods.");
    }

    /**
     * Gets the properties.
     *
     * @param resourceName the resource filename
     * @return the properties
     */
    public static Properties propertiesFor(final String resourceName) {
        final Properties properties = new Properties();
        if (resourceName != null) {
            try {
                final InputStream stream = ResourceLoader.streamFor(propertiesFilename(resourceName));
                properties.load(stream);
                properties.setProperty("propertyFilename", resourceName);
            } catch (final IOException e) {
                LOG.error(e.getLocalizedMessage(), e);
            }
        }
        return properties;
    }

    /**
     * Properties filename.
     *
     * @param resourceName the resource name
     * @return the string
     */
    private static String propertiesFilename(final String resourceName) {
        if (resourceName != null) {
            if (resourceName.endsWith(DEFAULT_SUFFIX)) {
                return resourceName;
            } else {
                return String.format("%s%s", resourceName, DEFAULT_SUFFIX);
            }
        }
        return "";
    }

    /**
     * Gets the xml properties.
     *
     * @param resourceName the xml resource filename
     * @return the xml properties
     */
    public static Properties propertiesFromXml(final String resourceName) {
        final Properties properties = new Properties();
        if (resourceName != null) {
            try {
                final InputStream stream = ResourceLoader.streamFor(xmlPropertiesFilename(xmlPropertiesFilename(resourceName)));
                properties.loadFromXML(stream);
                properties.setProperty("propertyFilename", resourceName);
            } catch (final IOException e) {
                LOG.error(e.getLocalizedMessage(), e);
            }
        }
        return properties;
    }

    /**
     * Xml properties filename.
     *
     * @param resourceName the resource name
     * @return the string
     */
    private static String xmlPropertiesFilename(final String resourceName) {
        if (resourceName != null) {
            if (resourceName.endsWith(XML_SUFFIX)) {
                return resourceName;
            } else {
                return String.format("%s%s", resourceName, XML_SUFFIX);
            }
        }
        return null;
    }
}
