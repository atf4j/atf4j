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

/**
 * The ScenarioRunner Class.
 */
public class ScenarioRunner {

    /** The log. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The target scenario. */
    private LoggedScenario targetScenario;

    /**
     * Instantiates a new scenario runner.
     */
    public ScenarioRunner() {
        super();
    }

    /**
     * Instantiates a new scenario runner.
     *
     * @param targetScenario the target scenario
     */
    public ScenarioRunner(final LoggedScenario targetScenario) {
        super();
        this.targetScenario = targetScenario;
    }

    /**
     * Execute.
     *
     * @param scenario the scenario
     * @return the scenario runner
     */
    public ScenarioRunner execute(final LoggedScenario scenario) {
        this.targetScenario = scenario;
        return this;
    }

    /**
     * Execute.
     *
     * @return the scenario runner
     */
    public ScenarioRunner execute() {
        Assume.assumeNotNull(this.targetScenario);
        executeGiven().executeWhen().executeThen();
        return this;
    }

    /**
     * Execute given.
     *
     * @return the scenario runner
     */
    private ScenarioRunner executeGiven() {
        return executeGiven(this.targetScenario);
    }

    /**
     * Execute given.
     *
     * @param scenario the scenario
     * @return the scenario runner
     */
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

    /**
     * Execute when.
     *
     * @return the scenario runner
     */
    private ScenarioRunner executeWhen() {
        return executeWhen(this.targetScenario);
    }

    /**
     * Execute when.
     *
     * @param scenario the scenario
     * @return the scenario runner
     */
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

    /**
     * Execute then.
     *
     * @return the scenario runner
     */
    private ScenarioRunner executeThen() {
        return executeThen(this.targetScenario);
    }

    /**
     * Execute then.
     *
     * @param scenario the scenario
     * @return the scenario runner
     */
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
