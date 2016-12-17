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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * NationalInsurance.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class NationalInsurance {

    /** The Constant pattern. */
    private static final Pattern pattern = Pattern.compile("");

    /** The code. */
    private String code;

    /**
     * Instantiates a new national insurance number.
     */
    public NationalInsurance() {
        super();
    }

    /**
     * Instantiates a new national insurance number.
     *
     * @param code
     *            the code
     */
    public NationalInsurance(final String code) {
        super();
        this.code = code;
    }

    /**
     * Verify.
     *
     * @param code
     *            the code
     * @return true, if successful
     */
    public static boolean verify(final String code) {
        final Matcher matcher = pattern.matcher(code);
        return matcher.find();
    }

    /**
     * @return the code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @param code
     *            the code to set
     * @return
     */
    public NationalInsurance setCode(final String code) {
        this.code = code;
        return this;
    }

}
