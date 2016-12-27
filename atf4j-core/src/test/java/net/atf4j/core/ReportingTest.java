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
package net.atf4j.core;

import org.junit.Test;

public class ReportingTest extends Reporting {

    @Test
    public void testVerify() {
        super.verify(1, 1);
    }

    @Test(expected = AssertionError.class)
    public void testVerifyNotEqual() {
        super.verify(new Object(), new Object());
    }

    @Test
    public void testVerifyEqual() {
        final Object expected = new Object();
        super.verify(expected, expected);
    }

    @Test
    public void testToDescription() throws ClassNotFoundException {
        this.log.info(super.toDescription());
    }

}
