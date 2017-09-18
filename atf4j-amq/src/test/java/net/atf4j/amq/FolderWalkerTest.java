package net.atf4j.amq;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FilenameFilter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FolderWalkerTest {
    private static final Logger LOG = LoggerFactory.getLogger(FolderWalkerTest.class);

    public class FolderWalker extends AbstractFolderWalker {

        public class ExtensionFilter implements FilenameFilter {
            private final String extension;

            public ExtensionFilter(final String extension) {
                this.extension = extension;
            }

            @Override
            public boolean accept(final File dir, final String filename) {
                return filename.endsWith(this.extension);
            }
        }

        public FolderWalker() {
            super();
        }

        public FolderWalker(final String path) {
            super(path);
        }
    }

    @Test
    public void testFolderWalker() {
        LOG.info("testFolderWalker");
        final AbstractFolderWalker folderWalker = new FolderWalker();
        assertNotNull(folderWalker);
        folderWalker.walk();
    }

    @Test
    public void testFolderWalkerNull() {
        LOG.info("testFolderWalker");
        final AbstractFolderWalker folderWalker = new FolderWalker(null);
        assertNotNull(folderWalker);
        folderWalker.walk();
    }

    @Test
    public void testFolderWalkerEmpty() {
        LOG.info("testFolderWalker");
        final AbstractFolderWalker folderWalker = new FolderWalker("");
        assertNotNull(folderWalker);
        folderWalker.walk();
    }

    @Test
    public void testFolderWalkerDot() {
        LOG.info("testFolderWalker");
        final AbstractFolderWalker folderWalker = new FolderWalker(".");
        assertNotNull(folderWalker);
        folderWalker.walk();
    }

    @Test
    public void testFolderWalkerString() {
        LOG.info("testFolderWalker");
        final AbstractFolderWalker folderWalker = new FolderWalker("messages");
        assertNotNull(folderWalker);
        folderWalker.walk();
    }

}
