/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with atf4j. If not, see http://www.gnu.org/licenses/.
 */

package net.atf4j.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

/**
 * An abstract Configuration class.
 */
public abstract class AbstractConfig
        extends TestResultsReporting
        implements ConfigurationInterface {

    /** The properties. */
    protected final Properties properties = new Properties();

    /** The property filename. */
    protected String propertyFilename;

    /**
     * Instantiates a new abstract configuration.
     */
    public AbstractConfig() {
        super();
        loadPropertyFileFrom(defaultFilename());
    }

    /**
     * Instantiates a new abstract configuration.
     *
     * @param configFilename the Configuration filename
     */
    public AbstractConfig(final String configFilename) {
        this.propertyFilename = configFilename;
        loadPropertyFileFrom(configFilename);
    }

    /**
     * Default filename.
     *
     * @return the string
     */
    protected String defaultFilename() {
        this.propertyFilename = this.getClass().getSimpleName();
        return this.propertyFilename;
    }

    /**
     * configuration from XML filename.
     *
     * configuration filename
     *
     * @param configFilename the Configuration filename
     */
    protected void loadPropertyFileFrom(final String configFilename) {
        final InputStream inputStream = inputStream(toPropertyFilename(configFilename));
        if (inputStream != null) {
            loadPropertyFileFrom(inputStream);
        } else {
            this.log.warn("Using class default values, property file '{}' not found.", configFilename);
        }
    }

    /**
     * Load from property file.
     *
     * resource as stream
     *
     * @param resourceAsStream the resource as stream
     */
    protected void loadPropertyFileFrom(final InputStream resourceAsStream) {
        assertNotNull(resourceAsStream);
        try {
            this.properties.load(resourceAsStream);
        } catch (final IOException exception) {
            this.log.error(exception.toString());
        }
    }

    /**
     * Input stream.
     *
     * @param resourceName the resource name
     * @return the input stream
     */
    protected InputStream inputStream(final String resourceName) {
        final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        final InputStream resourceAsStream = classloader.getResourceAsStream(resourceName);
        return resourceAsStream;
    }

    /**
     * To property filename.
     *
     * @param configFilename the Configuration filename
     * @return the string
     */
    protected String toPropertyFilename(final String configFilename) {
        if (configFilename.endsWith(".properties")) {
            return configFilename;
        } else {
            return String.format("%s.properties", configFilename);
        }
    }

    /**
     * Gets the value from the properties.
     *
     * @param key the key
     * @return the string
     */
    @Override
    public String get(final String key) {
        return get(key, null);
    }

    /**
     * Get a property from System Property if available, otherwise from Property
     * File if available, otherwise default.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the string
     */
    @Override
    public String get(final String key, final String defaultValue) {
        String propertyValue = System.getProperty(key);
        if (propertyValue == null) {
            propertyValue = this.properties.getProperty(key, defaultValue);
            this.log.trace("Using property file for key {} = {}", key, propertyValue);
        } else {
            this.log.warn("Using system property override for key {} = {}", key, propertyValue);
        }

        return propertyValue;
    }

    /**
     * Gets the value for the key.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the int
     */
    @Override
    public int get(final String key, final int defaultValue) {
        return Integer.parseInt(this.get(key, Integer.toString(defaultValue)));
    }

    /**
     * Gets the value for the key.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the long
     */
    @Override
    public long get(final String key, final long defaultValue) {
        return Long.parseLong(this.get(key, Long.toString(defaultValue)));
    }

    /**
     * Gets the value for the key.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the boolean
     */
    @Override
    public boolean get(final String key, final boolean defaultValue) {
        return Boolean.parseBoolean(this.get(key, Boolean.toString(defaultValue)));
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String,
     * java.lang.String)
     */
    @Override
    public String valueFor(final String key, final String defaultValue) {
        return get(key, defaultValue);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String,
     * int)
     */
    @Override
    public int valueFor(final String key, final int defaultValue) {
        return get(key, defaultValue);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String,
     * long)
     */
    @Override
    public long valueFor(final String key, final long defaultValue) {
        return get(key, defaultValue);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String,
     * boolean)
     */
    @Override
    public boolean valueFor(final String key, final boolean defaultValue) {
        return get(key, defaultValue);
    }

    /**
     * Pretty string.
     *
     * @return the string
     */
    @Override
    public String prettyString() {
        final String className = this.getClass().getSimpleName();
        return String.format("%s [properties=%s]", className, prettyProperties(this.properties));
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final String className = this.getClass().getSimpleName();
        return String.format("%s [properties=%s]", className, prettyProperties(this.properties));
    }

    /**
     * Pretty Format the properties.
     *
     * @param properties the properties as Properties object.
     * @return the properties as a formated String object.
     */
    protected String prettyProperties(final Properties properties) {
        if (properties == null) {
            return "{null}";
        } else if (properties.isEmpty()) {
            return "{empty}";
        } else {
            return prettyProperties(properties.toString());
        }
    }

    /**
     * Pretty Format the properties.
     *
     * @param properties the properties as String.
     * @return the properties as a formated String.
     */
    protected String prettyProperties(final String properties) {
        return properties
            .replace("[", "[\n\t")
            .replace("{", "{\n\t")
            .replace(", ", "\n\t")
            .replace("}", "\n\t}")
            .replace("]", "\n\t]}");
    }

    /**
     * No property was found for the key.
     */
    @SuppressWarnings("serial")
    public class PropertyNotFoundException extends VerificationError {
        /**
         * Instantiates a new property not found.
         *
         * @param propertyKey the property key
         */
        public PropertyNotFoundException(final String propertyKey) {
            super(String.format("Property value not found for key %s.", propertyKey));
        }
    }

    /**
     * Configuration Not Loaded.
     */
    @SuppressWarnings("serial")
    public class ConfigurationNotLoadedException extends VerificationError {
        /**
         * Instantiates a missing configuration exception.
         *
         * @param propertyFilename the property filename
         */
        public ConfigurationNotLoadedException(final String propertyFilename) {
            super(String.format("Property file '%s' not found.", propertyFilename));
        }
    }
}
