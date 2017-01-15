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

import org.junit.Test;

import net.atf4j.core.ResultsReporting;

public class JavaClassGeneratorTest extends ResultsReporting {
    public class JavaClassGenerator extends CodeGenerator {
        public JavaClassGenerator() {
            super();
        }

        public JavaClassGenerator(final String templateFilename) throws TemplateNotLoaded {
            super(templateFilename);
        }
    }

    @Test
    public void testPrototype() throws Exception {
        this.log.info("==============================================");
        final JavaClassGenerator javaClassGenerator = new JavaClassGenerator();
        assertNotNull(javaClassGenerator);
        this.log.info(javaClassGenerator.prototype());
    }

    @Test
    public void testExpected() throws Exception {
        this.log.info("==============================================");
        final JavaClassGenerator javaClassGenerator = new JavaClassGenerator();
        assertNotNull(javaClassGenerator);
        javaClassGenerator.setClassName("NewClass");
        javaClassGenerator.addField(new ClassField("String", "aString"));
        javaClassGenerator.addMethod(new ClassMethod("String", "toString"));
        this.log.info(javaClassGenerator.prototype());
        javaClassGenerator.generate();
    }
}
