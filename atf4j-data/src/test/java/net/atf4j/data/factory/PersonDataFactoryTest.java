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

import static net.atf4j.core.Verify.verifyNotNull;

import org.junit.Ignore;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import net.atf4j.data.Person;

/**
 * Unit Test Suite for the PersonDataFactory.
 */
@Slf4j
public final class PersonDataFactoryTest {

    /**
     * Test create.
     */
    @Test
    public void testCreate() {
        final Person person = PersonDataFactory.create();
        log.debug("PersonDataFactory.create() = {}", person);
        verifyNotNull(person);
    }

    /**
     * Test random.
     */
    @Test
    public void testRandom() {
        final Person person = PersonDataFactory.random();
        log.debug("PersonDataFactory.create() = {}", person);
        verifyNotNull(person);
    }

    /**
     * Test method for void.
     */
    @Test
    public void testGetInstance() {
        final AbstractDataFactory personDataFactory = PersonDataFactory.getInstance();
        log.debug("PersonDataFactory.getInstance() = {}", personDataFactory);
        verifyNotNull(personDataFactory);
        verifyNotNull(personDataFactory.toString());
    }

    /**
     * Test example usage.
     */
    @Ignore
    @Test
    public void testExampleUsage() {
        log.info("randomForename() = {}", PersonDataFactory.randomForename());
        log.info("randomMaleForename() = {}", PersonDataFactory.randomMaleForename());
        log.info("randomFemaleForename() = {}", PersonDataFactory.randomFemaleForename());

        log.info("randomSurname() = {}", PersonDataFactory.randomSurname());
        log.info("randomSurname() = {}", PersonDataFactory.randomSurname());

        log.info("randomFullname() = {}", PersonDataFactory.randomFullname());
        log.info("randomFullname() = {}", PersonDataFactory.randomFullname());

        log.info("randomEmail() = {}", PersonDataFactory.randomEmail());
        log.info("randomEmail() = {}", PersonDataFactory.randomEmail());
    }
}
