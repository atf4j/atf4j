
package net.atf4j.data;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

public class TupleTest extends ResultsReporting {

    @Test
    public void testSetKey() {
        Tuple<String, String> tuple = new Tuple<String, String>();
        assertNotNull(tuple);
        log.info("{}", tuple);
    }

    @Test
    public void testSetValue() {
        Tuple<String, String> tuple = new Tuple<String, String>();
        assertNotNull(tuple);
        log.info("{}", tuple);
    }

    @Test
    public void testKey() {
        Tuple<String, String> tuple = new Tuple<String, String>();
        assertNotNull(tuple);
        log.info("{}", tuple);
    }

    @Test
    public void testValue() {
        Tuple<String, String> tuple = new Tuple<String, String>();
        assertNotNull(tuple);
        log.info("{}", tuple);
    }

}
