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
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;

/**
 * Consumer Class.
 */
public final class Consumer extends AbstractConnectionWrapper {

    /**
     * Instantiates a new consumer.
     *
     * @throws JMSException the JMS exception
     */
    public Consumer() throws JMSException {
        super();
    }

    /**
     * Instantiates a new consumer.
     *
     * @param brokerUrl the broker url
     * @throws JMSException the JMS exception
     */
    public Consumer(final String brokerUrl) throws JMSException {
        super(brokerUrl);
    }

    /**
     * Instantiates a new consumer.
     *
     * @param connection the connection
     * @throws JMSException the JMS exception
     */
    public Consumer(final Connection connection) throws JMSException {
        super(connection);
    }

    /**
     * Instantiates a new consumer.
     *
     * @param connectionFactory the connection factory
     * @throws JMSException the JMS exception
     */
    public Consumer(final ConnectionFactory connectionFactory) throws JMSException {
        super(connectionFactory);
    }

    /**
     * Execute, consumer all messages.
     *
     * @return the string[]
     * @throws JMSException the JMS exception
     */
    public String[] execute() throws JMSException {
        final MessageConsumer messageConsumer = this.session.createConsumer(this.topic);
        final Message message = messageConsumer.receive(1000);

        if (message != null) {
            final TextMessage textMessage = (TextMessage) message;
            final String text = textMessage.getText();
        }

        messageConsumer.close();
        this.connection.close();
        return new String[0];
    }

}
