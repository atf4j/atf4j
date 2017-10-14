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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A Unit test class for Field objects.
 */
public final class FieldTest extends ResultsReporting {

    /**
     * Test method for void.
     */
    @Test
    public void testDefaultConstructor() {
        final Field field = new Field();
        assertNotNull("unexpected null",field);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testFieldString() {
        final Field field = new Field("");
        assertNotNull("unexpected null",field);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testFieldSetGetKey() {
        final String key = "key";
        assertEquals(key, new Field().setKey(key).getKey());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testFieldSetGetValue() {
        final String value = "Value";
        assertEquals(value, new Field().setValue(value).getValue());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testFieldSetGetStatus() {
        final FieldStatus status = FieldStatus.initialise();
        assertEquals(status, new Field().setStatus(status).getStatus());
    }

}
