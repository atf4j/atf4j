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

import java.util.Properties;

import net.atf4j.core.Atf4jException;

/**
 * TestStep.
 */
public class TestStep extends TestBase {

	/**
	 * Execute.
	 *
	 * @param context
	 *            the context
	 * @return the test result
	 * @throws Atf4jException
	 *             the atf4j exception
	 * @see net.atf4j.core.model.TestBase#execute(net.atf4j.core.model.TestContext)
	 */
	@Override
	public AbstractTestResult execute(final TestContext context) throws Atf4jException {
		logging(context.toString());
		throw new FailStep("");
	}

	/**
	 * Logging.
	 *
	 * @param string
	 *            the string
	 */
	private void logging(final String string) {
	}

	public Properties execute(final Properties properties) {
		return null;
	}

}
