
package net.atf4j.core;

/**
 * ResourceNotLoadedException.
 */
public class ResourceNotLoadedException extends AssertionError {

    /** serialVersionUID constant. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new resource not found exception.
     *
     * @param message the message
     */
    public ResourceNotLoadedException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new resource not found exception.
     *
     * @param assumption the assumption
     * @param t the t
     */
    public ResourceNotLoadedException(final String assumption, final Throwable t) {
        super(assumption, t);
    }
}
