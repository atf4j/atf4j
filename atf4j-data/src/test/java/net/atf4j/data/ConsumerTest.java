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

package net.atf4j.data;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * The ConsumerTest Class.
 */
public class ConsumerTest extends ResultsReporting {

    /**
     * Test consumer.
     */
    @Test
    public void testConsumer() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

    /**
     * Test consumer credentials.
     */
    @Test
    public void testConsumerCredentials() {
        Credentials credentials = new Credentials();
        assertNotNull(credentials);
        Consumer consumer = new Consumer(credentials);
        assertNotNull(consumer);
    }

    /**
     * Test consumer string string string.
     */
    @Test
    public void testConsumerStringStringString() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

    /**
     * Test set get credentials.
     */
    @Test
    public void testSetGetCredentials() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

    /**
     * Test set get username.
     */
    @Test
    public void testSetGetUsername() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

    /**
     * Test set get password.
     */
    @Test
    public void testSetGetPassword() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

    /**
     * Test set get email.
     */
    @Test
    public void testSetGetEmail() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

}
