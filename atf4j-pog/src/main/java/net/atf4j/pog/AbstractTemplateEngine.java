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

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import net.atf4j.core.Atf4jException;
import net.atf4j.core.TestResultsReporting;

/**
 * Abstract Template Engine Class.
 */
public abstract class AbstractTemplateEngine extends TestResultsReporting {

    /** Default template folder. */
    private static final String DEFAULT_CLASS_TEMPLATE = "template.vm";

    /** Default base folder. */
    private String basePath = "./";

    /** Default template filename. */
    protected String templateFilename = DEFAULT_CLASS_TEMPLATE;

    /**
     * Instantiates a new abstract template engine.
     */
    public AbstractTemplateEngine() {
        super();
    }

    /**
     * Instantiates a new abstract template engine.
     *
     * @param templateFilename the template filename
     */
    public AbstractTemplateEngine(final String templateFilename) {
        super();
        setTemplateFilename(templateFilename);
    }

    /**
     * Sets the base folder.
     *
     * @param baseFolder the new base folder
     */
    public void setBaseFolder(final String baseFolder) {
        this.basePath = baseFolder;
    }

    /**
     * Execute.
     *
     * @return this for a fluent interface.
     */
    protected AbstractTemplateEngine execute() {
        return execute(getTemplateFilename());
    }

    /**
     * Execute.
     *
     * @param templateFilename the template filename
     * @return this for a fluent interface.
     */
    protected AbstractTemplateEngine execute(final String templateFilename) {
        log.info(toCode(templateFilename));
        return this;
    }

    /**
     * To code.
     *
     * @return the code as a string.
     */
    public String toCode() {
        return toCode(getTemplateFilename());
    }

    /**
     * To code.
     *
     * @param templateFilename the template filename
     * @return the code as a string.
     */
    protected String toCode(final String templateFilename) {
        log.info("templateFilename = {}", templateFilename);

        final VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();
        velocityEngine.setProperty("file.resource.loader.path", basePath);

        final Template template = velocityEngine.getTemplate(templateFilename);
        final VelocityContext context = new VelocityContext();
        context.put("name", this);

        final StringWriter writer = new StringWriter();
        template.merge(context, writer);

        return writer.toString();
    }

    /**
     * Sets the template filename.
     *
     * @param templateFilename the new template filename
     */
    public void setTemplateFilename(String templateFilename) {
        this.templateFilename = templateFilename;
    }

    /**
     * Gets the template filename.
     *
     * @return the template filename
     */
    public String getTemplateFilename() {
        return templateFilename;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("AbstractTemplateEngine [baseFolder=%s, templateFilename=%s]",
                basePath,
                templateFilename);
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
