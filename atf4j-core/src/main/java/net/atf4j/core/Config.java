/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */

package net.atf4j.core;

/**
 * Configuration Class.
 */
public class Config extends AbstractConfig {

    private static Config instance = null;

    /**
     * Instantiates a new configuration. Private default constructor prevents
     * wild instantiation.
     */
    private Config() {
        super();
    }

    /**
     * Instantiates a new configuration.
     *
     * @param propertyFilename the property filename
     * @throws ConfigurationNotLoaded the configuration not loaded
     */
    public Config(final String propertyFilename) throws ConfigurationNotLoaded {
        super(propertyFilename);
    }

    /**
     * Gets the single instance of configuration.
     *
     * @return single instance of Configuation.
     */
    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.core.ConfigurationInterface#valueFor(java.lang.String)
     */
    @Override
    public String valueFor(final String key) {
        return get(key, null);
    }

}
