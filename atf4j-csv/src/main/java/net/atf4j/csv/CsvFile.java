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
package net.atf4j.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The CsvFile Class.
 */
public class CsvFile {

    /** The logger. */
    protected static final Logger log = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    /** The header. */
    private HeaderLine header;

    /** The data. */
    private final List<CsvRow> data = new ArrayList<CsvRow>();

    /**
     * Default Constructor Instantiates a new CsvFile object.
     *
     * @throws Exception
     *             Signals that an I/O exception has occurred.
     */
    public CsvFile() throws Exception {
        super();
    }

    /**
     * Instantiates a new csv file.
     *
     * @param dataFilename
     *            the data filename
     * @throws Exception
     *             the exception
     */
    public CsvFile(final String dataFilename) throws Exception {
        super();
        load(dataFilename);
    }

    /**
     * Read.
     *
     * @param dataFilename
     *            the data filename
     * @return the csv file
     * @throws Exception
     *             the exception
     */
    public static CsvFile read(final String dataFilename) throws Exception {
        return new CsvFile(dataFilename);
    }

    /**
     * Load.
     *
     * @throws Exception
     *             the exception
     */
    public void load() throws Exception {
        final String dataFilename = this.getClass().getSimpleName() + ".csv";
        load(dataFilename);
    }

    /**
     * Load.
     *
     * @param dataFilename
     *            the data filename
     * @throws Exception
     *             the exception
     */
    public void load(final String dataFilename) throws Exception {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        final InputStream in = classLoader.getResourceAsStream(dataFilename);
        if (in != null) {
            load(in);
        } else {
            throw new FileNotFoundException(dataFilename);
        }
    }

    /**
     * Load.
     *
     * @param in
     *            the in
     * @throws Exception
     *             the exception
     */
    public void load(final InputStream in) throws Exception {
        final InputStreamReader inputStreamReader = new InputStreamReader(in);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            String line = bufferedReader.readLine();
            if (line.startsWith("#")) {
                this.header = new HeaderLine(line);
            } else {
                this.data.add(new CsvRow(line));
            }
            while ((line = bufferedReader.readLine()) != null) {
                log.trace(line);
                this.data.add(new CsvRow(line));
            }
        } finally {
            bufferedReader.close();
        }
    }

    /**
     * Scan.
     *
     * @param csvFile
     *            the csv file
     * @return the string
     * @throws FileNotFoundException
     *             the file not found exception
     */
    public static String scan(final String csvFile) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new FileReader(csvFile));
        final StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            final String line = scanner.nextLine();
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
        }
        scanner.close();
        return stringBuilder.toString();
    }

    /**
     * Gets the header.
     *
     * @return the header
     */
    public HeaderLine getHeader() {
        return this.header;
    }

    /**
     * Gets the header for a column.
     *
     * @param columnNumber
     *            the column number
     * @return the header
     */
    public String getHeader(final int columnNumber) {
        return this.header.getField(columnNumber);
    }

    /**
     * Get a row by index.
     *
     * @param index
     *            line number
     * @return the csv row
     * @see java.util.List#get(int)
     */
    public CsvRow get(final int index) {
        return this.data.get(index);
    }

    /**
     * return the csv file data as an array of rows.
     *
     * @return the object[]
     * @see java.util.List#toArray()
     */
    public Object[] toArray() {
        return this.data.toArray();
    }

    /**
     * convert the data to an array of rows.
     *
     * @param <T>
     *            the generic type
     * @param a
     *            the a
     * @return the t[]
     * @see java.util.List#toArray(java.lang.Object[])
     */
    public <T> T[] toArray(final T[] a) {
        return this.data.toArray(a);
    }

    /**
     * To string.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [header=%s, data=%s]", this.getClass().getSimpleName(), this.header, this.data);
    }

}
