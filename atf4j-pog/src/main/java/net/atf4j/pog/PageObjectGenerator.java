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
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.pog;

import java.io.File;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class PageObjectGenerator {

    protected VelocityEngine velocityEngine;
    protected Template template;
    VelocityContext context;

    public PageObjectGenerator(final String templateFilename) {
        super();

        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        final String file = contextClassLoader.getResource("/").getFile();
        System.out.println(file);
        final String absolutePath = new File(file).getParentFile().getParentFile().getPath();
        System.out.println(absolutePath);

        final Properties properties = new Properties();
        properties.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
        properties.setProperty("file.resource.loader.path", "/path/to/templates");

        this.velocityEngine = new VelocityEngine();
        this.velocityEngine.init(properties);

        this.velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        this.velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        this.template = this.velocityEngine.getTemplate(templateFilename);
        this.context = new VelocityContext();

    }

    public void with(final String key, final String value) {
        this.context.put(key, value);
    }

    public StringWriter generate(final String targetUrl) {
        final StringWriter writer = new StringWriter();
        this.template.merge(this.context, writer);
        return writer;
    }

}
