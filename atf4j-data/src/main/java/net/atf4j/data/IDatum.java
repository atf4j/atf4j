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

/**
 * IDatum.
 *
 *
 */
public interface IDatum {

    /**
     * Sets the new.
     *
     * @param isNew
     *            the isNew to set
     * @return the datum
     */
    abstract Datum setFresh(boolean isNew);

    /**
     * Sets the dirty.
     *
     * @param isDirty
     *            the isDirty to set
     * @return the datum
     */
    abstract Datum setDirty(boolean isDirty);

    /**
     * Sets the deleted.
     *
     * @param isDeleted
     *            the isDeleted to set
     * @return the datum
     */
    abstract Datum setDeleted(boolean isDeleted);

    /**
     * Sets the used.
     *
     * @param isUsed
     *            the isUsed to set
     * @return the datum
     */
    abstract Datum setUsed(boolean isUsed);

    /**
     * Checks if is new.
     *
     * @return the isNew
     */
    abstract boolean isFresh();

    /**
     * Checks if is dirty.
     *
     * @return the isDirty
     */
    abstract boolean isChanged();

    /**
     * Checks if is deleted.
     *
     * @return the isDeleted
     */
    abstract boolean isDeleted();

    /**
     * Checks if is used.
     *
     * @return the isUsed
     */
    abstract boolean isUsed();

}