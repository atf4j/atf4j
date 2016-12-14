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
 * along with atf4j. If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.core;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractConfig.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public abstract class AbstractConfig implements ToName {

    /** logging. */
    protected static final Logger log = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    /** The properties. */
    protected final Properties properties = new Properties();

    /**
     * Instantiates a new config.
     *
     * @throws MissingPropertyFileException
     *             the missing exception
     */
    public AbstractConfig() throws MissingPropertyFileException {
        super();
        load();
    }

    /**
     * Instantiates a new config.
     *
     * @param propertyFilename
     *            as String
     * @throws MissingPropertyFileException
     *             the missing exception
     */
    public AbstractConfig(final String propertyFilename) throws MissingPropertyFileException {
        super();
        load(propertyFilename);
    }

    /**
     * Load.
     *
     * @throws MissingPropertyFileException
     *             the missing exception
     */
    protected void load() throws MissingPropertyFileException {
        final String propertyFilename = String.format("/%s.properties", this.getClass().getSimpleName());
        load(propertyFilename);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("AbstractConfig [properties=%s]", this.properties);
    }

    /**
     * Load.
     *
     * @param propertyFilename
     *            the property filename
     * @throws MissingPropertyFileException
     *             the missing exception
     */
    private void load(final String propertyFilename) throws MissingPropertyFileException {
        try {
            // final InputStream resourceAsStream =
            // this.getClass().getClassLoader().getResourceAsStream(propertyFilename);
            final InputStream resourceAsStream = this.getClass().getResourceAsStream(propertyFilename);
            this.properties.load(resourceAsStream);
            this.properties.setProperty("propertiesFilename", propertyFilename);
        } catch (final Exception exception) {
            log.error(exception.toString());
            throw new MissingPropertyFileException(propertyFilename);
        }
    }

    /**
     * (non-Javadoc).
     *
     * @return the string
     * @see net.atf4j.core.ToName#toName()
     */
    @Override
    public String toName() {
        return this.getClass().getSimpleName();
    }

    /**
     * MissingPropertyFileException.
     */
    public class MissingPropertyFileException extends Exception {

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
        public MissingPropertyFileException(final String propertyFilename) {
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
    public String get(final String key) {
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
    public String get(final String key, final String defaultValue) {
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
    public boolean get(final String key, final boolean defaultValue) {
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
    public int get(final String key, final int defaultValue) {
        return Integer.parseInt(this.properties.getProperty(key, Integer.toString(defaultValue)));
    }

}
