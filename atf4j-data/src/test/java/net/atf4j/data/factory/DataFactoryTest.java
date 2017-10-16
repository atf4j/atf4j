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

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * Test method for expected usage.
     */
    @Test
    public void testExpectedUsage() {
        final Calendar today = DataFactory.today();
        assertNotNull(UNEXPECTED_NULL, today);
        this.log.info("DataFactory.today() = {}", DataFactory.format(today));

        final Calendar dateOfBirth = DataFactory.dateOfBirth();
        assertNotNull(UNEXPECTED_NULL, dateOfBirth);
        this.log.info("DataFactory.dateOfBirth() = {}", DataFactory.format(dateOfBirth));

        final Calendar dobOver18 = DataFactory.dobOver18();
        assertNotNull(UNEXPECTED_NULL, dobOver18);
        this.log.info("DataFactory.dobOver18() = {}", DataFactory.format(dobOver18));

        final Calendar dobUnder18 = DataFactory.dobUnder18();
        assertNotNull(UNEXPECTED_NULL, dobUnder18);
        this.log.info("DataFactory.dobUnder18() = {}", DataFactory.format(dobUnder18));

        final Calendar futureDate = DataFactory.futureDate();
        assertNotNull(UNEXPECTED_NULL, futureDate);
        this.log.info("DataFactory.futureDate() = {}", DataFactory.format(futureDate));

        final Calendar pastDate = DataFactory.pastDate();
        assertNotNull(UNEXPECTED_NULL, pastDate);
        this.log.info("DataFactory.pastDate() = {}", DataFactory.format(pastDate));
    }

    /**
     * Test default constructor.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDefaultConstructor() throws Exception {
        final DataFactory dataFactory = new DataFactory();
        assertNotNull(UNEXPECTED_NULL, dataFactory);
        this.log.info("DataFactory = {}", dataFactory);
    }

    /**
     * Test random string creation.
     *
     * @throws Exception the exception
     */
    @Test
    public void testString() throws Exception {
        final char randomChar = DataFactory.randomChar();
        assertNotNull(UNEXPECTED_NULL, randomChar);
        this.log.info("DataFactory.randomChar() = {}", randomChar);

        final String randomString = DataFactory.randomString(10);
        assertNotNull(UNEXPECTED_NULL, randomString);
        this.log.info("DataFactory.randomString(10) = {}", randomString);
    }

    /**
     * Test random numeric string creation.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDigits() throws Exception {
        final char randomDigit = DataFactory.randomDigit();
        assertNotNull(UNEXPECTED_NULL, randomDigit);
        this.log.info("DataFactory.randomDigit() = {}", randomDigit);

        final String randomDigits = DataFactory.randomDigits(10);
        assertNotNull(UNEXPECTED_NULL, randomDigits);
        this.log.info("DataFactory.randomDigits(10) = {}", randomDigits);
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception the exception
     */
    @Test
    public void testToday() throws Exception {
        final Calendar today = DataFactory.today();
        assertNotNull(UNEXPECTED_NULL, today);
        verifyDateData(today);
    }

    /**
     * Test method for DataFactory.
     *
     * @throws Exception the exception
     */
    @Test
    public void testThisMonth() throws Exception {
        final int thisMonth = DataFactory.thisMonth();
        assertTrue(thisMonth >= 0 && thisMonth <= 11);
    }

    /**
     * Test method for DataFactory.
     *
     * @throws Exception the exception
     */
    @Test
    public void testThisYear() throws Exception {
        final int thisYear = DataFactory.thisYear();
        assertNotEquals(0, thisYear);
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception the exception
     */
    @Test
    public void testPastDate() throws Exception {
        final Calendar pastDate = DataFactory.pastDate();
        verifyDateData(pastDate);
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception the exception
     */
    @Test
    public void testFutureDate() throws Exception {
        final Calendar futureDate = DataFactory.futureDate();
        verifyDateData(futureDate);
    }

    /**
     * Test method for void.
     *
     * @throws Exception the exception
     */
    public void testDateBetween() throws Exception {
        final Calendar futureDate = DataFactory.dateBetween(DataFactory.pastDate(), DataFactory.today());
        verifyDateData(futureDate);
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDateOfBirth() throws Exception {
        final Calendar dateOfBirth = DataFactory.dateOfBirth();
        verifyDateData(dateOfBirth);
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception the exception
     */
    @Test
    public void testOver18() throws Exception {
        final Calendar dobOver18 = DataFactory.dobOver18();
        verifyDateData(dobOver18);
    }

    /**
     * test DataFactory object.
     *
     * @throws Exception the exception
     */
    @Test
    public void testUnder18() throws Exception {
        final Calendar dobUnder18 = DataFactory.dobUnder18();
        verifyDateData(dobUnder18);
    }

    /**
     * Verify DataFactory object.
     *
     * @param dateData the date data
     */
    private void verifyDateData(final Calendar dateData) {
        assertNotNull(UNEXPECTED_NULL, dateData);
        this.log.info("verifyDateData({})", dateData.toString());

        final String fromCalendar = DataFactory.format(dateData);
        assertNotNull(UNEXPECTED_NULL, fromCalendar);

        final Date time = dateData.getTime();
        assertNotNull(UNEXPECTED_NULL, time);

        final String fromDate = DataFactory.format(time);
        assertNotNull(UNEXPECTED_NULL, fromDate);
        assertEquals(fromCalendar, fromDate);
    }

    /**
     * Unit Test for test create person.
     */
    @Test
    public void testCreatePerson() {
        final Person person = DataFactory.createPerson();
        assertNotNull(UNEXPECTED_NULL, person);
        this.log.info("{}", person.toString());
    }

    /**
     * Test create customer.
     */
    @Test
    public void testCreateCustomer() {
        final Customer customer = DataFactory.createCustomer();
        assertNotNull(UNEXPECTED_NULL, customer);
        this.log.info("{}", customer.toString());
    }

    /**
     * Test create consumer.
     */
    @Test
    public void testCreateConsumer() {
        final Consumer consumer = DataFactory.createConsumer();
        assertNotNull(UNEXPECTED_NULL, consumer);
        this.log.info("{}", consumer.toString());
    }

    /**
     * Test create card.
     */
    @Test
    public void testCreateCard() {
        final Card card = DataFactory.createCard();
        assertNotNull(UNEXPECTED_NULL, card);
        this.log.info("{}", card.toString());
    }

    /**
     * Test create business.
     */
    @Test
    public void testCreateBusiness() {
        final Business business = DataFactory.createBusiness();
        assertNotNull(UNEXPECTED_NULL, business);
        this.log.info("{}", business.toString());
    }

    /**
     * Test create bank.
     */
    // @Test
    // public void testCreateBank() {
    // final Bank bank = DataFactory.createBank();
    // assertNotNull(UNEXPECTED_NULL, bank);
    // this.log.info("{}", bank.toString());
    // }

    /**
     * Test create address.
     */
    @Test
    public void testCreateAddress() {
        final PostalAddress address = DataFactory.createAddress();
        assertNotNull(UNEXPECTED_NULL, address);
        this.log.info("{}", address.toString());
    }

}
