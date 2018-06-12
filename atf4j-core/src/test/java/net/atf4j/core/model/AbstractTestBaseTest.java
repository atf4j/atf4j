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

package net.atf4j.core.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mortbay.log.Log;

import net.atf4j.core.TestResult;
import net.atf4j.core.VerificationError;

/**
 * The AbstractTestBaseTest Class.
 */
public class AbstractTestBaseTest {

    /**
     * Passing Test Base class.
     */
    public class PassTestBase extends AbstractTestBase {
        @Override
        public AbstractTestBase execute() throws VerificationError {
            return this;
        }
    }

    /**
     * Failing Test Base class.
     */
    public class FailTestBase extends AbstractTestBase {
        @Override
        public AbstractTestBase execute() throws VerificationError {
            throw new VerificationError();
        }
    }

    /**
     * The MockTestReport class.
     */
    public class MockTestReport implements TestReport {
    }

    /**
     * Test abstract test base.
     */
    @Test
    public void testAbstractTestBase() {
        final PassTestBase testBase = new PassTestBase();
        assertNotNull(testBase);
    }

    /**
     * Test typical usage.
     */
    @Test
    public void testTypicalUsage() {
        final PassTestBase testBase = new PassTestBase();
        assertNotNull(testBase);
        testBase.setName("name");
        testBase.setDescription("description");
        testBase.setTaxonomy("taxonomy");
        testBase.setTester("tester");
        Log.debug(testBase.debugString());
    }

    /**
     * Test execute.
     */
    @Test
    public void testExecute() {
        new PassTestBase().execute();
    }

    /**
     * Test set get test status.
     */
    @Test
    public void testSetGetTestStatus() {
        final PassTestBase testBase = new PassTestBase();
        assertNotNull(testBase);
        assertEquals(TestResult.PENDING, testBase.setTestStatus(TestResult.PENDING).getTestStatus());
    }

    /**
     * Test set get unique identifier.
     */
    @Test
    public void testSetGetUniqueIdentifier() {
        final PassTestBase testBase = new PassTestBase();
        assertNotNull(testBase);
        final TestIdentifier testId = TestIdentifier.create();
        assertEquals(testId, testBase.setUniqueIdentifier(testId).getUniqueIdentifier());
    }

    /**
     * Test set get name.
     */
    @Test
    public void testSetGetName() {
        final PassTestBase testBase = new PassTestBase();
        assertNotNull(testBase);
        assertEquals("testName", testBase.setName("testName").getName());
    }

    /**
     * Test set get taxonomy.
     */
    @Test
    public void testSetGetTaxonomy() {
        final PassTestBase testBase = new PassTestBase();
        assertNotNull(testBase);
        assertEquals("taxonomy", testBase.setTaxonomy("taxonomy").getTaxonomy());
    }

    /**
     * Test set get description.
     */
    @Test
    public void testSetGetDescription() {
        final PassTestBase testBase = new PassTestBase();
        assertNotNull(testBase);
        assertEquals("description", testBase.setDescription("description").getDescription());
    }

    /**
     * Test set get tester.
     */
    @Test
    public void testSetGetTester() {
        final PassTestBase testBase = new PassTestBase();
        assertNotNull(testBase);
        assertEquals("tester", testBase.setTester("tester").getTester());
    }

    /**
     * Test set get timestamp.
     */
    @Test
    public void testSetGetTimestamp() {
        final PassTestBase testBase = new PassTestBase();
        assertNotNull(testBase);
        assertEquals("timestamp", testBase.setTimestamp("timestamp").getTimestamp());
    }

    /**
     * Test set get logging.
     */
    @Test
    public void testSetGetLogging() {
        final PassTestBase testBase = new PassTestBase();
        assertNotNull(testBase);
        final MockTestReport logging = new MockTestReport();
        testBase.setLogging(logging);
    }

}
