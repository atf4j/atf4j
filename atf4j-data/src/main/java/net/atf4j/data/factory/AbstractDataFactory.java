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

package net.atf4j.data.factory;

import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A factory for creating AbstractData objects.
 */
public abstract class AbstractDataFactory {

    private static final String UNEXPECTED_NULL = "unexpected null";
    private String[] lines;
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    protected static Random rnd = new Random(System.currentTimeMillis());

    /**
     * Instantiates a new abstract data factory.
     */
    protected AbstractDataFactory() {
        super();
    }

    /**
     * Instantiates a new abstract data factory.
     *
     * @param dataFilename the data filename
     * @throws FileNotFoundException the file not found exception
     */
    protected AbstractDataFactory(final String dataFilename) throws FileNotFoundException {
        super();
        load(dataFilename);
    }

    /**
     * Load.
     */
    protected void load() {
        try {
            lines = load(filename());
        } catch (final FileNotFoundException e) {
            log.error("{} Using default values.", e.getMessage());
        }
    }

    /**
     * filename.
     *
     * @return the string
     */
    private String filename() {
        final String simpleName = this.getClass().getSimpleName();
        return String.format("%s.csv", simpleName);
    }

    /**
     * Load data file.
     *
     * @param dataFilename the data filename
     * @return the string[]
     * @throws FileNotFoundException the file not found exception
     */
    public String[] load(final String dataFilename) throws FileNotFoundException {
        assertNotNull(UNEXPECTED_NULL, dataFilename);
        final InputStream inputStream = resourceAsStream(dataFilename);
        if (inputStream != null) {
            return load(inputStream);
        } else {
            throw new FileNotFoundException(dataFilename);
        }
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

    /**
     * Load.
     *
     * @param inputStream the input stream
     * @return the string[]
     */
    public String[] load(final InputStream inputStream) {
        assertNotNull(UNEXPECTED_NULL, inputStream);
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        final List<String> lines = new ArrayList<String>();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
                log.trace(line);
            }
            bufferedReader.close();
        } catch (final IOException e) {
            log.error(e.toString());
        }
        return lines.toArray(new String[lines.size()]);
    }

    /**
     * Random entry.
     *
     * @return the string
     */
    protected String randomEntry() {
        return randomEntry(lines);
    }

    /**
     * Random entry.
     *
     * @param content the content
     * @return the string
     */
    protected static String randomEntry(final String[] content) {
        final int bounds = content.length;
        final int randomIndex = rnd.nextInt(bounds);
        return content[randomIndex];
    }

    /**
     * Data for tag.
     *
     * @param tag the tag
     * @return the string
     */
    public String dataForTag(final String tag) {
        if (tag.charAt(0) == '@') {
            for (final String line : lines) {
                final String[] fields = line.split(",");
                if (fields[0].contains(tag)) {
                    return line;
                }
            }
        }
        return null;
    }
}
