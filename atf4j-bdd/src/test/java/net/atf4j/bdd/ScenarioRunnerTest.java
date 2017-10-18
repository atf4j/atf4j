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

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.TestResultsReporting;

/**
 * Scenario Runner Test class.
 */
public class ScenarioRunnerTest extends TestResultsReporting {

    private static final Logger LOG = LoggerFactory.getLogger(ScenarioRunnerTest.class);

    /**
     * Scenario class.
     */
    public class Scenario extends AbstractScenario {

        /**
         * Test pass given.
         */
        @Atf4j.Given("Pass Given")
        public void passGiven() {
            LOG.info("passGiven");
            Assume.assumeTrue(true);
        }

        /**
         * Test pass when.
         */
        @Atf4j.When("Pass When")
        public void passWhen() {
            LOG.info("passWhen");
            Assert.assertTrue(true);
        }

        /**
         * Test pass then.
         */
        @Atf4j.Then("Pass Then")
        public void passThen() {
            LOG.info("passThen");
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
        @Atf4j.Given("Fail Given")
        public void failGiven() {
            LOG.info("failGiven");
            Assume.assumeTrue(false);
        }

        /**
         * Test pass when.
         */
        @Atf4j.When("Pass When")
        public void passWhen() {
            LOG.info("passWhen");
            Assert.assertTrue(true);
        }

        /**
         * Test pass then.
         */
        @Atf4j.Then("Pass Then")
        public void passThen() {
            LOG.info("testPassThen");
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
        @Atf4j.Given("Pass Given")
        public void passGiven() {
            LOG.info("passGiven");
            Assume.assumeTrue(true);
        }

        /**
         * Test fail when.
         */
        @Atf4j.When("Fail When")
        public void failWhen() {
            LOG.info("failWhen");
            Assert.assertTrue(false);
        }

        /**
         * Test pass then.
         */
        @Atf4j.Then("Skipped Then")
        public void skippedThen() {
            LOG.info("skippedThen");
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
        @Atf4j.Given("Pass Given")
        public void passGiven() {
            LOG.info("passGiven");
            Assume.assumeTrue(true);
        }

        /**
         * Test pass when.
         */
        @Atf4j.When("Pass When")
        public void passWhen() {
            LOG.info("passWhen");
            Assert.assertTrue(true);
        }

        /**
         * Test fail then.
         */
        @Atf4j.Then("Fail Then")
        public void failThen() {
            LOG.info("failThen");
            Assert.assertTrue(false);
        }
    }

    /**
     * Test scenario execution.
     */
    @Test
    public void testScenarioExecution() {
        LOG.info("{}.testScenarioExecution", this.getClass().getSimpleName());
        final ScenarioRunner scenarioRunner = new ScenarioRunner();
        final Scenario scenario = new Scenario();
        assertNotNull(UNEXPECTED_NULL, scenarioRunner);
        scenarioRunner.execute(scenario);
    }

    /**
     * Test fail given scenario.
     */
    @Test
    public void testFailGivenScenario() {
        LOG.info("{}.testFailGivenScenario", this.getClass().getSimpleName());
        final ScenarioRunner scenarioRunner = new ScenarioRunner();
        final FailGivenScenario scenario = new FailGivenScenario();
        assertNotNull(UNEXPECTED_NULL, scenarioRunner);
        scenarioRunner.execute(scenario);
    }

    /**
     * Test fail when scenario.
     */
    @Test
    public void testFailWhenScenario() {
        LOG.info("{}.testFailWhenScenario", this.getClass().getSimpleName());
        final ScenarioRunner scenarioRunner = new ScenarioRunner();
        final FailWhenScenario scenario = new FailWhenScenario();
        assertNotNull(UNEXPECTED_NULL, scenarioRunner);
        scenarioRunner.execute(scenario);
    }

    /**
     * Test fail then scenario.
     */
    @Test
    public void testFailThenScenario() {
        LOG.info("{}.testFailThenScenario", this.getClass().getSimpleName());
        final ScenarioRunner scenarioRunner = new ScenarioRunner();
        final FailThenScenario scenario = new FailThenScenario();
        assertNotNull(UNEXPECTED_NULL, scenarioRunner);
        scenarioRunner.execute(scenario);
    }

    /**
     * Test scenario runner.
     */
    @Test
    public void testScenarioRunner() {
        LOG.info("{}.testScenarioRunner", this.getClass().getSimpleName());
        final Scenario targetScenario = new Scenario();
        final ScenarioRunner scenarioRunner = new ScenarioRunner(targetScenario);
        assertNotNull(UNEXPECTED_NULL, scenarioRunner);
        scenarioRunner.execute();
    }

}
