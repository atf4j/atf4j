package net.atf4j.core;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class Atf4jTest {

    @Test
    public void testStartEnd() {
        Atf4j.start();
        assertNotNull(this);
        Atf4j.end();
    }

    @Test
    public void testDocument() {
        Atf4j.start();
        Atf4j.document();
        Atf4j.end();
    }

}
