
package net.atf4j.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

public class CredentialsTest extends ResultsReporting {

    @Test
    public void testCredentials() {
        Credentials credentials = new Credentials();
        assertNotNull(credentials);
        log.info("{}", credentials);
    }

    @Test
    public void testSetGetUsername() {
        Credentials credentials = new Credentials();
        assertNotNull(credentials);
        log.info("{}", credentials);
        credentials.setUsername("username");
        assertEquals("username", credentials.getUsername());
    }

    @Test
    public void testSetGetPassword() {
        Credentials credentials = new Credentials();
        assertNotNull(credentials);
        log.info("{}", credentials);
        credentials.setPassword("username");
        assertEquals("username", credentials.getPassword());
    }

    @Test
    public void testSetGetEmail() {
        Credentials credentials = new Credentials();
        assertNotNull(credentials);
        log.info("{}", credentials);
        credentials.setEmail("email@example.org");
        assertEquals("email@example.org", credentials.getEmail());
    }

}
