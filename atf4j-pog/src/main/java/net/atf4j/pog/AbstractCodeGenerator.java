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
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.atf4j.core.Atf4jException;
import net.atf4j.core.TestResultsReporting;

/**
 * Abstract Code Generator class.
 */
public abstract class AbstractCodeGenerator extends TestResultsReporting {

    /** The Constant TARGET_FOLDER. */
    private static final String TARGET_FOLDER = "src/generated/java";

    /** The Constant CLASS_TEMPLATE. */
    private static final String CLASS_TEMPLATE = "/templates/Class.vm";

    /** The Constant UNEXPECTED_NULL. */
    protected static final String UNEXPECTED_NULL = "unexpected null";

    /** The velocity engine. */
    private final VelocityEngine velocityEngine = new VelocityEngine();

    /** The context. */
    private final VelocityContext context = new VelocityContext();

    /** The fields. */
    protected final List<ClassField> fields = new ArrayList<ClassField>();

    /** The methods. */
    protected final List<ClassMethod> methods = new ArrayList<ClassMethod>();

    /** The log. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The template filename. */
    private String templateFilename = CLASS_TEMPLATE;

    /** The package name. */
    private String packageName = "net.atf4j.generated";

    /** The class name. */
    private String className = "ExampleClass";

    /** The target home folder. */
    private final String targetHomeFolder = TARGET_FOLDER;

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
     * @param templateFilename the template filename
     * @throws TemplateNotLoadedException the template not loaded
     */
    public AbstractCodeGenerator(final String templateFilename) throws TemplateNotLoadedException {
        super();
        setTemplate(templateFilename);
        initialise();
    }

    /**
     * Initialise.
     */
    private void initialise() {
        velocityEngine.init();
        contextBinding("util", this);
    }

    /**
     * Context binding.
     *
     * @param key the key
     * @param value the value
     * @return the code generator
     */
    public AbstractCodeGenerator contextBinding(final String key, final Object value) {
        assumeNotNull(key);
        assumeTrue(key.length() > 0);
        assumeNotNull(value);
        context.put(key, value);
        return this;
    }

    /**
     * Sets the template.
     *
     * @param templateFilename the template filename
     * @return the code generator
     * @throws TemplateNotLoadedException the template not loaded
     */
    public AbstractCodeGenerator setTemplate(final String templateFilename) throws TemplateNotLoadedException {
        this.templateFilename = templateFilename;
        return this;
    }

    /**
     * Sets the package name.
     *
     * @param packageName the package name
     * @return the code generator
     */
    public AbstractCodeGenerator setPackageName(final String packageName) {
        this.packageName = packageName;
        return this;
    }

    /**
     * Sets the class name.
     *
     * @param className the class name
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
        return templateFilename;
    }

    /**
     * Package name.
     *
     * @return the string
     */
    public String packageName() {
        return packageName;
    }

    /**
     * Class name.
     *
     * @return the string
     */
    public String className() {
        return className;
    }

    /**
     * Class case.
     *
     * @param candidateClassName the candidate class name
     * @return the string
     */
    public String classCase(final String candidateClassName) {
        return firstUpper(candidateClassName);
    }

    /**
     * Method case.
     *
     * @param string the string
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
     * @param string the string
     * @return the string
     */
    public String firstUpper(final String string) {
        final char[] charArray = string.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        return new String(charArray);
    }

    /**
     * Adds the field.
     *
     * @param classField the class field
     * @return the code generator
     */
    public AbstractCodeGenerator addField(final ClassField classField) {
        fields.add(classField);
        return this;
    }

    /**
     * Adds the method.
     *
     * @param returnType the return type
     * @param methodName the method name
     * @return the code generator
     */
    public AbstractCodeGenerator addMethod(final String returnType, final String methodName) {
        final ClassMethod classField = new ClassMethod(returnType, methodName);
        methods.add(classField);
        return this;
    }

    /**
     * Adds the method.
     *
     * @param classMethod the class method
     * @return the code generator
     */
    public AbstractCodeGenerator addMethod(final ClassMethod classMethod) {
        methods.add(classMethod);
        return this;
    }

    /**
     * Generate.
     *
     * @return the code generator
     * @throws Atf4jException the Atf4jException
     */
    public AbstractCodeGenerator generate() throws Atf4jException {
        assumeNotNull(templateFilename);
        assumeTrue(templateFilename.length() > 0);
        return generate(templateFilename);
    }

