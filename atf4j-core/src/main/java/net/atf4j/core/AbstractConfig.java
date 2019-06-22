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

import lombok.extern.slf4j.Slf4j;

/**
 * An abstract Configuration class.
 *
 * Extend this class to define your desired Configuration, so :
 * <code>TestConfig extends AbstractConfig</code> would expect the configuration
 * to be defined in <code>TestConfig.properties</code>.
 * <code>WebDriverConfig extends AbstractConfig</code> would expect the
 * configuration to be defined in <code>WebDriverConfig.properties</code>.
 *
 */
@Slf4j
public abstract class AbstractConfig implements Configuration {

    /** The configuration filename. */
    protected String configFilename;

    /** The properties values loaded from file. */
    protected final Properties properties = new Properties();

    /**
     * Instantiates a new abstract configuration.
     */
    public AbstractConfig() {
        super();
        loadFrom(defaultFilename());
    }

    /**
     * Instantiates a new abstract configuration.
     *
     * @param configFilename the ExampleConfiguration filename
     */
    public AbstractConfig(final String configFilename) {
        loadFrom(configFilename);
    }

    /**
     * Default filename.
     *
     * @return the string
     */
    protected String defaultFilename() {
        return this.getClass().getSimpleName();
    }

    /**
     * configuration from XML filename.
     *
     * configuration filename
     *
     * @param configFilename the ExampleConfiguration filename
     */
    protected void loadFrom(final String configFilename) {
        this.configFilename = toPropertyFilename(configFilename);
        final InputStream inputStream = inputStream(this.configFilename);
        if (inputStream != null) {
            loadFrom(inputStream);
        } else {
            log.warn("Using class default values, property file '{}' not found.", configFilename);
        }
    }

    /**
     * Load from property file.
     *
     * resource as stream
     *
     * @param resourceAsStream the resource as stream
     */
    protected void loadFrom(final InputStream resourceAsStream) {
        assertNotNull(resourceAsStream);
        try {
            this.properties.load(resourceAsStream);
        } catch (final IOException exception) {
            log.error(exception.toString());
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
     * @param configFilename the ExampleConfiguration filename
     * @return the string
     */
    protected String toPropertyFilename(final String configFilename) {
        if (configFilename.endsWith(".properties")) {
            return configFilename;
        } else {
            return String.format("%s.properties", configFilename);
        }
    }

    /*
     * (non-Javadoc)
     * @see net.atf4j.core.Configuration#valueFor(java.lang.String)
     */
    @Override
    public String valueFor(final String key) {
        return get(key, "");
    }

    /*
     * (non-Javadoc)
     * @see
     * net.atf4j.core.examples.ConfigurationInterface#valueFor(java.lang.String,
     * java.lang.String)
     */
    @Override
    public String valueFor(final String key, final String defaultValue) {
        return get(key, defaultValue);
    }

    /*
     * (non-Javadoc)
     * @see
     * net.atf4j.core.examples.ConfigurationInterface#valueFor(java.lang.String,
     * long)
     */
    @Override
    public long valueFor(final String key, final long defaultValue) {
        return Long.parseLong(get(key, Long.toString(defaultValue)));
    }

    /*
     * (non-Javadoc)
     * @see
     * net.atf4j.core.examples.ConfigurationInterface#valueFor(java.lang.String,
     * boolean)
     */
    @Override
    public boolean valueFor(final String key, final boolean defaultValue) {
        return Boolean.parseBoolean(get(key, Boolean.toString(defaultValue)));
    }

    /**
     * If defined as a System Property, that value overrides all other settings.
     * If it's defined in the <code>.properties</code> file, that is used.
     * Otherwise default value is used.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value as a String.
     */
    protected String get(final String key, final String defaultValue) {
        String propertyValue = System.getProperty(key);
        if (propertyValue == null) {
            propertyValue = this.properties.getProperty(key, defaultValue);
            log.trace("{} = {} from property file.", key, propertyValue);
        } else {
            log.warn("System property override key : {} with : {}", key, propertyValue);
        }
        return propertyValue;
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
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final String className = this.getClass().getSimpleName();
        return String.format("%s [properties=%s]", className, prettyProperties(this.properties));
    }

    /*
     * (non-Javadoc)
     * @see net.atf4j.core.Configuration#toLog()
     */
    @Override
    public void toLog() {
        log.info(prettyProperties(this.properties));
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
     * ExampleConfiguration Not Loaded.
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
