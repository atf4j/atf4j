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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

/**
 * Abstract Test Runner for Cucumber.
 */
@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, strict = true, snippets = SnippetType.CAMELCASE, features = "classpath:features", tags = {
        "~@Ignore" })
public abstract class AbstractTestRunner {

    private static final Logger log = LoggerFactory.getLogger(AbstractTestRunner.class);

    /**
     * Before class.
     */
    @BeforeClass
    public static void beforeClass() {
        log.debug("beforeClass");
        final String targetEnvironment = System.getProperty("targetEnvironment");
        assertNotNull("Expected -DtargetEnvironment to be defined", targetEnvironment);
    }

    /**
     * Before feature.
     */
    @cucumber.api.java.Before
    public static void beforeFeature() {
        log.trace("beforeFeature");
    }

    /**
     * Before test.
     */
    @Before
    public void beforeTest() {
        log.trace("beforeFeature");
    }

    /**
     * After test.
     */
    @After
    public void afterTest() {
        log.trace("afterTest");
    }

    /**
     * After feature.
     */
    @cucumber.api.java.After
    public void afterFeature() {
        log.trace("afterFeature");
    }

    /**
     * After class.
     */
    @AfterClass
    public void afterClass() {
        log.trace("afterClass");
    }

}
