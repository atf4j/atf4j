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

import java.io.FileNotFoundException;
import java.util.Arrays;

import net.atf4j.data.PostalAddress;
import net.atf4j.data.Postcode;

/**
 * Address Data Factory.
 */
public final class AddressDataFactory extends AbstractDataFactory {

    private static final String FILE_NOT_FOUND_MSG = "Expected file '%s' not found.";

    private static AddressDataFactory addressDataFactory = null;

    private String[] addressLineStems;
    private String[] addressLinePostfix;
    private String[] addressLocals;
    private String[] addressStems;

    /**
     * Gets the single INSTANCE of AddressDataFactory.
     *
     * @return single INSTANCE of AddressDataFactory
     */
    public static AddressDataFactory getInstance() {
        if (AddressDataFactory.addressDataFactory == null) {
            AddressDataFactory.addressDataFactory = new AddressDataFactory();
        }
        return AddressDataFactory.addressDataFactory;
    }

    /**
     * Create new INSTANCE of create.
     *
     * @return the postal address
     */
    public static PostalAddress create() {
        return new PostalAddress();
    }

    /**
     * Random.
     *
     * @return the postal address
     */
    public static PostalAddress random() {
        final PostalAddress postalAddress = new PostalAddress();
        postalAddress.setAddressRow(1, null);
        postalAddress.setAddressRow(2, null);
        postalAddress.setPostcode(new Postcode());
        return postalAddress;
    }

    /**
     * To log.
     */
    public void toLog() {
        log.info(toString());
    }

    /**
     * Instantiates a new address data factory.
     */
    private AddressDataFactory() {
        super();
        initialise();
    }

    /**
     * Initialise.
     */
    protected void initialise() {
        try {
            addressLineStems = load("addressLineStems.txt");
        } catch (final FileNotFoundException e) {
            final String errorMessage = String.format(FILE_NOT_FOUND_MSG, e.getLocalizedMessage());
            log.error(errorMessage);
        }

        try {
            addressLinePostfix = load("addressLinePostfix.txt");
        } catch (final FileNotFoundException e) {
            final String errorMessage = String.format(FILE_NOT_FOUND_MSG, e.getLocalizedMessage());
            log.error(errorMessage);
        }

        try {
            addressStems = load("addressStems.txt");
        } catch (final FileNotFoundException e) {
            final String errorMessage = String.format(FILE_NOT_FOUND_MSG, e.getLocalizedMessage());
            log.error(errorMessage);
        }

        try {
            addressLocals = load("addressLocals.txt");
        } catch (final FileNotFoundException e) {
            final String errorMessage = String.format(FILE_NOT_FOUND_MSG, e.getLocalizedMessage());
            log.error(errorMessage);
        }

    }

    /**
     * Format data lines.
     *
     * @param data the data
     * @return the string
     */
    private String fromatData(final String data) {
        return data.replace("{", "{\n\t").replace(", ", "\n\t").replace("}", "\n\t}");
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        assertNotNull(addressLineStems);
        assertNotNull(addressLinePostfix);
        assertNotNull(addressStems);
        assertNotNull(addressLocals);

        return String.format(
                "AddressDataFactory [addressLineStems=%s, addressLinePostfix=%s, addressStems=%s, addressLocals=%s]",
                fromatData(Arrays.toString(addressLineStems)),
                fromatData(Arrays.toString(addressLinePostfix)),
                fromatData(Arrays.toString(addressStems)),
                fromatData(Arrays.toString(addressLocals)));
    }

}
