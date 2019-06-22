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

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assume.assumeTrue;

import net.atf4j.core.TestContext;

/**
 * Unit test for ConnectionMock class.
 */
public class ConnectionWrapperTest {

    /**
     * Mock the connection wrapper class.
     *
     * Using test broker
     * vm:// localhost?broker.persistent=false
     */
    public class ConnectionMock extends AbstractConnectionWrapper {
        /**
         * Instantiates a new connection wrapper.
         *
         * @throws JMSException the JMS exception exception.
         */
        protected ConnectionMock() throws JMSException {
            super(new ActiveMQConnectionFactory("vm://localhost?broker.persistent=false"));
        }
    }

    /**
     * Unit tests for the ConnectionMock object.
     *
     * @throws JMSException the JMS exception exception.
     */
    @Test
    public void testConnectionWrapper() throws JMSException {
        assumeTrue(TestContext.isActiveMQ());
        final ConnectionMock connection = new ConnectionMock();
        assertNotNull(connection);
    }

    // @Before
    // public void setupAMQ(){
    // broker = new BrokerService();
    // TransportConnector connector = new TransportConnector();
    // connector.setUri(new URI("tcp://localhost:61616"));
    // broker.addConnector(connector);
    // // More config here!
    // broker.start()
    // }
    //
    // @After
    // public void tearDownAMQ() {
    // broker.stop();
    // }

}
