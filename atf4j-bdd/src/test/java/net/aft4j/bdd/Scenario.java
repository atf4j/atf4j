package net.aft4j.bdd;

import org.junit.Test;

import net.atf4j.bdd.AbstractLoggedScenario;
import net.atf4j.bdd.ScenarioRunner;

public class Scenario extends AbstractLoggedScenario {
    @Test
    public void testScenarioRunner() {
        new ScenarioRunner(this).execute();
    }

}
