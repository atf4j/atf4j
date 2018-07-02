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
import java.io.FilenameFilter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import net.atf4j.core.TestResultsReporting;

/**
 * An abstract class to walk folders.
 */
public abstract class AbstractFolderWalker
        extends TestResultsReporting
        implements FolderWalkerInterface {

    /** base path. */
    private String path = "messages";

    /** filename filter. */
    private FilenameFilter filter = new Unfiltered();

    /** list of found files. */
    // private final List<File> foundFiles = new ArrayList<File>();
    private final FoundFiles foundFiles = new FoundFiles();

    /**
     * Unfiltered filename class.
     */
    public class Unfiltered implements FilenameFilter {

        /*
         * (non-Javadoc)
         *
         * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
         */
        @Override
        public boolean accept(final File dir, final String filename) {
            AbstractFolderWalker.this.log.trace("accept({},{})", dir, filename);
            return true;
        }
    }

    /**
     * Instantiates a new abstract folder walker.
     */
    public AbstractFolderWalker() {
        super();
    }

    /**
     * Instantiates a new abstract folder walker.
     *
     * @param path the path
     */
    public AbstractFolderWalker(final String path) {
        super();
        setPath(path);
    }

    /**
     * Instantiates a new abstract folder walker.
     *
     * @param extensionFilter the extension filter
     */
    public AbstractFolderWalker(final FilenameFilter extensionFilter) {
        super();
        useExtensionFilter(extensionFilter);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.amq.FolderWalkerInterface#setPath(java.lang.String)
     */
    @Override
    public FolderWalkerInterface setPath(final String path) {
        this.path = path;
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.amq.FolderWalkerInterface#setExtensionFilter(java.io.
     * FilenameFilter)
     */
    @Override
    public FolderWalkerInterface useExtensionFilter(final FilenameFilter extensionFilter) {
        this.filter = extensionFilter;
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.amq.FolderWalkerInterface#walk()
     */
    @Override
    public FoundFiles walk() {
        return walk(this.path);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.amq.FolderWalkerInterface#walk(java.lang.String)
     */
    @Override
    public FoundFiles walk(final String path) {
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

    @Override
    public FoundFiles scan() {
        return scan(this.path);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.amq.FolderWalkerInterface#scan(java.lang.String)
     */
    @Override
    public FoundFiles scan(final String folder) {
        if (this.path != null) {
            final ClassLoader loader = Thread.currentThread().getContextClassLoader();
            final URL url = loader.getResource(folder);
            final String path = url.getPath();
            final File[] files = new File(path).listFiles(this.filter);
            if (files != null) {
                for (final File file : files) {
                    if (file.isDirectory()) {
                        final String subDir = file.getAbsolutePath();
                        scan(subDir);
                    } else {
                        this.foundFiles.add(file);
                    }
                }
            }
        }
        return this.foundFiles;
    }

    /**
     * File from resource URL.
     *
     * @param path the path
     * @return the file
     */
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

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.amq.FolderWalkerInterface#getPath()
     */
    @Override
    public String getPath() {
        return this.path;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.amq.FolderWalkerInterface#getFoundFiles()
     */
    @Override
    public FoundFiles getFoundFiles() {
        return this.foundFiles;
    }

    @Override
    public String toString() {
        return String.format("%s [path=%s, filter=%s, foundFiles=%s]",
                this.getClass().getSimpleName(),
                this.path,
                this.filter,
                this.foundFiles);
    }

}
