package net.atf4j.amq;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MessageFinderTest {

    @Test
    public void testMessageFinder() {
        MessageFinder folderWalker = new MessageFinder();
        assertNotNull(folderWalker);
        folderWalker.walk();
    }
}
