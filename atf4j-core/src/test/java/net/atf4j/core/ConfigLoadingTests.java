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

import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * Unit test for loading a ExampleConfiguration from properties.
 */
@Slf4j
public final class ConfigLoadingTests {

    /**
     * An Example of Configuration class loading from a properties file,
     * which is loaded from the project's resources folder,
     * Defaults to same name as the the class.
     */
    private class TestConfig extends AbstractConfig {
    }

    /**
     * Test method for TestConfig.
     */
    @Test
    public void testTestConfig() {
        final Configuration config = new TestConfig();
        verifyNotNull(config);
    }

}
