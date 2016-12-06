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

	public PageObjectGenerator(String templateFilename) {
		super();
		
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		String file = contextClassLoader.getResource("/").getFile();
		System.out.println(file);
		String absolutePath = new File(file).getParentFile().getParentFile().getPath();
		System.out.println(absolutePath);		

		Properties properties = new Properties();
		properties.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
		properties.setProperty("file.resource.loader.path", "/path/to/templates");

        velocityEngine = new VelocityEngine();
        velocityEngine.init(properties);

        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath"); 
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        
		template = velocityEngine.getTemplate( templateFilename );
		context = new VelocityContext();

	}

	public void with(final String key, final String value) {
        context.put(key,value);
	}

	public StringWriter generate(String targetUrl) {
        StringWriter writer = new StringWriter();
        template.merge( context, writer );
        return writer;
	}

}
