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
package net.atf4j.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * StringBuilderTest Class.
 *
 *
 */
public class StringBuilderTest extends ResultsReporting {

    private final String string = "StringBuilderTest";
    private final boolean bool = true;
    private final double real = Math.PI;
    private final int number = 999;

    /**
     * SubClassWithoutProperties Class.
     */
    public class SubClassWithoutProperties extends StringBuilderTest {

        /* (non-Javadoc)
         * @see net.atf4j.core.StringBuilderTest#toString()
         */
        @Override
        public String toString() {
            return String.format("SubClassWithoutProperties [%s]", super.toString());
        }
    }

    /**
     * The Class SubClassWithProperties.
     */
    public class SubClassWithProperties extends StringBuilderTest {

        /** The Constant CONSTANT. */
        private static final String CONSTANT = "CONSTANT";

        /** The Constant π. */
        public static final double π = 3.14159;

        /** The super class. */
        private final String superClass = "SubClassWithProperties";

        /** The protected string. */
        protected String protectedString = "protectedString";

        /** The public string. */
        public String publicString = "publicString";

        /* (non-Javadoc)
         * @see net.atf4j.core.StringBuilderTest#toString()
         */
        @Override
        public String toString() {
            return String.format("%s [%s, protectedString=%s, publicString=%s]", this.getClass().getSimpleName(),
                    super.toString(), this.protectedString, this.publicString);
        }
    }

    /**
     * Test method for {@link StringBuilder}.
     */
    @Test
    public void testDefaultConstructor() {
        new ToStringBuilder();
    }

    /**
     * Test null class.
     */
    @Test
    public void testNullClass() {
        final String reflectionToString = ToStringBuilder.reflectObjectToString(null);
        this.log.info(reflectionToString);
        Assert.assertTrue("|testNullClass|", reflectionToString.equals("[NULL]"));
    }

    /**
     * Test this class.
     */
    @Test
    public void testThisClass() {
        final String reflectionToString = ToStringBuilder.reflectObjectToString(this);
        this.log.info(reflectionToString);
        Assert.assertNotNull("|testThisClass|", reflectionToString);
        Assert.assertTrue("|testThisClass|", reflectionToString.length() > 0);
    }

    /**
     * Test sub class without properties.
     */
    @Test
    public void testSubClassWithoutProperties() {
        final SubClassWithoutProperties superClassWithoutProperties = new SubClassWithoutProperties();
        final String reflectionToString = ToStringBuilder.reflectObjectToString(superClassWithoutProperties);
        this.log.info(reflectionToString);
        Assert.assertNotNull("|testSubClassWithoutProperties|", reflectionToString);
        Assert.assertTrue("|testSubClassWithoutProperties|", reflectionToString.length() > 0);
    }

    /**
     * Test sub class with properties.
     */
    @Test
    public void testSubClassWithProperties() {
        final SubClassWithProperties superClassWithProperties = new SubClassWithProperties();
        final String reflectionToString = ToStringBuilder.reflectObjectToString(superClassWithProperties);
        this.log.info(reflectionToString);
        Assert.assertNotNull("|testSubClassWithProperties|", reflectionToString);
        Assert.assertTrue("|testSubClassWithProperties|", reflectionToString.length() > 0);
    }

    /**
     * Test method for {@link StringBuilder}.
     */
    @Test
    public void testRefection() {
        this.log.info(ToStringBuilder.reflectObjectToString(getClass()));
    }

}
