package net.atf4j.data.jms;

import static org.junit.Assert.*;

import org.junit.Test;

import net.atf4j.data.JmsData;

public class JmsDataTest {

	@Test
	public void testSetUp() {
	    new JmsData().setUp();
	}

	@Test
	public void testReset() {
        new JmsData().reset();
	}

	@Test
	public void testTearDown() {
        new JmsData().tearDown();
	}

	@Test
	public void testJmsData() {
        new JmsData();
	}

}
