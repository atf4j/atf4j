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

package net.atf4j.data.factory;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A UnitTest for AbstractDataFactory objects.
 */
public final class MockDataFactoryTest extends TestResultsReporting {

    /**
     * Mock Test Data.
     */
    public final class MockDataFactory extends AbstractDataFactory {
        /**
         * Instantiates a new test data.
         *
         * @throws Exception the exception
         */
        public MockDataFactory() throws Exception {
            super();
        }
    }

    /**
     * Test default constructor.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDefaultConstructor() throws Exception {
        final MockDataFactory testDataFactory = new MockDataFactory();
        log.debug("new MockDataFactory() = {}", testDataFactory);
        assertNotNull(UNEXPECTED_NULL, testDataFactory);
    }

    /**
     * Test static data for tag.
     *
     * @throws Exception the exception
     */
    @Test
    public void testStaticDataForTag() throws Exception {
        final MockDataFactory testDataFactory = new MockDataFactory();
        log.debug("new MockDataFactory() = {}", testDataFactory);
        assertNotNull(UNEXPECTED_NULL, testDataFactory);

        final String dataForTag = testDataFactory.dataForTag("#Data");
        log.debug("dataFactory.dataForTag('#Data') = {}", dataForTag);
    }

}
