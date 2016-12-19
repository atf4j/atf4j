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
package net.atf4j.data.factory;

import net.atf4j.core.AbstractConfig;

/**
 * A factory for creating AbstractData objects.
 */
public abstract class AbstractDataFactory extends AbstractConfig {

    /**
     * Instantiates a new abstract data factory.
     *
     * @throws Exception
     *             the exception
     */
    public AbstractDataFactory() throws Exception {
        super();
        loadData();
    }

    /**
     * Load data.
     *
     * @return the abstract data factory
     * @throws Exception
     *             the exception
     */
    private AbstractDataFactory loadData() throws Exception {
        return this;
    }

}
