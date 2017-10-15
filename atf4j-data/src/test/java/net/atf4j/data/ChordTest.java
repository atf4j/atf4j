
package net.atf4j.data;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

public class ChordTest extends ResultsReporting {

    @Test
    public void testSetStem() {
        Chord chord = new Chord();
        assertNotNull(chord);
        log.info("{}", chord);
    }

    @Test
    public void testGetStem() {
        Chord chord = new Chord();
        assertNotNull(chord);
        log.info("{}", chord);
    }

    @Test
    public void testAdd() {
        Chord chord = new Chord();
        assertNotNull(chord);
        log.info("{}", chord);
    }

}
