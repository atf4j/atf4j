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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Unit test class for AbstractWalker objects.
 */
public final class AbstractWalkerTest {

    private static final String UNEXPECTED_NULL = "unexpected null";
    private static final Logger LOG = LoggerFactory.getLogger(AbstractWalkerTest.class);

    /**
     * MockWalker Class.
     */
    public class MockWalker extends AbstractWalker {

        /**
         * Instantiates a new mock walker.
         */
        public MockWalker() {
            super();
        }

        /**
         * Instantiates a new mock walker.
         * 
         * @param basePath
         *            the base path
         * @throws Exception
         *             the exception
         */
        public MockWalker(final String basePath) {
            super(basePath);
        }
    }

    @Test(expected = AssertionError.class)
    public void testAbstractWalker() {
        MockWalker mockWalker = new MockWalker();
        assertNotNull(UNEXPECTED_NULL, mockWalker);
        LOG.info("{}", mockWalker);
        assertNotNull(UNEXPECTED_NULL, mockWalker.walk());
    }

    @Test
    public void testAbstractWalkerDot() {
        MockWalker mockWalker = new MockWalker(".");
        assertNotNull(UNEXPECTED_NULL, mockWalker);
        LOG.info("{}", mockWalker);
        assertNotNull(UNEXPECTED_NULL, mockWalker.walk());
    }

    @Test
    public void testAbstractWalkerFolder() {
        MockWalker mockWalker = new MockWalker("/messages");
        assertNotNull(UNEXPECTED_NULL, mockWalker);
        LOG.info("{}", mockWalker);
        assertNotNull(UNEXPECTED_NULL, mockWalker.walk());
    }

    @Test
    public void testAbstractWalkerMissingFolder() {
        MockWalker mockWalker = new MockWalker("/missing");
        assertNotNull(UNEXPECTED_NULL, mockWalker);
        LOG.info("{}", mockWalker);
        assertNotNull(UNEXPECTED_NULL, mockWalker.walk());
    }
}
