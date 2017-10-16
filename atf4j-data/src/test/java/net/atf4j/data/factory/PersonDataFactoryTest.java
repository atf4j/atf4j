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

package net.atf4j.data.factory;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;
import net.atf4j.data.Person;

/**
 * Unit Test Suite for the PersonDataFactory.
 */
public final class PersonDataFactoryTest extends ResultsReporting {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test method for expected usage.
     */
    @Test
    public void testExpectedUsage() {
        final Person person = PersonDataFactory.create();
        assertNotNull(UNEXPECTED_NULL, person);

        this.log.info("{}", PersonDataFactory.randomForename());
        this.log.info("{}", PersonDataFactory.randomFemaleForename());
        this.log.info("{}", PersonDataFactory.randomMaleForename());

        this.log.info("{}", PersonDataFactory.randomSurname());
        this.log.info("{}", PersonDataFactory.randomSurname());
        this.log.info("{}", PersonDataFactory.randomSurname());

        this.log.info("{}", PersonDataFactory.randomFullname());
        this.log.info("{}", PersonDataFactory.randomFullname());

        this.log.info("{}", PersonDataFactory.randomEmail());
    }

    /**
     * Test default constructor.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDefaultConstructor() throws Exception {
        final PersonDataFactory personDataFactory = new PersonDataFactory();
        assertNotNull(UNEXPECTED_NULL, personDataFactory);
        final String string = personDataFactory.toString();
        this.log.debug("{}", string);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testGetInstance() {
        final AbstractDataFactory personDataFactory = PersonDataFactory.getInstance();
        assertNotNull(UNEXPECTED_NULL, personDataFactory);
        assertNotNull(UNEXPECTED_NULL, personDataFactory.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreate() {
        final Person person = PersonDataFactory.create();
        assertNotNull(UNEXPECTED_NULL, person);
        this.log.info("{}", person.toString());
    }

}
