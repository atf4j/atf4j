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

package net.atf4j.pog;

import static org.junit.Assert.assertNotNull;

/**
 * A class to represent a WebElement decorated by FindBy annotation.
 */
public class WebElementField extends ClassField {

    /** The Constant FIND_BY_FORMAT. */
    private static final String FIND_BY_FORMAT = "\t@FindBy(%s = \"%s\")\n";

    /** The Constant FIELD_FORMAT. */
    private static final String FIELD_FORMAT = "\tprivate %s %s;\n";

    /** The Constant FULL_FORMAT. */
    private static final String FULL_FORMAT = "%s%s\n";

    /** The Constant WEB_ELEMENT_TYPE. */
    private static final String WEB_ELEMENT_TYPE = "WebElement";

    /**
     * The Strategy Enum.
     */
    public enum Strategy {

        /** The unknown. */
        UNKNOWN("Unknown"),

        /** The id. */
        ID("id"),

        /** The name. */
        NAME("name"),

        /** The class name. */
        CLASS_NAME("className"),

        /** The xpath. */
        XPATH("xpath"),

        /** The css. */
        CSS("css"),

        /** The link text. */
        LINK_TEXT("linkText"),

        /** The partial link text. */
        PARTIAL_LINK_TEXT("partialLinkText");

        /** The value. */
        private final String strategy;

        /**
         * Instantiates a new strategy.
         *
         * @param asText the as text
         */
        Strategy(final String asText) {
            strategy = asText;
        }

        /**
         * Initialise.
         *
         * @return the strategy
         */
        public static Strategy initialise() {
            return Strategy.UNKNOWN;
        }

        /**
         * Status forString.
         *
         * @param asText the as text
         * @return Status value
         */
        public static Strategy fromString(final String asText) {
            for (final Strategy value : values()) {
                if (value.strategy.equals(asText)) {
                    return value;
                }
            }
            return null;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return strategy;
        }
    }

    /** The strategy. */
    private Strategy strategy = null;

    /** The locator. */
    private String locator = null;

    /**
     * Instantiates a new page web element.
     */
    public WebElementField() {
        super();
    }

    /**
     * Instantiates a new page web element.
     *
     * @param name the name
     * @param strategy the strategy
     * @param locator the locator
     */
    public WebElementField(final String name, final String strategy, final String locator) {
        super(WEB_ELEMENT_TYPE, name);
        setStrategy(Strategy.fromString(strategy));
        setLocator(locator);
    }

    /**
     * Instantiates a new page web element.
     *
     * @param name the name
     * @param strategy the strategy
     * @param locator the locator
     */
    public WebElementField(final String name, final Strategy strategy, final String locator) {
        super(WEB_ELEMENT_TYPE, name);
        setStrategy(strategy);
        setLocator(locator);
    }

    /**
     * Sets the locator strategy.
     *
     * @param strategy the strategy
     * @return the page web element
     */
    public WebElementField setStrategy(final String strategy) {
        assertNotNull(UNEXPECTED_NULL, strategy);
        this.strategy = Strategy.fromString(strategy);
        return this;
    }

    /**
     * Sets the locator strategy.
     *
     * @param strategy the strategy
     * @return the page web element
     */
    public WebElementField setStrategy(final Strategy strategy) {
        assertNotNull(UNEXPECTED_NULL, strategy);
        this.strategy = strategy;
        return this;
    }

    /**
     * Sets the locator.
     *
     * @param locator the locator
     * @return the page web element
     */
    public WebElementField setLocator(final String locator) {
        assertNotNull(UNEXPECTED_NULL, locator);
        this.locator = locator;
        return this;
    }

    /**
     * Gets the locator type.
     *
     * @return the locator type
     */
    public Strategy getLocatorType() {
        return strategy;
    }

    /**
     * Gets the locator.
     *
     * @return the locator
     */
    public String getLocator() {
        return locator;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.pog.ClassField#toString()
     */
    @Override
    public String toString() {
        final String locatorLine = String.format(FIND_BY_FORMAT, strategy, locator);
        final String webElementLine = String.format(FIELD_FORMAT, super.getType(), super.getName());
        return String.format(FULL_FORMAT, locatorLine, webElementLine);
    }

}
