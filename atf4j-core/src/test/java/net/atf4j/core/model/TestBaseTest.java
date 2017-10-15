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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.Atf4jException;
import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for TestBase objects.
 */
public class TestBaseTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * The MockTestBase Class.
     */
    public class MockTestBase extends AbstractTestBase {

        /*
         * (non-Javadoc)
         *
         * @see net.atf4j.core.model.TestBase#execute(net.atf4j.core.model.
         * TestContext)
         */
        @Override
        public AbstractTestBase execute(final TestContext context) throws Atf4jException {
            return this;
        }
    }

    /**
     * The IncompleteTestBase Class.
     */
    public class IncompleteTestBase extends AbstractTestBase {
    }

    /**
     * The MockTestReport Class.
     */
    public class MockTestReport implements TestReport {
    }

    /**
     * The PassingCondition Class.
     */
    public class PassingCondition extends Condition {
    }

    /**
     * Test method for TestCase.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(UNEXPECTED_NULL, new MockTestBase());
    }

    /**
     * Test method for TestBase.
     *
     * @throws Atf4jException
     *             the atf 4 j exception
     */
    @Test
    public void testRegisterLogging() throws Atf4jException {
        assertNotNull(UNEXPECTED_NULL, new MockTestBase().registerLogging(new MockTestReport()));
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testUniqueIdentifier() {
        final MockTestBase mockTestBase = new MockTestBase();
        assertNotNull(UNEXPECTED_NULL, mockTestBase.getUniqueIdentifier());
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testTestStatus() {
        assertNotNull(UNEXPECTED_NULL, new MockTestBase().getTestStatus());
    }

    /**
     * Test method for TestBase.
     *
     * @throws Atf4jException
     *             the atf 4 j exception
     */
    @Test
    public void testExecute() throws Atf4jException {
        final TestContext context = new TestContext();
        final MockTestBase mockTestBase = new MockTestBase();
        mockTestBase.assumedPreConditions();
        mockTestBase.execute(context);
        mockTestBase.assertPostConditions();
        this.log.info(mockTestBase.debugString());
    }

    /**
     * Test method for TestBase.
     *
     * @throws Atf4jException
     *             the atf 4 j exception
     */
    @Test(expected = Atf4jException.class)
    public void testMissingExecute() throws Atf4jException {
        final TestContext context = new TestContext();
        final IncompleteTestBase incompleteTestBase = new IncompleteTestBase();
        incompleteTestBase.execute(context);
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testAddPreCondition() {
        final Condition newPreCondition = new PassingCondition();
        assertNotNull(UNEXPECTED_NULL, newPreCondition);
        final MockTestBase mockTestBase = new MockTestBase();
        assertNotNull(UNEXPECTED_NULL, mockTestBase);
        assertNotNull(UNEXPECTED_NULL, mockTestBase.addPreCondition(newPreCondition));
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testAddPostCondition() {
        final Condition newPostCondition = new PassingCondition();
        assertNotNull(UNEXPECTED_NULL, newPostCondition);
        final MockTestBase mockTestBase = new MockTestBase();
        assertNotNull(UNEXPECTED_NULL, mockTestBase);
        assertNotNull(UNEXPECTED_NULL, mockTestBase.addPostCondition(newPostCondition));
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testToString() {
        assertNotNull(UNEXPECTED_NULL, new MockTestBase().toString());
    }

    /**
     * Test method for TestBase.
     */
    @Test
    public void testDebugString() {
        assertNotNull(UNEXPECTED_NULL, new MockTestBase().debugString());
    }

}
