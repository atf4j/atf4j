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

/**
 * Message Finder class.
 */
public class MessageFinder extends AbstractFolderWalker {

    /**
     * Xml Filter class.
     */
    public class MsgFilter implements FilenameFilter {
        /** Default file extension . */
        private static final String MSG_FILE = ".msg";

        /*
         * (non-Javadoc)
         * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
         */
        @Override
        public boolean accept(final File dir, final String filename) {
            return filename.endsWith(MSG_FILE);
        }
    }

    /**
     * Instantiates a new message finder.
     */
    public MessageFinder() {
        super();
        final FilenameFilter extensionFilter = new MsgFilter();
        super.useExtensionFilter(extensionFilter);
    }

    /**
     * Instantiates a new message finder.
     *
     * @param path the path
     */
    public MessageFinder(final String path) {
        super(path);
    }

    /**
     * Instantiates a new message finder.
     *
     * @param extensionFilter the extension filter
     */
    public MessageFinder(final FilenameFilter extensionFilter) {
        super(extensionFilter);
    }

}
