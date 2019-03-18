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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A class to represent a row from a CSV data file.
 */
public class CsvRow {

    /**
     * @param index
     * @return
     * @see java.util.List#get(int)
     */
    public String get(final int index) {
        return this.fields.get(index);
    }

    /** fields. */
    private List<String> fields = new ArrayList<String>();

    public static CsvRow parse(final String lineOfData) {
        return new CsvRow(lineOfData);
    }

    /**
     * Instantiates a new CSV row.
     */
    public CsvRow() {
        super();
    }

    /**
     * Instantiates a new CSV row.
     *
     * @param line the line
     */
    public CsvRow(final String lineOfData) {
        this.fields = Arrays.asList(lineOfData.split(","));
    }

    public int colCount() {
        return 0;
    }

    public String getCol(final int col) {
        return null;
    }

    public Object length() {
        return null;
    }

    public Object getField(final int i) {
        return null;
    }

    public String[] getFields() {
        return null;
    }

    public String getColumn(final int i) {
        return null;
    }

}
