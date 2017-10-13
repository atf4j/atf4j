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

package net.atf4j.bdd;

import static org.junit.Assert.assertNotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.ResultsReporting;

/**
 * Behaviour Pass Test Class.
 */
public class BehaviourPassTest extends ResultsReporting {

    private static final Logger LOG = LoggerFactory.getLogger(BehaviourPassTest.class);

    /**
     * Test given.
     */
    @Atf4j.Given("testGiven")
    public void testGiven() {
        LOG.info("{}.testGiven", this.getClass().getSimpleName());
        Given given = new Given();
        assertNotNull(given);
        given.execute();
    }

    /**
     * Test when.
     */
    @Atf4j.When("testWhen")
    public void testWhen() {
        LOG.info("{}.testGiven", this.getClass().getSimpleName());
        When when = new When();
        assertNotNull(when);
        when.execute();
    }

    /**
     * Test then.
     */
    @Atf4j.Then("testThen")
    public void testThen() {
        LOG.info("{}.testGiven", this.getClass().getSimpleName());
        Then then = new Then();
        assertNotNull(then);
        then.execute();
    }

}