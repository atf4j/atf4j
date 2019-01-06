
package net.atf4j.ddt;

/**
 * Provides the ExpectedData for automated tests.
 */
public class ExpectedData {

    private static final String EXPECTED_DATA = "The expected data";

    /**
     * For tag.
     *
     * @param string the string
     * @return the string
     */
    public String forTag(final String string) {
        return EXPECTED_DATA;
    }

}
