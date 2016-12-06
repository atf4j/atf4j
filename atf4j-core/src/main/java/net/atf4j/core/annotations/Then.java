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
 * Then Predicate annotation. contains the short name for the test.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 * @version $Revision: 1.0 $
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Then {

	/**
	 * Value.
	 *
	 * @return the string
	 */
	String value();

}
