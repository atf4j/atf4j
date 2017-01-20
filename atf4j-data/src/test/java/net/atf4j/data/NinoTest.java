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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for NationalInsurance objects.
 */
public class NinoTest extends ResultsReporting {

    private static final String BLANK_NI = "";
    private static final String PIC = "XX-99-99-99X";

    /**
     * Test method for NationalInsurance}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new Nino());
    }

    /**
     * test NationalInsurance object.
     */
    @Test
    public void testNationalInsurance() {
        assertNotNull(new Nino());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        assertNotNull(Nino.create());
    }

    /**
     * test NationalInsurance object.
     */
    @Test
    public void testVerify() {
        assertFalse(Nino.verify(BLANK_NI));
        assertFalse(Nino.verify(BLANK_NI));
        assertFalse(Nino.verify(BLANK_NI));
    }

    /**
     * Test method for NationalInsurance}.
     */
    @Test
    public void testDebugString() {
        final String string = new Nino().debugString();
        assertNotNull(string);
    }

    /**
     * Test method for NationalInsurance}.
     */
    @Test
    public void testToString() {
        final String string = new Nino().toString();
        assertNotNull(string);
    }

}
