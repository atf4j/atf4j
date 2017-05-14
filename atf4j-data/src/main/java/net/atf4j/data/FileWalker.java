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
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The FileWalker Class.
 */
public class FileWalker extends AbstractWalker {

    /**
     * Instantiates a new file walker.
     */
    public FileWalker() {
        super();
        this.log.info("FileWalker()");
    }

    /**
     * Instantiates a new file walker.
     * @param path the path
     * @throws Exception the exception
     */
    public FileWalker(final String path) throws Exception {
        super();
        this.log.info("FileWalker({})", path);
        setBasePath(path);
    }

    /**
     * Process file.
     * @param f the f
     * @throws Exception the exception
     */
    private void processFile(final File f) throws Exception {
        final File absoluteFile = f.getAbsoluteFile();
        this.log.info("FILE:{}", absoluteFile);
        final String string = readFile(absoluteFile.getPath());
        this.log.info("{}", string);
    }

    /**
     * Read file.
     * @param filename the filename
     * @return the string
     * @throws Exception the exception
     */
    String readFile(final String filename) throws Exception {
        final byte[] encoded = Files.readAllBytes(Paths.get(filename));
        return new String(encoded, Charset.defaultCharset());
    }
}
