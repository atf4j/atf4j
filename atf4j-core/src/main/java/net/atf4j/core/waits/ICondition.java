/*
 * 
 */
package net.atf4j.core.waits;

/**
 * ICondition.
 */
public interface ICondition {

	/**
	 * asBoolean.
	 * 
	 * @return true, if successful
	 */
	boolean asBoolean();

	/**
	 * test condition is True.
	 *
	 * @return boolean true or false.
	 */
	boolean isTrue();

	/**
	 * test condition is False.
	 *
	 * @return boolean true or false.
	 */
	boolean isFalse();

	/**
	 * toString.
	 *
	 * @return condition as meaningful String.
	 */
	@Override
	String toString();
}
