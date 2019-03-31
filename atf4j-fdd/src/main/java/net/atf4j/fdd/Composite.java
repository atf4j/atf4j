
package net.atf4j.fdd;

public interface Composite {

    Composite show();

    Composite add(final Composite c);

    Composite remove(final Composite c);

    // Composite getChild();

    // Composite[] getChildren();

}
