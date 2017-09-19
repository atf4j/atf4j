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
import java.io.FilenameFilter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FolderWalkerTest {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(FolderWalkerTest.class);

    public class FolderWalker extends AbstractFolderWalker {

        public class ExtensionFilter implements FilenameFilter {

            /** The extension. */
            private final String extension;

            /**
             * Instantiates a new extension filter.
             *
             * @param extension
             *            the extension
             */
            public ExtensionFilter(final String extension) {
                this.extension = extension;
            }

            /*
             * (non-Javadoc)
             * 
             * @see java.io.FilenameFilter#accept(java.io.File,
             * java.lang.String)
             */
            @Override
            public boolean accept(final File dir, final String filename) {
                return filename.endsWith(this.extension);
            }
        }

        /**
         * Instantiates a new folder walker.
         */
        public FolderWalker() {
            super();
        }

        /**
         * Instantiates a new folder walker.
         *
         * @param path
         *            the path
         */
        public FolderWalker(final String path) {
            super(path);
        }
    }

    /**
     * Test folder walker.
     */
    @Test
    public void testFolderWalker() {
        LOG.info("testFolderWalker");
        final AbstractFolderWalker folderWalker = new FolderWalker();
        assertNotNull(folderWalker);
        folderWalker.walk();
    }

    /**
     * Test folder walker null.
     */
    @Test
    public void testFolderWalkerNull() {
        LOG.info("testFolderWalker");
        final AbstractFolderWalker folderWalker = new FolderWalker(null);
        assertNotNull(folderWalker);
        folderWalker.walk();
    }

    /**
     * Test folder walker empty.
     */
    @Test
    public void testFolderWalkerEmpty() {
        LOG.info("testFolderWalker");
        final AbstractFolderWalker folderWalker = new FolderWalker("");
        assertNotNull(folderWalker);
        folderWalker.walk();
    }

    /**
     * Test folder walker dot.
     */
    @Test
    public void testFolderWalkerDot() {
        LOG.info("testFolderWalker");
        final AbstractFolderWalker folderWalker = new FolderWalker(".");
        assertNotNull(folderWalker);
        folderWalker.walk();
    }

    /**
     * Test folder walker string.
     */
    @Test
    public void testFolderWalkerString() {
        LOG.info("testFolderWalker");
        final AbstractFolderWalker folderWalker = new FolderWalker("messages");
        assertNotNull(folderWalker);
        folderWalker.walk();
    }

}
