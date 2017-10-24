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

import net.atf4j.core.TestResultsReporting;

/**
 * Template Engine Class.
 */
public abstract class AbstractTemplateEngine extends TestResultsReporting {

    /** Default template filename. */
    protected String templateFilename = "templates/Class.vm";

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
    public AbstractTemplateEngine(String templateFilename) {
        super();
        setTemplateFilename(templateFilename);
    }

    /**
     * Execute.
     *
     * @return this for a fluent interface.
     */
    public AbstractTemplateEngine execute() {
        final VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        final Template template = velocityEngine.getTemplate(templateFilename);
        final VelocityContext context = new VelocityContext();
        context.put("name", this);

        final StringWriter writer = new StringWriter();
        template.merge(context, writer);

        log.info(writer.toString());

        return this;
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

    /**
     * To code.
     *
     * @return the string
     */
    public String toCode() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("AbstractTemplateEngine [templateFilename=%s]", templateFilename);
    }

}
