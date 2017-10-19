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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A Unit test class for Postcode objects.
 */
public final class PostcodeTest extends TestResultsReporting {

    private static final String TEST_OUTWARD = "XX00";
    private static final String TEST_INWARD = "9XX";
    private static final String TEST_POSTCODE = "XX00 9XX";

    /**
     * Test method for Postcode default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        final Postcode postcode = new Postcode();
        assertNotNull(UNEXPECTED_NULL, postcode);
        log.info("postcode = {}", postcode);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testPostcodeCreate() {
        final Postcode postcode = Postcode.create();
        assertNotNull(UNEXPECTED_NULL, postcode);
        log.info("postcode = {}", postcode);
    }

    /**
     * Test postcode random.
     */
    @Test
    public void testPostcodeRandom() {
        final Postcode postcode = Postcode.random();
        assertNotNull(UNEXPECTED_NULL, postcode);
        assertTrue(Postcode.verify(postcode.toString()));
        log.info("postcode = {}", postcode);
    }

    /**
     * Test method for Postcode.
     */
    @Test
    public void testPostcodeString() {
        final Postcode postcode = new Postcode(TEST_POSTCODE);
        assertNotNull(UNEXPECTED_NULL, postcode);
        log.info("postcode = {}", postcode);
    }

    /**
     * Test set get postcode.
     */
    @Test
    public void testSetGetPostcode() {
        final Postcode postcode = new Postcode();
        assertEquals(postcode, postcode.setPostCode(TEST_POSTCODE));
        assertEquals(TEST_POSTCODE, postcode.getPostCode());
        log.info("postcode = {}", postcode);
    }

    /**
     * Test postcode parts.
     */
    @Test
    public void testOutwardPart() {
        final Postcode postcode = new Postcode(TEST_POSTCODE);
        assertNotNull(UNEXPECTED_NULL, postcode);
        String outwardCode = postcode.getOutwardCode();
        assertNotNull(UNEXPECTED_NULL, outwardCode);
        assertEquals(TEST_OUTWARD, outwardCode);
        log.info("outwardCode = {}", outwardCode);
    }

    /**
     * Test postcode parts.
     */
    @Test
    public void testInwardPart() {
        final Postcode postcode = new Postcode(TEST_POSTCODE);
        String inwardCode = postcode.getInwardCode();
        assertNotNull(UNEXPECTED_NULL, inwardCode);
        assertEquals(TEST_INWARD, inwardCode);
        log.info("inwardCode = {}", inwardCode);
    }

    /**
     * Test method for Postcode.
     */
    @Test
    public void testVerify() {
        assertTrue(Postcode.verify(TEST_POSTCODE));
    }

    /**
     * Test method for Postcode.
     */
    @Test
    public void testToString() {
        final Postcode postcode = new Postcode(TEST_POSTCODE);
        assertNotNull(UNEXPECTED_NULL, postcode);
        final String string = postcode.toString();
        assertNotNull(UNEXPECTED_NULL, string);
        assertEquals(TEST_POSTCODE, string);
        log.info("postcode = {}", postcode);
    }

}
