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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The TemplateEngine Class.
 */
public abstract class TemplateEngine {
    
    /** The template filename. */
    protected String templateFilename = "template.vm";
    
    /** The log. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /**
     * Execue.
     *
     * @return the template engine
     */
    public TemplateEngine execue() {
        final VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        final Template template = velocityEngine.getTemplate(this.templateFilename);
        final VelocityContext context = new VelocityContext();
        context.put("name", this);

        final StringWriter writer = new StringWriter();
        template.merge(context, writer);

        this.log.info(writer.toString());

        return this;
    }
}
