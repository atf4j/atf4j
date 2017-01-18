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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import net.atf4j.data.Bank;
import net.atf4j.data.Business;
import net.atf4j.data.Card;
import net.atf4j.data.Consumer;
import net.atf4j.data.Customer;
import net.atf4j.data.Person;
import net.atf4j.data.PostalAddress;

/**
 * DataFactory.
 */
public class DataFactory {

    /** The Constant simpleDateFormat. */
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");

    private static Random random = new Random(System.currentTimeMillis());

    /**
     * Random char.
     *
     * @return the char
     */
    public static char randomChar() {
        return (char) (random.nextInt(26) + 'a');
    }

    /**
     * Random string.
     *
     * @param length
     *            the length
     * @return the string
     */
    public static String randomString(final int length) {
        final StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(randomChar());
        }
        return stringBuffer.toString();
    }

    /**
     * Today date.
     *
     * @return today as Calendar
     */
    public static Calendar today() {
        final Calendar instance = Calendar.getInstance();
        return instance;
    }

    /**
     * Date of birth.
     *
     * @return random date of birth as Calendar
     */
    public static Calendar dateOfBirth() {
        final Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR, -1);
        instance.add(Calendar.MONTH, -1);
        instance.add(Calendar.DATE, -1);
        return instance;
    }

    /**
     * DOB over 18.
     *
     * @return the calendar
     */
    public static Calendar dobOver18() {
        final Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR, 18);
        instance.add(Calendar.MONTH, 0);
        instance.add(Calendar.DATE, 1);
        return instance;
    }

    /**
     * DOB under 18.
     *
     * @return the calendar
     */
    public static Calendar dobUnder18() {
        final Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR, 18);
        instance.add(Calendar.MONTH, 0);
        instance.add(Calendar.DATE, -1);
        return instance;
    }

    /**
     * Future date.
     *
     * @return the calendar
     */
    public static Calendar futureDate() {
        final Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR, 0);
        instance.add(Calendar.MONTH, 0);
        instance.add(Calendar.DATE, 1);
        return instance;
    }

    /**
     * Past date.
     *
     * @return the calendar
     */
    public static Calendar pastDate() {
        final Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR, 0);
        instance.add(Calendar.MONTH, 0);
        instance.add(Calendar.DATE, -1);
        return instance;
    }

    /**
     * Date between.
     *
     * @param startDate
     *            the start date
     * @param endDate
     *            the end date
     * @return the calendar
     */
    public static Calendar dateBetween(final Date startDate, final Date endDate) {
        return dateBetween(toCalendar(startDate), toCalendar(endDate));
    }

    /**
     * Date between.
     *
     * @param pastDate
     *            the past date
     * @param today
     *            the today
     * @return the calendar
     */
    public static Calendar dateBetween(final Calendar pastDate, final Calendar today) {
        return null;
    }

    /**
     * This year.
     *
     * @return the int
     */
    public static int thisYear() {
        final Calendar instance = Calendar.getInstance();
        return instance.get(Calendar.YEAR);
    }

    /**
     * This month.
     *
     * @return the int
     */
    public static int thisMonth() {
        final Calendar instance = Calendar.getInstance();
        return instance.get(Calendar.MONTH);
    }

    /**
     * Format.
     *
     * @param calendar
     *            the calendar
     * @return the string
     */
    public static String format(final Calendar calendar) {
        return format(calendar.getTime());
    }

    /**
     * Format.
     *
     * @param date
     *            the date
     * @return the string
     */
    public static String format(final Date date) {
        return simpleDateFormat.format(date);
    }

    /**
     * Create a new instances of Data.
     *
     * @return the person
     */
    public static Person createPerson() {
        return new Person();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the customer
     */
    public static Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the card
     */
    public static Card createCard() {
        return new Card();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the business
     */
    public static Business createBusiness() {
        return new Business();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the bank
     */
    public static Bank createBank() {
        return new Bank();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the postal address
     */
    public static PostalAddress createAddress() {
        return new PostalAddress();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the consumer
     */
    public static Consumer createConsumer() {
        return new Consumer();
    }

    /**
     * To calendar.
     *
     * @param startDate the start date
     * @return the calendar
     */
    private static Calendar toCalendar(final Date startDate) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(startDate);
        return instance;
    }

}
