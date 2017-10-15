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
import java.util.List;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.Atf4jException;

/**
 * Abstract Code Generator class.
 */
public abstract class AbstractCodeGenerator {

    private final VelocityEngine velocityEngine = new VelocityEngine();
    private final VelocityContext context = new VelocityContext();

    private static final String TARGET_FOLDER = "src/generated/java";
    private static final String CLASS_TEMPLATE = "/templates/Class.vm";
    protected static final String UNEXPECTED_NULL = "unexpected null";

    private String templateFilename = CLASS_TEMPLATE;
    private String packageName = "net.atf4j.generated";
    private String className = "ExampleClass";
    private final String targetHomeFolder = TARGET_FOLDER;

    protected final List<ClassField> fields = new ArrayList<ClassField>();
    protected final List<ClassMethod> methods = new ArrayList<ClassMethod>();
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Instantiates a new code generator.
     */
    public AbstractCodeGenerator() {
        super();
        initialise();
    }

    /**
     * Instantiates a new code generator.
     *
     * @param templateFilename
     *            the template filename
     * @throws TemplateNotLoaded
     *             the template not loaded
     */
    public AbstractCodeGenerator(final String templateFilename) throws TemplateNotLoaded {
        super();
        setTemplate(templateFilename);
        initialise();
    }

    /**
     * Initialise.
     */
    private void initialise() {
        this.velocityEngine.init();
        contextBinding("util", this);
    }

    /**
     * Context binding.
     *
     * @param key
     *            the key
     * @param value
     *            the value
     * @return the code generator
     */
    public AbstractCodeGenerator contextBinding(final String key, final Object value) {
        assumeNotNull(key);
        assumeTrue(key.length() > 0);
        assumeNotNull(value);
        this.context.put(key, value);
        return this;
    }

    /**
     * Sets the template.
     *
     * @param templateFilename
     *            the template filename
     * @return the code generator
     * @throws TemplateNotLoaded
     *             the template not loaded
     */
    public AbstractCodeGenerator setTemplate(final String templateFilename) throws TemplateNotLoaded {
        this.templateFilename = templateFilename;
        return this;
    }

    /**
     * Sets the package name.
     *
     * @param packageName
     *            the package name
     * @return the code generator
     */
    public AbstractCodeGenerator setPackageName(final String packageName) {
        this.packageName = packageName;
        return this;
    }

    /**
     * Sets the class name.
     *
     * @param className
     *            the class name
     * @return the code generator
     */
    public AbstractCodeGenerator setClassName(final String className) {
        this.className = classCase(className);
        return this;
    }

    /**
     * Template filename.
     *
     * @return the string
     */
    public String templateFilename() {
        return this.templateFilename;
    }

    /**
     * Package name.
     *
     * @return the string
     */
    public String packageName() {
        return this.packageName;
    }

    /**
     * Class name.
     *
     * @return the string
     */
    public String className() {
        return this.className;
    }

    /**
     * Class case.
     *
     * @param candidateClassName
     *            the candidate class name
     * @return the string
     */
    public String classCase(final String candidateClassName) {
        return firstUpper(candidateClassName);
    }

