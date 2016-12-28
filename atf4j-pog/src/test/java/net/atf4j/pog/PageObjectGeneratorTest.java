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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.Ignore;
import org.junit.Test;

import net.atf4j.core.ResultsReporting;

/**
 * A UnitTest for PageObjectGenerator objects.
 */
@Ignore
public class PageObjectGeneratorTest extends ResultsReporting {

    @Test
    public void testMissingTemplate() {
        new PageObjectGenerator("Missing.vm");
    }

    @Test
    public void testPageObjectGenerator() {
        final PageObjectGenerator pog = new PageObjectGenerator("PageObject.vm");
        pog.target("http://atf4j.net");
        pog.with("name", "MyPage");
        pog.generate();
    }

    /**
     * test PageObjectGenerator object.
     *
     * @throws Exception
     *             the exception
     */
    @Test
    public void testVelocity() throws Exception {
        final VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        ve.init();

        final String templatePath = "/templates/PageObject.vm";
        final InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(templatePath);
        final InputStreamReader reader = new InputStreamReader(inputStream);

        final VelocityContext context = new VelocityContext();

        // if (properties != null) {
        // stringfyNulls(properties);
        // for (Map.Entry<String, Object> property : properties.entrySet()) {
        // context.put(property.getKey(), property.getValue());
        // }
        // }

        final Template template = ve.getTemplate(templatePath, "UTF-8");
        final String outFileName = File.createTempFile("report", ".html").getAbsolutePath();
        final BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outFileName)));

        if (!ve.evaluate(context, writer, templatePath, reader)) {
            throw new Exception("Failed to convert the template into html.");
        }

        template.merge(context, writer);

        writer.flush();
        writer.close();
    }

}
