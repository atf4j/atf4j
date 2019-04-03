
package net.atf4j.fdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class AbstractComposite.
 */
public class AbstractComposite implements Composite {

    /** The map. */
    private final Map<String, Composite> map = new HashMap<String, Composite>();
    
    /** The children. */
    private final List<Composite> children = new ArrayList<Composite>();

    /* (non-Javadoc)
    * @see net.atf4j.fdd.Composite#show()
    */
    @Override
    public Composite show() {
        for (Composite child : this.children) {
            child.show();
        }
        return this;
    }

    /* (non-Javadoc)
    * @see net.atf4j.fdd.Composite#add(net.atf4j.fdd.Composite)
    */
    @Override
    public Composite add(final Composite c) {
        this.children.add(c);
        return this;
    }

    /* (non-Javadoc)
    * @see net.atf4j.fdd.Composite#remove(net.atf4j.fdd.Composite)
    */
    @Override
    public Composite remove(final Composite c) {
        this.children.remove(c);
        return this;
    }

}
