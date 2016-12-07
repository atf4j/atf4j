package net.atf4j.data.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import net.atf4j.data.RestfulData;

public class RestfulDataTest {

	@Test
	public void testSetUp() {
	    new RestfulData().setUp();
	}

	@Test
	public void testReset() {
	    new RestfulData().reset();
	    }

	@Test
	public void testTearDown() {
        new RestfulData().tearDown();
	}

	@Test
	public void testRestfulData() {
        new RestfulData();
	}

}
