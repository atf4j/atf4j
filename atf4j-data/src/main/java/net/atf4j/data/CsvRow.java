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

package net.atf4j.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * A class to represent a row from a CSV data file.
 */
public class CsvRow {

    /** The values. */
    private List<String> values = new ArrayList<String>();

    /**
     * A factory method that parses a String as a row of comma separated values
     * and returns a CsvRow.
     *
     * @param lineOfData the line of data
     * @return this for a fluent interface.
     */
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
     * @param lineOfData the line of data
     */
    public CsvRow(final String lineOfData) {
        if (lineOfData != null) {
            this.values = Arrays.asList(lineOfData.split("\\s*,\\s*"));
        }
    }

    /**
     * Adds a value to the end of the row.
     *
     * @param value the field to be added.
     * @return this for a fluent interface.
     * @see java.util.List#add(int, java.lang.Object)
     */
    protected CsvRow addField(final String value) {
        this.values.add(value);
        return this;
    }

    /**
     * Set the value in the specified column index.
     *
     * @param index the index
     * @param value the field to be added.
     * @return this for a fluent interface.
     * @see java.util.List#set(int, java.lang.Object)
     */
    protected CsvRow setField(final int index, final String value) {
        this.values.set(index - 1, value);
        return this;
    }

    /**
     * The number of values (columns) in the row.
     *
     * @return size as an int.
     * @see java.util.List#size()
     */
    public int length() {
        return this.values.size();
    }

    /**
     * Checks if the row is empty.
     *
     * @return true, if is empty, otherwise false.
     * @see java.util.List#isEmpty()
     */
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    /**
     * An iterator for the values.
     *
     * @return the iterator
     * @see java.util.List#iterator()
     */
    public Iterator<String> iterator() {
        return this.values.iterator();
    }

    /**
     * Find field with a specific value.
     *
     * @param value the value
     * @return index of the value.
     */
    public int findField(final String value) {
        for (int index = 0; index < this.values.size(); index++) {
            if (this.values.get(index).equals(value)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Gets the field value from the column number.
     *
     * @param index the column number
     * @return the field.
     */
    public String getField(final int index) {
        return this.values.get(index - 1);
    }

    /**
     * Get all the values in the row.
     *
     * @return the values as String array.
     */
    public String[] getFields() {
        return (String[]) this.values.toArray();
    }

    /**
     * Removes the value at index, without shifting the following elements.
     * Returns the element that was removed from the list.
     *
     * To remove a value and shift following values left, use
     * <code>removeField</code> function.
     *
     * @param index the column to be removed.
     * @return the string
     * @see java.util.List#remove(int)
     */
    public String clearField(final int index) {
        return this.values.set(index - 1, "");
    }

    /**
     * Removes the value at index and shifts following elements to the left.
     * Returns the element that was removed from the list.
     *
     * To remove a value without shifting left, use <code>clearField</code>
     * function.
     *
     * @param index the column to be removed.
     * @return the string
     * @see java.util.List#remove(int)
     */
    public String removeField(final int index) {
        return this.values.remove(index - 1);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuffer buffer = new StringBuffer();
        Iterator<String> iterator = this.values.iterator();
        while (iterator.hasNext()) {
            buffer.append(iterator.next().trim());
            if (iterator.hasNext()) {
                buffer.append(", ");
            }
        }
        return buffer.toString();
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("%s [values=%s]", this.getClass().getSimpleName(), this.values);
    }

}
