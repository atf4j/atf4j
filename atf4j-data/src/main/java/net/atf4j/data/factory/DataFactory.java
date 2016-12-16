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

import java.util.Date;

import net.atf4j.data.FactoryMethod;

/**
 * DataFactory.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 *
 */
public class DataFactory extends AbstractDataFactory implements FactoryMethod {

    protected DataFactory() throws Exception {
        super();
    }

    @Override
    public Object create() {
        return null;
    }

    public static Date today() {
        return new Date();
    }

    public static Date dateOfBirth() {
        return null;
    }

    public static Date dobOver18() {
        return null;
    }

    public static Date dobUnder18() {
        return null;
    }

    public static Date futureDate() {
        return null;
    }

    public static Date pastDate() {
        return null;
    }

    public static String thisYear() {
        return null;
    }

    public static String thisMonth() {
        return null;
    }

    public static String familyName() {
        return null;
    }

    public static String givenName() {
        return null;
    }

}
