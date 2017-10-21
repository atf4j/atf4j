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

package net.atf4j.data.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;
import net.atf4j.data.Postcode;

/**
 * The PostcodeDataFactoryTest Class.
 */
public class PostcodeDataFactoryTest extends TestResultsReporting {

    /**
     * Test postcode get instance.
     */
    @Test
    public void testPostcodeGetInstance() {
        final PostcodeDataFactory instance = PostcodeDataFactory.getInstance();
        assertNotNull(UNEXPECTED_NULL, instance);
        this.log.info("PostcodeDataFactory = {}", instance);
        final PostcodeDataFactory same = PostcodeDataFactory.getInstance();
        assertNotNull(UNEXPECTED_NULL, same);
        assertEquals(same, instance);
    }

    /**
     * Test postcode random.
     */
    @Test
    public void testPostcodeCreate() {
        final Postcode postcode = PostcodeDataFactory.create();
        assertNotNull(UNEXPECTED_NULL, postcode);
        final String string = postcode.toString();
        final boolean verify = Postcode.verify(string);
        assertTrue(verify);
    }

    /**
     * Test postcode random.
     */
    @Test
    public void testPostcodeRandom() {
        final Postcode postcode = PostcodeDataFactory.random();
        assertNotNull(UNEXPECTED_NULL, postcode);
        final String string = postcode.toString();
        this.log.info("string  = {}", string);
        final boolean verify = Postcode.verify(string);
        assertTrue(verify);
        this.log.info("postcode = {}", postcode);
    }

}
