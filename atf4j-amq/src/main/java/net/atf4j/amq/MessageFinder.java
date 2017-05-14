package net.atf4j.amq;

import java.io.File;
import java.io.FilenameFilter;

public class MessageFinder extends AbstractFolderWalker {

    private static final String XML_FILE = ".xml";
    private static final String PATH = "messages";

    public class XmlFilter implements FilenameFilter {
        @Override
        public boolean accept(File dir, String filename) {
            log.debug("dir = {}", dir.toString());
            log.debug("filename = {}", filename.toString());
            return filename.endsWith(XML_FILE);
        }
    }

    public MessageFinder() {
        super();
        super.setPath(PATH);
        super.setExtensionFilter(new XmlFilter());
    }

}
