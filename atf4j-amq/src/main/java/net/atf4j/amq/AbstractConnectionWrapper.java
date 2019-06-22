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
import javax.jms.ConnectionMetaData;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * An abstract class to wrap ActiveMQ Connections.
 */
public abstract class AbstractConnectionWrapper implements ConnectionWrapperInterface {

    protected String brokerUrl = ActiveMQConnection.DEFAULT_BROKER_URL;
    protected ConnectionFactory connectionFactory;
    protected Connection connection;
    protected Session session;
    protected String name;
    protected Topic topic;
    protected Queue queue;

    /**
     * Default constructor instantiates a new connection wrapper.
     *
     * @throws JMSException the JMS exception exception.
     */
    protected AbstractConnectionWrapper() throws JMSException {
        super();
        this.connectionFactory = new ActiveMQConnectionFactory(this.brokerUrl);
        this.connection = this.connectionFactory.createConnection();
        this.connection.start();
    }

    /**
     * Instantiates a new abstract connection wrapper.
     *
     * @param connectionFactory the connection factory
     * @throws JMSException the JMS exception
     */
    public AbstractConnectionWrapper(final ConnectionFactory connectionFactory) throws JMSException {
        super();
        this.connectionFactory = connectionFactory;
        this.connection = this.connectionFactory.createConnection();
        this.connection.start();
    }

    /**
     * Instantiates a new abstract connection wrapper.
     *
     * @param connection the connection
     * @throws JMSException the JMS exception
     */
    public AbstractConnectionWrapper(final Connection connection) throws JMSException {
        super();
        this.connection = connection;
        this.connection.start();
    }

    /**
     * Instantiates a new abstract connection wrapper.
     *
     * @param brokerUrl the broker url
     * @throws JMSException the JMS exception
     */
    public AbstractConnectionWrapper(final String brokerUrl) throws JMSException {
        super();
        this.connectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        this.connection = this.connectionFactory.createConnection();
        this.connection.start();
    }

    /**
     * New session on the connection.
     *
     * @return the session
     * @throws JMSException the JMS exception exception.
     */
    @Override
    public ConnectionWrapperInterface startSession() throws JMSException {
        this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        return this;
    }

    /**
     * Gets the meta data.
     *
     * @return the meta data
     * @throws JMSException the JMS exception
     * @see javax.jms.Connection#getMetaData()
     */
    @Override
    public ConnectionMetaData getMetaData() throws JMSException {
        return this.connection.getMetaData();
    }

    /**
     * Creates the queue.
     *
     * @param queueName the queue name
     * @return the queue
     * @throws JMSException the JMS exception
     * @see javax.jms.Session#createQueue(java.lang.String)
     */
    @Override
    public ConnectionWrapperInterface createQueue(final String queueName) throws JMSException {
        this.name = queueName;
        this.queue = this.session.createQueue(this.name);
        return this;
    }

    /**
     * Creates the topic.
     *
     * @param topicName the topic name
     * @return the topic
     * @throws JMSException the JMS exception
     * @see javax.jms.Session#createTopic(java.lang.String)
     */
    @Override
    public ConnectionWrapperInterface createTopic(final String topicName) throws JMSException {
        this.name = topicName;
        this.topic = this.session.createTopic(this.name);
        return this;
    }

}
