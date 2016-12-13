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
package net.atf4j.core.model;

import java.util.UUID;

/**
 * Unique TestIdentifier TODO : Make serializable?.
 */
public class TestIdentifier {

    /** The uuid. */
    private UUID uuid;

    /**
     * create.
     */
    public void create() {
        this.uuid = UUID.randomUUID();
    }

    /**
     * return the UUID as a String.
     *
     * @return the string
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.uuid.toString();
    }

    /**
     * Gets the uuid.
     *
     * @return the uuid
     */
    public UUID getUuid() {
        return this.uuid;
    }

    /**
     * Sets the uuid.
     *
     * @param uuidIn
     *            the new uuid
     */
    public void setUuid(final UUID uuidIn) {
        this.uuid = uuidIn;
    }
}
