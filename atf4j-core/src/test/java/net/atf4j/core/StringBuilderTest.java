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
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class StringBuilderTest extends LoggedTest {

    String string = "StringBuilderTest";
    boolean bool = true;
    double real = Math.PI;
    int number = 999;

    /**
     * SubClassWithoutProperties Class.
     */
    public class SubClassWithoutProperties extends StringBuilderTest {
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

        @Override
        public String toString() {
            return String.format("%s [%s, protectedString=%s, publicString=%s]", this.getClass().getSimpleName(),
                    super.toString(), this.protectedString, this.publicString);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("StringBuilderTest [string=%s, bool=%s, real=%s, number=%s]", this.string, this.bool,
                this.real, this.number);
    }

    /**
     * Test null class.
     */
    @Test
    public void testNullClass() {
        final String reflectionToString = ToStringBuilder.reflectObjectToString(null);
        log.info(reflectionToString);
        Assert.assertTrue("|testNullClass|", reflectionToString.equals("[NULL]"));
    }

    /**
     * Test this class.
     */
    @Test
    public void testThisClass() {
        final String reflectionToString = ToStringBuilder.reflectObjectToString(this);
        log.info(reflectionToString);
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
        log.info(reflectionToString);
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
        log.info(reflectionToString);
        Assert.assertNotNull("|testSubClassWithProperties|", reflectionToString);
        Assert.assertTrue("|testSubClassWithProperties|", reflectionToString.length() > 0);
    }

}
