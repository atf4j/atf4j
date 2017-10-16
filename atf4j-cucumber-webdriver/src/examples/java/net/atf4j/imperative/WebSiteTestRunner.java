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

package net.atf4j.imperative;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.fdd.AbstractTestRunner;

/**
 * WebSiteTestRunner Class.
 */
public class WebSiteTestRunner extends AbstractTestRunner {

    private static final Logger log = LoggerFactory.getLogger(AbstractTestRunner.class);

    /**
     * Before feature.
     */
    @cucumber.api.java.Before
    public static void beforeFeature() {
        log.trace("beforeFeature");
    }

    /**
     * After feature.
     */
    @cucumber.api.java.After
    public void afterFeature() {
        log.trace("afterFeature");
    }

}
