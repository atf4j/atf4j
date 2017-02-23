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
 * An Example Configuration loader.
 * This will load the ExampleConfig.properties file from the resources folder.
 * It make the Configuration available by
 */
public class ExampleConfig extends AbstractConfig {

    private static ExampleConfig instance = null;

    /**
     * Gets the single instance of AbstractConfig.
     *
     * @return single instance of AbstractConfig
     */
    public static ExampleConfig getInstance() {
        if (ExampleConfig.instance == null) {
            ExampleConfig.instance = create();
        }
        return ExampleConfig.instance;
    }

    /**
     * Create new instance of create.
     *
     * @return the abstract configuration.
     */
    public static ExampleConfig create() {
        return new ExampleConfig();
    }

}
