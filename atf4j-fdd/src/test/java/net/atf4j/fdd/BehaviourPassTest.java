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

package net.atf4j.fdd;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * Behaviour Pass Test Class.
 */
public final class BehaviourPassTest extends TestResultsReporting {

    /**
     * Test given.
     */
    @Test
    @Feature.Given("passGiven")
    public void passGiven() {
        this.log.debug("passGiven");
        final Given given = new Given();
        assertNotNull(UNEXPECTED_NULL, given);
        assertNotNull(UNEXPECTED_NULL, given.execute());
    }

    /**
     * Test when.
     */
    @Test
    @Feature.When("passWhen")
    public void passWhen() {
        this.log.debug("passWhen");
        final When when = new When();
        assertNotNull(UNEXPECTED_NULL, when);
        assertNotNull(UNEXPECTED_NULL, when.execute());
    }

    /**
     * Test then.
     */
    @Test
    @Feature.Then("passThen")
    public void passThen() {
        this.log.debug("passThen");
        final Then then = new Then();
        assertNotNull(UNEXPECTED_NULL, then);
        assertNotNull(UNEXPECTED_NULL, then.execute());
    }

}
