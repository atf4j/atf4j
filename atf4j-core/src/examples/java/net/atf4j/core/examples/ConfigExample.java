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

package net.atf4j.core.examples;

import net.atf4j.core.AbstractConfig;

/**
 * Example ExampleConfiguration class.
 */
public final class ConfigExample extends AbstractConfig {

    /** The instance. */
    private static ConfigExample config = new ConfigExample();

    /**
     * private constructor to prevent wild instantiation.
     */
    private ConfigExample() {
        super();
    }

    /**
     * Gets the single INSTANCE of AbstractConfig.
     *
     * @return single INSTANCE of AbstractConfig
     */
    public static ConfigExample getInstance() {
        return ConfigExample.config;
    }

    /**
     * A string value.
     *
     * @return the string
     */
    public String myKey() {
        return super.get("myKey", "myValue");
    }

    /**
     * A long value.
     *
     * @return the long
     */
    public long myLongValue() {
        return super.valueFor("myLongValue", 0L);
    }

    /**
     * A boolean value.
     *
     * @return true, if successful
     */
    public boolean myBooleanValue() {
        return super.valueFor("myBooleanValue", true);
    }

}
