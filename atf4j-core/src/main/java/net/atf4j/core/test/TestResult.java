/*
 * 
 */
package net.atf4j.core.test;

/**
 * TestResult.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 * @version $Revision: 1.0 $
 */
public enum TestResult {

	/** The passed. */
	PASSED(true, "PASSED"),
	/** The failed. */
	FAILED(false, "FAILED");

	/** The status. */
	private boolean status;

	/** The value. */
	private String value;

	/**
	 * Instantiates a new test result.
	 *
	 * @param booleanStatus
	 *            the boolean status
	 * @param stringValue
	 *            the string value
	 */
	TestResult(final Boolean booleanStatus, final String stringValue) {
		this.status = booleanStatus;
		this.value = stringValue;
	}

	/**
	 * To boolean.
	 *
	 * @return the boolean
	 */
	public Boolean toBoolean() {
		return this.status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.value;
	}

	/**
	 * From value.
	 *
	 * @param valueFor
	 *            the value for
	 * @return the test result
	 */
	public static TestResult fromValue(final String valueFor) {
		for (TestResult testResult : TestResult.values()) {
			if (testResult.value.equals(valueFor)) {
				return testResult;
			}
		}
		throw new IllegalArgumentException(valueFor);
	}
}
