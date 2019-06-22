
package net.atf4j.data;

import lombok.extern.slf4j.Slf4j;

/**
 * The PlatformData class.
 */
@Slf4j public final class PlatformData extends AbstractExpectedData implements ExpectedDataInterface {

    private String platform = null;

    /**
     * Factory method to load the default Platform Data.
     *
     * @return instance of PlatformData
     */
    public static PlatformData platform() {
        return new PlatformData();
    }

    /**
     * Factory method to load Platform Data for Local.
     *
     * @return instance of PlatformData
     */
    public static PlatformData local() {
        return new PlatformData("local");
    }

    /**
     * Factory method to load Platform Data for the specified platform.
     *
     * @param platform the platform
     * @return the platform data
     */
    public static PlatformData platform(final String platform) {
        return new PlatformData(platform);
    }

    /**
     * Return the data with the tag.
     *
     * @param tag the tag
     * @return the data as a string
     */
    public static String withTag(final String tag) {
        return new PlatformData().getTagged(tag);
    }

    /**
     * Return the data with the characteristic.
     *
     * @param tag the tag
     * @return the data as a string
     */
    public static String withCharacteristic(final String tag) {
        return new PlatformData().getTagged(tag);
    }

    /**
     * Return all data with the with the tag.
     *
     * @param tag the tag
     * @return the string[]
     */
    public static String[] allWithTag(final String tag) {
        return new PlatformData().getAllTagged(tag);
    }

    /**
     * Private default constructor to prevent wild instantiation.
     */
    private PlatformData() {
        super();
        setPlatform(System.getProperty("platform", "local"));
        load();
    }

    /**
     * Private constructor to prevent wild instantiation.
     */
    private PlatformData(final String platform) {
        super();
        setPlatform(platform);
        load();
    }

    /**
     * Load platform data.
     */
    private void load() {
        super.initialise(System.getProperty("platformDataFile", "PlatformData.csv"));
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

    /*
     * (non-Javadoc)
     * @see coaching.automation.ddt.AbstractExpectedData#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [platform=%s %s]", this.getClass().getSimpleName(), this.platform, super.toString());
    }

}
