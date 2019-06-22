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

import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * A UnitTest for AbstractDataFactory objects.
 */
@Slf4j
public final class MockDataFactoryTest {

    /**
     * Mock Data Factory.
     */
    public final class MockDataFactory extends AbstractDataFactory {
        /**
         * Instantiates a new test data.
         */
        public MockDataFactory() {
            super();
        }
    }

    /**
     * Test default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        final MockDataFactory testDataFactory = new MockDataFactory();
        verifyNotNull(testDataFactory);
        log.debug("new MockDataFactory() = {}", testDataFactory);
    }

    /**
     * Test static data for tag.
     */
    @Test
    public void testStaticDataForTag() {
        final String dataForTag = new MockDataFactory().dataForTag("#Data");
        log.debug("dataFactory.dataForTag('#Data') = {}", dataForTag);
    }

}
