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

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract Common class.
 */
public abstract class AbstractCommon {

    protected static final Logger log = LoggerFactory.getLogger(AbstractCommon.class);
    protected static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    protected ConnectionFactory connectionFactory;
    protected javax.jms.Connection connection;
    protected Session session;
    protected String topicName = "testQueue";
    protected Topic topic;

    /**
     * Instantiates a new common.
     *
     * @throws JMSException
     *             the JMS exception
     */
    public AbstractCommon() throws JMSException {
        super();
        this.connection = initialise();
        this.session = newSession(this.connection);
        this.topic = this.session.createTopic(this.topicName);
    }

    /**
     * Initialise.
     *
     * @return the connection
     * @throws JMSException
     *             the JMS exception
     */
    protected Connection initialise() throws JMSException {
        this.connectionFactory = new ActiveMQConnectionFactory(url);
        this.connection = this.connectionFactory.createConnection();
        this.connection.start();
        return this.connection;
    }

    /**
     * New session.
     *
     * @param connection
     *            the connection
     * @return the session
     * @throws JMSException
     *             the JMS exception
     */
    protected Session newSession(final Connection connection) throws JMSException {
        return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

}
