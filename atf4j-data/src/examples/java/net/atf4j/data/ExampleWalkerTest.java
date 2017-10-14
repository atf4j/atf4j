
package net.atf4j.data;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ExampleWalkerTest {

    public class ExampleWalker extends AbstractWalker {
    }

    @Test
    public void testAbstractWalker() throws Exception {
        ExampleWalker exampleWalker = new ExampleWalker();
        assertNotNull(exampleWalker);
        exampleWalker.walk();
    }

}
