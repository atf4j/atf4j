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

import org.junit.Ignore;
import org.junit.Test;

import net.atf4j.bdd.Atf4j.Scenario;
import net.atf4j.core.TestResultsReporting;

/**
 * Scenario Missing When class.
 */
@Scenario("Scenario")
public final class MissingWhenScenarioTest extends TestResultsReporting {

    /**
     * Test scenario runner.
     */
    @Ignore
    @Test
    public void testScenarioRunner() {
        log.debug("{}.testScenarioRunner", this.getClass().getSimpleName());
        final ScenarioRunner scenarioRunner = new ScenarioRunner(this);
        assertNotNull(UNEXPECTED_NULL, scenarioRunner);
        assertNotNull(UNEXPECTED_NULL, scenarioRunner.execute());
    }

    /**
     * Test pass given.
     */
    @Atf4j.Given("Pass Given")
    public void passGiven() {
        log.debug("{}", super.toString());
    }

    // Deliberately missing.
    // @Atf4j.When("When")
    // public void testPassWhen() {
    // }

    /**
     * Test pass then.
     */
    @Atf4j.Then("Skip Then")
    public void skipThen() {
        log.debug("{}", super.toString());
    }

}
