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
package net.atf4j.core.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.Atf4jException;
import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for TestBase objects.
 */
public class TestBaseTest extends ResultsReporting {

    /**
     * The MockTestBase Class.
     */
    public class MockTestBase extends TestBase {

        /* (non-Javadoc)
         * @see net.atf4j.core.model.TestBase#execute(net.atf4j.core.model.TestContext)
         */
        @Override
        public TestBase execute(final TestContext context) throws Atf4jException {
            return this;
        }
    }

    /**
     * The IncompleteTestBase Class.
     */
    public class IncompleteTestBase extends TestBase {
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
     * Test method for {@link TestCase}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new MockTestBase());
    }

    /**
     * Test method for {@link TestBase}.
     *
     * @throws Atf4jException
     *             the atf 4 j exception
     */
    @Test
    public void testRegisterLogging() throws Atf4jException {
        assertNotNull(new MockTestBase().registerLogging(new MockTestReport()));
    }

    /**
     * Test method for {@link TestBase}.
     */
    @Test
    public void testUniqueIdentifier() {
        final MockTestBase mockTestBase = new MockTestBase();
        assertNotNull(mockTestBase.getUniqueIdentifier());
    }

    /**
     * Test method for {@link TestBase}.
     */
    @Test
    public void testTestStatus() {
        assertNotNull(new MockTestBase().getTestStatus());
    }

    /**
     * Test method for {@link TestBase}.
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
     * Test method for {@link TestBase}.
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
     * Test method for {@link TestBase}.
     */
    @Test
    public void testAddPreCondition() {
        final Condition newPreCondition = new PassingCondition();
        assertNotNull(newPreCondition);
        final MockTestBase mockTestBase = new MockTestBase();
        assertNotNull(mockTestBase);
        assertNotNull(mockTestBase.addPreCondition(newPreCondition));
    }

    /**
     * Test method for {@link TestBase}.
     */
    @Test
    public void testAddPostCondition() {
        final Condition newPostCondition = new PassingCondition();
        assertNotNull(newPostCondition);
        final MockTestBase mockTestBase = new MockTestBase();
        assertNotNull(mockTestBase);
        assertNotNull(mockTestBase.addPostCondition(newPostCondition));
    }

    /**
     * Test method for {@link TestBase}.
     */
    @Test
    public void testToString() {
        assertNotNull(new MockTestBase().toString());
    }

    /**
     * Test method for {@link TestBase}.
     */
    @Test
    public void testDebugString() {
        assertNotNull(new MockTestBase().debugString());
    }

}
