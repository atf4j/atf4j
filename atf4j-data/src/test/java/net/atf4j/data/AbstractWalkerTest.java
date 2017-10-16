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

import net.atf4j.core.ResultsReporting;

/**
 * A Unit test class for AbstractWalker objects.
 */
public final class AbstractWalkerTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

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
         * @param basePath the base path
         */
        public MockWalker(final String basePath) {
            super(basePath);
        }
    }

    /**
     * Test abstract walker.
     */
    @Test
    public void testAbstractWalker() {
        MockWalker mockWalker = new MockWalker();
        assertNotNull(UNEXPECTED_NULL, mockWalker);
        log.info("{}", mockWalker);
        assertNotNull(UNEXPECTED_NULL, mockWalker.walk());
    }

    /**
     * Test abstract walker dot.
     */
    @Test
    public void testAbstractWalkerDot() {
        MockWalker mockWalker = new MockWalker(".");
        assertNotNull(UNEXPECTED_NULL, mockWalker);
        log.info("{}", mockWalker);
        assertNotNull(UNEXPECTED_NULL, mockWalker.walk());
    }

    /**
     * Test abstract walker folder.
     */
    @Test
    public void testAbstractWalkerFolder() {
        MockWalker mockWalker = new MockWalker("/messages");
        assertNotNull(UNEXPECTED_NULL, mockWalker);
        log.info("{}", mockWalker);
        assertNotNull(UNEXPECTED_NULL, mockWalker.walk());
    }

    /**
     * Test abstract walker missing folder.
     */
    @Test
    public void testAbstractWalkerMissingFolder() {
        MockWalker mockWalker = new MockWalker("/missing");
        assertNotNull(UNEXPECTED_NULL, mockWalker);
        log.info("{}", mockWalker);
        assertNotNull(UNEXPECTED_NULL, mockWalker.walk());
    }
}
