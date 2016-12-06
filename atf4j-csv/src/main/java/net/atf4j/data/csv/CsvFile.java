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
package net.atf4j.data.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The CsvFile Class.
 */
public class CsvFile {

	/** The Constant log. */
	protected static final Logger log = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

	/** The header. */
	private HeaderLine header;

	/** The data. */
	private final List<CsvRow> data = new ArrayList<CsvRow>();

	/**
	 * Instantiates a new csv file.
	 * @throws Exception 
	 */
	public CsvFile() throws Exception {
		super();
		load(this.getClass().getSimpleName());
	}
	
	/**
	 * Instantiates a new csv file.
	 *
	 * @param dataFilename
	 *            the data filename
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public CsvFile(final String dataFilename) throws Exception {
		super();
		load(dataFilename);
	}

	/**
	 * Load.
	 *
	 * @param csvFile
	 *            the csv file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws URISyntaxException 
	 */
	public void load(final String csvFile) throws Exception {
		URL resource = this.getClass().getResource(csvFile);
		InputStream openStream = resource.openStream();
		File file = new File(resource.toURI());

		FileReader in = new FileReader(file);
		final BufferedReader bufferedReader = new BufferedReader(in);
		try {
			final String line = bufferedReader.readLine().trim();
			this.header = new HeaderLine(line);
			while (line != null) {
				if (!line.startsWith("#")) {
					this.data.add(new CsvRow(line));
				}
			}
		} finally {
			bufferedReader.close();
		}
	}

	/**
	 * Read.
	 *
	 * @param csvFile
	 *            the csv file
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String read(final String csvFile) throws IOException {
		final BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
		final StringBuilder stringBuilder = new StringBuilder();
		try {
			String line = bufferedReader.readLine();
			while (line != null) {
				stringBuilder.append(line);
				stringBuilder.append(System.lineSeparator());
				line = bufferedReader.readLine();
			}
		} finally {
			bufferedReader.close();
		}
		return stringBuilder.toString();
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
		return this.header.get(columnNumber);
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

}
