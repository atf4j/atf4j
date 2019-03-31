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

package net.atf4j.core;

import org.junit.AssumptionViolatedException;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;

/**
 * A UnitTest for TestContext objects.
 */
public class TestContextTest extends TestResultsReporting {

    /**
     * Unit test to assume local true.
     */
    @Test
    public void testAssumeLocalTrue() {
        System.setProperty("isLocal", "True");
        assertTrue(TestContext.assumeLocal());
    }

    /**
     * Unit test to assume local false.
     */
    @Test(expected = AssumptionViolatedException.class)
    public void testAssumeLocalFalse() {
        System.setProperty("isLocal", "False");
        TestContext.assumeLocal();
    }

    /**
     * Unit test to assume jenkins.
     */
    @Test
    public void testAssumeJenkins() {
        if (TestContext.isJenkins()) {
            TestContext.assumeJenkins();
            assertTrue(TestContext.assumeJenkins());
        } else {
            TestContext.assumeJenkins();
        }
    }

    /**
     * Unit test to assume local tomcat.
     */
    @Test
    public void testAssumeLocalTomcat() {
        TestContext.assumeLocalTomcat();
    }

    /**
     * Unit Test Context.isLocal().
     */
    @Test
    public void testIsLocal() {
        TestContext.assumeLocal();
        assertTrue(TestContext.isLocal());
        System.setProperty("isLocal", "true");
        assertTrue(TestContext.isLocal());
    }

    /**
     * Test method for TestContext. Unit Test Context.isLocal().
     */
    @Test
    public void testIsSeleniumGrid() {
        TestContext.assumeSeleniumGrid();
        assertTrue(TestContext.isSeleniumGrid());
        System.setProperty("isSeleniumGrid", "true");
        assertTrue(TestContext.isSeleniumGrid());
        assumeNotNull(TestContext.seleniumGridUrl());
    }

    /**
     * Unit test to assume headless.
     */
    @Test
    public void testAssumeHeadless() {
        TestContext.assumeHeadless();
    }

    /**
     * Unit Test Context.isLocal(). Test method for TestContext.
     */
    @Test
    public void testIsJenkins() {
        TestContext.assumeJenkins();
        assertFalse(TestContext.isJenkins());
        System.setProperty("isJenkins", "true");
        assertTrue(TestContext.isJenkins());
        assertNotNull(TestContext.jenkinstUrl());
    }

    /**
     * Test is active MQ.
     */
    @Test
    public void testIsActiveMQ() {
        TestContext.assumeActiveMQ();
        TestContext.isActiveMQ();
        System.setProperty("isActiveMQ", "true");
        assertTrue(TestContext.isActiveMQ());
    }

    /**
     * Testlocal server.
     */
    @Test
    public void testlocalServer() {
        TestContext.assumeLocalServer();
        assertTrue(TestContext.localServer());
        System.setProperty("isLocal", "true");
        assertTrue(TestContext.isLocal());
    }

    /**
     * Unit test to check if Apache Tomcat is available locally. If Tomcat is
     * available, the URL must be provided.
     */
    @Test
    public void testIsTomcat() {
        assumeTrue(TestContext.isTomcat());
        assertNotNull(TestContext.tomcatUrl());
    }

    /**
     * Unit test for System property override of the webDriver waits.
     */
    @Test
    public void testWebDriverWaits() {
        assumeTrue(TestContext.pageWait() > 0);
        assumeTrue(TestContext.implicitWait() > 0);
        assumeTrue(TestContext.explicitWait() > 0);
        assumeTrue(TestContext.retryInterval() > 0 && TestContext.retryInterval() < TestContext.explicitWait());
    }

    /**
     * Unit test to target platform.
     */
    @Test
    public void testTargetPlatform() {
        assumeNotNull(TestContext.targetPlatform());
    }

    /**
     * Unit test to target environment.
     */
    @Test
    public void testTargetEnvironment() {
        assumeNotNull(TestContext.targetEnvironment());
    }

}
