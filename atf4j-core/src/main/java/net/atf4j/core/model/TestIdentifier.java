/*
 * 
 */
package net.atf4j.core.model;

import java.util.UUID;

/**
 * Unique TestIdentifier TODO : Make serializable?.
 */
public class TestIdentifier {

	/** The uuid. */
	private UUID uuid;

	/**
	 * create.
	 */
	public void create() {
		this.uuid = UUID.randomUUID();
	}

	/**
	 * return the UUID as a String.
	 *
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.uuid.toString();
	}

	/**
	 * Gets the uuid.
	 *
	 * @return the uuid
	 */
	public UUID getUuid() {
		return this.uuid;
	}

	/**
	 * Sets the uuid.
	 *
	 * @param uuidIn
	 *            the new uuid
	 */
	public void setUuid(final UUID uuidIn) {
		this.uuid = uuidIn;
	}
}
