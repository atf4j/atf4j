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

import java.io.FilenameFilter;

/**
 * The FolderWalkerInterface.
 */
public interface FolderWalkerInterface {

    /**
     * Sets the path.
     *
     * @param path the new path
     */
    FolderWalkerInterface setPath(final String path);

    /**
     * Sets the extension filter.
     *
     * @param extensionFilter the new extension filter
     */
    FolderWalkerInterface useExtensionFilter(final FilenameFilter extensionFilter);

    /**
     * Walk.
     *
     * @return the list
     */
    FoundFiles walk();

    /**
     * Walk the path.
     *
     * @param path the path
     * @return the list
     */
    FoundFiles walk(final String path);

    /**
     * Scan the home folder downwards.
     *
     * @return the found files
     */
    FoundFiles scan();

    /**
     * Scan the path downwards.
     *
     * @param path the path
     * @return the list
     */
    FoundFiles scan(final String path);

    /**
     * Gets the path.
     *
     * @return the path
     */
    String getPath();

    /**
     * Gets the found files.
     *
     * @return the found files
     */
    FoundFiles getFoundFiles();

}
