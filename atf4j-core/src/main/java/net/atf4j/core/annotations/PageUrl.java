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
 * The PageUrl annotation. Contains the starting URL for a AbstractPage.
 * 
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 * @version $Revision: 1.0 $
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PageUrl {
	/**
	 * Value is String representation of a URL of a Page.
	 *
	 * @return the string
	 */
	String value();

}
