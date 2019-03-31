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

package net.atf4j.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Text utilities class.
 */
public final class Text {

    /** provides logging. */
    private static final Logger log = LoggerFactory.getLogger(Text.class);

    /** RND constant. */
    private static final Random RND = new Random(System.currentTimeMillis());

    /**
     * Instantiates a new text.
     */
    private Text() {
        super();
    }

    /**
     * A single random lowercase char.
     * Usage:
     * <code>
     * char c = Test.randomChar();
     * char u = Char.toUpper(Test.randomChar());
     * </code>
     *
     * @return the char
     */
    public static char randomChar() {
        return (char) ('a' + RND.nextInt(26));
    }

    /**
     * Random string of specified length.
     *
     * @param length the length
     * @return the string
     */
    public static String randomString(final int length) {
        final StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(randomChar());
        }
        return stringBuffer.toString();
    }

    /**
     * A single random digit.
     *
     * @return the char
     */
    public static char randomDigit() {
        return (char) ('0' + RND.nextInt(9));
    }

    /**
     * Random digits of specified length.
     *
     * @param length the length
     * @return the string
     */
    public static String randomDigits(final int length) {
        final StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(randomDigit());
        }
        return stringBuffer.toString();
    }

    /**
     * Capitalise a string as a proper noun such as Name.
     *
     * @param input as String.
     * @return string input as capitalised String.
     */
    public static String capitalise(final String input) {
        if (input != null) {
            if (input.length() > 0) {
                final String trim = input.trim();
                final String lowerCase = trim.toLowerCase();
                final StringBuffer buffer = new StringBuffer(lowerCase);
                buffer.setCharAt(0, Character.toUpperCase(input.charAt(0)));
                return buffer.toString();
            }
        }
        return "";
    }

    /**
     * Fill a String.
     *
     * @param length the length
     * @return the string
     */
    public static String fill(final int length) {
        return padToLength("", length);
    }

    /**
     * Fill.
     *
     * @param length the length
     * @param chr the chr
     * @return the string
     */
    public static String fill(final int length, final char chr) {
        return padToLength("", length, chr);
    }

    /**
     * Pad to length.
     *
     * @param stem the stem
     * @param length the length
     * @return the string
     */
    public static String padToLength(final String stem, final int length) {
        return padToLength(stem, length, ' ');
    }

    /**
     * Pad to length.
     *
     * @param stem the stem
     * @param length the length
     * @param chr the chr
     * @return the string
     */
    public static String padToLength(final String stem, final int length, final char chr) {
        final StringBuilder builder = new StringBuilder(stem);
        while (builder.length() < length) {
            builder.append(chr);
        }
        return builder.toString();
    }

    /**
     * Join an array of strings.
     *
     * @param strings the strings
     * @param delimiter the delimiter
     * @return the string
     */
    public static String join(final String[] strings, final String delimiter) {
        StringBuffer buffer = new StringBuffer();
        if (strings != null) {
            for (String value : strings) {
                buffer.append(value);
                buffer.append(delimiter);
            }
        }
        return buffer.toString();
    }

    /**
     * Join.
     *
     * @param collection the collection
     * @param delimiter the delimiter
     * @return the string
     */
    public static String join(final Collection<String> collection, final String delimiter) {
        StringBuffer buffer = new StringBuffer();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            buffer.append(it.next());
            if (it.hasNext()) {
                buffer.append(delimiter);
            }
        }
        return buffer.toString();
    }

    /**
     * Repeat a char a specified number of times.
     *
     * @param character the character
     * @param count the count
     * @return the string
     */
    public static String repeat(final char character, final int count) {
        return "";
    }

    /**
     * Repeat a string a specified number of times.
     *
     * @param string the string
     * @param count the count
     * @return the string
     */
    public static String repeat(final String string, final int count) {
        return "";
    }

    /**
     * Replace a marker in template with a replacement string.
     *
     * @param template the template
     * @param marker the marker
     * @param replacement the replacement
     * @return the string
     */
    public static String replace(final String template, final String marker, final String replacement) {
        return "";
    }

    /**
     * String from an Input Stream.
     *
     * @param inputStream the input stream
     * @return the string
     */
    public static String from(final InputStream inputStream) {
        return from(inputStream, Charset.defaultCharset());
    }

    /**
     * String from an Input Stream.
     *
     * @param inputStream the input stream
     * @param charset the charset
     * @return the string
     */
    public static String from(final InputStream inputStream, final Charset charset) {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset))) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (IOException ignore) {
            ignore.printStackTrace(System.err);
            // log.error("{}", ignore);
        }
        return stringBuffer.toString();
    }

    /**
     * String from a File.
     *
     * @param file the file
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static String from(final File file) throws IOException {
        return from(file, Charset.forName("UTF-8"));
    }

    /**
     * String from a File.
     *
     * @param file the file
     * @param charset the charset
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static String from(final File file, final Charset charset) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), charset);
    }

    /**
     * Pretty properties, format the properties to aid clarity.
     *
     * @param properties the properties.
     * @return pretty properties as a string.
     */
    public static String prettyProperties(final String properties) {
        return properties.replace("[", "[\n\t")
                .replace("{", "{\n\t")
                .replace(", ", "\n\t")
                .replace("}", "\n\t}")
                .replace("]", "\n\t]}");
    }

}
