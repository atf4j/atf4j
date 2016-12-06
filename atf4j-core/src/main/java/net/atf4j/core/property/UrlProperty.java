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
package net.atf4j.core.property;

import java.net.URL;

import net.atf4j.core.IConfig;
import net.atf4j.core.Property;

/**
 * The Class UrlProperty.
 */
public class UrlProperty implements IConfig {

	/** The url. */
	private URL url;

	/*
	 * (non-Javadoc)
	 *
	 * @see net.atf4j.core.IConfig#useProperty(java.lang.String)
	 */
	public Property useProperty(final String key) {
		// this.url = new URL();
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.atf4j.core.IConfig#useProperty(java.lang.String,
	 * java.lang.String)
	 */
	public Property useProperty(final String key, final String defaultValue) {
		// this.url = new URL();
		return null;
	}

}
