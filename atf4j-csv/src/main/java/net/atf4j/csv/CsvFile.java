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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A CSV Data File.
 */
public class CsvFile {

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The header line, if present */
    private HeaderLine header;

    /** The data. */
    private final List<CsvRow> data = new ArrayList<CsvRow>();

    /**
     * Default Constructor instantiates a new empty CsvFile object.
     *
     * @throws Exception
     *             Signals that an I/O exception has occurred.
     */
    public CsvFile() throws Exception {
        load();
    }

    /**
     * Instantiates a new CSV file.
     *
     * @param dataFilename
     *            the data filename
     * @throws Exception
     *             the exception
     */
    public CsvFile(final String dataFilename) throws Exception {
        load(dataFilename);
    }

    /**
     * Factory Method returns file as CsvFile instance.
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
    protected void load() throws Exception {
        final String simpleName = this.getClass().getSimpleName();
        final String dataFilename = String.format("/%s.csv", simpleName);
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
            String line = bufferedReader.readLine().trim();
            this.log.trace(line);
            if (line.startsWith("#")) {
                this.header = new HeaderLine(line.substring(1));
            } else {
                this.data.add(new CsvRow(line));
            }
            while ((line = bufferedReader.readLine()) != null) {
                this.log.trace(line);
                this.data.add(new CsvRow(line));
            }
        } finally {
            bufferedReader.close();
        }
    }

    /**
     * Gets the header.
     *
     * @return the header
     */
    public HeaderLine getHeaderLine() {
        return this.header;
    }

    /**
     * Gets the column names.
     *
     * @return the column names
     */
    public String[] getColumnNames() {
        return this.header.getFields();
    }

    /**
     * Gets the header for a column.
     *
     * @param columnNumber
     *            the column number
     * @return the header
     */
    public String getColumnName(final int columnNumber) {
        return this.header.getField(columnNumber);
    }

    /**
     * Length.
     *
     * @return the int
     */
    public int rowCount() {
        return this.data.size();
    }

    /**
     * Get a row by index.
     *
     * @param index
     *            line number
     * @return the csv row
     * @see java.util.List#get(int)
     */
    public CsvRow getRow(final int index) {
        return this.data.get(index - 1);
    }

    /**
     * return the CSV file data as an array of rows.
     *
     * @return the object[]
     * @see java.util.List#toArray()
     */
    public Object[] toArray() {
        return this.data.toArray();
    }

    /**
     * To string.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    public String debugString() {
        final String simpleName = this.getClass().getSimpleName();
        return String.format("%s [header=%s, data=%s]", simpleName, this.header.toString(), this.data.toString());
    }

}
