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

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractWalker Class.
 */
public abstract class AbstractWalker {

    private static final String UNEXPECTED_NULL = "unexpected null";
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private String basePath = ".";

    /**
     * Instantiates a new abstract walker.
     */
    public AbstractWalker() {
        super();
        this.log.info("AbstractWalker()");
    }

    /**
     * Instantiates a new abstract walker.
     *
     * @param basePath the path
     * @throws Exception the exception
     */
    public AbstractWalker(final String basePath) {
        super();
        this.log.info("AbstractWalker({})", basePath);
        setBasePath(basePath);
    }

    /**
     * Sets the base path.
     *
     * @param basePath the base path
     * @return the abstract walker
     */
    public AbstractWalker setBasePath(final String basePath) {
        this.basePath = basePath;
        return this;
    }

    /**
     * Walk the folders under the base path.
     *
     * @return the abstract walker
     */
    protected AbstractWalker walk() {
        return walk(this.basePath);
    }

    /**
     * Walk the folders under the path.
     *
     * @param path the path
     * @return the abstract walker
     */
    protected AbstractWalker walk(final String path) {
        assertNotNull(UNEXPECTED_NULL, path);
        this.log.trace("walk({})", path);
        final URL resource = this.getClass().getResource(path);
        walk(resource);
        return this;
    }

    private void walk(final URL url) {
        assertNotNull(UNEXPECTED_NULL, url);
        this.log.trace("url:{}", url);
        if (url != null) {
            URI uri;
            try {
                uri = url.toURI();
                walk(uri);
            } catch (URISyntaxException e) {
                log.error("{}", e.getLocalizedMessage());
            }
        }
    }

    private void walk(URI uri) {
        if (uri != null) {
            final File root = Paths.get(uri).toFile();
            walk(root);
        } else {
            this.log.trace("url is null");
        }
    }

    private void walk(final File root) {
        if (root != null) {
            final File[] list = root.listFiles();
            walk(list);
        } else {
            this.log.trace("root is null");
        }
    }

    private void walk(final File[] list) {
        if (list != null) {
            this.log.trace("length:{}", list.length);
            for (final File file : list) {
                if (file.isDirectory()) {
                    walk(file.getAbsolutePath());
                } else {
                    processFile(file);
                }
            }
        } else {
            this.log.trace("listFiles is null");
        }
    }

    /**
     * Process file.
     *
     * @param file the file
     */
    private void processFile(final File file) {
        this.log.info("processFile({})", file.getName());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("AbstractWalker [basePath=%s]", basePath);
    }

}
