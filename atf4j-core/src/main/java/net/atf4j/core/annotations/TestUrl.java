/*
 * 
 */
package net.atf4j.core.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The TestUrl annotation. Contains the starting URL for a AbstractTestSuite /
 * AbstractWebDriverScript.
 * 
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 * @version $Revision: 1.0 $
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestUrl {
	/**
	 * Value is String representation of a URL.
	 *
	 * @return the string
	 */
	String value();

}
