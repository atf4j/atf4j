/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with atf4j. If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.data;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.atf4j.data.management.JdbcData;
import net.atf4j.data.management.JmsData;
import net.atf4j.data.management.RestfulData;
import net.atf4j.data.management.SetUpData;

/**
 * A UnitTest for SetUpData objects.
 */
public class SetUpDataTest {

    protected SetUpData jdbcData = new JdbcData();
    protected SetUpData jmsData = new JmsData();
    protected SetUpData restfulData = new RestfulData();

    /**
     * Before.
     */
    @Before
    public void before() {
        assertTrue(this.jdbcData.setUp());
    }

    /**
     * After.
     */
    @After
    public void after() {
        assertTrue(this.jdbcData.tearDown());
    }

    /**
     * Test.
     */
    @Test
    public void test() {
        assertTrue(this.jdbcData.reset());
    }

}
