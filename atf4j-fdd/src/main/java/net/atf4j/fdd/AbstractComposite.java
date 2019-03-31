
package net.atf4j.fdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractComposite implements Composite {

    private final Map<String, Composite> map = new HashMap<String, Composite>();
    private final List<Composite> children = new ArrayList<Composite>();

    @Override
    public Composite show() {
        for (Composite child : this.children) {
            child.show();
        }
        return this;
    }

    @Override
    public Composite add(final Composite c) {
        this.children.add(c);
        return this;
    }

    @Override
    public Composite remove(final Composite c) {
        this.children.remove(c);
        return this;
    }

}
