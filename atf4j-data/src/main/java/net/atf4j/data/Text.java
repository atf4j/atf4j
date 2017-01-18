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

/**
 * The Text Class.
 */
public class Text {

    /**
     * Capitalise as Name.
     *
     * @param input
     *            as String.
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
     * Fill.
     *
     * @param string the string
     * @param i the i
     * @return the string
     */
    public static String fill(final String string, final int i) {
        return "";
    }

    /**
     * Fill.
     *
     * @param i the i
     * @return the string
     */
    public static String fill(final int i) {
        return "";
    }

    /**
     * Paragraph.
     *
     * @param i the i
     * @return the string
     */
    public static String paragraph(final int i) {
        return "";
    }

    /**
     * Sentence.
     *
     * @param i the i
     * @return the string
     */
    public static String sentence(final int i) {
        return "";
    }

    /**
     * Words.
     *
     * @param i the i
     * @return the string
     */
    public static String words(final int i) {
        return "";
    }

}
