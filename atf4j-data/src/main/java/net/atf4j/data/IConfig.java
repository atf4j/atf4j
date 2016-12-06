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
package net.atf4j.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * IConfig.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public interface IConfig {

	/**
	 * properties.
	 * 
	 * @param propertiesIn
	 *            as Properties object.
	 */
	public abstract void properties(Properties propertiesIn);

	/**
	 * load.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public abstract void load() throws Exception;

	/**
	 * load.
	 * 
	 * @param propertiesFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public abstract void load(String propertiesFile) throws Exception;

	/**
	 * load.
	 * 
	 * @param propertiesFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public abstract void load(File propertiesFile) throws Exception;

}
