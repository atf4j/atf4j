package net.atf4j.annotations;

import static org.junit.Assert.*;

import org.junit.Test;

import net.atf4j.core.LoggedTest;

public class LogTest extends LoggedTest {

    @Test
    public void test() {
        log.info("log.info");
        log.warn("log.warn");
        log.debug("log.debug");
        log.error("log.error");
    }
}
