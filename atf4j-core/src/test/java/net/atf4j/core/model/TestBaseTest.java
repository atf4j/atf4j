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
import static org.junit.Assert.fail;

import org.junit.Test;

import net.atf4j.core.Atf4jException;

public class TestBaseTest {

    public class MockTestBase extends TestBase {
    }

    public class MockTestReport implements TestReport {
    }

    /**
     * Test method for {@link TestCase}.
     */
    @Test
    public void testDefaultConstructor() {
        assertNotNull(new MockTestBase());
    }

    @Test
    public void testRegisterLogging() throws Atf4jException {
        assertNotNull(new MockTestBase().registerLogging(new MockTestReport()));
    }

    @Test
    public void testExecute() throws Atf4jException {
        final TestContext context = new TestContext();
        assertNotNull(context);
        new MockTestBase().execute(context);
    }

    @Test
    public void testAddPreCondition() {
        final Condition newPreCondition = null;
        assertNotNull(new MockTestBase().addPreCondition(newPreCondition));
    }

    @Test
    public void testAddPostCondition() {
        final Condition newPostCondition = null;
        assertNotNull(new MockTestBase().addPostCondition(newPostCondition));
    }

    @Test
    public void testToString() {
        assertNotNull(new MockTestBase());
        fail("Not yet implemented");
    }

}
