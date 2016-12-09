/*
 * 
 */
package net.atf4j.core.bdd;

/**
 * Hoare post condition as Then.
 */
public class Then extends PostCondition {
	/**
	 * Instantiates a new Hoare post condition as Then.
	 */
	public Then() {
		super();
	}

	/**
	 * Then.
	 *
	 * @param string
	 *            the string
	 */
	public Then(final String string) {
		super(string);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.atf4j.core.bdd.HoareStep#execute()
	 */
	@Override
	public void execute() {
		super.execute();
	}

}
