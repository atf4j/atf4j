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
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.aft4j.bdd;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import net.atf4j.bdd.AbstractLoggedScenario;
import net.atf4j.bdd.Atf4j;
import net.atf4j.bdd.ScenarioRunner;

public class ScenarioRunnerTest {

	public class Scenario extends AbstractLoggedScenario {
		@Atf4j.Given("Given")
		public void testPassGiven() {
			Assume.assumeTrue(true);
		}

		@Atf4j.When("When")
		public void testPassWhen() {
			Assert.assertTrue(true);
		}

		@Atf4j.Then("Then")
		public void testPassThen() {
			Assert.assertTrue(true);
		}
	}

	public class FailGivenScenario extends AbstractLoggedScenario {
		@Atf4j.Given("Given")
		public void testPassGiven() {
			Assume.assumeTrue(false);
		}

		@Atf4j.When("When")
		public void testPassWhen() {
			Assert.assertTrue(true);
		}

		@Atf4j.Then("Then")
		public void testPassThen() {
			Assert.assertTrue(true);
		}
	}

	public class FailWhenScenario extends AbstractLoggedScenario {
		@Atf4j.Given("Given")
		public void testPassGiven() {
			Assume.assumeTrue(true);
		}

		@Atf4j.When("When")
		public void testPassWhen() {
			Assert.assertTrue(false);
		}

		@Atf4j.Then("Then")
		public void testPassThen() {
			Assert.assertTrue(true);
		}
	}

	public class FailThenScenario extends AbstractLoggedScenario {
		@Atf4j.Given("Given")
		public void testPassGiven() {
			Assume.assumeTrue(true);
		}

		@Atf4j.When("When")
		public void testPassWhen() {
			Assert.assertTrue(true);
		}

		@Atf4j.Then("Then")
		public void testPassThen() {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void testScenarioExecution() {
		final ScenarioRunner scenarioRunner = new ScenarioRunner();
		scenarioRunner.execute(new Scenario());
	}

	@Test
	public void testFailGivenScenario() {
		final ScenarioRunner scenarioRunner = new ScenarioRunner();
		scenarioRunner.execute(new FailGivenScenario());
	}

	@Test
	public void testFailWhenScenario() {
		final ScenarioRunner scenarioRunner = new ScenarioRunner();
		scenarioRunner.execute(new FailWhenScenario());
	}

	@Test
	public void testFailThenScenario() {
		final ScenarioRunner scenarioRunner = new ScenarioRunner();
		scenarioRunner.execute(new FailThenScenario());
	}

	@Test
	public void testScenarioRunner() {
		final ScenarioRunner scenarioRunner = new ScenarioRunner(new Scenario());
		scenarioRunner.execute();
	}

}
