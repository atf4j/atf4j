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

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * AbstractDataLoader.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public abstract class AbstractDataLoader {
	
	/** The Constant BUFFER_SIZE. */
	private static final int BUFFER_SIZE = 4096;

	/**
	 * Load.
	 *
	 * @return the object
	 * @throws Exception the exception
	 */
	public Object load() throws Exception {
		final String dataFilename = this.getClass().getSimpleName() + ".csv";
		return load(dataFilename);
	}

	/**
	 * Load.
	 *
	 * @param dataFilename the data filename
	 * @return the object
	 * @throws Exception the exception
	 */
	public Object load(final String dataFilename) throws Exception {
		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream in = classLoader.getResourceAsStream(dataFilename);
		return load(in);
	}

	/**
	 * Load.
	 *
	 * @param in the in
	 * @return the byte[]
	 * @throws Exception the exception
	 */
	public byte[] load(final InputStream in) throws Exception {
		InputStreamReader inputStreamReader = new InputStreamReader(in);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] buf = new byte[BUFFER_SIZE];
		while(true) {
		  int n = in.read(buf);
		  if( n < 0 ) break;
		  byteArrayOutputStream.write(buf,0,n);
		}
		inputStreamReader.close();

		return byteArrayOutputStream.toByteArray();
		}

}
