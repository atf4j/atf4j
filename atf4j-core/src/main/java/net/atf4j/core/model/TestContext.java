/*
 * 
 */
package net.atf4j.core.model;

/**
 * The Class TestContext.
 */
public class TestContext {

	/** The platform. */
	String platform;

	/** The context. */
	String context;

	/**
	 * Gets the platform.
	 *
	 * @return the platform
	 */
	public String getPlatform() {
		return this.platform;
	}

	/**
	 * Sets the platform.
	 *
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(final String platform) {
		this.platform = platform;
	}

	/**
	 * (non-Javadoc).
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestContext [platform=" + this.platform + ", context=" + this.context + "]";
	}

}
