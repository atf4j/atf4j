
package net.atf4j.data.manager;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public final class DataManagerTest {

    @Test
    public  void testDefaultConstructor() throws Exception {
        assertNotNull("unexpected null",new DataManager());
    }

    @Test
    public  void testStaticDataForTag() throws Exception {
        DataManager.dataForTag("#Data");
    }
}
