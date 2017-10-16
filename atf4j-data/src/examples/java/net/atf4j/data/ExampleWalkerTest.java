
package net.atf4j.data;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ExampleWalkerTest {

    public class ExampleWalker extends AbstractWalker {
        private ExampleWalker() {
            super("/messages");
        }
    }

    @Test
    public void testAbstractWalker() throws Exception {
        ExampleWalker exampleWalker = new ExampleWalker();
        assertNotNull("unexpected null", exampleWalker);
        assertNotNull("unexpected null", exampleWalker.walk());
    }

}
