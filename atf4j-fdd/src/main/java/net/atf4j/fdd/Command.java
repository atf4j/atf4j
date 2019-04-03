
package net.atf4j.fdd;

/**
 * The Interface Command.
 */
public interface Command {

    /**
     * Execute.
     *
     * @param context the context
     * @return the context
     */
    Context execute(final Context context);

}
