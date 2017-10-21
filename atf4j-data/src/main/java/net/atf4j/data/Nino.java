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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UK National Insurance number, commonly known as Nino.
 * ([0-9]){2}([0-9]){2}([0-9]){2}
 */
public final class Nino {

    /** REGULAR EXPRESSION. */
    private static final Pattern PATTERN = Pattern
        .compile("^[A-CEGHJ-PR-TW-Z]{1}[A-CEGHJ-NPR-TW-Z]{1}[- ]?[0-9]{2}[- ]?[0-9]{2}[- ]?[0-9]{2}[- ]?[A-D]?$");

    private String nino = "";

    /**
     * Create new INSTANCE of create.
     *
     * @return the nino
     */
    public static Nino create() {
        return new Nino();
    }

    /**
     * Instantiates a new national insurance number.
     */
    public Nino() {
        super();
    }

    /**
     * Instantiates a new national insurance number.
     *
     * @param code the code
     */
    public Nino(final String code) {
        super();
        this.nino = code;
    }

    /**
     * Sets the code.
     *
     * @param code the code to set
     * @return the national insurance
     */
    public Nino setCode(final String code) {
        this.nino = code;
        return this;
    }

    /**
     * Verify.
     *
     * @param code the code \* @return true, if successful, otherwise false.
     * @return true, if successful, otherwise false.
     */
    public static boolean verify(final String code) {
        final Matcher matcher = PATTERN.matcher(code);
        return matcher.find();
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return this.nino;
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format("Nino [nino=%s]", this.nino);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.nino;
    }
}
