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

import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * Behaviour Pass Test class.
 */
@Slf4j
public final class BehaviourPassTest {

    /**
     * Test given.
     */
    @Test
    @Feature.Given("passGiven")
    public void passGiven() {
        log.debug("passGiven");
        final Given given = new Given();
        verifyNotNull(given);
        verifyNotNull(given.execute());
    }

    /**
     * Test when.
     */
    @Test
    @Feature.When("passWhen")
    public void passWhen() {
        log.debug("passWhen");
        final When when = new When();
        verifyNotNull(when);
        verifyNotNull(when.execute());
    }

    /**
     * Test then.
     */
    @Test
    @Feature.Then("passThen")
    public void passThen() {
        log.debug("passThen");
        final Then then = new Then();
        verifyNotNull(then);
        verifyNotNull(then.execute());
    }

}
