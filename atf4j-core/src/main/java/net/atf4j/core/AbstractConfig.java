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
 * AbstractConfig.
 */
public abstract class AbstractConfig {

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    protected final Properties properties = new Properties();

    /**
     * Default Constructor for Configuration.
     */
    public AbstractConfig() {
        super();
        try {
            load();
        } catch (final ConfigurationNotLoaded e) {
            this.log.error(e.toString());
        }
    }

    /**
     * Instantiates a new configuration.
     *
     * @param propertyFilename
     *            as String
     * @throws ConfigurationNotLoaded
     *             the missing exception
     */
    public AbstractConfig(final String propertyFilename) throws ConfigurationNotLoaded {
        super();
        load(propertyFilename);
    }

    /**
     * Load configuration from property file named after class.
     *
     * @return the abstract config
     * @throws ConfigurationNotLoaded
     *             the missing exception
     */
    protected AbstractConfig load() throws ConfigurationNotLoaded {
        final String propertyFilename = String.format("/%s.properties", toName());
        return load(propertyFilename);
    }

    /**
     * Load properties file.
     *
     * @param propertyFilename
     *            the property filename
     * @return the abstract config
     * @throws ConfigurationNotLoaded
     *             the missing exception
     */
    private AbstractConfig load(final String propertyFilename) throws ConfigurationNotLoaded {
        try {
            final InputStream resourceAsStream = this.getClass().getResourceAsStream(propertyFilename);
            this.properties.load(resourceAsStream);
            this.properties.setProperty("propertiesFilename", propertyFilename);
        } catch (final Exception e) {
            throw new ConfigurationNotLoaded(propertyFilename);
        }
        return this;
    }

    /**
     * To string.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [properties=%s]", toName(), this.properties);
    }

    /**
     * To name.
     *
     * @return the string
     */
    public String toName() {
        return this.getClass().getSimpleName();
    }

    /**
     * MissingPropertyFileException.
     */
    public class ConfigurationNotLoaded extends Atf4jException {

        /** The Constant serialVersionUID. */
        private static final long serialVersionUID = 1L;

        /** The property filename. */
        private final String expectedPropertyFilename;

        /**
         * Instantiates a new missing exception.
         *
         * @param propertyFilename
         *            the property filename
         */
        public ConfigurationNotLoaded(final String propertyFilename) {
            this.expectedPropertyFilename = propertyFilename;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Throwable#toString()
         */
        @Override
        public String toString() {
            return String.format("MissingPropertyFileException [propertyFilename=%s]", this.expectedPropertyFilename);
        }
    }

    /**
     * Get a property from System Property if available, otherwise from Property
     * File if available, otherwise default.
     *
     * @param key
     *            the key
     * @return the string
     */
    protected String get(final String key) {
        final String systemProperty = System.getProperty(key);
        this.log.trace("Using system property for key {} = {}", key, systemProperty);
        if (systemProperty == null) {
            final String property = this.properties.getProperty(key);
            this.log.trace("Using property file for key {} = {}", key, property);
            return property;
        } else {
            return systemProperty;
        }
    }

    /**
     * Gets a configuration property by key,.
     *
     * @param key
     *            the key
     * @param defaultValue
     *            the default value
     * @return the configuration property as a String
     */
    protected String get(final String key, final String defaultValue) {
        return this.properties.getProperty(key, defaultValue);
    }

    /**
     * Gets a configuration property by key,.
     *
     * @param key
     *            the key
     * @param defaultValue
     *            the default value
     * @return the configuration property as a boolean
     */
    protected boolean get(final String key, final boolean defaultValue) {
        return Boolean.parseBoolean(this.properties.getProperty(key, Boolean.toString(defaultValue)));
    }

    /**
     * Gets a configuration property by key,.
     *
     * @param key
     *            the key
     * @param defaultValue
     *            the default value
     * @return the configuration property as a boolean
     */
    protected int get(final String key, final int defaultValue) {
        return Integer.parseInt(this.properties.getProperty(key, Integer.toString(defaultValue)));
    }

}
