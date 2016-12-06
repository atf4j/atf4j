/*
 * 
 */
package net.atf4j.core.waits;

/**
 * WaitCondition.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class WaitCondition extends AbstractCondition {
	/**
	 * WaitCondition constructor.
	 * 
	 * @param useValue
	 *            as test condition value.
	 */
	public WaitCondition(final boolean useValue) {
		super(useValue);
	}

}
