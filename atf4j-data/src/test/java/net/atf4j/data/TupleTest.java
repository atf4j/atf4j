
package net.atf4j.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

public class TupleTest extends ResultsReporting {

    @Test
    public void testSetGetKey() {
        Tuple<String, String> tuple = new Tuple<String, String>();
        assertNotNull(tuple);
        String key = "key";
        tuple.setKey(key);
        assertEquals(key, tuple.key());
        log.info("{}", tuple);
    }

    @Test
    public void testSetGetValue() {
        Tuple<String, String> tuple = new Tuple<String, String>();
        assertNotNull(tuple);
        String value = "value";
        tuple.setValue(value);
        assertEquals(value, tuple.value());
        log.info("{}", tuple);
    }

}
