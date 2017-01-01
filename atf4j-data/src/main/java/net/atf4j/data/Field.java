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

import java.util.UUID;

public class Field {
    private FieldStatus status;
    private String key;
    private String value;

    public Field() {
        super();
        this.status = FieldStatus.PRISTINE;
    }

    public Field(final String value) {
        super();
        this.status = FieldStatus.PRISTINE;
        this.key = UUID.randomUUID().toString();
        this.value = value;
    }

    public Field(final String key, final String value) {
        super();
        this.status = FieldStatus.PRISTINE;
        this.key = key;
        this.value = value;
    }

    public Field setValue(final String value) {
        this.value = value;
        this.status = FieldStatus.CHANGED;
        return this;
    }

    public Field setKey(final String key) {
        this.key = key;
        this.status = FieldStatus.CHANGED;
        return this;
    }

    public Field setStatus(final FieldStatus fieldStatus) {
        this.status = fieldStatus;
        return this;
    }

    public String getValue() {
        return this.value;
    }

    public String getKey() {
        return this.key;
    }

    public FieldStatus getStatus() {
        return this.status;
    }

    public String debugString() {
        return String.format("Field [status=%s, key=%s, value=%s]", this.status, this.key, this.value);
    }

    @Override
    public String toString() {
        return debugString();
    }

}
