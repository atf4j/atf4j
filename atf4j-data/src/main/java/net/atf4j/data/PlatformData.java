
package net.atf4j.data;

/**
 * The PlatformData class.
 */
public final class PlatformData extends AbstractExpectedData implements ExpectedDataInterface {

    /** The platform. */
    private String platform = null;

    /**
     * Default constructor.
     */
    private PlatformData() {
        super();
        setPlatform(System.getProperty("platform", "local"));
        loadPlatformData();
    }

    /**
     * The Constructor.
     *
     * @param platform the platform
     */
    private PlatformData(final String platform) {
        super();
        setPlatform(platform);
        loadPlatformData();
    }

    /**
     * Load platform data.
     */
    private void loadPlatformData() {
        super.initialise(System.getProperty("platformDataFile", "PlatformData.csv"));
    }

    /**
     * @param platform the platform
     * @return the platform data
     */
    public static PlatformData local() {
        return new PlatformData("local");
    }

    /**
     * @param platform the platform
     * @return the platform data
     */
    public static PlatformData platform() {
        return new PlatformData();
    }

    /**
     * @param platform the platform
     * @return the platform data
     */
    public static PlatformData platform(final String platform) {
        return new PlatformData(platform);
    }

    /**
     * Sets the platform.
     *
     * @param platform the platform
     * @return the platform data
     */
    protected PlatformData setPlatform(final String platform) {
        this.platform = platform;
        return this;
    }

    /**
     * Gets the platform.
     *
     * @return the platform
     */
    protected String getPlatform() {
        return this.platform;
    }

    /**
     * With tag.
     *
     * @param tag the tag
     * @return the string
     */
    public static String withTag(final String tag) {
        return new PlatformData().getTagged(tag);
    }

    /**
     * With characteristic.
     *
     * @param tag the tag
     * @return the string
     */
    public static String withCharacteristic(final String tag) {
        return new PlatformData().getTagged(tag);
    }

    /**
     * All with tag.
     *
     * @param tag the tag
     * @return the string[]
     */
    public static String[] allWithTag(final String tag) {
        return new PlatformData().getAllTagged(tag);
    }

    /*
     * (non-Javadoc)
     * @see coaching.automation.ddt.AbstractExpectedData#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [platform=%s %s]", this.getClass().getSimpleName(), this.platform, super.toString());
    }

}
