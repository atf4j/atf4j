
package net.atf4j.data;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assume.assumeTrue;

/**
 * The abstract ExpectedData class.
 */
public abstract class AbstractExpectedData implements ExpectedDataInterface {

    /** provides logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** CSV file containing the expected data. */
    protected CsvFile csvFile;

    /** The path to the CSV file. */
    protected String path = "data/";

    /**
     * Default constructor.
     */
    public AbstractExpectedData() {
        super();
    }

    /**
     * Load data.
     *
     * @param filename the filename
     */
    protected void initialise(final String filename) {
        this.csvFile = new CsvFile(filename);
    }

    /**
     * Gets the tagged.
     *
     * @param tag the tag
     * @return the tagged
     */
    protected String getTagged(final String tag) {
        assumeTrue(this.csvFile.isLoaded());
        final int rowCount = this.csvFile.rowCount();
        for (int index = 0; index < rowCount; index++) {
            final CsvRow record = this.csvFile.row(index);
            assertNotNull(record);
            if (record.getField(0).toUpperCase().contains(tag.toUpperCase())) {
                return record.toString();
            }
        }
        return null;
    }

    /**
     * Gets the all tagged.
     *
     * @param tag the tag
     * @return the all tagged
     */
    protected String[] getAllTagged(final String tag) {
        assumeTrue(this.csvFile.isLoaded());
        final ArrayList<String> all = new ArrayList<>();
        assumeTrue(this.csvFile.isLoaded());
        final int rowCount = this.csvFile.rowCount();
        for (int index = 0; index < rowCount; index++) {
            final CsvRow record = this.csvFile.row(index);
            assertNotNull(record);
            if (record.getField(0).toUpperCase().contains(tag.toUpperCase())) {
                all.add(record.toString());
            }
        }
        return all.toArray(new String[all.size()]);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [path=%s, csvFile=%s]", this.getClass().getSimpleName(), this.path, this.csvFile);
    }

}
