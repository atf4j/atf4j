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
 * A Unit test class for Business objects.
 */
public final class BusinessTest extends ResultsReporting {

    /**
     * Test method for Business}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull("unexpected null",new Business());
    }

    /**
     * Test method for Business}.
     */
    @Test
    public void testBusiness() {
        assertNotNull("unexpected null",new Business());
    }

    /**
     * Test method for Business}.
     */
    @Test
    public void testBusinessString() {
        final String businessName = "Business Name";
        final Business business = new Business(businessName);
        assertNotNull("unexpected null",business);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        assertNotNull("unexpected null",Business.create());
    }

    /**
     * Test method for Business}.
     */
    @Test
    public void testDebugString() {
        final String string = new Business().debugString();
        assertNotNull("unexpected null",string);
        this.log.info("{}", string);
    }

    /**
     * Test method for Business}.
     */
    @Test
    public void testToString() {
        final String string = new Business().toString();
        assertNotNull("unexpected null",string);
        this.log.info("{}", string);
    }

}
