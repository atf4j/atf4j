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

/**
 * The Class CsvRow.
 */
public class CsvRow {

    /** The fields. */
    private final String[] fields;

    public CsvRow() {
        this.fields = new String[] {};
    }

    /**
     * Instantiates a new csv row.
     *
     * @param line
     *            the line
     */
    public CsvRow(final String line) {
        this.fields = line.split(",");
    }

    public String getField(final int columnNumber) {
        return this.fields[columnNumber - 1];
    }

    /**
     * Gets the fields.
     *
     * @return the fields
     */
    public String[] getFields() {
        return this.fields;
    }

    /**
     * To string.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("CsvRow [fields=%s]", this.fields);
    }

}
