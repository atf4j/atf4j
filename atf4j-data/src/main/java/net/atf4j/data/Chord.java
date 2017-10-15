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

import java.util.List;

/**
 * Chord Class.
 */
public class Chord {
    private CharSequence stem;
    private List<Chord> children;

    /**
     * Sets the stem.
     *
     * @param stem
     *            the new stem
     */
    public void setStem(final CharSequence stem) {
        this.stem = stem;
    }

    /**
     * Gets the stem.
     *
     * @return the stem
     */
    public CharSequence getStem() {
        return this.stem;
    }

    /**
     * Adds the.
     *
     * @param e
     *            the e
     * @return true, if successful, otherwise false.
     */
    public boolean add(final Chord e) {
        return this.children.add(e);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Chord [stem=" + this.stem + ", children=" + this.children + "]";
    }
}
