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

package net.atf4j.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.ResourceLoader;

/**
 * The CsvFile class represents a dataLines file containing comma separated
 * values.
 */
public class CsvFile {
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The filename. */
    private String csvFilename;

    private final List<HeaderLine> headerLines = new ArrayList<HeaderLine>();
    private final List<CsvRow> dataLines = new ArrayList<CsvRow>();

    /** The loaded successfully. */
    private boolean loaded = false;

    /**
     * Default Constructor instantiates a new empty CsvFile object.
     */
    public CsvFile() {
        super();
        this.log.debug("CsvFile()");
        initialise(defaultFilename());
    }

    /**
     * Default filename.
     *
     * @return the string
     */
    private String defaultFilename() {
        if (this.csvFilename == null) {
            final String stem = this.getClass().getSimpleName();
            this.csvFilename = String.format("%s.csv", stem);
        }
        return this.csvFilename;
    }

    /**
     * Instantiates a new csv file from filename.
     *
     * @param csvFilename the csv filename
     */
    public CsvFile(final String csvFilename) {
        super();
        this.log.debug("CsvFile({})", csvFilename);
        initialise(csvFilename);
    }

    /**
     * Initialise.
     *
     * @param csvFilename the csv filename
     */
    private void initialise(final String csvFilename) {
        this.log.debug("initialise({})", csvFilename);
        this.csvFilename = csvFilename;
        readResource(this.csvFilename);
    }

    /**
     * Read filename.
     *
     * @param resourceName the filename of the resource
     */
    private void readResource(final String resourceName) {
        this.log.debug("read({})", resourceName);
        final InputStream stream = ResourceLoader.streamFor(resourceName);
        try {
            read(stream);
        } catch (final IOException e) {
            this.log.error(e.getLocalizedMessage(), e);
        }
    }

    /**
     * Read a resource as a stream.
     *
     * @param resourceAsStream the resource as stream
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void read(final InputStream resourceAsStream) throws IOException {
        final InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
        read(inputStreamReader);
        inputStreamReader.close();
    }

    /**
     * Read input stream reader.
     *
     * @param inputStreamReader the input stream reader
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void read(final InputStreamReader inputStreamReader) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        read(bufferedReader);
        bufferedReader.close();
    }

    /**
     * Read.
     *
     * @param bufferedReader the buffered reader
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void read(final BufferedReader bufferedReader) throws IOException {
        String line = bufferedReader.readLine();
        while (line != null) {
            if (line.length() > 0) {
                processLine(line.trim());
            }
            line = bufferedReader.readLine();
        }
        this.loaded = true;
    }

    /**
     * Process line.
     *
     * @param line the line
     */
    private void processLine(final String line) {
        if (line.charAt(0) == '#') {
            addHeaderLine(line);
        } else {
            final CsvRow record = new CsvRow(line);
            this.dataLines.add(record);
            final String recordString = record.toString();
        }
    }

    /**
     * header line new header line.
     *
     * @param line the new header line
     */
    public void addHeaderLine(final HeaderLine line) {
        this.headerLines.add(line);
    }

    public void addHeaderLine(final String line) {
        this.headerLines.add(new HeaderLine(line));
    }

    /**
     * Factory Method returns file as CsvFile INSTANCE.
     *
     * @param dataFilename the dataLines filename
     * @return the csv file
     * @throws FileNotFoundException the file not found exception
     */
    public static CsvFile read(final String dataFilename) throws FileNotFoundException {
        return new CsvFile(dataFilename);
    }

    /**
     * Load.
     */
    protected void load() {
        try {
            load(configFilename());
        } catch (final FileNotFoundException e) {
            this.log.warn(e.toString());
        }
    }

    /**
     * Configuration filename.
     *
     * @return the string
     */
    private String configFilename() {
        final String simpleName = this.getClass().getSimpleName();
        return String.format("%s.csv", simpleName);
    }

    /**
     * Load.
     *
     * @param csvFilename the dataLines filename
     * @throws FileNotFoundException the file not found exception
     */
    public void load(final String csvFilename) throws FileNotFoundException {
        final InputStream resourceAsStream = resourceAsStream(csvFilename);
        if (resourceAsStream != null) {
            load(resourceAsStream);
        } else {
            final String message = String.format("Expected '%s'", csvFilename);
            throw new FileNotFoundException(message);
        }
    }

    /**
     * Load.
     *
     * @param inputStream the InputStream
     */
    public void load(final InputStream inputStream) {
        final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String line = bufferedReader.readLine().trim();
            if (line.charAt(0) == '#') {
                addHeaderLine(new HeaderLine(line.substring(1)));
            } else {
                this.dataLines.add(new CsvRow(line));
            }

            while ((line = bufferedReader.readLine()) != null) {
                this.dataLines.add(new CsvRow(line));
            }
            bufferedReader.close();

        } catch (final IOException e) {
            this.log.error(e.toString());
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
     * Column count.
     *
     * @return the int
     */
    public int columnCount() {
        return 0;
    }

    /**
     * Gets the column names.
     *
     * @return the column names
     */
    public String[] getColumnNames() {
        return null;
    }

    /**
     * Gets the header for a column.
     *
     * @param columnNumber the column number
     * @return the header
     */
    public String getColumnName(final int columnNumber) {
        return null;
    }

    /**
     * Length.
     *
     * @return the int
     */
    public int rowCount() {
        return this.dataLines.size();
    }

    /**
     * Get a row by index.
     *
     * @param index line number
     * @return the csv row
     * @see java.util.List#get(int)
     */
    public CsvRow getRow(final int index) {
        return this.dataLines.get(index - 1);
    }

    /**
     * return the CSV file dataLines as an array of rows.
     *
     * @return the object[]
     * @see java.util.List#toArray()
     */
    public CsvRow[] toArray() {
        return (CsvRow[]) this.dataLines.toArray();
    }

    public HeaderLine getHeaderLine() {
        return null;
    }

    public boolean isLoaded() {
        return false;
    }

    public CsvRow getRecord(final int index) {
        return null;
    }

}
