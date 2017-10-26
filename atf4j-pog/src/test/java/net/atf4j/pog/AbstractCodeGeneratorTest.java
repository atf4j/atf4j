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

import org.junit.Test;

import net.atf4j.core.Atf4jException;
import net.atf4j.core.TestResultsReporting;

/**
 * The Class AbstractCodeGeneratorTest.
 */
public class AbstractCodeGeneratorTest extends TestResultsReporting {

    /**
     * The Class JavaClassGenerator.
     */
    public class JavaClassGenerator extends AbstractCodeGenerator {

        /**
         * Instantiates a new java class generator.
         */
        public JavaClassGenerator() {
            super();
        }

        /**
         * Instantiates a new java class generator.
         *
         * @param templateFilename the template filename
         * @throws TemplateNotLoadedException the template not loaded exception
         */
        public JavaClassGenerator(final String templateFilename) throws TemplateNotLoadedException {
            super(templateFilename);
        }
    }

    /**
     * Test abstract code generator.
     *
     * @throws Atf4jException the atf 4 j exception
     */
    @Test
    public void testAbstractCodeGenerator() throws Atf4jException {
        final JavaClassGenerator javaClassGenerator = new JavaClassGenerator();
        verifyNotNull(javaClassGenerator);
        verifyNotNull(javaClassGenerator.generate());
    }

    /**
     * Test abstract code generator string.
     *
     * @throws Atf4jException the atf 4 j exception
     */
    @Test
    public void testAbstractCodeGeneratorString() throws Atf4jException {
        final JavaClassGenerator javaClassGenerator = new JavaClassGenerator("templates/Class.vm");
        verifyNotNull(javaClassGenerator);
        verifyNotNull(javaClassGenerator.generate());
    }

}
