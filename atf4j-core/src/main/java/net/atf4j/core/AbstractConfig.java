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

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract Configuration class.
 */
public abstract class AbstractConfig implements ConfigurationInterface {

    protected final Properties properties = new Properties();
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Default Constructor for Configuration.
     */
    public AbstractConfig() {
        super();
        load();
    }

    /**
     * Instantiates a new configuration.
     *
     * @param propertyFilename as String
     * @throws ConfigurationNotLoaded the missing exception
     */
    public AbstractConfig(final String propertyFilename) throws ConfigurationNotLoaded {
        super();
        load(propertyFilename);
    }

    /**
     * Load configuration from property file named after class.
     *
     * @return the abstract configuration
     */
    protected ConfigurationInterface load() {
        try {
            load(propertiesFilename());
        } catch (final ConfigurationNotLoaded e) {
            this.log.error("Using default values; {}", e.getMessage());
        }
        return this;
    }

    /**
     * Properties filename.
     *
     * @return the string
     */
    private String propertiesFilename() {
        final String simpleName = this.getClass().getSimpleName();
        return String.format("/%s.properties", simpleName);
    }

    /**
     * Load properties file.
     *
     * @param propertyFilename the property filename
     * @return the abstract configuration
     * @throws ConfigurationNotLoaded the missing exception
     */
    protected ConfigurationInterface load(final String propertyFilename) throws ConfigurationNotLoaded {
        try {
            this.properties.load(resourceAsStream(propertyFilename));
            this.properties.setProperty("propertiesFilename", propertyFilename);
        } catch (final Exception e) {
            throw new ConfigurationNotLoaded(propertyFilename);
        }
        return this;
    }

    /**
     * Resource as stream.
     *
     * @param resourceFilename the resource filename
     * @return the input stream
     */
    private InputStream resourceAsStream(final String resourceFilename) {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        return classLoader.getResourceAsStream(resourceFilename);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String)
     */
    @Override
    public String valueFor(final String key) {
        return get(key);
    }

    /**
     * Gets the value from the properties.
     *
     * @param key the key
     * @return the string
     */
    protected String get(final String key) {
        return get(key, null);
    }

    /**
     * Gets the value for the key.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the int
     */
    protected int get(final String key, final int defaultValue) {
        return Integer.parseInt(this.get(key, Integer.toString(defaultValue)));
    }

    /**
     * Gets the value for the key.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the long
     */
    protected long get(final String key, final long defaultValue) {
        return Long.parseLong(this.get(key, Long.toString(defaultValue)));
    }

    /**
     * Get a property from System Property if available, otherwise from Property
     * File if available, otherwise default.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the string
     */
    protected String get(final String key, final String defaultValue) {
        final String systemProperty = System.getProperty(key);
        this.log.trace("Using system property for key {} = {}", key, systemProperty);
        if (systemProperty == null) {
            final String property = this.properties.getProperty(key, defaultValue);
            this.log.trace("Using property file for key {} = {}", key, property);
            return property;
        } else {
            return systemProperty;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String,
     * int)
     */
    @Override
    public int valueFor(final String key, final int defaultValue) {
        return Integer.parseInt(this.get(key, Integer.toString(defaultValue)));
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String,
     * long)
     */
    @Override
    public long valueFor(final String key, final long defaultValue) {
        return Long.parseLong(this.get(key, Long.toString(defaultValue)));
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String,
     * boolean)
     */
    @Override
    public boolean valueFor(final String key, final boolean defaultValue) {
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

    /**
     * The property file was not found.
     */
    public class PropertyNotFound extends Atf4jException {
        private static final long serialVersionUID = 1L;

        /**
         * Instantiates a new property not found.
         *
         * @param propertyKey the property key
         */
        public PropertyNotFound(final String propertyKey) {
            super(String.format("Property not found for key %s", propertyKey));
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [properties=%s]", this.getClass().getSimpleName(), this.properties);
    }

    /**
     * Configuration Not Loaded.
     */
    public class ConfigurationNotLoaded extends Atf4jException {
        private static final long serialVersionUID = 1L;

        /**
         * Instantiates a missing configuration exception.
         *
         * @param propertyFilename the property filename
         */
        public ConfigurationNotLoaded(final String propertyFilename) {
            super(String.format("PropertyFile %s not found", propertyFilename));
        }
    }
}
