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
import org.junit.Test;

import net.atf4j.core.LoggedTest;

public class PageObjectGeneratorTest extends LoggedTest {

	@Test
	public void test() {
		PageObjectGenerator pog = new PageObjectGenerator("PageObject.vm");
		pog.with("name", "MyPage");
		pog.generate("http://atf4j.net");
	}

	@Test
	public void testVelocity() throws Exception {
		VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        ve.init();

        final String templatePath = "templates/PageObject.vm";
        InputStream input = this.getClass().getClassLoader().getResourceAsStream(templatePath);
        InputStreamReader reader = new InputStreamReader(input);

        VelocityContext context = new VelocityContext();

//        if (properties != null) {
//            stringfyNulls(properties);
//            for (Map.Entry<String, Object> property : properties.entrySet()) {
//                context.put(property.getKey(), property.getValue());
//            }
//        }

        Template template = ve.getTemplate(templatePath, "UTF-8");
        String outFileName = File.createTempFile("report", ".html").getAbsolutePath();
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outFileName)));

        if (!ve.evaluate(context, writer, templatePath, reader)) {
            throw new Exception("Failed to convert the template into html.");
        }

        template.merge(context, writer);

        writer.flush();
        writer.close();		
	}
	
}
