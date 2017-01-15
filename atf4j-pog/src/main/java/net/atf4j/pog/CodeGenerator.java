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

public abstract class CodeGenerator {
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private final VelocityEngine velocityEngine = new VelocityEngine();
    private final VelocityContext context = new VelocityContext();

    private static final String TARGET_FOLDER = "src/generated/java";
    private static final String CLASS_TEMPLATE = "/templates/Class.vm";

    private String templateFilename = CLASS_TEMPLATE;
    private String packageName = "net.atf4j.generated";
    private String className = "ExampleClass";

    protected ArrayList<ClassField> fields = new ArrayList<ClassField>();
    protected ArrayList<ClassMethod> methods = new ArrayList<ClassMethod>();

    private final String targetHomeFolder = TARGET_FOLDER;

    public CodeGenerator() {
        initialise();
    }

    public CodeGenerator(final String templateFilename) throws TemplateNotLoaded {
        setTemplate(templateFilename);
        initialise();
    }

    private void initialise() {
        this.velocityEngine.init();
        contextBinding("util", this);
    }

    public CodeGenerator contextBinding(final String key, final Object value) {
        assumeNotNull(key);
        assumeTrue(key.length() > 0);
        assumeNotNull(value);
        this.context.put(key, value);
        return this;
    }

    public CodeGenerator setTemplate(final String templateFilename) throws TemplateNotLoaded {
        this.templateFilename = templateFilename;
        return this;
    }

    public CodeGenerator setPackageName(final String packageName) {
        this.packageName = packageName;
        return this;
    }

    public CodeGenerator setClassName(final String className) {
        this.className = classCase(className);
        return this;
    }

    public String templateFilename() {
        return this.templateFilename;
    }

    public String packageName() {
        return this.packageName;
    }

    public String className() {
        return this.className;
    }

    public String classCase(final String candidateClassName) {
        return firstUpper(candidateClassName);
    }

    public String methodCase(final String string) {
        final char[] charArray = string.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public String firstUpper(final String string) {
        final char[] charArray = string.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        return new String(charArray);
    }

    public CodeGenerator addField(final ClassField classField) {
        this.fields.add(classField);
        return this;
    }

    public CodeGenerator addMethod(final String returnType, final String methodName) {
        final ClassMethod classField = new ClassMethod(returnType, methodName);
        this.methods.add(classField);
        return this;
    }

    public CodeGenerator addMethod(final ClassMethod classMethod) {
        this.methods.add(classMethod);
        return this;
    }

    public String prototype() throws Exception {
        final InputStreamReader templateReader = templateReader(this.templateFilename);
        final StringWriter writer = new StringWriter();
        generate(templateReader, writer);
        return writer.toString();
    }

    public CodeGenerator generate() throws Exception {
        assumeNotNull(this.templateFilename);
        assumeTrue(this.templateFilename.length() > 0);
        return generate(this.templateFilename);
    }

    public CodeGenerator generate(final String templateFilename) throws Exception {
        return generate(templateReader(templateFilename));
    }

    private CodeGenerator generate(final InputStreamReader templateReader) throws Exception {
        final BufferedWriter bufferedWriter = destinationWriter();
        assertNotNull(bufferedWriter);
        return generate(templateReader, bufferedWriter);
    }

    private CodeGenerator generate(final InputStreamReader templateReader, final Writer writer) throws Exception {
        final String logTag = this.getClass().getSimpleName();

        contextBinding("packageName", this.packageName);
        contextBinding("className", this.className);
        contextBinding("fields", this.fields);
        contextBinding("methods", this.methods);

        final boolean evaluate = this.velocityEngine.evaluate(this.context,
                writer,
                logTag,
                templateReader);

        writer.flush();
        writer.close();

        assertTrue(evaluate);

        return this;
    }

    private InputStreamReader templateReader(final String templateFilename) throws TemplateNotLoaded {
        this.log.info(templateFilename);
        final InputStream resourceAsStream = this.getClass().getResourceAsStream(templateFilename);
        if (resourceAsStream == null) {
            throw new TemplateNotLoaded(templateFilename);
        } else {
            return new InputStreamReader(resourceAsStream);
        }
    }

    private BufferedWriter destinationWriter() throws IOException {
        final String packageFolder = packageFolder(this.packageName);
        final String targetPath = targetPath(this.targetHomeFolder, packageFolder);
        final String targetFile = targetFilename(targetPath, this.className);
        final File file = new File(targetFile);
        final FileWriter fileWriter = new FileWriter(file);
        final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        return bufferedWriter;
    }

    private String targetFilename(final String targetPath, final String className) {
        final String targetFile = String.format("%s/%s.java",
                targetPath,
                className);
        this.log.info("generatedFile={}", targetFile);
        return targetFile;
    }

    private String targetPath(final String homeFolder, final String packageFolder) {
        assertNotNull(homeFolder);
        assertNotNull(packageFolder);
        final String targetPath = String.format("%s/%s",
                homeFolder,
                packageFolder);
        this.log.info("targetPath={}", targetPath);
        new File(targetPath).mkdirs();
        return targetPath;
    }

    private String packageFolder(final String packageName) {
        final String packageFolder = packageName.replace('.', File.separatorChar);
        this.log.info("packageFolder={}", packageFolder);
        return packageFolder;
    }

    @Override
    public String toString() {
        return String.format(
                "JavaClassGenerator [templateFilename=%s, packageName=%s, className=%s, fields=%s, methods=%s]",
                this.templateFilename,
                this.packageName,
                this.className,
                this.fields,
                this.methods);
    }

    @SuppressWarnings("serial")
    public class TemplateNotLoaded extends Atf4jException {
        public TemplateNotLoaded(final String expectedTemplateFilename) {
            super(String.format("TemplateNotLoaded [expectedTemplateFilename=%s]", expectedTemplateFilename));
        }
    }

}
