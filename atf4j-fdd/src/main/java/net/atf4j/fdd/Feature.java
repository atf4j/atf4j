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

package net.atf4j.fdd;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Atf4j Interface Annotations for Behaviour Driven Development.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Feature {

    /**
     * The Behaviour Interface.
     */
    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Behaviour {
        /**
         * Value.
         *
         * @return the string
         */
        String value();
    }

    /**
     * The Scenario Interface.
     */
    @Documented
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Scenario {
        /**
         * Value.
         *
         * @return the string
         */
        String value();
    }

    /**
     * The Given Interface.
     */
    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Given {
        /**
         * Value.
         *
         * @return the string
         */
        String value();
    }

    /**
     * The When Interface.
     */
    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface When {
        /**
         * Value.
         *
         * @return the string
         */
        String value();
    }

    /**
     * The Then Interface.
     */
    @Documented
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Then {
        /**
         * Value.
         *
         * @return the string
         */
        String value();
    }

}
