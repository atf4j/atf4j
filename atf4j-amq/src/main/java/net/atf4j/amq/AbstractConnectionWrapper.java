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

import net.atf4j.core.TestResultsReporting;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * An abstract class to wrap ActiveMQ Connections.
 */
public abstract class AbstractConnectionWrapper
        extends TestResultsReporting
        implements ConnectionWrapperInterface {

    /** URL. */
    protected static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    /** connection factory. */
    protected ConnectionFactory connectionFactory;

    /** connection. */
    protected Connection connection;

    /** session. */
    protected Session session;

    /** topic name. */
    protected String topicName = "testQueue";

    /** topic. */
    protected Topic topic;

    /**
     * Default constructor instantiates a new connection wrapper.
     *
     * @throws JMSException the JMS exception exception.
     */
    protected AbstractConnectionWrapper() throws JMSException {
        super();
        this.connection = initialise();
        this.session = newSession(this.connection);
        this.topic = this.session.createTopic(this.topicName);
    }

    /**
     * Initialise the connection.
     *
     * @return the connection
     * @throws JMSException the JMS exception exception.
     */
    protected Connection initialise() throws JMSException {
        this.connectionFactory = new ActiveMQConnectionFactory(url);
        this.connection = this.connectionFactory.createConnection();
        this.connection.start();
        return this.connection;
    }

    /**
     * New session on the connection.
     *
     * @param connection the connection
     * @return the session
     * @throws JMSException the JMS exception exception.
     */
    protected Session newSession(final Connection connection) throws JMSException {
        return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }
}
