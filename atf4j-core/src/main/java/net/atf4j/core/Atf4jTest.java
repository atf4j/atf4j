package net.atf4j.core;

import org.junit.Test;

public class Atf4jTest {

    @Test
    public void testStartEnd() {
        Atf4j.start();
        Atf4j.end();
    }

    @Test
    public void testDocument() {
        Atf4j.document();
    }

}