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

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * Message Finder Test class.
 */
public class MessageFinderTest extends TestResultsReporting {

    /**
     * Test message finder.
     */
    @Test
    public void testMessageFinder() {
        final MessageFinder folderWalker = new MessageFinder();
        log.debug("{}", folderWalker);
        assertNotNull(UNEXPECTED_NULL, folderWalker);

        final List<File> messages = folderWalker.walk();
        assertNotNull(UNEXPECTED_NULL, messages);
        for (final File file : messages) {
            log.debug("{}", file.toString());
        }
    }
}
