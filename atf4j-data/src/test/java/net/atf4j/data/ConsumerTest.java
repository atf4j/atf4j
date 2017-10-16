
package net.atf4j.data;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

public class ConsumerTest extends ResultsReporting {

    @Test
    public void testConsumer() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

    @Test
    public void testConsumerCredentials() {
        Credentials credentials = new Credentials();
        assertNotNull(credentials);
        Consumer consumer = new Consumer(credentials);
        assertNotNull(consumer);
    }

    @Test
    public void testConsumerStringStringString() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

    @Test
    public void testSetGetCredentials() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

    @Test
    public void testSetGetUsername() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

    @Test
    public void testSetGetPassword() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

    @Test
    public void testSetGetEmail() {
        Consumer consumer = new Consumer();
        assertNotNull(consumer);
    }

}
