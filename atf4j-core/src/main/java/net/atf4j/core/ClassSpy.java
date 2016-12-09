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
package net.atf4j.core;

import static java.lang.System.out;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

enum ClassMember {
	CONSTRUCTOR, FIELD, METHOD, CLASS, ALL
}

/**
 * ClassSpy Class.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public class ClassSpy {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String... args) {
		try {
			final Class<?> aClass = Class.forName(args[0]);
			out.format("Class:%n  %s%n%n", aClass.getCanonicalName());
			final Package aPackage = aClass.getPackage();
			out.format("Package:%n  %s%n%n", (aPackage != null ? aPackage.getName() : "-- No Package --"));

			for (int i = 1; i < args.length; i++) {
				switch (ClassMember.valueOf(args[i])) {
				case CONSTRUCTOR:
					printMembers(aClass.getConstructors(), "Constructor");
					break;
				case FIELD:
					printMembers(aClass.getFields(), "Fields");
					break;
				case METHOD:
					printMembers(aClass.getMethods(), "Methods");
					break;
				case CLASS:
					printClasses(aClass);
					break;
				case ALL:
					printMembers(aClass.getConstructors(), "Constuctors");
					printMembers(aClass.getFields(), "Fields");
					printMembers(aClass.getMethods(), "Methods");
					printClasses(aClass);
					break;
				default:
					assert false;
				}
			}

			// production code should handle these exceptions more gracefully
		} catch (final ClassNotFoundException x) {
			x.printStackTrace();
		}
	}

	/**
	 * Prints the members.
	 *
	 * @param members
	 *            the members
	 * @param string
	 *            the string
	 */
	private static void printMembers(final Member[] members, final String string) {
		out.format("%s:%n", string);
		for (final Member member : members) {
			if (member instanceof Field) {
				out.format("  %s%n", ((Field) member).toGenericString());
			} else if (member instanceof Constructor) {
				out.format("  %s%n", ((Constructor<?>) member).toGenericString());
			} else if (member instanceof Method) {
				out.format("  %s%n", ((Method) member).toGenericString());
			}
		}
		if (members.length == 0) {
			out.format("  -- No %s --%n", string);
		}
		out.format("%n");
	}

	/**
	 * Prints the classes.
	 *
	 * @param aClass
	 *            the a class
	 */
	private static void printClasses(final Class<?> aClass) {
		out.format("Classes:%n");
		final Class<?>[] memberClassArray = aClass.getClasses();
		for (final Class<?> memberClass : memberClassArray) {
			out.format("  %s%n", memberClass.getCanonicalName());
		}
		if (memberClassArray.length == 0) {
			out.format("  -- No member interfaces, classes, or enums --%n");
		}
		out.format("%n");
	}
}
