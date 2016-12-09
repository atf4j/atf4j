/*
 * 
 */
package net.atf4j.bdd.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The PageById annotation. Contains the starting URL for a AbstractPage.
 * 
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 * @version $Revision: 1.0 $
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PageId {
	/**
	 * Value is String representation of a Key.
	 *
	 * @return the string
	 */
	String value();

}
