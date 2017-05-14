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
    private List<File> foundFiles = new ArrayList<File>();

    public class Unfiltered implements FilenameFilter {
        @Override
        public boolean accept(File dir, String filename) {
            log.trace("accept({},{})", dir, filename);
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

    public AbstractFolderWalker(FilenameFilter extensionFilter) {
        super();
        setExtensionFilter(extensionFilter);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setExtensionFilter(FilenameFilter extensionFilter) {
        this.filter = extensionFilter;
    }

    public List<File> walk() {
        return walk(this.path);
    }

    public List<File> walk(final String path) {
        if (path != null) {
            File dir = new File(path);
            File[] files = dir.listFiles(filter);
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        String subDir = file.getAbsolutePath();
                        walk(subDir);
                    } else {
                        foundFiles.add(file);
                    }
                }
            }
        }
        return foundFiles;
    }

    public List<File> scan(final String path) {
        File root = new File(path);
        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                String subDir = file.getAbsolutePath();
                log.debug("{}", subDir);
                scan(subDir);
            } else {
                log.debug("{}", file);
                foundFiles.add(file);
            }
        }
        return foundFiles;
    }

    protected File fileFromResourceURL(final String path) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource(path);
        File file = null;
        URI uri;
        try {
            uri = url.toURI();
            file = new File(uri);
        } catch (URISyntaxException e) {
            log.error(e.toString());
        }
        return file;
    }

    public String getPath() {
        return path;
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }

}
