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

package net.atf4j.amq;

import javax.jms.JMSException;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assume.assumeTrue;

import net.atf4j.core.TestContext;

/**
 * Unit test for ConnectionWrapper class.
 */
public class ConnectionWrapperTest {

    /**
     * Mock the connection wrapper class.
     */
    public class ConnectionWrapper extends AbstractConnectionWrapper {

        /**
         * Instantiates a new connection wrapper.
         *
         * @throws JMSException the JMS exception exception.
         */
        protected ConnectionWrapper() throws JMSException {
            super();
        }
    }

    /**
     * Unit tests for the ConnectionWrapper object.
     *
     * @throws JMSException the JMS exception exception.
     */
    @Test
    public void testConnectionWrapper() throws JMSException {
        assumeTrue(TestContext.isActiveMQ());
        final ConnectionWrapper connection = new ConnectionWrapper();
        assertNotNull(connection);
    }

}
