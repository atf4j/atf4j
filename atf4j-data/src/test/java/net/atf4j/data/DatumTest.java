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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assume;
import org.junit.Test;

import net.atf4j.core.LoggedTest;

/**
 * DatumTest.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class DatumTest extends LoggedTest {

    class MockDatum extends Datum {
    }

    /**
     * Test method for {@link net.atf4j.data.Datum#setDeleted(boolean)}.
     */
    @Test
    public final void testIsDeleted() {
        final MockDatum mockDatum = new MockDatum();
        Assume.assumeFalse(mockDatum.isDeleted());
        mockDatum.setDeleted(true);
        assertTrue(mockDatum.isDeleted());
    }

    /**
     * Test method for {@link net.atf4j.data.Datum#isDirty()}.
     */
    @Test
    public final void testIsDirty() {
        final MockDatum mockDatum = new MockDatum();
        Assume.assumeFalse(mockDatum.isDirty());
        mockDatum.setDirty(true);
        assertTrue(mockDatum.isDirty());
    }

    /**
     * Test method for {@link net.atf4j.data.Datum#isNew()}.
     */
    @Test
    public final void testIsNew() {
        final MockDatum mockDatum = new MockDatum();
        Assume.assumeTrue(mockDatum.isNew());
        mockDatum.setNew(false);
        assertFalse(mockDatum.isNew());
    }

    /**
     * Test method for {@link net.atf4j.data.Datum#setUsed(boolean)}.
     */
    @Test
    public final void testIsUsed() {
        final MockDatum mockDatum = new MockDatum();
        Assume.assumeFalse(mockDatum.isUsed());
        mockDatum.setUsed(true);
        assertTrue(mockDatum.isUsed());
    }

}
