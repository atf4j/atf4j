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
package net.atf4j.data.factory;

import java.io.IOException;
import java.util.Enumeration;

import net.atf4j.core.AbstractConfig;
import net.atf4j.data.CsvFile;

public class AbstractDataFactory extends AbstractConfig {

	public AbstractDataFactory() throws Exception {
		super();
		loadData();
	}

	protected void loadData() throws Exception {
		final Enumeration<Object> keys = this.properties.keys();
		while (keys.hasMoreElements()) {
			final String key = (String) keys.nextElement();
			if (key.startsWith("datafile.")) {
				final String dataFilename = this.properties.getProperty(key);
				loadData(dataFilename);
			}
		}
	}

	private void loadData(final String dataFilename) throws Exception {
		try {
			final CsvFile dataFile = new CsvFile(dataFilename);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

}
