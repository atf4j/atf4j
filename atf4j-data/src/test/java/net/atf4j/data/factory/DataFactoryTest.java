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

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.LoggedTest;

/**
 * PeopleFactoryTest.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class DataFactoryTest extends LoggedTest {
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Test Data Mock.
     */
    public class TestData extends AddressFactory {
        /**
         * Instantiates a new mock data.
         *
         * @throws Exception
         */
        public TestData() throws Exception {
            super();
        }
    }

    /**
     * Test default constructor.
     *
     * @throws Exception
     */
    @Test
    public final void testDefaultConstructor() throws Exception {
        final AbstractDataFactory testData = new TestData();
        Assert.assertNotNull(testData);
        this.log.info(testData.toString());
    }

    @Test
    public void testSomeThing() throws Exception {
        this.log.info(DataFactory.dateOfBirth().toString());
        this.log.info(DataFactory.dobOver18().toString());
        this.log.info(DataFactory.dobUnder18().toString());
        this.log.info(DataFactory.futureDate().toString());
        this.log.info(DataFactory.pastDate().toString());
        this.log.info(DataFactory.thisYear().toString());
        this.log.info(DataFactory.thisMonth().toString());
        this.log.info(DataFactory.familyName().toString());
        this.log.info(DataFactory.givenName().toString());
    }

}
