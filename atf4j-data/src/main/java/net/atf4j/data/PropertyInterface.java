
package net.atf4j.data;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * The Interface for Property handing classes.
 */
public interface PropertyInterface {

    /**
     * Sets the property.
     *
     * @param key the key
     * @param value the value
     * @return the property interface
     */
    PropertyInterface setProperty(final String key, final String value);

    /**
     * Gets the property.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the property
     */
    String getProperty(final String key, final String defaultValue);

    /**
     * Gets the property.
     *
     * @param key the key
     * @return the property
     */
    String getProperty(final String key);

    /**
     * Size.
     *
     * @return the int
     */
    int size();

    /**
     * Load.
     *
     * @param inputStream the input stream
     * @return the property interface
     */
    PropertyInterface load(final InputStream inputStream);

    /**
     * Load from XML.
     *
     * @param inputStream the input stream
     * @return the property interface
     */
    PropertyInterface loadFromXML(final InputStream inputStream);

    /**
     * Store.
     *
     * @param outputStream the output stream
     * @return the property interface
     */
    PropertyInterface store(final OutputStream outputStream);

    /**
     * Store.
     *
     * @param outputStream the output stream
     * @param comment the comment
     * @return the property interface
     */
    PropertyInterface store(final OutputStream outputStream, final String comment);

}
