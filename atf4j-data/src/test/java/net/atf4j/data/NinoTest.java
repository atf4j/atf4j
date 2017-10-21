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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A Unit test class for National Insurance number objects.
 */
public final class NinoTest extends TestResultsReporting {

    private static final String BLANK = "";
    private static final String INVALID = "XX-99-99-99X";
    private static final String VALID = "AA-99-99-99A";

    /**
     * Test method for NationalInsurance.
     */
    @Test
    public void testDefaultConstructor() {
        final Nino nino = new Nino();
        assertNotNull(UNEXPECTED_NULL, nino);
    }

    /**
     * test NationalInsurance object.
     */
    @Test
    public void testNationalInsurance() {
        final Nino nino = new Nino();
        assertNotNull(UNEXPECTED_NULL, nino);
    }

    /**
     * Test national insurance pic.
     */
    @Test
    public void testInvalidNino() {
        final Nino nino = new Nino(INVALID);
        this.log.debug("{}", nino);
        assertNotNull(UNEXPECTED_NULL, nino);
        assertEquals(INVALID, nino.toString());
    }

    /**
     * Test valid nino.
     */
    @Test
    public void testValidNino() {
        final Nino nino = new Nino(VALID);
        this.log.debug("{}", nino);
        assertNotNull(UNEXPECTED_NULL, nino);
        assertEquals(VALID, nino.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        final Nino nino = Nino.create();
        assertNotNull(UNEXPECTED_NULL, nino);
    }

    /**
     * test NationalInsurance object.
     */
    @Test
    public void testVerify() {
        assertFalse(Nino.verify(BLANK));
        assertFalse(Nino.verify(INVALID));
        assertTrue(Nino.verify(VALID));
    }

    /**
     * Test set get nino.
     */
    @Test
    public void testSetGetNino() {
        Nino nino = new Nino();
        assertNotNull(UNEXPECTED_NULL, nino);
        assertEquals(VALID, nino.setCode(VALID).getCode());
        assertEquals(INVALID, nino.setCode(INVALID).getCode());
    }

    /**
     * Test method for NationalInsurance.
     */
    @Test
    public void testToString() {
        final String string = new Nino().toString();
        assertNotNull(UNEXPECTED_NULL, string);
    }
}
