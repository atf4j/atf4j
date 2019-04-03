
package net.atf4j.fdd;

/**
 * The Interface Composite.
 */
public interface Composite {

    /**
     * Show.
     *
     * @return the composite
     */
    Composite show();

    /**
     * Adds the.
     *
     * @param c the c
     * @return the composite
     */
    Composite add(final Composite c);

    /**
     * Removes the.
     *
     * @param c the c
     * @return the composite
     */
    Composite remove(final Composite c);

    // Composite getChild();

    // Composite[] getChildren();

}
