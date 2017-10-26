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

import net.atf4j.core.TestResultsReporting;

/**
 * The ConsumerTest Class.
 */
@Ignore
public final class ConsumerTest extends TestResultsReporting {

    /**
     * Test reader.
     *
     * @throws JMSException the JMS exception
     */
    @Test
    public void testReader() throws JMSException {
        this.log.debug("testReader");

        final Consumer consumer = new Consumer();
        assertNotNull(UNEXPECTED_NULL, consumer);
        this.log.debug("{}", consumer);
    }

    /**
     * Test execute.
     *
     * @throws JMSException the JMS exception
     */
    @Test
    public void testExecute() throws JMSException {
        this.log.debug("testExecute");

        final Consumer consumer = new Consumer();
        assertNotNull(UNEXPECTED_NULL, consumer);
        this.log.debug("{}", consumer);

        final String[] messages = consumer.execute();
        assertNotNull(UNEXPECTED_NULL, messages);
        this.log.debug("{}", Arrays.toString(messages));
    }
}
