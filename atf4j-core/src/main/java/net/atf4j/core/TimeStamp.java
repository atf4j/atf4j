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

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * TimeStamp class.
 */
@Slf4j public final class TimeStamp {

    /** ISO_DATE_TIME format constant. */
    public static final String ISO_DATE_TIME = "yyyy-MM-dd'T'HH:mm'Z'";

    /** Default TIMESTAP_FORMAT with millisec precision. */
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * private constructor to prevent wild instantiation.
     */
    private TimeStamp() {
        super();
    }

    /**
     * Date time.
     *
     * @return the string
     */
    public static String timestamp() {
        return format(TIMESTAMP_FORMAT);
    }

    /**
     * Iso.
     *
     * @return the string
     */
    public static String iso() {
        return format(ISO_DATE_TIME);
    }

    /**
     * TimeStamp in passed format.
     *
     * @param format the format
     * @return the string
     */
    public static String format(final String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

}
