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
 * Abstract Datum for field status.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
abstract public class Datum implements IDatum {

	private boolean isNew = true;
	private boolean isDirty = false;
	private boolean isDeleted = false;
	private boolean isUsed = false;

	/**
	 * Sets the new.
	 *
	 * @param isNew
	 *            the new new
	 * @return
	 * @see net.atf4j.data.IDatum#setNew(boolean)
	 */
	@Override
	public Datum setNew(final boolean isNew) {
		this.isDirty = !(this.isNew = isNew);
		return this;
	}

	/**
	 * Sets the dirty.
	 *
	 * @param isDirty
	 *            the new dirty
	 * @see net.atf4j.data.IDatum#setDirty(boolean)
	 */
	@Override
	public Datum setDirty(final boolean isDirty) {
		this.isNew = !(this.isDirty = isDirty);
		return this;
	}

	/**
	 * Sets the deleted.
	 *
	 * @param isDeleted
	 *            the new deleted
	 * @see net.atf4j.data.IDatum#setDeleted(boolean)
	 */
	@Override
	public Datum setDeleted(final boolean isDeleted) {
		this.isDeleted = isDeleted;
		return this;
	}

	/**
	 * Sets the used.
	 *
	 * @param isUsed
	 *            the new used
	 * @see net.atf4j.data.IDatum#setUsed(boolean)
	 */
	@Override
	public Datum setUsed(final boolean isUsed) {
		this.isUsed = isUsed;
		return this;
	}

	/**
	 * Checks if is new.
	 *
	 * @return true, if is new
	 * @see net.atf4j.data.IDatum#isNew()
	 */
	@Override
	public boolean isNew() {
		return this.isNew;
	}

	/**
	 * Checks if is dirty.
	 *
	 * @return true, if is dirty
	 * @see net.atf4j.data.IDatum#isDirty()
	 */
	@Override
	public boolean isDirty() {
		return this.isDirty;
	}

	/**
	 * Checks if is deleted.
	 *
	 * @return true, if is deleted
	 * @see net.atf4j.data.IDatum#isDeleted()
	 */
	@Override
	public boolean isDeleted() {
		return this.isDeleted;
	}

	/**
	 * Checks if is used.
	 *
	 * @return true, if is used
	 * @see net.atf4j.data.IDatum#isUsed()
	 */
	@Override
	public boolean isUsed() {
		return this.isUsed;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Datum [isNew=%s, isDirty=%s, isDeleted=%s, isUsed=%s]", this.isNew, this.isDirty,
				this.isDeleted, this.isUsed);
	}

}
