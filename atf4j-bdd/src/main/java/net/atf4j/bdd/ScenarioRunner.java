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

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private LoggedScenario targetScenario;

    public ScenarioRunner() {
        super();
    }

    public ScenarioRunner(final LoggedScenario targetScenario) {
        super();
        this.targetScenario = targetScenario;
    }

    public ScenarioRunner execute(final LoggedScenario scenario) {
        this.targetScenario = scenario;
        return this;
    }

    public ScenarioRunner execute() {
        Assume.assumeNotNull(this.targetScenario);
        executeGiven().executeWhen().executeThen();
        return this;
    }

    private ScenarioRunner executeGiven() {
        return executeGiven(this.targetScenario);
    }

    private ScenarioRunner executeGiven(final LoggedScenario scenario) {
        final Class<?> candidateClass = this.targetScenario.getClass();
        if (candidateClass.isAnnotationPresent(Atf4j.Scenario.class)) {
            this.log.info(candidateClass.toGenericString());
            final Method[] declaredMethods = candidateClass.getDeclaredMethods();
            for (final Method method : declaredMethods) {
                if (method.isAnnotationPresent(Atf4j.Given.class)) {
                    this.log.info(method.toGenericString());
                }
            }
        }

        return this;
    }

    private ScenarioRunner executeWhen() {
        return executeWhen(this.targetScenario);
    }

    private ScenarioRunner executeWhen(final LoggedScenario scenario) {
        final Class<?> candidateClass = this.targetScenario.getClass();
        if (candidateClass.isAnnotationPresent(Atf4j.Scenario.class)) {
            this.log.info(candidateClass.toGenericString());
            final Method[] declaredMethods = candidateClass.getDeclaredMethods();
            for (final Method method : declaredMethods) {
                if (method.isAnnotationPresent(Atf4j.Given.class)) {
                    this.log.info(method.toGenericString());
                }
            }
        }

        return this;
    }

    private ScenarioRunner executeThen() {
        return executeThen(this.targetScenario);
    }

    private ScenarioRunner executeThen(final LoggedScenario scenario) {
        final Class<?> candidateClass = this.targetScenario.getClass();
        if (candidateClass.isAnnotationPresent(Atf4j.Scenario.class)) {
            this.log.info(candidateClass.toGenericString());
            final Method[] declaredMethods = candidateClass.getDeclaredMethods();
            for (final Method method : declaredMethods) {
                if (method.isAnnotationPresent(Atf4j.Given.class)) {
                    this.log.info(method.toGenericString());
                }
            }
        }
        return this;
    }
}
