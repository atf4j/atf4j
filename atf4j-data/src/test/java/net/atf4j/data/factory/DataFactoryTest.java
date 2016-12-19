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

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

import net.atf4j.core.Reporting;

/**
 * A UnitTest for DataFactory objects.
 */
public class DataFactoryTest extends Reporting {

    /**
     * Test default constructor.
     *
     * @throws Exception
     */
    @Test
    public final void testDefaultConstructor() throws Exception {
        final DataFactory testData = new DataFactory();
        assertNotNull(testData);
        this.log.info(testData.toString());
    }

    @Test
    public final void testToday() throws Exception {
        final Date today = DataFactory.today();
    }

    @Test
    public final void testPastDate() throws Exception {
        DataFactory.pastDate();
    }

    @Test
    public final void testFutureDate() throws Exception {
        DataFactory.futureDate();
    }

    @Test
    public final void testDateOfBirth() throws Exception {
        DataFactory.dateOfBirth();
    }

    @Test
    public final void testOver18() throws Exception {
        DataFactory.dobOver18();
    }

    @Test
    public final void testUnder18() throws Exception {
        DataFactory.dobUnder18();
    }
}
