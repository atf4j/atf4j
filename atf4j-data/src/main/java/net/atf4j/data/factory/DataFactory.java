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

import java.io.FileNotFoundException;
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
 * Factory for random data. TODO: Add variants formated date string.
 */
public class DataFactory {

    public static final String ISO_DATE_TIME = "yyyy-MM-dd'T'HH:mm'Z'";
    public static final String ISO_DATE = "yyyy-MM-dd";
    public static final String ISO_TIME = "HH:mm'Z'";
    public static final String UK_DATE = "dd:MM-yyyy";

    private static Random rnd = new Random(System.currentTimeMillis());

    /**
     * Random char.
     *
     * @return the char
     */
    public static char randomChar() {
        return (char) ('a' + rnd.nextInt(26));
    }

    /**
     * Random string.
     *
     * @param length the length
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
     * Random digit.
     *
     * @return the char
     */
    public static char randomDigit() {
        return (char) ('0' + rnd.nextInt(9));
    }

    /**
     * Random digits.
     *
     * @param length the length
     * @return the string
     */
    public static String randomDigits(final int length) {
        final StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            stringBuffer.append(randomDigit());
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
     * Today date as string.
     *
     * @param format the format to use for date
     * @return today as String.
     */
    public static String today(final String format) {
        final Calendar today = today();
        return format(today);
    }

    /**
     * Date of birth.
     *
     * @return random date of birth as Calendar
     */
    public static Calendar dateOfBirth() {
        final Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.add(Calendar.YEAR, -1);
        dateOfBirth.add(Calendar.MONTH, -1);
        dateOfBirth.add(Calendar.DATE, -1);
        return dateOfBirth;
    }

    /**
     * DOB over 18.
     *
     * @param format the format
     * @return the string
     */
    public static String dobOver18(final String format) {
        final Calendar dobOver18 = dobOver18();
        return format(dobOver18);
    }

    /**
     * DOB over 18.
     *
     * @return the calendar
     */
    public static Calendar dobOver18() {
        final Calendar dobOver18 = Calendar.getInstance();
        dobOver18.add(Calendar.YEAR, -18);
        dobOver18.add(Calendar.MONTH, 0);
        dobOver18.add(Calendar.DATE, 1);
        return dobOver18;
    }

    /**
     * DOB under 18.
     *
     * @param format the format
     * @return the string
     */
    public static String dobUnder18(final String format) {
        final Calendar dobOver18 = dobUnder18();
        return format(dobOver18);
    }

    /**
     * DOB under 18.
     *
     * @return the calendar
     */
    public static Calendar dobUnder18() {
        final Calendar dobUnder18 = Calendar.getInstance();
        dobUnder18.add(Calendar.YEAR, -18);
        dobUnder18.add(Calendar.MONTH, 0);
        dobUnder18.add(Calendar.DATE, -1);
        return dobUnder18;
    }

    /**
     * Tomorrow.
     *
     * @param format the format
     * @return the string
     */
    public static String tomorrow(final String format) {
        final Calendar dobOver18 = tomorrow();
        return format(dobOver18);
    }

    /**
     * Tomorrow date.
     *
     * @return the calendar
     */
    public static Calendar tomorrow() {
        final Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.YEAR, 0);
        tomorrow.add(Calendar.MONTH, 0);
        tomorrow.add(Calendar.DATE, 1);
        return tomorrow;
    }

    /**
     * Future date.
     *
     * @param format the format
     * @return the string
     */
    public static String futureDate(final String format) {
        final Calendar futureDate = futureDate();
        return format(futureDate);
    }

    /**
     * Future date.
     *
     * @return the calendar
     */
    public static Calendar futureDate() {
        final Calendar futureDate = Calendar.getInstance();
        futureDate.add(Calendar.YEAR, 1);
        futureDate.add(Calendar.MONTH, 1);
        futureDate.add(Calendar.DATE, 1);
        return futureDate;
    }

    /**
     * Yesterday.
     *
     * @param format the format
     * @return the string
     */
    public static String yesterday(final String format) {
        final Calendar yesterday = yesterday();
        return format(yesterday);
    }

    /**
     * Yesterday.
     *
     * @return the calendar
     */
    public static Calendar yesterday() {
        final Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.YEAR, 0);
        yesterday.add(Calendar.MONTH, 0);
        yesterday.add(Calendar.DATE, -1);
        return yesterday;
    }

    /**
     * Past date.
     *
     * @param format the format
     * @return the string
     */
    public static String pastDate(final String format) {
        final Calendar pastDate = pastDate();
        return format(pastDate);
    }

    /**
     * Past date.
     *
     * @return the calendar
     */
    public static Calendar pastDate() {
        final Calendar instance = Calendar.getInstance();
        instance.add(Calendar.YEAR, -1);
        instance.add(Calendar.MONTH, -1);
        instance.add(Calendar.DATE, -1);
        return instance;
    }

    /**
     * Date between.
     *
     * @param startDate the start date
     * @param endDate the end date
     * @return the calendar
     */
    public static Calendar dateBetween(final Date startDate, final Date endDate) {
        return dateBetween(toCalendar(startDate), toCalendar(endDate));
    }

    /**
     * Date between.
     *
     * @param pastDate the past date
     * @param today the today
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
     * @param calendar the calendar
     * @return the string
     */
    public static String format(final Calendar calendar) {
        return format(calendar.getTime());
    }

    /**
     * Format.
     *
     * @param date the date
     * @return the string
     */
    public static String format(final Date date) {
        return new SimpleDateFormat().format(date);
    }

    /**
     * Create a new instances of Data.
     *
     * @return the person
     */
    public static Person createPerson() {
        return PersonDataFactory.create();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the consumer
     */
    public static Consumer createConsumer() {
        return ConsumerDataFactory.create();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the customer
     */
    public static Customer createCustomer() {
        return CustomerDataFactory.create();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the card
     */
    public static Card createCard() {
        return CardDataFactory.create();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the business
     */
    public static Business createBusiness() {
        return BusinessDataFactory.create();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the bank
     * @throws FileNotFoundException the file not found exception
     */
    public static Bank createBank() throws FileNotFoundException {
        final BankDataFactory instance = BankDataFactory.getInstance();
        return instance.create();
    }

    /**
     * Create a new instances of Data.
     *
     * @return the postal address
     */
    public static PostalAddress createAddress() {
        return AddressDataFactory.create();
    }

    /**
     * To calendar.
     *
     * @param startDate the start date
     * @return the calendar
     */
    public static Calendar toCalendar(final Date startDate) {
        final Calendar instance = Calendar.getInstance();
        instance.setTime(startDate);
        return instance;
    }

}
