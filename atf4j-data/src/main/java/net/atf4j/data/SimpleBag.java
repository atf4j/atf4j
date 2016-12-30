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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A Simple Bag class.
 */
public class SimpleBag {

    /** The values. */
    private String[] values;

    /** The bag. */
    private final List<String> bag = new ArrayList<String>();

    /** The rnd. */
    private final Random rnd = new Random();

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
     * @param values
     *            the values
     */
    public SimpleBag(final String[] values) {
        fill(values == null ? new String[0] : values);
    }

    /**
     * Fill.
     *
     * @param values
     *            the values
     * @return the simple bag
     */
    public SimpleBag fill(final String[] values) {
        this.values = values;
        for (final String value : values) {
            this.bag.add(value);
        }
        return this;
    }

    /**
     * Pick.
     *
     * @return the string
     */
    public String pick() {
        return this.bag.remove(this.rnd.nextInt(this.bag.size()));
    }

    /**
     * Take.
     *
     * @return the string
     */
    public String take() {
        return pick();
    }

    /**
     * Put.
     *
     * @param item
     *            the item
     * @return the simple bag
     */
    public SimpleBag put(final String item) {
        this.bag.add(item);
        return this;
    }

    /**
     * Reset.
     *
     * @return the simple bag
     */
    public SimpleBag reset() {
        return fill(this.values);
    }

    /**
     * Clear.
     *
     * @return the simple bag
     * @see java.util.List#clear()
     */
    public SimpleBag clear() {
        this.bag.clear();
        return this;
    }

    /**
     * the current size of bag.
     *
     * @return the int
     */
    public int count() {
        return this.bag.size();
    }

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     * @see java.util.List#isEmpty()
     */
    public boolean isEmpty() {
        return this.bag.isEmpty();
    }

    /**
     * Occupied.
     *
     * @return true, if successful
     */
    public boolean occupied() {
        return !this.bag.isEmpty();
    }

    /* (non-Javadoc)
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
        return String.format("SimpleBag [values=%s]", Arrays.toString(this.values));
    }

}
