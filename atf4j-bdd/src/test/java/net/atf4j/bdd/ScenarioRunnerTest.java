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

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * Scenario Runner Test class.
 */
public class ScenarioRunnerTest extends ResultsReporting {

    /**
     * Scenario class.
     */
    public class Scenario extends AbstractScenario {

        /**
         * Test pass given.
         */
        @Atf4j.Given("Given")
        public void testPassGiven() {
            Assume.assumeTrue(true);
        }

        /**
         * Test pass when.
         */
        @Atf4j.When("When")
        public void testPassWhen() {
            Assert.assertTrue(true);
        }

        /**
         * Test pass then.
         */
        @Atf4j.Then("Then")
        public void testPassThen() {
            Assert.assertTrue(true);
        }
    }

    /**
     * Fail Given Scenario class.
     */
    public class FailGivenScenario extends AbstractScenario {

        /**
         * Test pass given.
         */
        @Atf4j.Given("Given")
        public void testPassGiven() {
            Assume.assumeTrue(false);
        }

        /**
         * Test pass when.
         */
        @Atf4j.When("When")
        public void testPassWhen() {
            Assert.assertTrue(true);
        }

        /**
         * Test pass then.
         */
        @Atf4j.Then("Then")
        public void testPassThen() {
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
        @Atf4j.Given("Given")
        public void testPassGiven() {
            Assume.assumeTrue(true);
        }

        /**
         * Test pass when.
         */
        @Atf4j.When("When")
        public void testPassWhen() {
            Assert.assertTrue(false);
        }

        /**
         * Test pass then.
         */
        @Atf4j.Then("Then")
        public void testPassThen() {
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
        @Atf4j.Given("Given")
        public void testPassGiven() {
            Assume.assumeTrue(true);
        }

        /**
         * Test pass when.
         */
        @Atf4j.When("When")
        public void testPassWhen() {
            Assert.assertTrue(true);
        }

        /**
         * Test pass then.
         */
        @Atf4j.Then("Then")
        public void testPassThen() {
            Assert.assertTrue(false);
        }
    }

    /**
     * Test scenario execution.
     */
    @Test
    public void testScenarioExecution() {
        final ScenarioRunner scenarioRunner = new ScenarioRunner();
        Scenario scenario = new Scenario();
        scenarioRunner.execute(scenario);
    }

    /**
     * Test fail given scenario.
     */
    @Test
    public void testFailGivenScenario() {
        final ScenarioRunner scenarioRunner = new ScenarioRunner();
        FailGivenScenario scenario = new FailGivenScenario();
        scenarioRunner.execute(scenario);
    }

    /**
     * Test fail when scenario.
     */
    @Test
    public void testFailWhenScenario() {
        final ScenarioRunner scenarioRunner = new ScenarioRunner();
        FailWhenScenario scenario = new FailWhenScenario();
        scenarioRunner.execute(scenario);
    }

    /**
     * Test fail then scenario.
     */
    @Test
    public void testFailThenScenario() {
        final ScenarioRunner scenarioRunner = new ScenarioRunner();
        FailThenScenario scenario = new FailThenScenario();
        scenarioRunner.execute(scenario);
    }

    /**
     * Test scenario runner.
     */
    @Test
    public void testScenarioRunner() {
        Scenario targetScenario = new Scenario();
        final ScenarioRunner scenarioRunner = new ScenarioRunner(targetScenario);
        scenarioRunner.execute();
    }

}
