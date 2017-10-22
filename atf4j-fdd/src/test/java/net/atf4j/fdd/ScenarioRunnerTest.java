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

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;

import net.atf4j.core.TestResultsReporting;
import net.atf4j.fdd.AbstractScenario;
import net.atf4j.fdd.Feature;
import net.atf4j.fdd.ScenarioRunner;

/**
 * Scenario Runner Test class.
 */
@Ignore
public final class ScenarioRunnerTest extends TestResultsReporting {

    /**
     * Scenario class.
     */
    public class Scenario extends AbstractScenario {

        /**
         * Test pass given.
         */
        @Feature.Given("Pass Given")
        public void passGiven() {
            log.debug("passGiven");
            Assume.assumeTrue(true);
        }

        /**
         * Test pass when.
         */
        @Feature.When("Pass When")
        public void passWhen() {
            log.debug("passWhen");
            Assert.assertTrue(true);
        }

        /**
         * Test pass then.
         */
        @Feature.Then("Pass Then")
        public void passThen() {
            log.debug("passThen");
            Assert.assertTrue(true);
        }
    }

    /**
     * Fail Given Scenario class.
     */
    public class FailGivenScenario extends AbstractScenario {

        /**
         * Test fail given.
         */
        @Feature.Given("Fail Given")
        public void failGiven() {
            log.debug("failGiven");
            Assume.assumeTrue(false);
        }

        /**
         * Test pass when.
         */
        @Feature.When("Pass When")
        public void passWhen() {
            log.debug("passWhen");
            Assert.assertTrue(true);
        }

        /**
         * Test pass then.
         */
        @Feature.Then("Pass Then")
        public void passThen() {
            log.debug("testPassThen");
            Assert.assertTrue(true);
        }
    }

    /**
     * FailWhenScenario Class.
     */
    public class FailWhenScenario extends AbstractScenario {

        /**
         * Test pass given.
         */
        @Feature.Given("Pass Given")
        public void passGiven() {
            log.debug("passGiven");
            Assume.assumeTrue(true);
        }

        /**
         * Test fail when.
         */
        @Feature.When("Fail When")
        public void failWhen() {
            log.debug("failWhen");
            Assert.assertTrue(false);
        }

        /**
         * Test pass then.
         */
        @Feature.Then("Skipped Then")
        public void skippedThen() {
            log.debug("skippedThen");
            Assert.assertTrue(true);
        }
    }

    /**
     * Fail Then Scenario Class.
     */
    public class FailThenScenario extends AbstractScenario {

        /**
         * Test pass given.
         */
        @Feature.Given("Pass Given")
        public void passGiven() {
            log.debug("passGiven");
            Assume.assumeTrue(true);
        }

        /**
         * Test pass when.
         */
        @Feature.When("Pass When")
        public void passWhen() {
            log.debug("passWhen");
            Assert.assertTrue(true);
        }

        /**
         * Test fail then.
         */
        @Feature.Then("Fail Then")
        public void failThen() {
            log.debug("failThen");
            Assert.assertTrue(false);
        }
    }

    /**
     * Test scenario execution.
     */
    @Test
    public void testScenarioExecution() {
        log.debug("testScenarioExecution", this.getClass().getSimpleName());
        final ScenarioRunner scenarioRunner = new ScenarioRunner(this);
        final Scenario scenario = new Scenario();
        assertNotNull(UNEXPECTED_NULL, scenarioRunner);
        scenarioRunner.execute(scenario);
    }

    /**
     * Test fail given scenario.
     */
    @Test
    public void testFailGivenScenario() {
        log.debug("testFailGivenScenario", this.getClass().getSimpleName());
        final ScenarioRunner scenarioRunner = new ScenarioRunner(this);
        final FailGivenScenario scenario = new FailGivenScenario();
        assertNotNull(UNEXPECTED_NULL, scenarioRunner);
        scenarioRunner.execute(scenario);
    }

    /**
     * Test fail when scenario.
     */
    @Test
    public void testFailWhenScenario() {
        log.debug("testFailWhenScenario", this.getClass().getSimpleName());
        final ScenarioRunner scenarioRunner = new ScenarioRunner(this);
        final FailWhenScenario scenario = new FailWhenScenario();
        assertNotNull(UNEXPECTED_NULL, scenarioRunner);
        scenarioRunner.execute(scenario);
    }

    /**
     * Test fail then scenario.
     */
    @Test
    public void testFailThenScenario() {
        log.debug("testFailThenScenario", this.getClass().getSimpleName());
        final ScenarioRunner scenarioRunner = new ScenarioRunner(this);
        final FailThenScenario scenario = new FailThenScenario();
        assertNotNull(UNEXPECTED_NULL, scenarioRunner);
        scenarioRunner.execute(scenario);
    }

    /**
     * Test scenario runner.
     */
    @Test
    public void testScenarioRunner() {
        log.debug("testScenarioRunner", this.getClass().getSimpleName());
        final Scenario targetScenario = new Scenario();
        final ScenarioRunner scenarioRunner = new ScenarioRunner(targetScenario);
        assertNotNull(UNEXPECTED_NULL, scenarioRunner);
        scenarioRunner.execute();
    }

}
