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
package net.atf4j.data;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for FileWalker objects.
 */
public class FileWalkerTest extends ResultsReporting {

    /**
     * Unit Test for test walk.
     *
     * @throws URISyntaxException the URI syntax exception
     */
    @Test
    public void testWalk() throws Exception {
        final FileWalker fileWalker = new FileWalker();
        assertNotNull(fileWalker);
        fileWalker.walk("/messages");
    }

    @Test
    public void testFileWalker() throws Exception {
        final FileWalker fileWalker = new FileWalker("/messages");
        assertNotNull(fileWalker);
    }

    @Test
    public void testFileWalkerWalk() throws Exception {
        final FileWalker fileWalker = new FileWalker();
        assertNotNull(fileWalker);
        fileWalker.walk("/messages");
    }
}
