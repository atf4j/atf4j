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
import java.net.URL;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractWalker Class.
 */
public abstract class AbstractWalker {

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private String basePath;

    /**
     * Instantiates a new abstract walker.
     */
    public AbstractWalker() {
        this.log.info("AbstractWalker()");
    }

    /**
     * Instantiates a new abstract walker.
     * 
     * @param path
     *            the path
     * @throws Exception
     *             the exception
     */
    public AbstractWalker(final String path) throws Exception {
        this.log.info("AbstractWalker({})", path);
        setBasePath(path);
    }

    /**
     * Sets the base path.
     * 
     * @param basePath
     *            the base path
     * @return the abstract walker
     */
    public AbstractWalker setBasePath(final String basePath) {
        this.basePath = basePath;
        return this;
    }

    /**
     * Walk.
     * 
     * @return the abstract walker
     * @throws Exception
     *             the exception
     */
    protected AbstractWalker walk() throws Exception {
        return walk(this.basePath);
    }

    /**
     * Walk.
     * 
     * @param path
     *            the path
     * @return the abstract walker
     * @throws Exception
     *             the exception
     */
    protected AbstractWalker walk(final String path) throws Exception {
        assertNotNull(path);
        this.log.trace("walk({})", path);
        final URL resource = this.getClass().getResource(path);
        this.log.trace("url:{}", resource);
        if (resource != null) {
            final URI uri = resource.toURI();
            if (uri != null) {
                final File root = Paths.get(uri).toFile();
                if (root != null) {
                    final File[] list = root.listFiles();
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
                } else {
                    this.log.trace("root is null");
                }
            } else {
                this.log.trace("url is null");
            }
        } else {
            assertNotNull("No messages found for {}", resource);
        }
        return this;
    }

    /**
     * Process file.
     * 
     * @param file
     *            the file
     * @throws Exception
     *             the exception
     */
    private void processFile(final File file) throws Exception {
        this.log.info("processFile({})", file.getName());
    }

}
