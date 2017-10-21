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

/**
 * Datum for providing field status.
 */
public abstract class Datum {

    private boolean isFresh = true;
    private boolean isChanged = false;
    private boolean isDeleted = false;
    private boolean isUsed = false;

    /**
     * Fresh.
     *
     * @param isNew the is new
     * @return the datum
     */
    protected Datum fresh(final boolean isNew) {
        isChanged = !(isFresh = isNew);
        return this;
    }

    /**
     * Changed.
     *
     * @param isDirty the is dirty
     * @return the datum
     */
    protected Datum changed(final boolean isDirty) {
        isFresh = !(isChanged = isDirty);
        return this;
    }

    /**
     * Deleted.
     *
     * @param isDeleted the is deleted
     * @return the datum
     */
    protected Datum deleted(final boolean isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }

    /**
     * Used.
     *
     * @param isUsed the is used
     * @return the datum
     */
    protected Datum used(final boolean isUsed) {
        this.isUsed = isUsed;
        return this;
    }

    /**
     * Checks if is new.
     *
     * @return true, if is new
     */
    public boolean isFresh() {
        return isFresh;
    }

    /**
     * Checks if is dirty.
     *
     * @return true, if is dirty
     */
    public boolean isChanged() {
        return isChanged;
    }

    /**
     * Checks if is deleted.
     *
     * @return true, if is deleted
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * Checks if is used.
     *
     * @return true, if is used
     */
    public boolean isUsed() {
        return isUsed;
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("%s [isNew=%s, isDirty=%s, isDeleted=%s, isUsed=%s]",
                this.getClass().getSimpleName(),
                isFresh,
                isChanged,
                isDeleted,
                isUsed);
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

}
