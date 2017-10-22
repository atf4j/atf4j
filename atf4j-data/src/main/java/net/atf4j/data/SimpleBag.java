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
import java.util.List;
import java.util.Random;

import net.atf4j.core.TestResultsReporting;

/**
 * A Simple Bag class.
 */
public class SimpleBag extends TestResultsReporting {

    private String[] values;
    private final List<String> bag = new ArrayList<String>();
    private final Random random = new Random();

    /**
     * Instantiates a new empty simple bag.
     */
    public SimpleBag() {
        super();
        fill(new String[0]);
    }

    /**
     * Instantiates a new simple bag.
     *
     * @param values the values
     */
    public SimpleBag(final String[] values) {
        super();
        fill(values == null ? new String[0] : values);
    }

    /**
     * Fill.
     *
     * @param values the values
     * @return the simple bag
     */
    public SimpleBag fill(final String[] values) {
        this.values = Arrays.copyOf(values, values.length);
        for (final String value : values) {
            bag.add(value);
        }
        return this;
    }

    /**
     * Pick an item from the bag.
     *
     * @return the string
     */
    public String pick() {
        return bag.remove(random.nextInt(bag.size()));
    }

    /**
     * Take an item from the bag.
     *
     * @return the string
     */
    public String take() {
        return pick();
    }

    /**
     * Put an item into the bag.
     *
     * @param item the item
     * @return the simple bag
     */
    public SimpleBag put(final String item) {
        bag.add(item);
        return this;
    }

    /**
     * Reset the bag to its initial state.
     *
     * @return the simple bag
     */
    public SimpleBag reset() {
        return fill(values);
    }

    /**
     * Clear the bag, empty it.
     *
     * @return the simple bag
     * @see java.util.List#clear()
     */
    public SimpleBag clear() {
        bag.clear();
        return this;
    }

    /**
     * count the current items in the bag.
     *
     * @return the int
     */
    public int count() {
        return bag.size();
    }

    /**
     * Checks if the bag is empty.
     *
     * @return true, if is empty, otherwise false.
     * @see java.util.List#isEmpty()
     */
    public boolean isEmpty() {
        return bag.isEmpty();
    }

    /**
     * Occupied.
     *
     * @return true, if successful, otherwise false.
     */
    public boolean occupied() {
        return !bag.isEmpty();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("%s [values=%s]", this.getClass().getSimpleName(), Arrays.toString(values));
    }

}
