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
     * The Class Scenario.
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
     * The Class FailGivenScenario.
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
     * The Class FailWhenScenario.
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
     * The Class FailThenScenario.
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
        scenarioRunner.execute(new Scenario());
    }

    /**
     * Test fail given scenario.
     */
    @Test
    public void testFailGivenScenario() {
        final ScenarioRunner scenarioRunner = new ScenarioRunner();
        scenarioRunner.execute(new FailGivenScenario());
    }

    /**
     * Test fail when scenario.
     */
    @Test
    public void testFailWhenScenario() {
        final ScenarioRunner scenarioRunner = new ScenarioRunner();
        scenarioRunner.execute(new FailWhenScenario());
    }

    /**
     * Test fail then scenario.
     */
    @Test
    public void testFailThenScenario() {
        final ScenarioRunner scenarioRunner = new ScenarioRunner();
        scenarioRunner.execute(new FailThenScenario());
    }

    /**
     * Test scenario runner.
     */
    @Test
    public void testScenarioRunner() {
        final ScenarioRunner scenarioRunner = new ScenarioRunner(new Scenario());
        scenarioRunner.execute();
    }

}
