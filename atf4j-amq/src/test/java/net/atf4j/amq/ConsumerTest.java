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

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import javax.jms.JMSException;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The ConsumerTest Class.
 */
@Ignore
public class ConsumerTest {

    private static final String UNEXPECTED_NULL = "unexpected null";
    private static final Logger LOG = LoggerFactory.getLogger(ConsumerTest.class);

    /**
     * Test reader.
     *
     * @throws JMSException the JMS exception
     */
    @Test
    public void testReader() throws JMSException {
        LOG.info("testReader");

        final Consumer consumer = new Consumer();
        assertNotNull(UNEXPECTED_NULL, consumer);
        LOG.info("{}", consumer);
    }

    /**
     * Test execute.
     *
     * @throws JMSException the JMS exception
     */
    @Test
    public void testExecute() throws JMSException {
        LOG.info("testExecute");

        final Consumer consumer = new Consumer();
        assertNotNull(UNEXPECTED_NULL, consumer);
        LOG.info("{}", consumer);

        final String[] messages = consumer.execute();
        assertNotNull(UNEXPECTED_NULL, messages);
        LOG.info("{}", Arrays.toString(messages));
    }
}
