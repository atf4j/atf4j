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
 * An enumeration to hold the status of a field.
 */
public enum FieldStatus {

    /** The field is pristine, unchanged. */
    PRISTINE("Pristine"),

    /** The field has been changed. */
    CHANGED("Changed"),

    /** The change to field has been persisted. */
    PERSISTED("Persisted"),

    /** The field is unwanted. */
    UNWANTED("Unwanted");

    /** The value. */
    private String value;

    /**
     * Instantiates a new field status.
     *
     * @param value the value
     */
    private FieldStatus(final String value) {
        this.value = value;
    }

    /**
     * Initialise.
     *
     * @return the field status
     */
    public static FieldStatus initialise() {
        return FieldStatus.PRISTINE;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return String.format("FieldStatus [value=%s]", value);
    }

}
