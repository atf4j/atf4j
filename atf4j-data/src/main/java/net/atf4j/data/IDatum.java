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
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public interface IDatum {

	/**
	 * @param isNew
	 *            the isNew to set
	 * @return
	 */
	public abstract Datum setNew(boolean isNew);

	/**
	 * @param isDirty
	 *            the isDirty to set
	 */
	public abstract Datum setDirty(boolean isDirty);

	/**
	 * @param isDeleted
	 *            the isDeleted to set
	 */
	public abstract Datum setDeleted(boolean isDeleted);

	/**
	 * @param isUsed
	 *            the isUsed to set
	 */
	public abstract Datum setUsed(boolean isUsed);

	/**
	 * @return the isNew
	 */
	public abstract boolean isNew();

	/**
	 * @return the isDirty
	 */
	public abstract boolean isDirty();

	/**
	 * @return the isDeleted
	 */
	public abstract boolean isDeleted();

	/**
	 * @return the isUsed
	 */
	public abstract boolean isUsed();

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public abstract String toString();

}