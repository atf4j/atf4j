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
import java.util.Date;

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
public final class DataFactoryTest extends ResultsReporting {

    /**
     * Test method for expected usage.
     */
    @Test
    public void testExpectedUsage() {
        final Calendar today = DataFactory.today();
        assertNotNull("unexpected null",today);
        this.log.info("DataFactory.today() = {}", DataFactory.format(today));
        final Calendar dateOfBirth = DataFactory.dateOfBirth();
        this.log.info("DataFactory.dateOfBirth() = {}", DataFactory.format(dateOfBirth));
        final Calendar dobOver18 = DataFactory.dobOver18();
        this.log.info("DataFactory.dobOver18() = {}", DataFactory.format(dobOver18));
        final Calendar dobUnder18 = DataFactory.dobUnder18();
        this.log.info("DataFactory.dobUnder18() = {}", DataFactory.format(dobUnder18));
        final Calendar futureDate = DataFactory.futureDate();
        this.log.info("DataFactory.futureDate() = {}", DataFactory.format(futureDate));
        final Calendar pastDate = DataFactory.pastDate();
        this.log.info("DataFactory.pastDate() = {}", DataFactory.format(pastDate));
    }

    /**
     * Test random string creation.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testString() throws Exception {
        final char randomChar = DataFactory.randomChar();
        this.log.info("DataFactory.randomChar() = {}", randomChar);
        final String randomString = DataFactory.randomString(10);
        this.log.info("DataFactory.randomString(10) = {}", randomString);
    }

    /**
     * Test random numeric string creation.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testDigits() throws Exception {
        final char randomDigit = DataFactory.randomDigit();
        this.log.info("DataFactory.randomDigit() = {}", randomDigit);
        final String randomDigits = DataFactory.randomDigits(10);
        this.log.info("DataFactory.randomDigits(10) = {}", randomDigits);
    }

    /**
     * Test default constructor.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testDefaultConstructor() throws Exception {
        final DataFactory dataFactory = new DataFactory();
        assertNotNull("unexpected null",dataFactory);
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
        assertNotNull("unexpected null",today);
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
        assertNotNull("unexpected null",dateData);
        this.log.info("verifyDateData({})", dateData.toString());
        final String fromCalendar = DataFactory.format(dateData);
        final Date time = dateData.getTime();
        final String fromDate = DataFactory.format(time);
        assertNotNull("unexpected null",fromCalendar);
        assertNotNull("unexpected null",fromDate);
        assertEquals(fromCalendar, fromDate);
    }

    /**
     * Unit Test for test create person.
     */
    @Test
    public void testCreatePerson() {
        final Person person = DataFactory.createPerson();
        assertNotNull("unexpected null",person);
        this.log.info("{}", person.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateCustomer() {
        final Customer customer = DataFactory.createCustomer();
        assertNotNull("unexpected null",customer);
        this.log.info("{}", customer.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateConsumer() {
        final Consumer consumer = DataFactory.createConsumer();
        assertNotNull("unexpected null",consumer);
        this.log.info("{}", consumer.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateCard() {
        final Card card = DataFactory.createCard();
        assertNotNull("unexpected null",card);
        this.log.info("{}", card.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateBusiness() {
        final Business business = DataFactory.createBusiness();
        assertNotNull("unexpected null",business);
        this.log.info("{}", business.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateBank() {
        final Bank bank = DataFactory.createBank();
        assertNotNull("unexpected null",bank);
        this.log.info("{}", bank.toString());
    }

    /**
     * Test method for void.
     */
    @Test
    public void testCreateAddress() {
        final PostalAddress address = DataFactory.createAddress();
        assertNotNull("unexpected null",address);
        this.log.info("{}", address.toString());
    }

}
