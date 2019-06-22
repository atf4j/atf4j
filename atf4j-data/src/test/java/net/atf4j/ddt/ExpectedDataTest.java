
package net.atf4j.ddt;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import lombok.extern.slf4j.Slf4j;
import net.atf4j.data.ExpectedData;

/**
 * Unit tests for ExpectedData class.
 */
@Slf4j public final class ExpectedDataTest {

    /** PLATFORM constant. */
    private static final String PLATFORM = "dev";

    /** TAG constant. */
    private static final String TAG = "@AUTHORISED";

    /** Provides logging. */
    

    /**
     * Unit test to expected data from csv.
     *
     * @throws Exception the exception
     */
    @Test
    public void testExpectedDataFromCsv() throws Exception {
        ExpectedData fromCsv = ExpectedData.fromCsv();
        assertNotNull(fromCsv);
        log.info("{}", fromCsv);
    }

    /**
     * Unit test to expected data from named csv.
     *
     * @throws Exception the exception
     */
    @Test
    public void testExpectedDataFromNamedCsv() throws Exception {
        ExpectedData fromCsv = ExpectedData.fromCsv("data.csv");
        assertNotNull(fromCsv);
        log.info("{}", fromCsv);
    }

    /**
     * Unit test to expected data from xml.
     *
     * @throws Exception the exception
     */
    @Test
    public void testExpectedDataFromXml() throws Exception {
        ExpectedData fromXml = ExpectedData.fromXml();
        assertNotNull(fromXml);
        log.info("{}", fromXml);
    }

    /**
     * Unit test to expected data from named xml.
     *
     * @throws Exception the exception
     */
    @Test
    public void testExpectedDataFromNamedXml() throws Exception {
        ExpectedData fromXml = ExpectedData.fromXml("data.xml");
        assertNotNull(fromXml);
        log.info("{}", fromXml);
    }

    /**
     * Unit test to expected data from json.
     *
     * @throws Exception the exception
     */
    @Test
    public void testExpectedDataFromJson() throws Exception {
        ExpectedData fromJson = ExpectedData.fromJson();
        assertNotNull(fromJson);
        log.info("{}", fromJson);
    }

    /**
     * Unit test to expected data from named json.
     *
     * @throws Exception the exception
     */
    @Test
    public void testExpectedDataFromNamedJson() throws Exception {
        ExpectedData fromJson = ExpectedData.fromJson("data.json");
        assertNotNull(fromJson);
        log.info("{}", fromJson);
    }

    /**
     * Unit test to default platform domain language.
     *
     * @throws Exception the exception
     */
    @Ignore
    @Test
    public void testDefaultPlatformDomainLanguage() throws Exception {
        assertNotNull(ExpectedData.withTag("@AUTHORISED"));
        assertNotNull(ExpectedData.withTag("@UNAUTHORISED"));
        assertNull(ExpectedData.withTag("@missing"));

        assertNotNull(ExpectedData.withCharacteristic("@AUTHORISED"));
        assertNotNull(ExpectedData.withCharacteristic("@UNAUTHORISED"));
        assertNull(ExpectedData.withCharacteristic("@missing"));

        assertNotNull(ExpectedData.allWithTag("@AUTHORISED"));
        assertNotNull(ExpectedData.allWithTag("@UNAUTHORISED"));
        assertNull(ExpectedData.allWithTag("@missing"));
    }

}
