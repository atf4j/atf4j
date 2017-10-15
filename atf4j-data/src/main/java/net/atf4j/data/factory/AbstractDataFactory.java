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
    protected static Random random = new Random(System.currentTimeMillis());

    /**
     * Load data file.
     *
     * @param dataFilename
     *            the data filename
     * @return the string[]
     * @throws Exception
     *             the exception
     */
    public String[] load(final String dataFilename) throws Exception {
        assertNotNull(UNEXPECTED_NULL, dataFilename);
        final ClassLoader classLoader = this.getClass().getClassLoader();
        final InputStream inputStream = classLoader.getResourceAsStream(dataFilename);
        if (inputStream != null) {
            this.lines = load(inputStream);
            return this.lines;
        } else {
            throw new FileNotFoundException(dataFilename);
        }
    }

    /**
     * Load.
     *
     * @param inputStream
     *            the input stream
     * @return the string[]
     * @throws Exception
     *             the exception
     */
    public String[] load(final InputStream inputStream) throws Exception {
        assertNotNull(UNEXPECTED_NULL, inputStream);
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        final List<String> lines = new ArrayList<String>();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
                this.log.trace(line);
            }
        } finally {
            bufferedReader.close();
        }
        return lines.toArray(new String[lines.size()]);
    }

    /**
     * Random entry.
     *
     * @param content
     *            the content
     * @return the string
     */
    protected static String randomEntry(final String[] content) {
        final int bounds = content.length;
        final int randomIndex = random.nextInt(bounds);
        return content[randomIndex];
    }

    /**
     * Data for tag.
     *
     * @param tag
     *            the tag
     * @return the string
     */
    public String dataForTag(final String tag) {
        if (tag.startsWith("@")) {
            for (final String line : this.lines) {
                final String[] fields = line.split(",");
                if (fields[0].contains(tag)) {
                    return line;
                }
            }
        }
        return null;
    }
}
