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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import org.junit.Test;

/**
 * A UnitTest for DataFactory objects.
 */
public class DataFactoryTest {

    /**
     * Test default constructor.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public final void testDefaultConstructor() throws Exception {
        final DataFactory testData = new DataFactory();
        assertNotNull(testData);
        assertNotNull(testData.toString());
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
     * Test method for {@link DataFactory}.
     *
     * @throws Exception
     *             the exception
     */
    public final void testThisMonth() throws Exception {
        final int thisMonth = DataFactory.thisMonth();
        assertNotEquals(0, thisMonth);
    }

    /**
     * Test method for {@link DataFactory}.
     *
     * @throws Exception
     *             the exception
     */
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
        final String fromCalendar = DataFactory.format(dateData);
        final String fromDate = DataFactory.format(dateData.getTime());
        assertEquals(fromCalendar, fromDate);
        assertNotNull(fromCalendar);
        assertNotNull(fromDate);
    }

}
