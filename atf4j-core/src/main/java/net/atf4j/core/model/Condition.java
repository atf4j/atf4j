/*
 * 
 */
package net.atf4j.core.model;

/**
 * Condition.
 *
 */
public abstract class Condition {
	/**
	 * isTrue.
	 * 
	 * @return true
	 */
	public boolean isTrue() {
		return true;
	}

	/**
	 * isFalse.
	 * 
	 * @return false.
	 */
	public boolean isFalse() {
		return false;
	}

	/**
	 * test.
	 *
	 * @param condition
	 *            the condition
	 * @return condition status as boolean.
	 */
	public boolean test(final Condition condition) {
		return condition.test(condition);
	}

	// TODO public waitUntilTrue();
	// TODO public waitWhileTrue();

}
