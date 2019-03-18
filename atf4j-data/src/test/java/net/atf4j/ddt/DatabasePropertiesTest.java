
package net.atf4j.ddt;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

import net.atf4j.data.DatabaseProperties;

/**
 * Unit test class for DatabaseProperties.
 */
public class DatabasePropertiesTest {

    /** PLATFORM constant. */
    private static final String PLATFORM = "dev";

    /** TAG constant. */
    private static final String TAG = "@AUTHORISED";

    /** provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(DatabasePropertiesTest.class);

    /**
     * Unit test to database properties.
     */
    @Test
    public void testDatabaseProperties() {
        final DatabaseProperties databaseProperties = new DatabaseProperties();
        assertNotNull(databaseProperties);
        LOG.info("{}", databaseProperties);
    }

    /**
     * Unit test to database properties named.
     */
    @Test
    public void testDatabasePropertiesNamed() {
        final DatabaseProperties databaseProperties = new DatabaseProperties(PLATFORM);
        assertNotNull(databaseProperties);
        LOG.info("{}", databaseProperties);
    }

}
