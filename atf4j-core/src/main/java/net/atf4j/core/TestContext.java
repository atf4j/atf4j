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

    /** LOCAL_TOMCAT_URL constant. */
    private static final String LOCAL_TOMCAT_URL = "http://localhost:8080";

    /** LOCAL_SELENIUM_URL constant. */
    private static final String LOCAL_SELENIUM_URL = "http://localhost:4444";

    /** LOCAL_JENKINS_URL constant. */
    private static final String LOCAL_JENKINS_URL = "http://localhost:8080";

    /**
     * Instantiates a new test context.
     */
    private TestContext() {
        super();
    }

    /**
     * Assume local. Use as a pre-condition for any platform specific test.
     *
     * @return true, if successful
     */
    public static boolean assumeLocal() {
        assumeTrue(
            "The test assume the SUT is running locally, if this is true then define the system property 'isLocal' for the environment.",
            isLocal());
        return true;
    }

    /**
     * Assume jenkins. Use as a pre-condition for any platform specific test.
     *
     * @return true, if successful
     */
    public static boolean assumeJenkins() {
        assumeTrue(
            "The test assume running under Jenkins, if this is true then define the system property 'isJenkins' for the environment.",
            isJenkins());
        return true;
    }

    /**
     * Assume local tomcat. Use as a pre-condition for any platform specific
     * test.
     *
     * @return true, if successful
     */
    public static boolean assumeLocalTomcat() {
        assumeTrue(
            "The test assume Tomcat is available on localhost, if this is true then define the system property 'isTomcat' for the environment.",
            isTomcat());
        return true;
    }

    /**
     * Assume selenium grid. Use as a pre-condition for any platform specific
     * test.
     *
     * @return true, if successful
     */
    public static boolean assumeSeleniumGrid() {
        assumeTrue(
            "The test assume Selenium Grid is available on localhost, if this is true then define the system property 'isSeleniumGrid' for the environment.",
            isSeleniumGrid());
        return true;
    }

    /**
     * Assume headless. Use as a pre-condition for any platform specific test.
     *
     * @return true, if successful
     */
    public static boolean assumeHeadless() {
        assumeTrue(
            "The test assume a headless webBrowser is available locally, if this is true then define the system property 'isHeadless' for the environment.",
            isHeadless());
        return true;
    }

    /**
     * Assume active MQ is available. Use as a pre-condition for any platform
     * specific test.
     */
    public static void assumeActiveMQ() {
        assumeTrue("Expected System property isActiveMQ to be defined", TestContext.isActiveMQ());
    }

    /**
     * Checks if browsers run on a local machine.
     *
     * -DisLocal=true
     *
     * @return true, if local, otherwise false.
     */
    public static boolean isLocal() {
        return systemPropertyAsBoolean("isLocal", false);
    }

    /**
     * Checks if Selenium grid is available.
     *
     * -DisGrid=true
     *
     * @return true, if grid is available, otherwise false.
     */
    public static boolean isSeleniumGrid() {
        return systemPropertyAsBoolean("isSeleniumGrid", false);
    }

    /**
     * Grid url.
     *
     * @return the string
     */
    public static String seleniumGridUrl() {
        return System.getProperty("seleniumUrl", LOCAL_SELENIUM_URL);
    }

    /**
     * Checks if we are running under jenkins.
     *
     * -DisJenkins=true
     *
     * @return true, if jenkins is available, otherwise false.
     */
    public static boolean isJenkins() {
        return systemPropertyAsBoolean("isJenkins", false);
    }

    /**
     * Jenkinst url.
     *
     * @return the string
     */
    public static String jenkinstUrl() {
        return System.getProperty("tomcatUrl", LOCAL_JENKINS_URL);
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
        return systemPropertyAsBoolean("isActiveMQ", false);
    }

    /**
     * Run WebDriver Headless.
     *
     * @return true, if headless
     */
    public static boolean isHeadless() {
        return systemPropertyAsBoolean("isHeadless", false);
    }

    /**
     * Local browser.
     *
     * @return the string
     */
    public static String localBrowser() {
        return System.getProperty("localBrowser", "Firefox");
    }

    /**
     * Checks if is tomcat.
     *
     * @return true, if checks if is tomcat
     */
    public static boolean isTomcat() {
        return Boolean.valueOf(System.getProperty("isTomcat"));
    }

    /**
     * Tomcat url.
     *
     * @return the string
     */
    public static String tomcatUrl() {
        return System.getProperty("tomcatUrl", LOCAL_TOMCAT_URL);
    }

    /**
     * Page wait in seconds, defaults to 4 seconds.
     *
     * @return the long
     */
    public static long pageWait() {
        return getSystemPropertyAsLong("pageWait", 4L);
    }

    /**
     * Implicit wait in milliseconds, default to tenth of a second.
     *
     * @return the implicitWait as long value.
     */
    public static long implicitWait() {
        return getSystemPropertyAsLong("implicitWait", 100L);
    }

    /**
     * Explicit wait in milliseconds, defaults to 1 second.
     *
     * @return the explicitWait as long value.
     */
    public static long explicitWait() {
        return getSystemPropertyAsLong("explicitWait", 1000L);
    }

    /**
     * Retry interval.
     *
     * @return the long
     */
    public static long retryInterval() {
        return getSystemPropertyAsLong("retryInterval", 100L);
    }

    /**
     * Target platform.
     *
     * @return the string
     */
    public static String targetPlatform() {
        return System.getProperty("targetPlatform", "dev");
    }

    /**
     * Target environment.
     *
     * @return the string
     */
    public static String targetEnvironment() {
        return System.getProperty("targetEnvironment", "local");
    }

    /**
     * System property as boolean.
     *
     * @param key the key
     * @param booleanDefault the boolean default
     * @return the boolean
     */
    private static Boolean systemPropertyAsBoolean(final String key, final Boolean booleanDefault) {
        return Boolean.valueOf(System.getProperty(key, booleanDefault.toString()));
    }

    /**
     * Gets the system property as long.
     *
     * @param key the key
     * @param longDefault the long default
     * @return the system property as long
     */
    private static Long getSystemPropertyAsLong(final String key, final Long longDefault) {
        return Long.valueOf(System.getProperty(key, longDefault.toString()));
    }

}
