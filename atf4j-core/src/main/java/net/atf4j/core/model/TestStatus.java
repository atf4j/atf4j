/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.core.model;

/**
 * TestStatus.
 */
public enum TestStatus {
	/**
	 * The test has not yet be run.
	 */
	NOT_RUN("NOT RUN"),
	/**
	 * The test has been run and passed.
	 */
	PASSED("PASSED"),
	/**
	 * The test has been run and failed.
	 */
	FAILED("FAILED"),
	/**
	 * The Test failed to complete. Note : Perhaps not necessary, FAILED might
	 * cover
	 */
	EXCEPTION("EXCEPTION");

	private String status;

	TestStatus(final String name) {
		this.status = name;
	}
}
