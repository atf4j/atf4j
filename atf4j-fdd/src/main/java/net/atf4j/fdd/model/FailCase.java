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

package net.atf4j.fdd.model;

/**
 * FailCase.
 */
public class FailCase extends FailStep {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6599571781425333411L;

    /**
     * Instantiates a new fail case.
     */
    public FailCase() {
        super();
    }

    /**
     * Instantiates a new fail case.
     *
     * @param message the message
     */
    public FailCase(final String message) {
        super(message);
    }

}
