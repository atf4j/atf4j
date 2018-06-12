/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */

package net.atf4j.core;

import static org.junit.Assume.assumeTrue;

/**
 * Test Context.
 */
public final class TestContext extends TestResultsReporting {

    /**
     * Instantiates a new test context.
     */
    private TestContext() {
        super();
    }

    /**
     * Checks if browsers run on a local machine.
     *
     * -DisLocal=true
     *
     * @return true, if local, otherwise false.
     */
    public static boolean isLocal() {
        return Boolean.getBoolean("isLocal");
    }

    /**
     * Assume browser available on the local machine.
     * Use as a pre-condition for any platform specific test.
     */
    public static void assumeLocal() {
        assumeTrue("Expected System property isLocal to be defined", TestContext.isLocal());
    }

    /**
     * Checks if Selenium grid is available.
     *
     * -DisGrid=true
     *
     * @return true, if grid is available, otherwise false.
     */
    public static boolean isSeleniumGrid() {
        return Boolean.getBoolean("isSeleniumGrid");
    }

    /**
     * Assume selenium grid.
     * Use as a pre-condition for any platform specific test.
     */
    public static void assumeSeleniumGrid() {
        assumeTrue("Expected System property isSeleniumGrid to be defined", TestContext.isSeleniumGrid());
    }

    /**
     * Checks if we are running under jenkins.
     *
     * -DisJenkins=true
     *
     * @return true, if jenkins is available, otherwise false.
     */
    public static boolean isJenkins() {
        return Boolean.getBoolean("isJenkins");
    }

    /**
     * Assume jenkins.
     * Use as a pre-condition for any platform specific test.
     */
    public static void assumeJenkins() {
        assumeTrue("Expected System property isJenkins to be defined", TestContext.isJenkins());
    }

    /**
     * Checks if Selenium grid is running as a localhost server.
     * <p>
     * Default to <code>http://127.0.0.1:8080/</code>.
     *
     * -DlocalServer=true
     *
     * @return true, if local server is available, otherwise false.
     */
    public static boolean localServer() {
        return Boolean.getBoolean("localServer");
    }

    /**
     * Assume local server is available.
     *
     * Use as a pre-condition for any platform specific test.
     */
    public static void assumeLocalServer() {
        assumeTrue("Expected System property localServer to be defined", TestContext.localServer());
    }

    /**
     * Checks if active MQ is available.
     *
     * @return true, if is active MQ
     */
    public static boolean isActiveMQ() {
        return Boolean.getBoolean("isActiveMQ");
    }

    /**
     * Assume active MQ is available.
     * Use as a pre-condition for any platform specific test.
     */
    public static void assumeActiveMQ() {
        assumeTrue("Expected System property isActiveMQ to be defined", TestContext.isActiveMQ());
    }

}
