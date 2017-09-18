package net.atf4j.amq;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractFolderWalker {
    protected final Logger log = LoggerFactory.getLogger(AbstractFolderWalker.class);
    private String path;
    private FilenameFilter filter = new Unfiltered();
    private final List<File> foundFiles = new ArrayList<File>();

    public class Unfiltered implements FilenameFilter {
        @Override
        public boolean accept(final File dir, final String filename) {
            AbstractFolderWalker.this.log.trace("accept({},{})", dir, filename);
            return true;
        }
    }

    public AbstractFolderWalker() {
        super();
        setPath("./");
    }

    public AbstractFolderWalker(final String path) {
        super();
        setPath(path);
    }

    public AbstractFolderWalker(final FilenameFilter extensionFilter) {
        super();
        setExtensionFilter(extensionFilter);
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public void setExtensionFilter(final FilenameFilter extensionFilter) {
        this.filter = extensionFilter;
    }

    public List<File> walk() {
        return walk(this.path);
    }

    public List<File> walk(final String path) {
        if (path != null) {
            final File dir = new File(path);
            final File[] files = dir.listFiles(this.filter);
            if (files != null) {
                for (final File file : files) {
                    if (file.isDirectory()) {
                        final String subDir = file.getAbsolutePath();
                        walk(subDir);
                    } else {
                        this.foundFiles.add(file);
                    }
                }
            }
        }
        return this.foundFiles;
    }

    public List<File> scan(final String path) {
        final File root = new File(path);
        for (final File file : root.listFiles()) {
            if (file.isDirectory()) {
                final String subDir = file.getAbsolutePath();
                this.log.debug("{}", subDir);
                scan(subDir);
            } else {
                this.log.debug("{}", file);
                this.foundFiles.add(file);
            }
        }
        return this.foundFiles;
    }

    protected File fileFromResourceURL(final String path) {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        final URL url = classLoader.getResource(path);
        File file = null;
        URI uri;
        try {
            uri = url.toURI();
            file = new File(uri);
        } catch (final URISyntaxException e) {
            this.log.error(e.toString());
        }
        return file;
    }

    public String getPath() {
        return this.path;
    }

    public List<File> getFoundFiles() {
        return this.foundFiles;
    }

}
