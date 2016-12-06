package net.atf4j.bdd;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Atf4j Interface Annotations for Behaviour Driven Development.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Atf4j {

	@Documented
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Behaviour {
		String value();
	}

	@Documented
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Scenario {
		String value();
	}

	@Documented
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Given {
		String value();
	}

	@Documented
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface When {
		String value();
	}

	@Documented
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Then {
		String value();
	}

}
