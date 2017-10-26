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

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A Unit test class for Field objects.
 */
public final class FieldTest extends TestResultsReporting {

    /**
     * Test method for void.
     */
    @Test
    public void testDefaultConstructor() {
        final Field<Object> field = new Field<Object>();
        verifyNotNull(field);
        assertEquals(FieldStatus.PRISTINE, field.getStatus());
    }

    /**
     * Test field string.
     */
    @Test
    public void testFieldString() {
        final Field<String> field = new Field<String>("");
        verifyNotNull(field);
        assertEquals(FieldStatus.PRISTINE, field.getStatus());
    }

    /**
     * Test method for Setting & Getting key.
     */
    @Test
    public void testFieldSetGetKey() {
        final Field<Object> field = new Field<Object>();
        verifyNotNull(field);
        assertEquals(FieldStatus.PRISTINE, field.getStatus());
        final String key = "key";
        assertEquals(key, field.setKey(key).getKey());
        assertEquals(FieldStatus.CHANGED, field.getStatus());
    }

    /**
     * Test method for Setting & Getting Value.
     */
    @Test
    public void testFieldSetGetValue() {
        final Field<Object> field = new Field<Object>();
        verifyNotNull(field);
        assertEquals(FieldStatus.PRISTINE, field.getStatus());
        final String value = "Value";
        assertEquals(value, field.setValue(value).getValue());
        assertEquals(FieldStatus.CHANGED, field.getStatus());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testFieldSetGetStatus() {
        final Field<Object> field = new Field<Object>();
        verifyNotNull(field);
        final FieldStatus status = FieldStatus.initialise();
        assertEquals(status, field.setStatus(status).getStatus());
    }

}
