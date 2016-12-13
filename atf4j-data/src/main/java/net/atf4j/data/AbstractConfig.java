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
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractConfig.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public abstract class AbstractConfig implements IConfig {

    /** logging. */
    protected static final Logger log = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    /** The properties. */
    protected Properties properties;

    /**
     * Instantiates a new abstract config.
     */
    public AbstractConfig() {
        super();
    }

    /**
     * Use properties.
     *
     * @param propertiesIn
     *            as Properties object.
     * @see net.atf4j.data.IConfig#properties(java.util.Properties)
     */
    @Override
    public void properties(final Properties propertiesIn) {
        this.properties = propertiesIn;
    }

    /**
     * load Properties.
     *
     * @throws FileNotFoundException
     *             the file not found exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Override
    public void load() throws Exception {
        this.properties.load(new FileReader(this.getClass().getName() + ".properties"));
    }

    /**
     * load Properties.
     *
     * @param propertiesFile
     *            name as String.
     * @throws FileNotFoundException
     *             the file not found exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Override
    public void load(final String propertiesFile) throws Exception {
        this.properties.load(new FileReader(propertiesFile));
    }

    /**
     * load Properties.
     *
     * @param propertiesFile
     *            file as File object,
     * @throws FileNotFoundException
     *             the file not found exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Override
    public void load(final File propertiesFile) throws Exception {
        this.properties.load(new FileReader(propertiesFile));
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

}
