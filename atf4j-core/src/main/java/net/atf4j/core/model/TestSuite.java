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
import static org.junit.Assert.assertTrue;

import java.util.ArrayDeque;
import java.util.Collection;

import net.atf4j.core.timers.MappedTimers;

/**
 * TestSuite.
 */
public class TestSuite extends AbstractTestBase {

    /** The test cases. */
    protected Collection<TestCase> testCases = new ArrayDeque<TestCase>();;

    /**
     * Instantiates a new test suite.
     */
    public TestSuite() {
        super();
    }

    public TestSuite(final TestReport testReport) {
        super(testReport);
    }

    /**
     * Execute.
     *
     * @return the test suite
     */
    @Override
    public TestSuite execute() {

        start();

        assertNotNull(this.testCases);
        if (this.testCases.size() > 0) {
            for (final TestCase testCase : this.testCases) {
                assertEquals(testCase, testCase.execute());
            }
        }

        end();

        return this;
    }

    /**
     * numberOfTestCases.
     *
     * @return size of testStep collection as int.
     * @see java.util.Collection#size()
     */
    public int numberOfTestCases() {
        return this.testCases == null ? 0 : this.testCases.size();
    }

    /**
     * Adds the test case.
     *
     * @param newTestCase as TestCase
     * @return success as boolean.
     * @see java.util.Collection#add(java.lang.Object)
     */
    public TestSuite addTestCase(final TestCase newTestCase) {
        assertNotNull(newTestCase);
        if (this.testCases == null) {
            this.testCases = new ArrayDeque<TestCase>();
        }
        assertTrue(this.testCases.add(newTestCase));
        return this;
    }

    /**
     * Start test suite.
     *
     * @return the test suite
     */
    public TestSuite start() {
        this.log.info("start test suite {}", this.getName());
        this.log.info("start timer {}", MappedTimers.start("TestSuite"));
        return this;
    }

    /**
     * End test suite.
     *
     * @return the test suite
     */
    public TestSuite end() {
        this.log.info("end timer {}", MappedTimers.stop("TestSuite"));
        this.log.info("end test suite {}", this.getName());
        return this;
    }

}