    /**
     * Method case.
     *
     * @param string
     *            the string
     * @return the string
     */
    public String methodCase(final String string) {
        final char[] charArray = string.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    /**
     * First upper.
     *
     * @param string
     *            the string
     * @return the string
     */
    @Deprecated
    public String firstUpper(final String string) {
        final char[] charArray = string.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        return new String(charArray);
    }

    /**
     * Adds the field.
     *
     * @param classField
     *            the class field
     * @return the code generator
     */
    public AbstractCodeGenerator addField(final ClassField classField) {
        this.fields.add(classField);
        return this;
    }

    /**
     * Adds the method.
     *
     * @param returnType
     *            the return type
     * @param methodName
     *            the method name
     * @return the code generator
     */
    public AbstractCodeGenerator addMethod(final String returnType, final String methodName) {
        final ClassMethod classField = new ClassMethod(returnType, methodName);
        this.methods.add(classField);
        return this;
    }

    /**
     * Adds the method.
     *
     * @param classMethod
     *            the class method
     * @return the code generator
     */
    public AbstractCodeGenerator addMethod(final ClassMethod classMethod) {
        this.methods.add(classMethod);
        return this;
    }

    /**
     * Prototype.
     *
     * @return the string
     * @throws Exception
     *             the exception
     */
    public String prototype() throws Exception {
        final InputStreamReader templateReader = templateReader(this.templateFilename);
        final StringWriter writer = new StringWriter();
        generate(templateReader, writer);
        return writer.toString();
    }

    /**
     * Generate.
     *
     * @return the code generator
     * @throws Exception
     *             the exception
     */
    public AbstractCodeGenerator generate() throws Exception {
        assumeNotNull(this.templateFilename);
        assumeTrue(this.templateFilename.length() > 0);
        return generate(this.templateFilename);
    }

    /**
     * Generate.
     *
     * @param templateFilename
     *            the template filename
     * @return the code generator
     * @throws Exception
     *             the exception
     */
    public AbstractCodeGenerator generate(final String templateFilename) throws Exception {
        return generate(templateReader(templateFilename));
    }

    /**
     * Generate.
     *
     * @param templateReader
     *            the template reader
     * @return the code generator
     * @throws Exception
     *             the exception
     */
    private AbstractCodeGenerator generate(final InputStreamReader templateReader) throws Exception {
        final BufferedWriter bufferedWriter = destinationWriter();
        assertNotNull(UNEXPECTED_NULL, bufferedWriter);
        return generate(templateReader, bufferedWriter);
    }

    /**
     * Generate.
     *
     * @param templateReader
     *            the template reader
     * @param writer
     *            the writer
     * @return the code generator
     * @throws Exception
     *             the exception
     */
    private AbstractCodeGenerator generate(final InputStreamReader templateReader, final Writer writer)
            throws Exception {
        final String logTag = this.getClass().getSimpleName();

        contextBinding("packageName", this.packageName);
        contextBinding("className", this.className);
        contextBinding("fields", this.fields);
        contextBinding("methods", this.methods);

        final boolean evaluate = this.velocityEngine.evaluate(this.context, writer, logTag, templateReader);

        writer.flush();
        writer.close();

        assertTrue(evaluate);

        return this;
    }

    /**
     * Template reader.
     *
     * @param templateFilename
     *            the template filename
     * @return the input stream reader
     * @throws TemplateNotLoaded
     *             the template not loaded
     */
    private InputStreamReader templateReader(final String templateFilename) throws TemplateNotLoaded {
        this.log.info(templateFilename);
        final InputStream resourceAsStream = this.getClass().getResourceAsStream(templateFilename);
        if (resourceAsStream == null) {
            throw new TemplateNotLoaded(templateFilename);
        } else {
            return new InputStreamReader(resourceAsStream);
        }
    }

    /**
     * Destination writer.
     *
     * @return the buffered writer
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private BufferedWriter destinationWriter() throws IOException {
        final String packageFolder = packageFolder(this.packageName);
        final String targetPath = targetPath(this.targetHomeFolder, packageFolder);
        final String targetFile = targetFilename(targetPath, this.className);
        final File file = new File(targetFile);
        final FileWriter fileWriter = new FileWriter(file);
        final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        return bufferedWriter;
    }

    /**
     * Target filename.
     *
     * @param targetPath
     *            the target path
     * @param className
     *            the class name
     * @return the string
     */
    private String targetFilename(final String targetPath, final String className) {
        final String targetFile = String.format("%s/%s.java", targetPath, className);
        this.log.info("generatedFile={}", targetFile);
        return targetFile;
    }

    /**
     * Target path.
     *
     * @param homeFolder
     *            the home folder
     * @param packageFolder
     *            the package folder
     * @return the string
     */
    private String targetPath(final String homeFolder, final String packageFolder) {
        assertNotNull(UNEXPECTED_NULL, homeFolder);
        assertNotNull(UNEXPECTED_NULL, packageFolder);
        final String targetPath = String.format("%s/%s", homeFolder, packageFolder);
        this.log.info("targetPath={}", targetPath);
        new File(targetPath).mkdirs();
        return targetPath;
    }

    /**
     * Package folder.
     *
     * @param packageName
     *            the package name
     * @return the string
     */
    private String packageFolder(final String packageName) {
        final String packageFolder = packageName.replace('.', File.separatorChar);
        this.log.info("packageFolder={}", packageFolder);
        return packageFolder;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format(
                "JavaClassGenerator [templateFilename=%s, packageName=%s, className=%s, fields=%s, methods=%s]",
                this.templateFilename, this.packageName, this.className, this.fields, this.methods);
    }

    /**
     * The TemplateNotLoaded Class.
     */
    @SuppressWarnings("serial")
    public class TemplateNotLoaded extends Atf4jException {

        /**
         * Instantiates a new template not loaded.
         *
         * @param expectedTemplateFilename
         *            the expected template filename
         */
        public TemplateNotLoaded(final String expectedTemplateFilename) {
            super(String.format("TemplateNotLoaded [expectedTemplateFilename=%s]", expectedTemplateFilename));
        }
    }

}
