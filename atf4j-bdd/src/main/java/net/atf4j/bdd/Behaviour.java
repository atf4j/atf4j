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

package net.atf4j.bdd;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Behaviour, this is essential a Hoare triple.
 *
 * Given Predicate; And more Predicates... When Event(s) occur; Then
 * PostCondition are confirmed; And moe PostConditions are confirmed.
 */
public abstract class Behaviour {

    private static final String UNEXPECTED_NULL = "unexpected null";
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The given situation. */
    private final List<Given> givenList = new ArrayList<Given>();

    /** The when and Event occurs. */
    private final List<When> whenList = new ArrayList<When>();

    /** The then Expectation is confirmed. */
    private final List<Then> thenList = new ArrayList<Then>();

    /**
     * given.
     *
     * @param given the given
     * @return the behaviour
     */
    protected Behaviour given(final Given given) {
        this.log.info("{}.given", this.getClass().getSimpleName());
        this.givenList.add(given);
        return this;
    }

    /**
     * when.
     *
     * @param when the when
     * @return the behaviour
     */
    protected Behaviour when(final When when) {
        this.log.info("{}.given", this.getClass().getSimpleName());
        this.whenList.add(when);
        return this;
    }

    /**
     * then.
     *
     * @param then the then
     * @return the behaviour
     */
    protected Behaviour then(final Then then) {
        this.log.info("{}.given", this.getClass().getSimpleName());
        this.thenList.add(then);
        return this;
    }

    /**
     * Execute.
     *
     * @param properties the properties
     * @return the properties
     */
    public Properties execute(final Properties properties) {
        this.log.info("{}.execute", this.getClass().getSimpleName());
        for (final Given given : this.givenList) {
            Properties execute = given.execute(properties);
            assertNotNull(UNEXPECTED_NULL, execute);
        }

        for (final When when : this.whenList) {
            Properties execute = when.execute(properties);
            assertNotNull(UNEXPECTED_NULL, execute);
        }

        for (final Then then : this.thenList) {
            Properties execute = then.execute(properties);
            assertNotNull(UNEXPECTED_NULL, execute);
        }

        return properties;
    }

}
