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

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import lombok.extern.slf4j.Slf4j;

/**
 * FileWalker Class.
 */
@Slf4j
public class FileWalker extends AbstractFolderWalker {

    /**
     * Instantiates a new file walker.
     */
    public FileWalker() {
        super();
        log.debug("FileWalker()");
    }

    /**
     * Instantiates a new file walker.
     *
     * @param path the path
     * @throws Exception the exception
     */
    public FileWalker(final String path) throws Exception {
        super();
        log.debug("FileWalker({})", path);
        setBasePath(path);
    }

    /**
     * Process file.
     *
     * @param f the f
     */
    @Override
    protected void processFile(final File f) {
        try {
            final File absoluteFile = f.getAbsoluteFile();
            log.trace("FILE:{}", absoluteFile);
            final String string = readFile(absoluteFile.getPath());
            log.debug("path = {}", string);
        } catch (final IOException e) {
            log.error(e.toString());
        }
    }

    /**
     * Read file.
     *
     * @param filename the filename
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected String readFile(final String filename) throws IOException {
        final byte[] encoded = Files.readAllBytes(Paths.get(filename));
        return new String(encoded, Charset.defaultCharset());
    }
}
