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
 * The AutomatedTestId annotation; contains the external reference for the test.
 * 
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 * @version $Revision: 1.0 $
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestId {

	/**
	 * Value.
	 *
	 * @return the string
	 */
	String value();

}
