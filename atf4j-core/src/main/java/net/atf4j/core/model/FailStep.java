/*
 * 
 */
package net.atf4j.core.model;

import net.atf4j.core.Atf4jException;

/**
 * FailTestStep.
 */
public class FailStep extends Atf4jException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 373193371915440744L;

	/**
	 * Instantiates a new fail step.
	 *
	 * @param message
	 *            the message
	 */
	public FailStep(final String message) {
		super(message);
	}
}
