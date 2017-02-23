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
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */
package net.atf4j.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.Test;

/**
 *
 */
public class UnitTest {

    @Test
    public void test() {
        final URL url = this.getClass().getResource("/log4j.properties");
        final File file = new File(url.getPath());
        if (file.exists()) {
            System.out.print("exists");
        } else {
            System.out.print("try again");
        }
    }

    @Test
    public void newTest() throws IOException {
        final InputStream stream = this.getClass().getResourceAsStream("/filename.txt");
        final InputStreamReader reader = new InputStreamReader(stream);
        final BufferedReader buffered = new BufferedReader(reader);
        final String line = buffered.readLine();
    }

}
