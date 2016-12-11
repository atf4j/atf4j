/*
 * 
 */

package net.atf4j.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Automated Test Script Annotation Interface.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Atf4jTestScript {
}
