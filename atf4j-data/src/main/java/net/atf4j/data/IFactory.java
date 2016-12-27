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

import java.util.Collection;

/**
 * IFactory.
 *
 * 
 */
public interface IFactory {
    /**
     * Factory method to create single instance of object.
     * 
     * @return Object.
     */
    public Object create();

    /**
     * Factory method to create a collection.
     * 
     * @param number
     *            of instances as int.
     * @return Collection of instances.
     */
    public Collection<Object> create(int number);
}
