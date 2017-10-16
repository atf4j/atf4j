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
 * The TupleTest Class.
 */
public class TupleTest extends ResultsReporting {

    /**
     * Test set get key.
     */
    @Test
    public void testSetGetKey() {
        final Tuple<String, String> tuple = new Tuple<String, String>();
        assertNotNull(tuple);
        final String key = "key";
        tuple.setKey(key);
        assertEquals(key, tuple.key());
        this.log.info("{}", tuple);
    }

    /**
     * Test set get value.
     */
    @Test
    public void testSetGetValue() {
        final Tuple<String, String> tuple = new Tuple<String, String>();
        assertNotNull(tuple);
        final String value = "value";
        tuple.setValue(value);
        assertEquals(value, tuple.value());
        this.log.info("{}", tuple);
    }

}
