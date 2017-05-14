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

import java.util.UUID;

/**
 * The Field Class.
 */
public class Field {

    private FieldStatus status;
    private String key;
    private String value;

    /**
     * Instantiates a new field.
     */
    public Field() {
        super();
        this.status = FieldStatus.PRISTINE;
        set(UUID.randomUUID().toString(), "");
    }

    /**
     * Instantiates a new field.
     *
     * @param value the value
     */
    public Field(final String value) {
        super();
        set(UUID.randomUUID().toString(), value);
        this.status = FieldStatus.PRISTINE;
    }

    /**
     * Instantiates a new field.
     *
     * @param key the key
     * @param value the value
     */
    public Field(final String key, final String value) {
        super();
        set(key, value);
        this.status = FieldStatus.PRISTINE;
    }

    /**
     * Sets the.
     *
     * @param key the key
     * @param value the value
     * @return the field
     */
    private Field set(final String key, final String value) {
        this.key = key;
        this.value = value;
        return this;
    }

    /**
     * Sets the key.
     *
     * @param key the key
     * @return the field
     */
    public Field setKey(final String key) {
        this.key = key;
        this.status = FieldStatus.CHANGED;
        return this;
    }

    /**
     * Sets the value.
     *
     * @param value the value
     * @return the field
     */
    public Field setValue(final String value) {
        this.value = value;
        this.status = FieldStatus.CHANGED;
        return this;
    }

    /**
     * Sets the status.
     *
     * @param fieldStatus the field status
     * @return the field
     */
    public Field setStatus(final FieldStatus fieldStatus) {
        this.status = fieldStatus;
        return this;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Gets the key.
     *
     * @return the key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public FieldStatus getStatus() {
        return this.status;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Field [status=%s, key=%s, value=%s]", this.status, this.key, this.value);
    }

}
