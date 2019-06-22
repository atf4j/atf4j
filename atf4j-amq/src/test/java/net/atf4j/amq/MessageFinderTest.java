
package net.atf4j.amq;

import static net.atf4j.core.Verify.verifyNotNull;

import java.io.File;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageFinderTest {

    @Test
    public void testMessageFinder() {
        verifyNotNull(new MessageFinder());
    }

    @Test
    public void testMessageFinderXML() {
        verifyNotNull(new MessageFinder("XML"));
    }

    /**
     * Unit tests for the messageFinderWalk() method of MessageFinder object.
     */
    @Test
    public void testMessageFinderWalk() {
        final FoundFiles messages = new XmlMessageFinder().walk();
        verifyNotNull(messages);
        for (final File file : messages) {
            log.info("{} = {}", file.getName(), file.toString());
        }
    }

    /**
     * Unit tests for the messageFinderScan() method of MessageFinder object.
     */
    @Test
    public void testMessageFinderScan() {
        final FoundFiles messages = new XmlMessageFinder().scan();
        verifyNotNull(messages);
        for (final File file : messages) {
            log.info("{} = {}", file.getName(), file.toString());
        }
    }
}
