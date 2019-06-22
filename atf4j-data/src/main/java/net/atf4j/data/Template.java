
package net.atf4j.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Template class.
 */
public class Template {

    /**
     * TemplateException class.
     */
    public class TemplateException extends Exception {

        /** serialVersionUID constant. */
        private static final long serialVersionUID = -7339416432777745473L;

        /**
         * Instantiates a new template exception.
         *
         * @param message the message
         */
        public TemplateException(final String message) {
            super(message);
        }
    }

    /** provide logging. */
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    /** The template. */
    protected StringBuffer template;

    /**
     * From filename.
     *
     * @param filename the filename
     * @return the template
     */
    public static Template from(final String filename) {
        return new Template(filename);
    }

    /**
     * From inputStream.
     *
     * @param inputStream the input stream
     * @return the template
     * @throws TemplateException the template exception
     */
    public static Template from(final InputStream inputStream) throws TemplateException {
        return new Template().load(inputStream);
    }

    /**
     * Instantiates a new template.
     */
    protected Template() {
        this.template = new StringBuffer();
    }

    /**
     * Instantiates a new template.
     *
     * @param string the string
     */
    protected Template(final String string) {
        this.template = new StringBuffer(string);
    }

    /**
     * Load template from inputStream.
     *
     * @param inputStream the input stream
     * @return the template
     * @throws TemplateException the template exception
     */
    public Template load(final InputStream inputStream) throws TemplateException {
        if (inputStream == null) {
            throw new TemplateException("input stream cannot be null");
        } else {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                this.template = new StringBuffer();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    this.template.append(line);
                }
            } catch (IOException e) {
                throw new TemplateException(e.getLocalizedMessage());
            }
        }
        return this;
    }

    /**
     * Load template from filename.
     *
     * @param filename the filename
     * @return the template
     * @throws TemplateException the template exception
     */
    public Template load(final String filename) throws TemplateException {
        if (filename == null) {
            throw new TemplateException("filename cannot be null");
        } else if (filename.isEmpty()) {
            throw new TemplateException("filename cannot be empty");
        } else {
            try {
                Path path = Paths.get(filename);
                Charset utf8 = StandardCharsets.UTF_8;
                byte[] bytes = Files.readAllBytes(path);
                this.template = new StringBuffer();
                this.template.append(bytes);
            } catch (IOException e) {
                String msg = "Template file not found : " + filename;
                throw new TemplateException(msg);
            }
        }
        return this;
    }

    /**
     * Replace target with replacement.
     *
     * @param target the target
     * @param replacement the replacement
     * @return the template
     * @throws TemplateException the template exception
     */
    public Template replace(final String target, final String replacement) throws TemplateException {
        if (target == null) {
            throw new TemplateException("target cannot be null");
        } else if (replacement == null) {
            throw new TemplateException("target cannot be null");
        } else {
            int startOfTarget = this.template.indexOf(target);
            if (startOfTarget >= 0) {
                int endOfTarget = startOfTarget + target.length();
                this.template.replace(startOfTarget, endOfTarget, replacement);
            } else {
                log.error("target {} not found in template\n\t{}", target, this.template.toString());
            }
        }
        return this;
    }

    /**
     * Merge the values from the map into the template.
     *
     * @param map the map
     * @return the template
     * @throws TemplateException the template exception
     */
    public Template merge(final Map<String, Object> map) throws TemplateException {
        if (map != null) {
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                Object object = map.get(key);
                String target = String.format("${%s}", key);
                String substitution = String.format("%s", object);
                replace(target, substitution);
            }
        }
        return this;
    }

    /**
     * Merge the values from the properties into the template.
     *
     * @param properties the properties
     * @return the template
     * @throws TemplateException the template exception
     */
    public Template merge(final Properties properties) throws TemplateException {
        if (properties != null) {
            Set<String> keySet = properties.stringPropertyNames();
            for (String key : keySet) {
                Object object = properties.get(key);
                String target = String.format("${%s}", key);
                String substitution = String.format("%s", object);
                replace(target, substitution);
            }
        }
        return this;
    }

    /**
     * To log.
     *
     * @return the template
     */
    public Template toLog() {
        log.info(toString());
        return this;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("Template [template=%s]", this.template.toString());
    }

}
