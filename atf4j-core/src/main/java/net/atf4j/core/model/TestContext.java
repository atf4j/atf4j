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
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.core.model;

/**
 * Test Context.
 */
public class TestContext {

    private String platform;
    private String context;

    /**
     * Checks if is local.
     *
     * @return true, if is local
     */
    public static boolean isLocal() {
        return Boolean.getBoolean("isLocal");
    }

    /**
     * Checks if is selenium.
     *
     * @return true, if is selenium
     */
    public static boolean isSelenium() {
        return Boolean.getBoolean("isSelenium");
    }

    /**
     * Checks if is jenkins.
     *
     * @return true, if is jenkins
     */
    public static boolean isJenkins() {
        return Boolean.getBoolean("isJenkins");
    }

    /**
     * Sets the platform.
     *
     * @param platform
     *            the platform to set
     */
    public TestContext setPlatform(final String platform) {
        this.platform = platform;
        return this;
    }

    /**
     * Sets the context.
     *
     * @param context
     *            the context
     * @return the test context
     */
    public TestContext setContext(final String context) {
        this.context = context;
        return this;
    }

    /**
     * Gets the platform.
     *
     * @return the platform
     */
    public String getPlatform() {
        return this.platform;
    }

    /**
     * Gets the context.
     *
     * @return the context
     */
    public String getContext() {
        return this.context;
    }

}
