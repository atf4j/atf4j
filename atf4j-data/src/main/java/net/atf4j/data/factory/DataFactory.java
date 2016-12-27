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
package net.atf4j.data.factory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DataFactory.
 *
 *
 *
 */
public class DataFactory {

    private AddressDataFactory addressData = null;
    private final BankDataFactory bankData = null;
    private final BusinessDataFactory businessData = null;
    private final CardDataFactory cardData = null;
    private final CustomerDataFactory contactData = null;
    private final PersonDataFactory personData = null;

    /** The Constant simpleDateFormat. */
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");

    /**
     * Instantiates a new data factory.
     *
     * @throws Exception
     *             the exception
     */
    protected DataFactory() throws Exception {
        this.addressData = new AddressDataFactory();
        // this.bankData = new BankDataFactory();
        // this.businessData = new BusinessDataFactory();
        // this.cardData = new CardDataFactory();
        // this.contactData = new CustomerDataFactory();
        // this.personData = new PersonDataFactory();
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
     * Family name.
     *
     * @return the string
     */
    public static String familyName() {
        return null;
    }

    /**
     * Given name.
     *
     * @return the string
     */
    public static String givenName() {
        return null;
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

    @Override
    public String toString() {
        return String.format(
                "DataFactory [addressData=%s, bankData=%s, businessData=%s, cardData=%s, contactData=%s, personData=%s]",
                this.addressData, this.bankData, this.businessData, this.cardData, this.contactData, this.personData);
    }

}
