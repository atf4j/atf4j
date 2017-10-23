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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.atf4j.core.TestResultsReporting;

/**
 * A factory for creating AbstractData objects.
 */
public abstract class AbstractDataFactory extends TestResultsReporting {

    /** The Constant FILE_NOT_FOUND_MSG. */
    private static final String FILE_NOT_FOUND_MSG = "Expected file '%s' not found.";

    /** Default file extension FILE_EXT. */
    private static final String FILE_EXT = "csv";

    /** lines from the data file. */
    protected String[] lines;

    /** random number generators. */
    protected static Random random = new Random(System.currentTimeMillis());

    /**
     * Instantiates a new abstract data factory.
     */
    protected AbstractDataFactory() {
        super();
        initialise();
    }

    /**
     * Initialise.
     */
    private void initialise() {
        lines = load(filename());
    }

    /**
     * Instantiates a new abstract data factory.
     *
     * @param dataFilename the data filename
     */
    protected AbstractDataFactory(final String dataFilename) {
        super();
        lines = load(dataFilename);
    }

    /**
     * filename from simple class name.
     *
     * @return the string
     */
    protected String filename() {
        final String simpleName = this.getClass().getSimpleName();
        return String.format("%s.%s", simpleName, FILE_EXT);
    }

    /**
     * Load data file.
     *
     * @param dataFilename the data filename
     * @return the string[]
     */
    protected String[] load(final String dataFilename) {
        assertNotNull(UNEXPECTED_NULL, dataFilename);
        final InputStream inputStream = resourceAsStream(dataFilename);
        if (inputStream != null) {
            return load(inputStream);
        }
        return null;
    }

    /**
     * Resource as stream.
     *
     * @param resourceFilename the resource filename
     * @return the input stream
     */
    protected InputStream resourceAsStream(final String resourceFilename) {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        return classLoader.getResourceAsStream(resourceFilename);
    }

    /**
     * Load.
     *
     * @param inputStream the input stream
     * @return the string[]
     */
    protected String[] load(final InputStream inputStream) {
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
     * @param lines the lines
     * @return the string
     */
    protected static String randomEntry(final String[] lines) {
        final int bounds = lines.length;
        final int randomIndex = random.nextInt(bounds);
        return lines[randomIndex];
    }

    /**
     * Return the first line of data to match the tag.
     *
     * @param tag the tag.
     * @return the data line as a String object.
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
