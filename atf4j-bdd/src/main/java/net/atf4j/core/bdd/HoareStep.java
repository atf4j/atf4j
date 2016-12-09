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
package net.atf4j.core.bdd;

import java.util.Properties;

import net.atf4j.core.Command;

/**
 * HoareStep Class.
 *
 * @author Martin Spamer <Martin@atf4j.net>
 */
public class HoareStep implements Command {

	protected String string;

	/**
	 * Instantiates a new hoare step.
	 */
	public HoareStep() {
	}

	/**
	 * Instantiates a new hoare step.
	 *
	 * @param string
	 *            the string2
	 */
	public HoareStep(final String string) {
	}

	public void execute() {
	}

	public Properties execute(final Properties properties) {
		return properties;
	}

}
