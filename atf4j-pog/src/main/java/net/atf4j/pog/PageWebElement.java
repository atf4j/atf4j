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
 * The PageWebElement Class.
 */
public class PageWebElement extends ClassField {

    private static final String UNEXPECTED_NULL = "unexpected null";

    /**
     * The Strategy Enum.
     */
    public enum Strategy {
        UNKNOWN("Unknown"), ID("id"), NAME("name"), CLASS_NAME("className"), XPATH("xpath"), CSS("css"), LINK_TEXT(
                "linkText"), PARTIAL_LINK_TEXT("partialLinkText");

        /** The value. */
        private final String strategy;

        /**
         * Instantiates a new strategy.
         *
         * @param asText the as text
         */
        Strategy(final String asText) {
            this.strategy = asText;
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
            return this.strategy;
        }
    }

    private Strategy strategy = null;
    private String locator = null;

    /**
     * Instantiates a new page web element.
     *
     * @param name the name
     * @param strategy the strategy
     * @param locator the locator
     */
    public PageWebElement(final String name, final String strategy, final String locator) {
        super("WebElement", name);
        setLocatorStrategy(Strategy.fromString(strategy));
        setLocator(locator);
    }

    /**
     * Instantiates a new page web element.
     *
     * @param name the name
     * @param strategy the strategy
     * @param locator the locator
     */
    public PageWebElement(final String name, final Strategy strategy, final String locator) {
        super("WebElement", name);
        setLocatorStrategy(strategy);
        setLocator(locator);
    }

    /**
     * Sets the locator strategy.
     *
     * @param strategy the strategy
     * @return the page web element
     */
    public PageWebElement setLocatorStrategy(final String strategy) {
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
    public PageWebElement setLocatorStrategy(final Strategy strategy) {
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
    public PageWebElement setLocator(final String locator) {
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
        return this.strategy;
    }

    /**
     * Gets the locator.
     *
     * @return the locator
     */
    public String getLocator() {
        return this.locator;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.pog.ClassField#toString()
     */
    @Override
    public String toString() {
        final String locatorLine = String.format("@FindBy(%s=\"%s\")", this.strategy, this.locator);
        final String webElementLine = String.format("private %s %s;", super.getType(), super.getName());
        return String.format("\n\t%s\n\t%s\n", locatorLine, webElementLine);
    }

}
