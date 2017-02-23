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
package net.atf4j.core;

import org.junit.Test;

/**
 * A UnitTest for Verify objects.
 */
public class VerifyTest extends ResultsReporting {

    /**
     * Unit Test for test verify equals byte byte.
     */
    @Test
    public void testVerifyEqualsByteByte() {
        final byte aByte = 0;
        Verify.verifyEquals(aByte, aByte);
    }

    /**
     * Unit Test for test verify equals char char.
     */
    @Test
    public void testVerifyEqualsCharChar() {
        final char aChar = 0;
        Verify.verifyEquals(aChar, aChar);
    }

    /**
     * Unit Test for test verify equals int int.
     */
    @Test
    public void testVerifyEqualsIntInt() {
        Verify.verifyEquals(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Verify.verifyEquals(0, 0);
        Verify.verifyEquals(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    /**
     * Unit Test for test verify equals long long.
     */
    @Test
    public void testVerifyEqualsLongLong() {
        Verify.verifyEquals(1L, 1L);
    }

    /**
     * Unit Test for test verify equals object object.
     */
    @Test
    public void testVerifyEqualsObjectObject() {
        final Object object = new Object();
        Verify.verifyEquals(object, object);
    }

    /**
     * Unit Test for test equals.
     */
    @Test
    public void testEquals() {
        Verify.verifyEquals("", "");
    }

}
