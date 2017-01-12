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
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.Atf4jException;

public abstract class JavaClassGenerator {

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private static final String TARGET_FOLDER = "src/generated/java";
    private static final String CLASS_TEMPLATE = "/templates/Class.vm";

    private final VelocityEngine velocityEngine = new VelocityEngine();
    private final VelocityContext context = new VelocityContext();

    private String templateFilename = CLASS_TEMPLATE;
    private InputStreamReader templateReader = null;

    private String packageName = "net.atf4j.generated";
    private String className = "ExampleClass";

    protected ArrayList<ClassField> fields = new ArrayList<ClassField>();
    protected ArrayList<ClassMethod> methods = new ArrayList<ClassMethod>();

    private final String targetHomeFolder = TARGET_FOLDER;
    private String targetPath = null;
    private String targetfilename = null;
    private final Writer targetWriter = null;

    public JavaClassGenerator() {
        initialise();
    }

    public JavaClassGenerator(final String templateFilename) throws TemplateNotLoaded {
        setTemplate(templateFilename);
        initialise();
    }

    private void initialise() {
        this.velocityEngine.init();
        contextBinding("fields", this.fields);
        contextBinding("methods", this.methods);
    }

    public JavaClassGenerator contextBinding(final String key, final Object value) {
        assumeNotNull(key);
        assumeTrue(key.length() > 0);
        assumeNotNull(value);
        this.context.put(key, value);
        return this;
    }

    public JavaClassGenerator setTemplate(final String templateFilename) throws TemplateNotLoaded {
        this.templateFilename = templateFilename;
        this.templateReader = templateReader(templateFilename);
        return this;
    }

    public JavaClassGenerator setPackageName(final String packageName) {
        this.packageName = packageName;
        return this;
    }

    public JavaClassGenerator setClassName(final String className) {
        this.className = classCase(className);
        this.targetfilename = String.format("", className);
        return this;
    }

    public String templateFilename() {
        return this.templateFilename;
    }

    public String className() {
        return this.className;
    }

    public String packageName() {
        return this.packageName;
    }

    private String classCase(final String candidateClassName) {
        final StringBuffer buffer = new StringBuffer(candidateClassName.trim());
        buffer.setCharAt(0, Character.toUpperCase(candidateClassName.charAt(0)));
        return buffer.toString();
    }

    public JavaClassGenerator addField(final String fieldType, final String fieldName) {
        final ClassField classField = new ClassField(fieldType, fieldName);
        this.fields.add(classField);
        return this;
    }

    public JavaClassGenerator addField(final ClassField classField) {
        this.fields.add(classField);
        return this;
    }

    public JavaClassGenerator addMethod(final String returnType, final String methodName) {
        final ClassMethod classField = new ClassMethod(returnType, methodName);
        this.methods.add(classField);
        return this;
    }

    public JavaClassGenerator addMethod(final ClassMethod classMethod) {
        this.methods.add(classMethod);
        return this;
    }

    public JavaClassGenerator generate() throws Exception {
        assumeNotNull(this.templateFilename);
        assumeTrue(this.templateFilename.length() > 0);
        return generate(this.templateFilename);
    }

    public JavaClassGenerator prototype() throws Exception {
        final StringWriter writer = new StringWriter();
        final InputStreamReader templateReader = templateReader(this.templateFilename);
        generate(templateReader, writer);
        return this;
    }

    public JavaClassGenerator generate(final String templateFilename) throws Exception {
        return generate(templateReader(templateFilename));
    }

    public JavaClassGenerator generate(final InputStreamReader templateReader) throws Exception {
        final BufferedWriter bufferedWriter = destinationWriter();
        assertNotNull(bufferedWriter);
        return generate(templateReader, bufferedWriter);
    }

    private JavaClassGenerator generate(final InputStreamReader templateReader, final Writer writer) throws Exception {

        contextBinding("packageName", this.packageName);
        contextBinding("className", this.className);
        contextBinding("fields", this.fields);
        contextBinding("methods", this.methods);

        final String logTag = this.getClass().getSimpleName();

        final boolean evaluate = this.velocityEngine.evaluate(this.context,
                writer,
                logTag,
                templateReader);

        writer.flush();
        writer.close();

        assertTrue(evaluate);

        return this;
    }

    public InputStreamReader templateReader(final String templateFilename) throws TemplateNotLoaded {
        this.log.info(templateFilename);
        final InputStream resourceAsStream = this.getClass().getResourceAsStream(templateFilename);
        final InputStreamReader inputStreamReader;
        if (resourceAsStream == null) {
            throw new TemplateNotLoaded(templateFilename);
        } else {
            inputStreamReader = new InputStreamReader(resourceAsStream);
        }
        return inputStreamReader;
    }

    private BufferedWriter destinationWriter() throws IOException {
        assumeNotNull(this.targetHomeFolder);
        assumeTrue(this.targetHomeFolder.length() > 0);
        this.log.info("generatedSources={}", this.targetHomeFolder);

        final String packageFolder = this.packageName.replace('.', File.separatorChar);
        this.log.info("packageFolder={}", packageFolder);

        this.targetPath = String.format("%s/%s",
                this.targetHomeFolder,
                packageFolder);
        this.log.info("targetPath={}", this.targetPath);
        new File(this.targetPath).mkdirs();

        final String targetFile = String.format("%s/%s/%s.java",
                this.targetHomeFolder,
                packageFolder,
                this.className);
        this.log.info("generatedFile={}", targetFile);

        final File file = new File(targetFile);
        final FileWriter fileWriter = new FileWriter(file);
        final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        return bufferedWriter;
    }

    @SuppressWarnings("serial")
    public class TemplateNotLoaded extends Atf4jException {
        public TemplateNotLoaded(final String expectedTemplateFilename) {
            super(String.format("TemplateNotLoaded [expectedTemplateFilename=%s]", expectedTemplateFilename));
        }
    }

}
