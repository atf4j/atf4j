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

import java.util.ArrayList;
import java.util.Arrays;

import net.atf4j.data.factory.AbstractDataFactory;

/**
 * Lorem Ipsum text generator.
 */
public class LoremIpsum extends AbstractDataFactory {

    private static LoremIpsum instance = null;
    private String[] rows = null;
    private final ArrayList<String> words = new ArrayList<String>();
    private int bounds;

    /**
     * Instantiates a new lorem ipsum.
     */
    public LoremIpsum() {
        super();
        initialise();
    }

    protected void initialise() {
        try {
            this.rows = load("lorem-ipsum.txt");
            for (final String row : this.rows) {
                final String sanitised = row.replace(",", "").replace(".", "").replace("?", "");
                if (sanitised.length() > 0) {
                    final String[] words = sanitised.split("\\W");
                    this.log.debug(Arrays.toString(words));
                    for (final String word : words) {
                        this.words.add(word.trim().toLowerCase());
                    }
                }
            }
            this.bounds = this.words.size();
            this.log.debug(Arrays.toString(this.words.toArray()));
        } catch (final Exception e) {
            this.log.error(e.getMessage());
        }
    }

    /**
     * Gets the single instance of LoremIpsum.
     *
     * @return single instance of LoremIpsum
     */
    public static LoremIpsum getInstance() {
        if (LoremIpsum.instance == null) {
            LoremIpsum.instance = new LoremIpsum();
        }
        return LoremIpsum.instance;
    }

    /**
     * Text.
     *
     * @return the string
     */
    public static String text() {
        return getInstance().getText();
    }

    /**
     * Gets the text.
     *
     * @return the text
     */
    protected String getText() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final String row : this.rows) {
            stringBuilder.append(row);
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public static String paragraph() {
        return getInstance().getParagraphs(1);
    }

    public static String paragraphs(final int count) {
        return getInstance().getParagraphs(count);
    }

    private String getParagraphs(final int count) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            final int length = random.nextInt(12) + 4;
            final String sentences = getSentences(length);
            stringBuilder.append(sentences);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static String sentence() {
        return getInstance().getSentences(1);
    }

    public static String sentences(final int count) {
        return getInstance().getSentences(count);
    }

    private String getSentences(final int count) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            final int length = random.nextInt(12) + 4;
            final String sentence = getInstance().getWords(length);
            stringBuilder.append(sentenceCase(sentence));
        }
        return stringBuilder.toString();
    }

    public static String word() {
        return getInstance().getWords(1);
    }

    public static String words(final int i) {
        return getInstance().getWords(i);
    }

    private String getWords(final int count) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            final int nextInt = random.nextInt(this.bounds);
            final String word = this.words.get(nextInt);
            stringBuilder.append(word);
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    public String sentenceCase(final String original) {
        final char punctuation = '.';
        return String.format("%s%c", Text.capitalise(original), punctuation);
    }

}