    /**
     * Generate from template.
     *
     * @param templateFilename the template filename
     * @return the code generator
     * @throws Atf4jException the Atf4jException
     */
    public AbstractCodeGenerator generate(final String templateFilename) throws Atf4jException {
        return generate(templateReader(templateFilename));
    }

    /**
     * Generate from input steam reader to output stream.
     *
     * @param templateReader the template reader
     * @return the code generator
     * @throws Atf4jException the Atf4jException
     */
    private AbstractCodeGenerator generate(final InputStreamReader templateReader) throws Atf4jException {
        final Writer writer;

        try {
            writer = destinationWriter();
        } catch (final IOException e) {
            log.error(e.toString());
            throw new CodeNotGeneratedException(className);
        }

        assertNotNull(UNEXPECTED_NULL, writer);

        final String logTag = this.getClass().getSimpleName();
        contextBinding("packageName", packageName);
        contextBinding("className", className);
        contextBinding("fields", fields);
        contextBinding("methods", methods);

        assertTrue(velocityEngine.evaluate(context, writer, logTag, templateReader));

        try {
            writer.flush();
            writer.close();
        } catch (final IOException e) {
            log.error(e.toString());
            throw new CodeNotGeneratedException(className);
        }

        return this;
    }

    /**
     * Template reader from template filename.
     *
     * @param templateFilename the template filename
     * @return the input stream reader
     * @throws TemplateNotLoadedException the template not loaded
     */
    private InputStreamReader templateReader(final String templateFilename) throws TemplateNotLoadedException {
        log.debug("templateFilename = {}", templateFilename);
        final InputStream resourceAsStream = resourceAsStream(templateFilename);
        if (resourceAsStream == null) {
            throw new TemplateNotLoadedException(templateFilename);
        } else {
            return new InputStreamReader(resourceAsStream);
        }
    }

    /**
     * Resource as stream from resource name.
     *
     * @param resourceFilename the resource filename
     * @return the input stream
     */
    private InputStream resourceAsStream(final String resourceFilename) {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        return classLoader.getResourceAsStream(resourceFilename);
    }

    /**
     * Destination writer.
     *
     * @return the buffered writer
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private BufferedWriter destinationWriter() throws IOException {
        final String packageFolder = packageFolder(packageName);
        final String targetPath = targetPath(targetHomeFolder, packageFolder);
        final String targetFile = targetFilename(targetPath, className);
        final File file = new File(targetFile);
        final FileWriter fileWriter = new FileWriter(file);
        return new BufferedWriter(fileWriter);
    }

    /**
     * Target filename.
     *
     * @param targetPath the target path
     * @param className the class name
     * @return the string
     */
    private String targetFilename(final String targetPath, final String className) {
        final String targetFile = String.format("%s/%s.java", targetPath, className);
        log.info("generatedFile={}", targetFile);
        return targetFile;
    }

    /**
     * Target path.
     *
     * @param homeFolder the home folder
     * @param packageFolder the package folder
     * @return the string
     */
    private String targetPath(final String homeFolder, final String packageFolder) {
        assertNotNull(UNEXPECTED_NULL, homeFolder);
        assertNotNull(UNEXPECTED_NULL, packageFolder);
        final String targetPath = String.format("%s/%s", homeFolder, packageFolder);
        log.info("targetPath={}", targetPath);
        new File(targetPath).mkdirs();
        return targetPath;
    }

    /**
     * Package folder.
     *
     * @param packageName the package name
     * @return the string
     */
    private String packageFolder(final String packageName) {
        final String packageFolder = packageName.replace('.', File.separatorChar);
        log.info("packageFolder={}", packageFolder);
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
                templateFilename,
                packageName,
                className,
                fields,
                methods);
    }

    /**
     * Exception to indicate that no Template was not loaded.
     */
    @SuppressWarnings("serial")
    public class TemplateNotLoadedException extends Atf4jException {
        /**
         * Instantiates a new template not loaded.
         *
         * @param expectedTemplateFilename the expected template filename
         */
        public TemplateNotLoadedException(final String expectedTemplateFilename) {
            super(String.format("TemplateNotLoaded [expectedTemplateFilename=%s]", expectedTemplateFilename));
        }
    }

    /**
     * Exception to indicate that no Code was Generated.
     */
    @SuppressWarnings("serial")
    public class CodeNotGeneratedException extends Atf4jException {

        /**
         * Instantiates a new template not loaded.
         *
         * @param expectedCodeFilename the expected code filename
         */
        public CodeNotGeneratedException(final String expectedCodeFilename) {
            super(String.format("TemplateNotLoaded [expectedCodeFilename=%s]", expectedCodeFilename));
        }
    }
}
