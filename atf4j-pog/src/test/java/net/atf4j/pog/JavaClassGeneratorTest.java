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
    public class MockGenerator extends JavaClassGenerator {
        public MockGenerator() {
            super();
        }

        public MockGenerator(final String templateFilename) throws TemplateNotLoaded {
            super(templateFilename);
        }
    }

    @Test
    public void test() throws Exception {
        final MockGenerator mockGenerator = new MockGenerator();
        assertNotNull(mockGenerator);
        mockGenerator.setPackageName(mockGenerator.packageName());
        mockGenerator.setClassName(mockGenerator.className());
        mockGenerator.addField(new ClassField("String", "aString"));
        mockGenerator.addMethod(new ClassMethod("String", "toString()"));
        mockGenerator.generate();
    }

    @Test
    public void testDefaultConstructor() {
        this.log.info("testDefaultConstructor");
        final MockGenerator mockGenerator = new MockGenerator();
        assertNotNull(mockGenerator);
        this.log.debug(mockGenerator.toString());
    }

    @Test
    public void testJavaClassGeneratorString() {
        this.log.info("testJavaClassGeneratorString");
        final MockGenerator mockGenerator = new MockGenerator();
        assertNotNull(mockGenerator);
        this.log.debug(mockGenerator.toString());
    }

    @Test
    public void testAddField() {
        final MockGenerator mockGenerator = new MockGenerator();
        assertNotNull(mockGenerator);
        mockGenerator.addField(new ClassField("String", "aString"));
        this.log.info(mockGenerator.toString());
    }

    @Test
    public void testAddMethod() {
        final MockGenerator mockGenerator = new MockGenerator();
        assertNotNull(mockGenerator);
        mockGenerator.addMethod(new ClassMethod("String", "toString()"));
        this.log.info(mockGenerator.toString());
    }

    @Test
    public void testExpected() throws Exception {
        final MockGenerator mockGenerator = new MockGenerator();
        assertNotNull(mockGenerator);
        mockGenerator.setClassName("NewClass");
        mockGenerator.addField(new ClassField("String", "aString"));
        mockGenerator.addMethod(new ClassMethod("String", "toString()"));
        mockGenerator.generate();
    }

}
