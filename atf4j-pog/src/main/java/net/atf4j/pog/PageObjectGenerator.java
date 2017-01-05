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

import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import net.atf4j.core.Atf4jException;
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
     * @throws TemplateNotLoaded
     *             the template not loaded
     */
    public PageObjectGenerator(final String templateFilename) throws TemplateNotLoaded {
        super();

        try {
            final InputStream resourceAsStream = this.getClass().getResourceAsStream(templateFilename);
            assertNotNull(resourceAsStream);
        } catch (final Exception e) {
            throw new TemplateNotLoaded(templateFilename);
        }

        final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        final URL resourceFolder = contextClassLoader.getResource("/");
        final URL templatesFolder = contextClassLoader.getResource("/templates");
        this.log.info(templatesFolder.toString());
        final String filePath = resourceFolder.getFile();
        this.log.info("filePath={}", filePath);
        final String absolutePath = new File(filePath).getParentFile().getParentFile().getPath();
        this.log.info("absolutePath={}", absolutePath);

        final Properties properties = new Properties();
        properties.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
        properties.setProperty("file.resource.loader.path", "/templates");

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
     * @param key
     *            the key
     * @param value
     *            the value
     * @return the page object generator
     */
    public PageObjectGenerator with(final String key, final String value) {
        this.context.put(key, value);
        return this;
    }

    /**
     * Target Page
     *
     * @param targetUrl
     *            the target url
     * @return the page object generator
     * @throws MalformedURLException
     *             the malformed URL exception
     */
    public PageObjectGenerator target(final String targetUrl) throws MalformedURLException {
        return target(new URL(targetUrl));
    }

    /**
     * Target.
     *
     * @param url
     *            the url
     * @return the page object generator
     */
    private PageObjectGenerator target(final URL targetUrl) {
        this.targetUrl = targetUrl;
        return this;
    }

    /**
     * Generate.
     *
     * @return the page object generator
     */
    public PageObjectGenerator generate() {
        if (this.targetUrl != null) {
            final StringWriter writer = new StringWriter();
            this.template.merge(this.context, writer);
        }
        return this;
    }

    @SuppressWarnings("serial")
    public class TemplateNotLoaded extends Atf4jException {
        /** The property filename. */
        private final String expectedTemplateFilename;

        public TemplateNotLoaded(final String missingTemplateFilename) {
            this.expectedTemplateFilename = missingTemplateFilename;
        }

        @Override
        public String toString() {
            return String.format("TemplateNotLoaded [expectedTemplateFilename=%s]", this.expectedTemplateFilename);
        }
    }

}
