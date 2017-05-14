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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import net.atf4j.core.ResultsReporting;
import net.atf4j.data.Bank;
import net.atf4j.data.Business;
import net.atf4j.data.Card;
import net.atf4j.data.Consumer;
import net.atf4j.data.Customer;
import net.atf4j.data.Person;
import net.atf4j.data.PostalAddress;

/**
 * A UnitTest for DataFactory objects.
 */
public class DataFactoryTest extends ResultsReporting {

    /**
     * Test method for expected usage.
     */
    @Test
    public void testExpectedUsage() {
        this.log.info("DataFactory.today() = {}", DataFactory.format(DataFactory.today()));
        this.log.info("DataFactory.dateOfBirth() = {}", DataFactory.format(DataFactory.dateOfBirth()));
        this.log.info("DataFactory.dobOver18() = {}", DataFactory.format(DataFactory.dobOver18()));
        this.log.info("DataFactory.dobUnder18() = {}", DataFactory.format(DataFactory.dobUnder18()));
        this.log.info("DataFactory.futureDate() = {}", DataFactory.format(DataFactory.futureDate()));
        this.log.info("DataFactory.pastDate() = {}", DataFactory.format(DataFactory.pastDate()));
    }

    /**
     * Test random string creation.
     *
     * @throws Exception the exception
     */
    @Test
    public final void testString() throws Exception {
        this.log.info("DataFactory.randomChar() = {}", DataFactory.randomChar());
        this.log.info("DataFactory.randomString(10) = {}", DataFactory.randomString(10));
    }

    /**
     * Test random numeric string creation.
     *
     * @throws Exception the exception
     */
    @Test
    public final void testDigits() throws Exception {
        this.log.info("DataFactory.randomDigit() = {}", DataFactory.randomDigit());
        this.log.info("DataFactory.randomDigits(10) = {}", DataFactory.randomDigits(10));
    }

    /**
     * Test default constructor.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testDefaultConstructor() throws Exception {
        assertNotNull(new DataFactory());
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testToday() throws Exception {
        final Calendar today = DataFactory.today();
        assertNotNull(today);
        verifyDateData(today);
    }

    /**
     * Test method for DataFactory}.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testThisMonth() throws Exception {
        final int thisMonth = DataFactory.thisMonth();
        assertTrue(thisMonth >= 0 && thisMonth <= 11);
    }

    /**
     * Test method for DataFactory}.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testThisYear() throws Exception {
        final int thisYear = DataFactory.thisYear();
        assertNotEquals(0, thisYear);
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testPastDate() throws Exception {
        final Calendar pastDate = DataFactory.pastDate();
        verifyDateData(pastDate);
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testFutureDate() throws Exception {
        final Calendar futureDate = DataFactory.futureDate();
        verifyDateData(futureDate);
    }

    /**
     * Test method for void.
     *
     * @throws Exception
     *             the exception
     */
    public final void testDateBetween() throws Exception {
        final Calendar futureDate = DataFactory.dateBetween(DataFactory.pastDate(), DataFactory.today());
        verifyDateData(futureDate);
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testDateOfBirth() throws Exception {
        final Calendar dateOfBirth = DataFactory.dateOfBirth();
        verifyDateData(dateOfBirth);
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testOver18() throws Exception {
        final Calendar dobOver18 = DataFactory.dobOver18();
        verifyDateData(dobOver18);
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testUnder18() throws Exception {
        final Calendar dobUnder18 = DataFactory.dobUnder18();
        verifyDateData(dobUnder18);
    }

    /**
     * Verify DataFactory object.
     *
     * @param dateData
     *            the date data
     */
    private void verifyDateData(final Calendar dateData) {
        assertNotNull(dateData);
        this.log.info("verifyDateData({})", dateData.toString());
        final String fromCalendar = DataFactory.format(dateData);
        final String fromDate = DataFactory.format(dateData.getTime());
        assertNotNull(fromCalendar);
        assertNotNull(fromDate);
        assertEquals(fromCalendar, fromDate);
    }

    /**
     * Unit Test for test create person.
     */
    @Test
    public void testCreatePerson() {
        final Person person = DataFactory.createPerson();
        assertNotNull(person);
        this.log.info(person.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateCustomer() {
        final Customer customer = DataFactory.createCustomer();
        assertNotNull(customer);
        this.log.info(customer.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateConsumer() {
        final Consumer consumer = DataFactory.createConsumer();
        assertNotNull(consumer);
        this.log.info(consumer.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateCard() {
        final Card card = DataFactory.createCard();
        assertNotNull(card);
        this.log.info(card.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateBusiness() {
        final Business business = DataFactory.createBusiness();
        assertNotNull(business);
        this.log.info(business.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateBank() {
        final Bank bank = DataFactory.createBank();
        assertNotNull(bank);
        this.log.info(bank.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateAddress() {
        final PostalAddress address = DataFactory.createAddress();
        assertNotNull(address);
        this.log.info(address.toString());
    }

}
