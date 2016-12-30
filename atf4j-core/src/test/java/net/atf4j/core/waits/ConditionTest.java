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
package net.atf4j.core.waits;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;
import net.atf4j.core.model.Condition;

/**
 * A UnitTest for Condition objects.
 */
public class ConditionTest extends ResultsReporting {

    /**
     * The PassingCondition Class.
     */
    public class PassingCondition extends Condition {
    }

    /**
     * The FailingCondition Class.
     */
    public class FailingCondition extends Condition {
    }

    /**
     * Passing condition.
     */
    @Test
    public void PassingCondition() {
        new PassingCondition();
    }

    /**
     * Test method for {@link Condition}.
     */
    @Test
    public void testFailingCondition() {
        new FailingCondition();
    }

}
