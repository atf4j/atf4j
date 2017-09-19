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
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract Folder Walker class.
 */
public abstract class AbstractFolderWalker {

    protected final Logger log = LoggerFactory.getLogger(AbstractFolderWalker.class);
    private String path;
    private FilenameFilter filter = new Unfiltered();
    private final List<File> foundFiles = new ArrayList<File>();

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
        setPath("./");
    }

    /**
     * Instantiates a new abstract folder walker.
     *
     * @param path
     *            the path
     */
    public AbstractFolderWalker(final String path) {
        super();
        setPath(path);
    }

    /**
     * Instantiates a new abstract folder walker.
     *
     * @param extensionFilter
     *            the extension filter
     */
    public AbstractFolderWalker(final FilenameFilter extensionFilter) {
        super();
        setExtensionFilter(extensionFilter);
    }

    /**
     * Sets the path.
     *
     * @param path
     *            the new path
     */
    public void setPath(final String path) {
        this.path = path;
    }

    /**
     * Sets the extension filter.
     *
     * @param extensionFilter
     *            the new extension filter
     */
    public void setExtensionFilter(final FilenameFilter extensionFilter) {
        this.filter = extensionFilter;
    }

    /**
     * Walk.
     *
     * @return the list
     */
    public List<File> walk() {
        return walk(this.path);
    }

    /**
     * Walk the path.
     *
     * @param path
     *            the path
     * @return the list
     */
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

    /**
     * Scan the path.
     *
     * @param path
     *            the path
     * @return the list
     */
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

    /**
     * File from resource URL.
     *
     * @param path
     *            the path
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

    /**
     * Gets the path.
     *
     * @return the path
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Gets the found files.
     *
     * @return the found files
     */
    public List<File> getFoundFiles() {
        return this.foundFiles;
    }
}
