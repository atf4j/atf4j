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
package net.atf4j.bdd;

import java.lang.reflect.Method;

import org.junit.Assume;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScenarioRunner {
	protected static final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

	private AbstractLoggedScenario targetScenario;

	public ScenarioRunner() {
		super();
	}

	public ScenarioRunner(final AbstractLoggedScenario targetScenario) {
		super();
		this.targetScenario = targetScenario;
	}

	public ScenarioRunner execute(final AbstractLoggedScenario scenario) {
		targetScenario = scenario;
		return this;
	}

	public ScenarioRunner execute() {
		Assume.assumeNotNull(targetScenario);
		executeGiven().executeWhen().executeThen();
		return this;
	}

	private ScenarioRunner executeGiven() {
		return executeGiven(targetScenario);
	}

	private ScenarioRunner executeGiven(final AbstractLoggedScenario scenario) {
		final Class<?> candidateClass = targetScenario.getClass();
		if (candidateClass.isAnnotationPresent(Atf4j.Scenario.class)) {
			logger.info(candidateClass.toGenericString());
			final Method[] declaredMethods = candidateClass.getDeclaredMethods();
			for (final Method method : declaredMethods) {
				if (method.isAnnotationPresent(Atf4j.Given.class)) {
					logger.info(method.toGenericString());
				}
			}
		}

		return this;
	}

	private ScenarioRunner executeWhen() {
		return executeWhen(targetScenario);
	}

	private ScenarioRunner executeWhen(final AbstractLoggedScenario scenario) {
		final Class<?> candidateClass = targetScenario.getClass();
		if (candidateClass.isAnnotationPresent(Atf4j.Scenario.class)) {
			logger.info(candidateClass.toGenericString());
			final Method[] declaredMethods = candidateClass.getDeclaredMethods();
			for (final Method method : declaredMethods) {
				if (method.isAnnotationPresent(Atf4j.Given.class)) {
					logger.info(method.toGenericString());
				}
			}
		}

		return this;
	}

	private ScenarioRunner executeThen() {
		return executeThen(targetScenario);
	}

	private ScenarioRunner executeThen(final AbstractLoggedScenario scenario) {
		final Class<?> candidateClass = targetScenario.getClass();
		if (candidateClass.isAnnotationPresent(Atf4j.Scenario.class)) {
			logger.info(candidateClass.toGenericString());
			final Method[] declaredMethods = candidateClass.getDeclaredMethods();
			for (final Method method : declaredMethods) {
				if (method.isAnnotationPresent(Atf4j.Given.class)) {
					logger.info(method.toGenericString());
				}
			}
		}
		return this;
	}
}
