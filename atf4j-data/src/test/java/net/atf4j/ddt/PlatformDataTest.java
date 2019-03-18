
package net.atf4j.ddt;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import net.atf4j.data.PlatformData;

/**
 * Unit tests for PlatformData class.
 */
public final class PlatformDataTest {

    /** Provide logging. */
    private static final Logger LOG = LoggerFactory.getLogger(PlatformDataTest.class);

    /**
     * Unit test to on platform.
     */
    @Test
    public void testPlatformDataOnPlatform() {
        PlatformData expectedData = PlatformData.platform();
        assertNotNull(expectedData);
        LOG.info(expectedData.toString());
    }

    /**
     * Unit test to platform data on platform local.
     */
    @Test
    public void testPlatformDataOnPlatformLocal() {
        PlatformData expectedData = PlatformData.platform("local");
        assertNotNull(expectedData);
        LOG.info(expectedData.toString());
    }

    /**
     * Unit test to platform data local.
     */
    @Test
    public void testPlatformDataLocal() {
        PlatformData expectedData = PlatformData.local();
        assertNotNull(expectedData);
        LOG.info(expectedData.toString());
    }

    /**
     * Unit test to default platform domain language.
     */
    @Test
    public void testDefaultPlatformDomainLanguage() {
        assertNotNull(PlatformData.withTag("@STORY-001"));
        assertNotNull(PlatformData.withTag("@STORY-002"));
        assertNull(PlatformData.withTag("@MISSING-STORY"));

        assertNotNull(PlatformData.withCharacteristic("@CREDIT-CUSTOMER"));
        assertNotNull(PlatformData.withCharacteristic("@CASH-CUSTOMER"));
        assertNull(PlatformData.withCharacteristic("@MISSING-CUSTOMER"));

        assertNotNull(PlatformData.allWithTag("@CREDIT-CUSTOMER"));
        assertNotNull(PlatformData.allWithTag("@CASH-CUSTOMER"));
        assertNotNull(PlatformData.allWithTag("@MISSING-CUSTOMER"));
    }

}
