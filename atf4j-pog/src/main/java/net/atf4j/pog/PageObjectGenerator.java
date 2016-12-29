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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import net.atf4j.core.ResultsReporting;

/**
 * Generator for Selenium WebDriver PageObject.
 */
public class PageObjectGenerator extends ResultsReporting {
    protected URL targetUrl;
    protected VelocityEngine velocityEngine;
    protected VelocityContext context;
    protected Template template;

    /**
     * Instantiates a new page object generator.
     *
     * @param templateFilename
     *            the template filename
     */
    public PageObjectGenerator(final String templateFilename) {
        super();

        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        final String filePath = contextClassLoader.getResource("/").getFile();
        this.log.info("filePath={}", filePath);
        final String absolutePath = new File(filePath).getParentFile().getParentFile().getPath();
        this.log.info("absolutePath={}", absolutePath);

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

    /**
     * With.
     *
     * @param key the key
     * @param value the value
     * @return the page object generator
     */
    public PageObjectGenerator with(final String key, final String value) {
        this.context.put(key, value);
        return this;
    }

    /**
     * Target.
     *
     * @param targetUrl the target url
     * @return the page object generator
     */
    public PageObjectGenerator target(final String targetUrl) {
        this.log.info("targetUrl={}", targetUrl);
        try {
            return target(new URL(targetUrl));
        } catch (final MalformedURLException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Target.
     *
     * @param url the url
     * @return the page object generator
     */
    private PageObjectGenerator target(final URL url) {
        return null;
    }

    /**
     * Generate.
     *
     * @return the page object generator
     */
    public PageObjectGenerator generate() {
        final StringWriter writer = new StringWriter();
        this.template.merge(this.context, writer);
        return this;
    }
}
