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

package net.atf4j.amq;

import java.io.File;
import java.util.List;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * Message Finder Test class.
 */
public class PlatformMessageFinderTest extends TestResultsReporting {

    /**
     * Test message finder.
     */
    @Test
    public void testPlatformMessageFinder() {
        final PlatformMessageFinder messageFinder = new PlatformMessageFinder();
        verifyNotNull(messageFinder);
        this.log.debug(messageFinder.toString());
    }

    @Test
    public void testStaticMessageFinder() {
        final PlatformMessageFinder forPlatform = PlatformMessageFinder.forPlatform("@dev");
        final Object obj = forPlatform.with("@tag");
    }

    /**
     * Unit tests for the messageFinderWalk() method of MessageFinder object.
     */
    @Test
    public void testMessageFinderWalk() {
        final PlatformMessageFinder messageFinder = new PlatformMessageFinder();
        verifyNotNull(messageFinder);

        final List<File> messages = messageFinder.walk();
        verifyNotNull(messages);
        for (final File file : messages) {
            this.log.info("{} = {}", file.getName(), file.toString());
        }
    }

    /**
     * Unit tests for the messageFinderScan() method of MessageFinder object.
     */
    @Test
    public void testMessageFinderScan() {
        final PlatformMessageFinder messageFinder = new PlatformMessageFinder();
        verifyNotNull(messageFinder);

        final List<File> messages = messageFinder.scan(".");
        verifyNotNull(messages);
        for (final File file : messages) {
            this.log.info("{} = {}", file.getName(), file.toString());
        }
    }
}
