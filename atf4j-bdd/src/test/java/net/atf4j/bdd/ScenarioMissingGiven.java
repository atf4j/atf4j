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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.bdd.Atf4j.Scenario;
import net.atf4j.core.ResultsReporting;

/**
 * ScenarioMissingGiven Class.
 */
@Scenario("Scenario")
public class ScenarioMissingGiven extends ResultsReporting {

    private static final Logger LOG = LoggerFactory.getLogger(ScenarioMissingGiven.class);

    /**
     * Test scenario runner.
     */
    @Test
    public void testScenarioRunner() {
        LOG.info("{}.testScenarioRunner", this.getClass().getSimpleName());
        ScenarioRunner scenarioRunner = new ScenarioRunner();
        assertNotNull(scenarioRunner);
        scenarioRunner.execute();
    }

    // Deliberately missing.
    // @Atf4j.Given("Given")
    // public void testPassGiven() {
    // }

    /**
     * Test pass when.
     */
    @Atf4j.When("When")
    public void testPassWhen() {
        this.log.info("{}", super.toString());
    }

    /**
     * Test pass then.
     */
    @Atf4j.Then("Then")
    public void testPassThen() {
        this.log.info("{}", super.toString());
    }

}
