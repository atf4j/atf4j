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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The CsvFile Class.
 */
public class CsvFile  {
    protected static final Logger log = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    /** Optional header from first line. */
	private HeaderLine header;

	/** The data from the body of the file. */
	private final List<CsvRow> data = new ArrayList<CsvRow>();

    /**
     * Instantiates a new csv file.
     * 
     * @throws Exception 
     *             Signals that an I/O exception has occurred.
     */
    public CsvFile() throws Exception {
        super();
        load(String.format("%s.csv",this.getClass().getSimpleName()));
    }

	/**
	 * Instantiates a new csv file.
	 *
	 * @param dataFilename
	 *            the data filename
     * @throws Exception 
	 *             Signals that an I/O exception has occurred.
	 */
	public CsvFile(final String dataFilename) throws Exception {
		super();
		load(dataFilename);
	}

    /**
     * Read.
     *
     * @param missingCsv the missing csv
     * @return the csv file
     * @throws Exception the exception
     */
    public static CsvFile read(String missingCsv) throws Exception {
        return new CsvFile(missingCsv);
    }
	
    /**
     * Load.
     *
     * @throws Exception the exception
     */
    public void load() throws Exception {
		final String dataFilename = this.getClass().getSimpleName() + ".csv";
		load(dataFilename);
	}

	/**
	 * Load.
	 *
	 * @param dataFilename the data filename
	 * @throws Exception the exception
	 */
	public void load(final String dataFilename) throws Exception {
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream in = classLoader.getResourceAsStream(dataFilename);
		if (in != null) {
		    load(in);
		} else {
		    throw new FileNotFoundException(dataFilename);
		}
	}

	/**
	 * Load.
	 *
	 * @param in the in
	 * @throws Exception the exception
	 */
	public void load(final InputStream in) throws Exception {
		InputStreamReader inputStreamReader = new InputStreamReader(in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		try {
		    String line ;
		    while((line = bufferedReader.readLine())!=null) {
		        log.trace(line);
				if (line.startsWith("#")) {
		            this.header = new HeaderLine(line);
				} else {
					this.data.add(new CsvRow(line));
				}
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
	public HeaderLine getHeader() {
		return this.header;
	}

	/**
	 * Gets the header.
	 *
	 * @param columnNumber
	 *            the column number
	 * @return the header
	 */
	public String getHeader(final int columnNumber) {
		return this.header.get(columnNumber);
	}

	/**
	 * Gets the.
	 *
	 * @param index
	 *            the index
	 * @return the csv row
	 * @see java.util.List#get(int)
	 */
	public CsvRow get(final int index) {
		return this.data.get(index);
	}

	/**
	 * To array.
	 *
	 * @return the object[]
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		return this.data.toArray();
	}

	/**
	 * To array.
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
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("CsvFile [header=%s, data=%s]",this.getClass().getSimpleName(), header, data);
    }

}
