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

public class FileWalker {

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public void walk(final String path) throws URISyntaxException {
        assertNotNull(path);
        this.log.info("{}", path);
        final URL resource = this.getClass().getResource(path);

        if (resource != null) {
            final URI uri = resource.toURI();
            if (uri != null) {
                final File root = Paths.get(uri).toFile();
                if (root != null) {
                    final File[] list = root.listFiles();

                    if (list != null) {
                        this.log.info("length={}", list.length);
                        for (final File f : list) {
                            processFile(f);
                        }
                        this.log.info("end");
                    } else {
                        assertNotNull("listFiles is null");
                    }
                } else {
                    assertNotNull("root is null");
                }
            } else {
                assertNotNull("url is null");
            }
        } else {
            assertNotNull("No messages found {}", resource);
        }
    }

    private void processFile(final File f) throws URISyntaxException {
        if (f.isDirectory()) {
            this.log.info("DIR :{}", f.getAbsoluteFile());
            walk(f.getAbsolutePath());
        } else {
            this.log.info("FILE:{}", f.getAbsoluteFile());
        }
    }
}
