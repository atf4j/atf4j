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
import static org.junit.Assert.fail;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;
import net.atf4j.data.Postcode.InvalidPostcodeException;

/**
 * A Unit test class for Postcode objects.
 */
public final class PostcodeTest extends TestResultsReporting {

    private static final String TEST_OUTWARD = "XX00";
    private static final String TEST_INWARD = "9XX";
    private static final String TEST_POSTCODE = "XX00 9XX";
    private static final String INVALID_POSTCODE = "00ZZ Z00";

    /**
     * Test method for Postcode default constructor.
     */
    @Test
    public void testDefaultConstructor() {
        final Postcode postcode = new Postcode();
        log.debug("new Postcode() = {}", postcode);
        assertNotNull(UNEXPECTED_NULL, postcode);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testPostcodeCreate() {
        final Postcode postcode = Postcode.create();
        log.debug("Postcode.create() = {}", postcode);
        assertNotNull(UNEXPECTED_NULL, postcode);
    }

    /**
     * Test method for Postcode.
     *
     * @throws InvalidPostcodeException the invalid postcode exception
     */
    @Test
    public void testPostcodeString() throws InvalidPostcodeException {
        final Postcode invalidPostcode = new Postcode(INVALID_POSTCODE);
        log.debug("new Postcode({}) = {}", INVALID_POSTCODE, invalidPostcode);
        assertNotNull(UNEXPECTED_NULL, invalidPostcode);
    }

    /**
     * Test set invalid postcode.
     *
     * @throws InvalidPostcodeException the invalid postcode exception
     */
    @Test(expected = InvalidPostcodeException.class)
    public void testSetInvalidPostcode() throws InvalidPostcodeException {
        final Postcode postcode = new Postcode();
        log.debug("new Postcode() = {}", postcode);
        assertNotNull(UNEXPECTED_NULL, postcode);
        postcode.setPostCode(INVALID_POSTCODE);
        fail(EXPECTED_EXCEPTION);
    }

    /**
     * Test set get postcode.
     *
     * @throws InvalidPostcodeException the invalid postcode exception
     */
    @Test
    public void testSetGetPostcode() throws InvalidPostcodeException {
        final Postcode postcode = new Postcode();
        log.debug("postcode = {}", postcode);
        assertEquals(postcode, postcode.setPostCode(TEST_POSTCODE));
        assertEquals(TEST_POSTCODE, postcode.getPostCode());
    }

    /**
     * Test postcode parts.
     *
     * @throws InvalidPostcodeException the invalid postcode exception
     */
    @Test
    public void testOutwardPart() throws InvalidPostcodeException {
        final Postcode postcode = new Postcode(TEST_POSTCODE);
        log.debug("postcode = {}", postcode);
        assertNotNull(UNEXPECTED_NULL, postcode);
        final String outwardCode = postcode.getOutwardCode();
        assertNotNull(UNEXPECTED_NULL, outwardCode);
        assertEquals(TEST_OUTWARD, outwardCode);
        log.debug("outwardCode = {}", outwardCode);
    }

    /**
     * Test postcode parts.
     *
     * @throws InvalidPostcodeException the invalid postcode exception
     */
    @Test
    public void testInwardPart() throws InvalidPostcodeException {
        final Postcode postcode = new Postcode(TEST_POSTCODE);
        log.debug("postcode = {}", postcode);
        final String inwardCode = postcode.getInwardCode();
        assertNotNull(UNEXPECTED_NULL, inwardCode);
        assertEquals(TEST_INWARD, inwardCode);
        log.debug("inwardCode = {}", inwardCode);
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
     *
     * @throws InvalidPostcodeException the invalid postcode exception
     */
    @Test
    public void testToString() throws InvalidPostcodeException {
        final Postcode postcode = new Postcode(TEST_POSTCODE);
        log.debug("postcode = {}", postcode);
        assertNotNull(UNEXPECTED_NULL, postcode);
        final String string = postcode.toString();
        assertNotNull(UNEXPECTED_NULL, string);
        assertEquals(TEST_POSTCODE, string);
        log.debug("postcode = {}", postcode);
    }

}
