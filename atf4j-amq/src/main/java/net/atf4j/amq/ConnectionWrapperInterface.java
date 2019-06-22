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

import javax.jms.ConnectionMetaData;
import javax.jms.JMSException;

/**
 * Interface for the Connection wrapper.
 */
public interface ConnectionWrapperInterface {

    /**
     * Creates the topic.
     *
     * @param topicName the topic name
     * @return the connection wrapper interface
     * @throws JMSException the JMS exception
     */
    ConnectionWrapperInterface createTopic(final String topicName) throws JMSException;

    /**
     * Creates the queue.
     *
     * @param queueName the queue name
     * @return the connection wrapper interface
     * @throws JMSException the JMS exception
     */
    ConnectionWrapperInterface createQueue(final String queueName) throws JMSException;

    /**
     * Gets the meta data.
     *
     * @return the meta data
     * @throws JMSException the JMS exception
     */
    ConnectionMetaData getMetaData() throws JMSException;

    /**
     * Start session.
     *
     * @return the connection wrapper interface
     * @throws JMSException the JMS exception
     */
    ConnectionWrapperInterface startSession() throws JMSException;

}
