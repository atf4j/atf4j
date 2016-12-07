package net.atf4j.data.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

import net.atf4j.data.JdbcData;

public class JdbcDataTest {

	@Test
	public void testSetUp() {
	    new JdbcData().setUp();
	}

	@Test
	public void testReset() {
	    new JdbcData().reset();
	}

	@Test
	public void testTearDown() {
        new JdbcData().tearDown();
	}

	@Test
	public void testJdbcData() {
        new JdbcData();
	}
}
