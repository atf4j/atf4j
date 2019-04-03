
package net.atf4j.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assume.assumeTrue;

/**
 * The CredentialsFactory class.
 */
public class CredentialsFactory extends AbstractExpectedData implements ExpectedDataInterface {

    /** Provides logging. */
    private static final Logger LOG = LoggerFactory.getLogger(CredentialsFactory.class);
    
    /** The platform. */
    private String platform;
    
    /** The csv file. */
    private CsvFile csvFile;

    /**
     * On.
     *
     * @param platform the platform
     * @return the credentials factory
     */
    public static CredentialsFactory on(final String platform) {
        return new CredentialsFactory(platform);
    }

    /**
     * With tag.
     *
     * @param string the string
     * @return the object
     */
    public static Object withTag(final String string) {
        return null;
    }

    /**
     * With characteristic.
     *
     * @param string the string
     * @return the object
     */
    public static Object withCharacteristic(final String string) {
        return null;
    }

    /**
     * All with tag.
     *
     * @param string the string
     * @return the object
     */
    public static Object allWithTag(final String string) {
        return null;
    }

    /**
     * Default constructor.
     */
    public CredentialsFactory() {
        super();
        LOG.debug("CredentialsFactory() : {}", this);
        loadFrom(pathForPlatform());
    }

    /**
     * The Constructor.
     *
     * @param platform the platform
     */
    public CredentialsFactory(final String platform) {
        super();
        this.platform = platform;
        LOG.debug("CredentialsFactory({}) : {}", platform, this);
        loadFrom(pathForPlatform());
    }

    /**
     * Load from.
     *
     * @param credentialsFilename the credentials filename
     */
    private void loadFrom(final String credentialsFilename) {
        this.csvFile = new CsvFile(credentialsFilename);
    }

    /**
     * Path for platform.
     *
     * @return the string
     */
    private String pathForPlatform() {
        final String systemPlatform = System.getProperty("platform");
        if (systemPlatform == null) {
            return defaultPath();
        }
        return pathFor(systemPlatform);
    }

    /**
     * Path for the platform.
     *
     * @param platform the platform
     * @return the string
     */
    private String pathFor(final String platform) {
        return String.format("data/%s/Credentials.csv", platform);
    }

    /**
     * Default path.
     *
     * @return the string
     */
    private String defaultPath() {
        return "data/Credentials.csv";
    }

    /**
     * On platform.
     *
     * @param platform the platform
     * @return the credentials factory
     */
    public CredentialsFactory onPlatform(final String platform) {
        this.platform = platform;
        return this;
    }

    /**
     * Tagged.
     *
     * @param tag the tag
     * @return the actor
     */
    public Actor tagged(final String tag) {
        assumeTrue(this.csvFile.isLoaded());
        final int rowCount = this.csvFile.rowCount();
        for (int index = 0; index < rowCount; index++) {
            final CsvRow record = this.csvFile.getRecord(index);
            assertNotNull(record);
            if (record.getField(0).contains(tag)) {
                final Actor credentials = new Actor();
                assertNotNull(credentials);
                credentials.setUsername(record.getField(1));
                credentials.setPassword(record.getField(2));
                credentials.setEmail(record.getField(3));
                return credentials;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [platform=%s, csvFile=%s]", this.getClass().getSimpleName(), this.platform, this.csvFile);
    }

}
