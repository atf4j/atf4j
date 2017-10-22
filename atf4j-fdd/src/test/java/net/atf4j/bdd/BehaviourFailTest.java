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

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;
import net.atf4j.fdd.Feature;
import net.atf4j.fdd.Given;
import net.atf4j.fdd.Then;
import net.atf4j.fdd.When;

/**
 * Behaviour Fail Test Class.
 */
public final class BehaviourFailTest extends TestResultsReporting {

    /**
     * Test Given.
     */
    @Test
    @Feature.Given("testGiven")
    public void testGiven() {
        log.debug("{}.testGiven", this.getClass().getSimpleName());
        final Given given = new Given();
        assertNotNull(UNEXPECTED_NULL, given);
        given.execute();
    }

    /**
     * Test When.
     */
    @Test
    @Feature.When("testWhen")
    public void testWhen() {
        log.debug("{}.testGiven", this.getClass().getSimpleName());
        final When when = new When();
        assertNotNull(UNEXPECTED_NULL, when);
        when.execute();
    }

    /**
     * Test then.
     */
    @Test
    @Feature.Then("testThen")
    public void testThen() {
        log.debug("{}.testGiven", this.getClass().getSimpleName());
        final Then then = new Then();
        assertNotNull(UNEXPECTED_NULL, then);
        then.execute();
    }

}
