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

import java.lang.annotation.Annotation;

import org.junit.Test;


/**
 * TestAnnotationReport.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class TestAnnotationReport extends AbstractAtf4jAnnotatedTest {
	
	/**
	 * Package annotations test.
	 *
	 * @throws Throwable the throwable
	 */
	@Test
	public void packageAnnotationsTest() throws Throwable {
		log.trace("TestAnnotationReport.packageAnnotationsTest");
		final Package[] allPackages = Package.getPackages();
		for (final Package namespace : allPackages) {
			log.trace("Package:" + namespace.toString());
			final Annotation[] annotations = namespace.getAnnotations();
			for (final Annotation annotation : annotations) {
				log.trace(annotation.toString());
			}
		}
	}
}
