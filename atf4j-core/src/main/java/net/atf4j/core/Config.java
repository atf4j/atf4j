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

/**
 * Configuration Class.
 */
public final class Config extends AbstractConfig {

    private static Config INSTANCE = new Config();

    /**
     * Instantiates a new configuration. Private default constructor prevents
     * wild instantiation.
     */
    private Config() {
        super();
    }

    /**
     * Gets the single INSTANCE of configuration.
     *
     * @return single INSTANCE of configuration.
     */
    public static Config getInstance() {
        return INSTANCE;
    }

    /**
     * Value for key.
     *
     * @param key the key
     * @return the string
     */
    public static String valueFor(final String key) {
        return getInstance().get(key);
    }

    /**
     * int value for.
     *
     * @param key the key
     * @return the int
     */
    public static int intValueFor(final String key) {
        return getInstance().get(key, 1);
    }

    /**
     * long value for.
     *
     * @param key the key
     * @return the long
     */
    public static long longValueFor(final String key) {
        return getInstance().get(key, 1);
    }

    /**
     * Boolean value for.
     *
     * @param key the key
     * @return true, if successful, otherwise false.
     */
    public static boolean booleanValueFor(final String key) {
        return getInstance().get(key, false);
    }

}
