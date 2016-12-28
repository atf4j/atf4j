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

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeFalse;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for TestContext objects.
 */
public class TestContextTest extends ResultsReporting {

    /**
     * Test method for {@link TestContext}.
     */
    @Test
    public void testDefaultConstructor() {
        new TestContext();
    }

    /**
     * Test method for {@link TestContext}.
     */
    @Test
    public void testIsSeleniumDefault() {
        assumeFalse(TestContext.isLocal());
    }

    /**
     * Test method for {@link TestContext}.
     */
    @Test
    public void testIsJenkinsDefault() {
        assumeFalse(TestContext.isLocal());
    }

    /**
     * Test method for {@link TestContext}.
     */
    @Test
    public void testSetGetPlatform() {
        final String platform = "PLATFORM";
        assertEquals(platform, new TestContext().setPlatform(platform).getPlatform());
    }

    /**
     * Test method for {@link TestContext}.
     */
    @Test
    public void testSetGetContext() {
        final String context = "CONTEXT";
        assertEquals(context, new TestContext().setContext(context).getContext());
    }

}
