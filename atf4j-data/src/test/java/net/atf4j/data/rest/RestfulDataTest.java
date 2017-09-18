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
package net.atf4j.data.rest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.data.management.RestfulData;

/**
 * A UnitTest for RestfulData objects.
 */
public class RestfulDataTest {

    /**
     * Test method for void.
     */
    @Test
    public void testRestfulData() {
        final RestfulData restfulData = new RestfulData();
        assertNotNull(restfulData);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testSetUp() {
        final RestfulData restfulData = new RestfulData();
        assertNotNull(restfulData);
        final boolean data = restfulData.setUp();
        assertNotNull(data);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testReset() {
        final RestfulData restfulData = new RestfulData();
        assertNotNull(restfulData);
        final boolean data = restfulData.reset();
        assertNotNull(data);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testTearDown() {
        final RestfulData restfulData = new RestfulData();
        assertNotNull(restfulData);
        final boolean data = restfulData.tearDown();
        assertNotNull(data);
    }

}
