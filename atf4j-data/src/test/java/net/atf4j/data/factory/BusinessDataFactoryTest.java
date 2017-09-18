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

import net.atf4j.core.ResultsReporting;
import net.atf4j.data.Business;

/**
 * A UnitTest for BusinessDataFactory objects.
 */
public class BusinessDataFactoryTest extends ResultsReporting {

    /**
     * Test method for expected usage.
     */
    @Test
    public void testExpectedUsage() {
        final String randomThing = BusinessDataFactory.randomThing();
        assertNotNull(randomThing);
        this.log.info("{}", randomThing);
    }

    /**
     * Test default constructor.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testDefaultConstructor() throws Exception {
        final BusinessDataFactory bdf = new BusinessDataFactory();
        assertNotNull(bdf);
        this.log.info("{}", bdf.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testGetInstance() {
        final BusinessDataFactory bdf = BusinessDataFactory.getInstance();
        assertNotNull(bdf);
        this.log.info("{}", bdf.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        final Business bdf = BusinessDataFactory.create();
        assertNotNull(bdf);
        this.log.info("{}", bdf.toString());
    }

}
