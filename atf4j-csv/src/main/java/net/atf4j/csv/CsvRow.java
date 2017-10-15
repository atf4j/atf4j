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

import java.util.Arrays;

/**
 * Row from a CSV file.
 */
public class CsvRow {

    /** The fields. */
    private String[] fields = new String[0];

    /**
     * Instantiates a new CSV row.
     */
    public CsvRow() {
        this.fields = new String[] {};
    }

    /**
     * Instantiates a new CSV row.
     *
     * @param line
     *            the line
     */
    public CsvRow(final String line) {
        initialise(line);
    }

    /**
     * Initialise.
     *
     * @param line
     *            the line
     */
    public void initialise(final String line) {
        this.fields = line.trim().split(",");
        for (int i = 0; i < this.fields.length; i++) {
            this.fields[i] = this.fields[i].trim();
        }
    }

    /**
     * Length.
     *
     * @return the int
     */
    public int length() {
        return this.fields.length;
    }

    /**
     * Gets the field.
     *
     * @param columnNumber
     *            the column number
     * @return the field
     */
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
    public String debugString() {
        return String.format("%s [fields=%s]", this.getClass().getSimpleName(), Arrays.toString(this.fields));
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Arrays.toString(this.fields).replaceAll("\\[|\\]", "");
    }

}
