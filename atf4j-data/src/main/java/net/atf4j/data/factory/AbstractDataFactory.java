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
package net.atf4j.data.factory;

import net.atf4j.csv.CsvFile;
import net.atf4j.csv.CsvRow;
import net.atf4j.csv.HeaderLine;

/**
 * A factory for creating AbstractData objects.
 */
public abstract class AbstractDataFactory {

    /** The data file. */
    private CsvFile dataFile = null;

    /**
     * Instantiates a new abstract data factory.
     *
     * @throws Exception
     *             the exception
     */
    public AbstractDataFactory() throws Exception {
        super();
    }

    /**
     * Instantiates a new abstract data factory.
     *
     * @param dataFilename
     *            the data filename
     * @throws Exception
     *             the exception
     */
    public AbstractDataFactory(final String dataFilename) throws Exception {
        load(dataFilename);
    }

    /**
     * Load.
     *
     * @return the abstract data factory
     * @throws Exception
     *             the exception
     */
    protected AbstractDataFactory load() throws Exception {
        final String simpleName = this.getClass().getSimpleName();
        final String dataFilename = String.format("/%s.csv", simpleName);
        return load(dataFilename);
    }

    /**
     * Load data.
     *
     * @param dataFilename
     *            the data filename
     * @return the abstract data factory
     * @throws Exception
     *             the exception
     */
    private AbstractDataFactory load(final String dataFilename) throws Exception {
        this.dataFile = new CsvFile(dataFilename);
        return this;
    }

    /**
     * Gets the column names.
     *
     * @return the column names
     */
    public HeaderLine getColumnNames() {
        return this.dataFile.getHeaderLine();
    }

    /**
     * Gets the column name.
     *
     * @param columnNumber
     *            the column number
     * @return the column name
     */
    public String getColumnName(final int columnNumber) {
        return this.dataFile.getColumnName(columnNumber);
    }

    /**
     * Row count.
     *
     * @return the int
     */
    public int rowCount() {
        return this.dataFile.rowCount();
    }

    /**
     * Gets the row.
     *
     * @param index
     *            the index
     * @return the row
     */
    public CsvRow getRow(final int index) {
        return this.dataFile.getRow(index);
    }

}
