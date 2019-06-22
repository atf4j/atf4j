
package net.atf4j.ddt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import static org.junit.Assume.assumeNotNull;

import lombok.extern.slf4j.Slf4j;
import net.atf4j.data.Actor;
import net.atf4j.data.CredentialsFactory;

/**
 * Unit tests for Credentials class.
 */
@Slf4j
public final class CredentialsTest {
    private static final String PLATFORM = "dev";
    private static final String TAG = "@AUTHORISED";

    /**
     * Unit test to credentials factory static.
     */
    @Test
    public void testCredentialsFactoryStatic() {
        final Actor actor = CredentialsFactory.on(PLATFORM).tagged(TAG);
        assertNotNull(actor);
        log.info(actor.toString());
    }

    /**
     * Unit test to credentials factory.
     */
    @Test
    public void testCredentialsFactory() {
        // Given a credentials factory
        final CredentialsFactory credentials = new CredentialsFactory();
        assertNotNull(credentials);
        log.info(credentials.toString());

        final Actor actor = credentials.onPlatform(PLATFORM).tagged(TAG);
        assertNotNull(actor);
        log.info(actor.toString());
    }

    /**
     * Unit test to credentials factory platform.
     */
    @Test
    public void testCredentialsFactoryPlatform() {
        // Given a credentials factory
        final CredentialsFactory credentials = new CredentialsFactory(PLATFORM);
        assertNotNull(credentials);
        log.info(credentials.toString());

        final Actor actor = credentials.tagged(TAG);
        assertNotNull(actor);
        log.info(actor.toString());
    }

    /**
     * Unit test to credentials factory data.
     *
     * <code>
     *  # tags, username, password, email
     *  &#64;ADMIN,admin,password,admin@example.com
     *  &#64;AUTHORISED,alice,password,alice@example.com
     *  &#64;AUTHORISED,bob,password,bob@example.com
     *  &#64;UNAUTHORISED,trudy,password,trudy@example.com
     * </code>
     */
    @Test
    public void testCredentialsFactoryData() {
        // Given a credentials factory
        final CredentialsFactory credentials = new CredentialsFactory(PLATFORM);
        assumeNotNull(credentials);
        log.info(credentials.toString());

        // When we retrieve admin credentials
        final Actor actor = credentials.tagged("@ADMIN");
        assertNotNull(actor);
        assertEquals("admin", actor.getUsername());
        assertEquals("password", actor.getPassword());
        assertEquals("admin@example.com", actor.getEmail());
        log.info(actor.toString());
    }

    /**
     * Unit test to default platform domain language.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDefaultPlatformDomainLanguage() throws Exception {
        assertNotNull(CredentialsFactory.withTag("@AUTHORISED"));
        assertNotNull(CredentialsFactory.withTag("@UNAUTHORISED"));
        assertNull(CredentialsFactory.withTag("@missing"));

        assertNotNull(CredentialsFactory.withCharacteristic("@AUTHORISED"));
        assertNotNull(CredentialsFactory.withCharacteristic("@UNAUTHORISED"));
        assertNull(CredentialsFactory.withCharacteristic("@missing"));

        assertNotNull(CredentialsFactory.allWithTag("@AUTHORISED"));
        assertNotNull(CredentialsFactory.allWithTag("@UNAUTHORISED"));
        assertNull(CredentialsFactory.allWithTag("@missing"));
    }

}
