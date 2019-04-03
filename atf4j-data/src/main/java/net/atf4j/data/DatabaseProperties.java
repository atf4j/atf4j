
package net.atf4j.data;

import net.atf4j.core.AbstractConfig;

/**
 * A class to provide database connection properties.
 */
public class DatabaseProperties extends AbstractConfig {

    /** DATABASE_PROPERTIES constant. */
    private static final String DATABASE_PROPERTIES = "database.properties";

    /**
     * Default constructor.
     */
    public DatabaseProperties() {
        super(DATABASE_PROPERTIES);
    }

    /**
     * Instantiates a new database properties.
     *
     * @param platform the platform
     */
    public DatabaseProperties(final String platform) {
        super(String.format("%s/%s", platform, DATABASE_PROPERTIES));
    }

}
