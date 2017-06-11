package net.atf4j.data.manager;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DataManagerTest {

    @Test
    public final void testDefaultConstructor() throws Exception {
        assertNotNull(new DataManager());
    }

    @Test
    public final void testStaticDataForTag() throws Exception {
        DataManager.dataForTag("#Data");
    }
}
