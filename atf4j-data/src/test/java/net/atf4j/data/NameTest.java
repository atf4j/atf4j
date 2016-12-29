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
package net.atf4j.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for Name objects.
 */
public class NameTest extends ResultsReporting {

    /**
     * Test method for {@link Name}.
     */
    @Test
    public void testDefaultConstructor() {
        new Name();
    }

    /**
     * Test method for {@link Name}.
     */
    @Test
    public void testSetGetName() {
        final String name = "Name";
        assertEquals(name, new Name().setName(name).getName());
    }

    /**
     * Test method for {@link Name}.
     */
    @Test
    public void testCapitalise() {
        assertEquals("Name", new Name().capitalise("nAME"));
    }

    /**
     * Test method for {@link Name}.
     */
    @Test
    public void testDebugString() {
        final String string = new Name().debugString();
        assertNotNull(string);
        this.log.info(string);
    }

    /**
     * Test method for {@link Name}.
     */
    @Test
    public void testToString() {
        final String string = new Name().toString();
        assertNotNull(string);
        this.log.info(string);
    }

}
