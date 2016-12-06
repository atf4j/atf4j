/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 * 
 * Atf4j is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version.
 * 
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License 
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>. 
 */
package net.aft4j.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Interface Atf4j.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Atf4j {

	/**
	 * The Interface AutomatedTestScript.
	 *
	 * @author Martin Spamer <Martin.Spamer@atf4j.net>
	 */
	@Documented
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface TestScript {

	}

	/**
	 * The Interface TestId.
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

	/**
	 * The Interface TestName.
	 */
	@Documented
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface TestName {

		/**
		 * Value.
		 *
		 * @return the string
		 */
		String value();
	}

	/**
	 * The Interface TestDescription.
	 */
	@Documented
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface TestDescription {

		/**
		 * Value.
		 *
		 * @return the string
		 */
		String value();
	}

}
