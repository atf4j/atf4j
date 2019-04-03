
package net.atf4j.data;

/**
 * A class to provide the ExpectedData for automated testing.
 *
 * Provides the data expected by an automated test case. This class abstract the
 * platform away behind a label and allows the automated test data to be
 * smoothly retrieved based on a characteristic of the data. e.g.
 *
 * Given a credit customer ... Given a cash customer ...
 *
 */
public final class ExpectedData extends AbstractExpectedData implements ExpectedDataInterface {

    /** single static instance within the class loader. */
    private static final ExpectedData INSTANCE = new ExpectedData();

    /**
     * Gets the instance.
     *
     * @return the instance
     */
    private static synchronized ExpectedData getInstance() {
        return INSTANCE;
    }

    /**
     * Default constructor.
     */
    private ExpectedData() {
        super();
        initialise();
    }

    /**
     * Load platform data.
     */
    private void initialise() {
        super.initialise("ExpectedData.csv");
    }

    /**
     * From csv.
     *
     * @return the expected data
     */
    public static ExpectedData fromCsv() {
        return ExpectedData.getInstance().loadFromCsv();
    }

    /**
     * From csv.
     *
     * @param filename the filename
     * @return the expected data
     */
    public static ExpectedData fromCsv(final String filename) {
        return ExpectedData.getInstance().loadFromCsv(filename);
    }

    /**
     * Load from csv.
     *
     * @return the expected data
     */
    private ExpectedData loadFromCsv() {
        final String simpleName = this.getClass().getSimpleName();
        final String filename = String.format("%s.csv", simpleName);
        this.log.info("{}", filename);
        return this;
    }

    /**
     * Load from csv.
     *
     * @param filename the filename
     * @return the expected data
     */
    private ExpectedData loadFromCsv(final String filename) {
        this.log.info("{}", filename);
        return this;
    }

    /**
     * From xml.
     *
     * @return the expected data
     */
    public static ExpectedData fromXml() {
        return ExpectedData.getInstance().loadFromXml();
    }

    /**
     * From xml.
     *
     * @param filename the filename
     * @return the expected data
     */
    public static ExpectedData fromXml(final String filename) {
        return ExpectedData.getInstance().loadFromXml(filename);
    }

    /**
     * Load from xml.
     *
     * @return the expected data
     */
    private ExpectedData loadFromXml() {
        final String simpleName = this.getClass().getSimpleName();
        final String filename = String.format("%s.xml", simpleName);
        this.log.info("{}", filename);
        return this;
    }

    /**
     * Load from xml.
     *
     * @param filename the filename
     * @return the expected data
     */
    private ExpectedData loadFromXml(final String filename) {
        this.log.info("{}", filename);
        return this;
    }

    /**
     * From json.
     *
     * @return the expected data
     */
    public static ExpectedData fromJson() {
        return ExpectedData.getInstance().loadFromJson();
    }

    /**
     * From json.
     *
     * @param filename the filename
     * @return the expected data
     */
    public static ExpectedData fromJson(final String filename) {
        return ExpectedData.getInstance().loadFromJson(filename);
    }

    /**
     * Load from json.
     *
     * @return the expected data
     */
    private ExpectedData loadFromJson() {
        final String simpleName = this.getClass().getSimpleName();
        final String filename = String.format("%s.json", simpleName);
        this.log.info("{}", filename);
        return this;
    }

    /**
     * Load from json.
     *
     * @param filename the filename
     * @return the expected data
     */
    private ExpectedData loadFromJson(final String filename) {
        this.log.info("{}", filename);
        return this;
    }

    /**
     * With tag.
     *
     * @param tag the tag
     * @return the string
     */
    public static String withTag(final String tag) {
        return ExpectedData.getInstance().getTagged(tag);
    }

    /**
     * With characteristic.
     *
     * @param tag the tag
     * @return the string
     */
    public static String withCharacteristic(final String tag) {
        return ExpectedData.getInstance().getTagged(tag);
    }

    /**
     * All with tag.
     *
     * @param tag the tag
     * @return the string[]
     */
    public static String[] allWithTag(final String tag) {
        return ExpectedData.getInstance().getAllTagged(tag);
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public static String debugString() {
        return ExpectedData.getInstance().toString();
    }

    /*
     * (non-Javadoc)
     * @see coaching.automation.ddt.AbstractExpectedData#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [%s]", this.getClass().getSimpleName(), super.toString());
    }

}
