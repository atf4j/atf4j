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
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;

public class Reader extends Common {

    private MessageConsumer messageConsumer;

    public Reader() throws JMSException {
        super();
    }

    public String[] execute() throws JMSException {

        this.messageConsumer = this.session.createConsumer(this.topic);

        final Message message = this.messageConsumer.receive(1000);

        if (message != null) {
            final TextMessage textMessage = (TextMessage) message;
            final String text = textMessage.getText();
        }
        this.connection.close();
        return new String[0];
    }
}
